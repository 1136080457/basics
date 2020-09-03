package fy;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class limit {
	
	//��ҳ:���Խ���ʼ��������ÿ�β�ѯ�ļ�¼���ŵ�map�У�ӳ���ļ��Ĳ���дmap�Ϳ����ˣ�����parameterType="map"
	
	public static List<empl> limt(int start,int size) throws Exception {
		Reader r = Resources.getResourceAsReader("myfirstbatis.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(r);
		SqlSession s = ssf.openSession();
		
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("one", start);
		m.put("two", size);
		
		return s.selectList("my.lim", m);
	}
	
	public static void main(String[] args) throws Exception {
		List<empl> l = limit.limt(0, 2);
		System.out.println("��һҳ�У�");
		for(empl e:l){
			System.out.println(e.getEid()+","+e.getEname()+","+e.getEage());
		}
		List<empl> ll = limit.limt(2, 2);
		System.out.println("�ڶ�ҳ�У�");
		for(empl e:ll){
			System.out.println(e.getEid()+","+e.getEname()+","+e.getEage());
		}
		List<empl> lll = limit.limt(4, 2);
		System.out.println("����ҳ�У�");
		for(empl e:lll){
			System.out.println(e.getEid()+","+e.getEname()+","+e.getEage());
		}
	}
}
