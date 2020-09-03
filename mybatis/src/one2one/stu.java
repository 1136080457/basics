package one2one;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class stu {
	//注意：当属性名和字段名不一样的时候，实体类中还需要提供无参构造器(用于查询，封装数据)
	//一对一的映射之学生端(有外键端)的操作
	
	

	public static Student select(Integer i) throws Exception {
		//根据学生的cid=身份证的cid查询
		Reader r = Resources.getResourceAsReader("myfirstbatis.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(r);
		SqlSession s = ssf.openSession();
		
		return s.selectOne(Student.class.getName()+".sse", i);
	}
	
	public static Student selected(String name) throws Exception {
		//根据学生的姓名查询
		Reader r = Resources.getResourceAsReader("myfirstbatis.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(r);
		SqlSession s = ssf.openSession();
		
		return s.selectOne(Student.class.getName()+".ssee", name);
	}
	
	
	public static void main(String[] args) throws Exception {
		
//		Student s = stu.select(1);
//		System.out.println(s.getName()+","+s.getCard().getNum()+","+s.getCard().getId());
		
		Student s = stu.selected("张三");
		System.out.println(s.getId()+","+s.getCard().getNum()+","+s.getCard().getId());
	}
}
