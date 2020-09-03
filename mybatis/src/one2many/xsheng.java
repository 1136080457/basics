package one2many;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class xsheng {
	//学生方(多的一方)
	
	public static xueke xuexi(String name) throws Exception {
		//根据学生的名字查询对应的学科信息
		Reader r = Resources.getResourceAsReader("myfirstbatis.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(r);
		SqlSession s = ssf.openSession();
		
		xueke x = s.selectOne("s.sh", name);
		return x;
	}
	
	public static void main(String[] args) throws Exception {
		xueke x = xsheng.xuexi("佛跳墙");
		System.out.println("该学生对应的学科是："+x.getName()+",该学生对应的学科编号是："+x.getId());
	}
}
