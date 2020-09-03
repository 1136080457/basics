package dongtai;

import java.io.Reader;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class update {
	//��̬����
	
	public static void up(Integer id,String name,Integer age) throws Exception {
		
		Reader r = Resources.getResourceAsReader("myfirstbatis.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(r);
		SqlSession s = ssf.openSession();
		
		Map<String, Object> m = new LinkedHashMap<String, Object>();
		m.put("һ", id);
		m.put("��", name);
		m.put("��", age);
		s.update("dong.u", m);
		s.commit();
		s.close();
	}
	
	public static void main(String[] args) throws Exception {
		//update.up(1, "С����", null); //����id��������һ����޸ĺ����
		update.up(2, null, 88);
	}
}
