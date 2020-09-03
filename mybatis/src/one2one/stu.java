package one2one;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class stu {
	//ע�⣺�����������ֶ�����һ����ʱ��ʵ�����л���Ҫ�ṩ�޲ι�����(���ڲ�ѯ����װ����)
	//һ��һ��ӳ��֮ѧ����(�������)�Ĳ���
	
	

	public static Student select(Integer i) throws Exception {
		//����ѧ����cid=���֤��cid��ѯ
		Reader r = Resources.getResourceAsReader("myfirstbatis.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(r);
		SqlSession s = ssf.openSession();
		
		return s.selectOne(Student.class.getName()+".sse", i);
	}
	
	public static Student selected(String name) throws Exception {
		//����ѧ����������ѯ
		Reader r = Resources.getResourceAsReader("myfirstbatis.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(r);
		SqlSession s = ssf.openSession();
		
		return s.selectOne(Student.class.getName()+".ssee", name);
	}
	
	
	public static void main(String[] args) throws Exception {
		
//		Student s = stu.select(1);
//		System.out.println(s.getName()+","+s.getCard().getNum()+","+s.getCard().getId());
		
		Student s = stu.selected("����");
		System.out.println(s.getId()+","+s.getCard().getNum()+","+s.getCard().getId());
	}
}
