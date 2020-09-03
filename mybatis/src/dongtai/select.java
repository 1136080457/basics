package dongtai;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class select {
	//动态查询，在映射文件中加判断即可
	
	public static List<empl> sele(Integer id,String name,Integer age) throws Exception {
		Reader r = Resources.getResourceAsReader("myfirstbatis.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(r);
		SqlSession s = ssf.openSession();
		
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("one", id);
		m.put("two", name);
		m.put("three", age);
		return s.selectList("dong.sel", m);
	}
	
	public static void main(String[] args) throws Exception {
		//List<empl> e = select.sele(1, null, null);	//查询eid为1的
		List<empl> e = select.sele(null, null,null );	//查询所有
		for(empl l:e){
			System.out.println("根据动态条件查询的结果是："+l.getEid()+","+l.getEname()+","+l.getEage());
		}
	}
}
