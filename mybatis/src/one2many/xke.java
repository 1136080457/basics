package one2many;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class xke {
	//ѧ�Ʒ�(�ٵ�һ��)
	
	
	public static List<xuesheng> ke(int i) throws Exception {
		//����ѧ�Ƶ�id��ѯ��Ӧ��ѧ��
		Reader r = Resources.getResourceAsReader("myfirstbatis.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(r);
		SqlSession s = ssf.openSession();
		
		return s.selectList("k.se", i);
	}
	
	
	public static void main(String[] args) throws Exception {
		List<xuesheng> l = xke.ke(1);
		System.out.println("ѧ����"+l.size()+"�����У�");
		for(xuesheng xs : l){
			System.out.println(xs.getName()+","+xs.getId());
		}
	}
}
