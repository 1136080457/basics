package one;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ibatis {
	/**1.ʹ��mybatis��Ҫ�ȵ���5����������asm.jar/cglib.jar/commons-logging.jar/log4j.jar/mybatis.jar;
	 * (����ʹ�õ����ݿ��������Ŷ)
	 * 2.һ��ӳ�������ļ�
	 * 3.һ���������ļ�(����ӳ���ļ�)
	 */
	
	//��������Ϊ�������д����
	//ThreadLocal<SqlSession> th = new ThreadLocal<SqlSession>();	//����һ���̣߳�����װ����sqlsession
	//	Reader r = Resources.getResourceAsReader("myfirstbatis.xml");	
	//	SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(r);	//����mybatis���������ļ�
	//	SqlSession session = ssf.openSession();
	//th.set(session);	//��sqlsession�����߳���
	//th.get();	//��ȡ��ǰ�߳��е�sqlsession
	//session.close();	//�ر�session
	//th.remove();	//���߳���sqlsession���룬��gc����ȥ����
	
	public static void t1() throws Exception {
		//��һ�֣��޲εķ�ʽ
		Reader r = Resources.getResourceAsReader("myfirstbatis.xml");	
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(r);	//����mybatis���������ļ�
		SqlSession session = ssf.openSession();	//����sqlsession����
		
		try {
			int i = session.insert("my.in1"); 	//ӳ���ļ��е����ƿռ�.��������Ӧ��ǩ��id
			System.out.println("����Ӱ����"+i+"������");
			session.commit();	//�ύ����(��ѯ��ѡ)
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();	//�����쳣���ع�
		}finally{
			session.close();
		}
	}
	
	public static void t2(emp e) throws IOException{
		//�ڶ��֣��в����ķ�ʽ
		Reader r = Resources.getResourceAsReader("myfirstbatis.xml");	
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(r);	//����mybatis���������ļ�
		SqlSession session = ssf.openSession();	//����sqlsession����
		
		try {
			int i = session.insert("my.in2",e); 	//ӳ���ļ��е����ƿռ�.��������ǩ��id
			session.commit();	
		} catch (Exception ee) {
			ee.printStackTrace();
			session.rollback();	
		}finally{
			session.close();
		}
	}
	
	
	
	public static void main(String[] args) throws Exception {
		ibatis i = new ibatis();
		i.t1();
		//i.t2(new emp(5,"tis",25));
		
	}
}
