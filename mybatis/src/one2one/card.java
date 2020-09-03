package one2one;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class card {
	//一对一映射之身份证端的操作
	//注意：当属性名和字段名不一样的时候，实体类中还需要提供无参构造器(用于查询，封装数据)
	
	public static void insert(IDcard rd) throws Exception {
		Reader r = Resources.getResourceAsReader("myfirstbatis.xml");
		SqlSessionFactory ssf= new SqlSessionFactoryBuilder().build(r);
		SqlSession s = ssf.openSession();
		
		s.insert(IDcard.class.getName()+".cin", rd);
		s.commit();
		s.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws Exception {
		card.insert(new IDcard(1, "1234567"));
		card.insert(new IDcard(2, "7654321"));
		card.insert(new IDcard(3, "13348810"));
		card.insert(new IDcard(4, "00001111"));
	}
}
