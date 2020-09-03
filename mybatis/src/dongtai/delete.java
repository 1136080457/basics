package dongtai;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class delete {
	//动态删除
	
	public static void del(Integer ...ids) throws Exception {
		//根据传入的id删除(数组的形式)
		Reader r = Resources.getResourceAsReader("myfirstbatis.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(r);
		SqlSession s = ssf.openSession();
		
		s.delete("dong.de", ids);
		s.commit();
		s.close();
	}
	
	public static void dell(List<Integer> l) throws Exception {
		//根据传入的id删除(集合的形式)
		Reader r = Resources.getResourceAsReader("myfirstbatis.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(r);
		SqlSession s = ssf.openSession();
		
		s.delete("dong.dee", l);
		s.commit();
		s.close();
	}
	
	public static void main(String[] args) throws Exception {
		//delete.del(4,5,7);
		//delete.del(new Integer[]{2,4,6});
		
		List<Integer> l = new ArrayList<Integer>();
		l.add(1);l.add(2);l.add(5);
		delete.dell(l);
	}
}
