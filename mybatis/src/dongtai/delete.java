package dongtai;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class delete {
	//��̬ɾ��
	
	public static void del(Integer ...ids) throws Exception {
		//���ݴ����idɾ��(�������ʽ)
		Reader r = Resources.getResourceAsReader("myfirstbatis.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(r);
		SqlSession s = ssf.openSession();
		
		s.delete("dong.de", ids);
		s.commit();
		s.close();
	}
	
	public static void dell(List<Integer> l) throws Exception {
		//���ݴ����idɾ��(���ϵ���ʽ)
		Reader r = Resources.getResourceAsReader("myfirstbatis.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(r);
		SqlSession s = ssf.openSession();
		
		s.delete("dong.dee", l);
		s.commit();
		s.close();
	}
	
	public static void main(String[] args) throws Exception {
		//delete.del(4,5,7);
		//delete.del(new Integer[]{2,4,6});
		
		List<Integer> l = new ArrayList<Integer>();
		l.add(1);l.add(2);l.add(5);
		delete.dell(l);
	}
}
