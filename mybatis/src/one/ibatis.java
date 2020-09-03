package one;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ibatis {
	/**1.使用mybatis需要先导入5个基础包：asm.jar/cglib.jar/commons-logging.jar/log4j.jar/mybatis.jar;
	 * (还有使用的数据库的驱动包哦)
	 * 2.一个映射配置文件
	 * 3.一个总配置文件(加载映射文件)
	 */
	
	//这里是作为工具类的写法：
	//ThreadLocal<SqlSession> th = new ThreadLocal<SqlSession>();	//创建一个线程，里面装的是sqlsession
	//	Reader r = Resources.getResourceAsReader("myfirstbatis.xml");	
	//	SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(r);	//加载mybatis的主配置文件
	//	SqlSession session = ssf.openSession();
	//th.set(session);	//将sqlsession放入线程中
	//th.get();	//获取当前线程中的sqlsession
	//session.close();	//关闭session
	//th.remove();	//将线程与sqlsession分离，让gc尽快去回收
	
	public static void t1() throws Exception {
		//第一种：无参的方式
		Reader r = Resources.getResourceAsReader("myfirstbatis.xml");	
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(r);	//加载mybatis的主配置文件
		SqlSession session = ssf.openSession();	//创建sqlsession对象
		
		try {
			int i = session.insert("my.in1"); 	//映射文件中的名称空间.插入语句对应标签的id
			System.out.println("本次影响了"+i+"条数据");
			session.commit();	//提交事务，(查询可选)
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();	//出现异常，回滚
		}finally{
			session.close();
		}
	}
	
	public static void t2(emp e) throws IOException{
		//第二种：有参数的方式
		Reader r = Resources.getResourceAsReader("myfirstbatis.xml");	
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(r);	//加载mybatis的主配置文件
		SqlSession session = ssf.openSession();	//创建sqlsession对象
		
		try {
			int i = session.insert("my.in2",e); 	//映射文件中的名称空间.插入语句标签的id
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
