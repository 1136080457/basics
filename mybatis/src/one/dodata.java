package one;

import java.io.Reader;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class dodata {
	//ע�⣺ʹ�ò�ѯ��ʱ��ʹ�õ�ʵ���������������ݿ��Ӧ�ֶ�������һ����������Ҫ��Ӧ�ñ�����ʵ���������������ѯ���߷���������resultmap=ӳ���id��
	//ӳ���ļ��еĲ��롢�޸ġ�ɾ����ǩ���Ի���ʹ�ã��������飻��ѯֻ��ʹ��select��ǩ
	//����list����ʱ��ӳ���ļ��з�������ֻ��Ҫд�������ݵ����ͼ���
	
	public static empl m1(int i) throws Exception {
		//��ѯһ��
		Reader r = Resources.getResourceAsReader("myfirstbatis.xml");
		SqlSessionFactory ss = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = ss.openSession();
		empl e = session.selectOne("my.se1",i);
		session.commit();
		session.close();
		return e;
	}
	
	public static List<empl> m11() throws Exception {
		//��ѯ����
		Reader r = Resources.getResourceAsReader("myfirstbatis.xml");
		SqlSessionFactory ss = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = ss.openSession();
		return session.selectList("my.se2");//ʹ�õķ���list�Ĳ�ѯ���
	}
	
	public static void m2(emp e) throws Exception {
		//�޸�
		Reader r = Resources.getResourceAsReader("myfirstbatis.xml");
		SqlSessionFactory ss = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = ss.openSession();
		session.update("my.up1", e);
		session.commit();
		session.close();
	}

	public static void m3() throws Exception {
		//ɾ��
		Reader r = Resources.getResourceAsReader("myfirstbatis.xml");
		SqlSessionFactory ss = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = ss.openSession();
		session.delete("my.de1");
		session.commit();
		session.close();
		
	}
	
	public static emp m4() throws Exception {
		//��ѯһ��(ʵ����������������ݿ��Ӧ���ֶ�����һ��)(ʹ�ñ����ķ�ʽ)
		Reader r = Resources.getResourceAsReader("myfirstbatis.xml");
		SqlSessionFactory ss = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = ss.openSession();
		emp e = session.selectOne("my.se3");
		session.commit();
		session.close();
		return e;
	}
	
	public static emp m5(int i) throws Exception {
		//��ѯһ��(ʵ����������������ݿ��Ӧ���ֶ�����һ��)(ʹ��resultmap�ķ�ʽ)
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
//		e.setName("��ٻ");
//		e.setId(4);
//		dodata.m2(e);	//�޸�
		
		
		//dodata.m3();	//ɾ��
		
	}
}
