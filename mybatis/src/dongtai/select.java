package dongtai;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class select {
	//��̬��ѯ����ӳ���ļ��м��жϼ���
	
	public static List<empl> sele(Integer id,String name,Integer age) throws Exception {
		Reader r = Resources.getResourceAsReader("myfirstbatis.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(r);
		SqlSession s = ssf.openSession();
		
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("one", id);
		m.put("two", name);
		m.put("three", age);
		return s.selectList("dong.sel", m);
	}
	
	public static void main(String[] args) throws Exception {
		//List<empl> e = select.sele(1, null, null);	//��ѯeidΪ1��
		List<empl> e = select.sele(null, null,null );	//��ѯ����
		for(empl l:e){
			System.out.println("���ݶ�̬������ѯ�Ľ���ǣ�"+l.getEid()+","+l.getEname()+","+l.getEage());
		}
	}
}
