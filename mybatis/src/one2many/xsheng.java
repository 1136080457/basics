package one2many;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class xsheng {
	//ѧ����(���һ��)
	
	public static xueke xuexi(String name) throws Exception {
		//����ѧ�������ֲ�ѯ��Ӧ��ѧ����Ϣ
		Reader r = Resources.getResourceAsReader("myfirstbatis.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(r);
		SqlSession s = ssf.openSession();
		
		xueke x = s.selectOne("s.sh", name);
		return x;
	}
	
	public static void main(String[] args) throws Exception {
		xueke x = xsheng.xuexi("����ǽ");
		System.out.println("��ѧ����Ӧ��ѧ���ǣ�"+x.getName()+",��ѧ����Ӧ��ѧ�Ʊ���ǣ�"+x.getId());
	}
}
