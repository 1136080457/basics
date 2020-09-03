package many2many;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class app {
	//多对多，可以建一张中间表，将表一的主键和表二的主键作为一个联合主键
	
	
	public static List<Course> se1(String name) throws Exception {
		//根据人的名字查询对应的课程信息
		
		Reader r = Resources.getResourceAsReader("myfirstbatis.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(r);
		SqlSession s = ssf.openSession();
		
		return s.selectList("pp.st", name);
	}
	
	
	public static List<People> se2(String name) throws Exception {
		//根据课程的名字查询对应的人信息
		
		Reader r = Resources.getResourceAsReader("myfirstbatis.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(r);
		SqlSession s = ssf.openSession();
		
		return s.selectList("cc.st", name);
	}
	
	public static void main(String[] args) throws Exception {
//		List<Course> c = app.se1("王大锤");
//		System.out.println("该学生共选修了"+c.size()+"门课程，分别是：");
//		for(Course cc : c){
//			System.out.print(cc.getName()+",课程编号是："+cc.getId()+";");
//		}
		
		
		List<People> ll = app.se2("java");
		System.out.println("该门课程已经被"+ll.size()+"个学生选修了，分别是：");
		for(People p : ll){
			System.out.println("学生的名字是："+p.getName()+",学生的编号是："+p.getId()+";");
		}
	}
}
