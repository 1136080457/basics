package dongtai;

import java.io.Reader;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class update {
	//动态更新
	
	public static void up(Integer id,String name,Integer age) throws Exception {
		
		Reader r = Resources.getResourceAsReader("myfirstbatis.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(r);
		SqlSession s = ssf.openSession();
		
		Map<String, Object> m = new LinkedHashMap<String, Object>();
		m.put("一", id);
		m.put("二", name);
		m.put("三", age);
		s.update("dong.u", m);
		s.commit();
		s.close();
	}
	
	public static void main(String[] args) throws Exception {
		//update.up(1, "小李子", null); //由于id是主键，一般就修改后面的
		update.up(2, null, 88);
	}
}
