package dongtai;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class insert {
	//��̬����
	
	public static void ins(empl e) throws Exception {
		Reader r = Resources.getResourceAsReader("myfirstbatis.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(r);
		SqlSession s = ssf.openSession();
		
		s.insert("dong.in", e);
		s.commit();
		s.close();
	}
	
	public static void main(String[] args) throws Exception {
		//insert.ins(new empl(1, "�ŷ�", 12));
		//insert.ins(new empl(2, null, 1));
		//insert.ins(new empl(3, "��ɽ��", 13));
		insert.ins(new empl(4, null, null));
	}
}
