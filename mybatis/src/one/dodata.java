package one;

import java.io.Reader;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class dodata {
	//注意：使用查询的时候，使用的实体类属性名和数据库对应字段名必须一样，否则需要对应用别名是实体类的属性名来查询或者返回类型用resultmap=映射的id；
	//映射文件中的插入、修改、删除标签可以互相使用，但不建议；查询只能使用select标签
	//返回list集合时，映射文件中返回类型只需要写里面数据的类型即可
	
	public static empl m1(int i) throws Exception {
		//查询一个
		Reader r = Resources.getResourceAsReader("myfirstbatis.xml");
		SqlSessionFactory ss = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = ss.openSession();
		empl e = session.selectOne("my.se1",i);
		session.commit();
		session.close();
		return e;
	}
	
	public static List<empl> m11() throws Exception {
		//查询所有
		Reader r = Resources.getResourceAsReader("myfirstbatis.xml");
		SqlSessionFactory ss = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = ss.openSession();
		return session.selectList("my.se2");//使用的返回list的查询语句
	}
	
	public static void m2(emp e) throws Exception {
		//修改
		Reader r = Resources.getResourceAsReader("myfirstbatis.xml");
		SqlSessionFactory ss = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = ss.openSession();
		session.update("my.up1", e);
		session.commit();
		session.close();
	}

	public static void m3() throws Exception {
		//删除
		Reader r = Resources.getResourceAsReader("myfirstbatis.xml");
		SqlSessionFactory ss = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = ss.openSession();
		session.delete("my.de1");
		session.commit();
		session.close();
		
	}
	
	public static emp m4() throws Exception {
		//查询一个(实体类的属性名和数据库对应的字段名不一样)(使用别名的方式)
		Reader r = Resources.getResourceAsReader("myfirstbatis.xml");
		SqlSessionFactory ss = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = ss.openSession();
		emp e = session.selectOne("my.se3");
		session.commit();
		session.close();
		return e;
	}
	
	public static emp m5(int i) throws Exception {
		//查询一个(实体类的属性名和数据库对应的字段名不一样)(使用resultmap的方式)
		Reader r = Resources.getResourceAsReader("myfirstbatis.xml");
		SqlSessionFactory ss = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = ss.openSession();
		emp e = session.selectOne("my.se4",i);
		session.commit();
		session.close();
		return e;
	}
	
	public static void main(String[] args) throws Exception {
//		emp e = dodata.m4();
//		System.out.println(e.getName());
		
//		emp e = dodata.m5(1);
//		System.out.println(e.getName()+","+e.getAge()+","+e.getId());
		
//		empl l = dodata.m1(1);
//		System.out.println(l.getEid()+","+l.getEname()+","+l.getEage());
		
//		List<empl> l = dodata.m11();
//		for(empl e : l){
//			System.out.println(e.getEid()+","+e.getEname()+","+e.getEage());
//		}
		
		
//		emp e = new emp();
//		e.setName("张倩");
//		e.setId(4);
//		dodata.m2(e);	//修改
		
		
		//dodata.m3();	//删除
		
	}
}
