package one2many;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class xke {
	//学科方(少的一方)
	
	
	public static List<xuesheng> ke(int i) throws Exception {
		//根据学科的id查询对应的学生
		Reader r = Resources.getResourceAsReader("myfirstbatis.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(r);
		SqlSession s = ssf.openSession();
		
		return s.selectList("k.se", i);
	}
	
	
	public static void main(String[] args) throws Exception {
		List<xuesheng> l = xke.ke(1);
		System.out.println("学生共"+l.size()+"名，有：");
		for(xuesheng xs : l){
			System.out.println(xs.getName()+","+xs.getId());
		}
	}
}
