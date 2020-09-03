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
	
	//分页:可以将开始的索引和每次查询的记录数放到map中，映射文件的参数写map就可以了，即：parameterType="map"
	
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
		System.out.println("第一页有：");
		for(empl e:l){
			System.out.println(e.getEid()+","+e.getEname()+","+e.getEage());
		}
		List<empl> ll = limit.limt(2, 2);
		System.out.println("第二页有：");
		for(empl e:ll){
			System.out.println(e.getEid()+","+e.getEname()+","+e.getEage());
		}
		List<empl> lll = limit.limt(4, 2);
		System.out.println("第三页有：");
		for(empl e:lll){
			System.out.println(e.getEid()+","+e.getEname()+","+e.getEage());
		}
	}
}
