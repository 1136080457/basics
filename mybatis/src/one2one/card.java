package one2one;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class card {
	//һ��һӳ��֮���֤�˵Ĳ���
	//ע�⣺�����������ֶ�����һ����ʱ��ʵ�����л���Ҫ�ṩ�޲ι�����(���ڲ�ѯ����װ����)
	
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
