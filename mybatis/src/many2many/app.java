package many2many;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class app {
	//��Զ࣬���Խ�һ���м������һ�������ͱ����������Ϊһ����������
	
	
	public static List<Course> se1(String name) throws Exception {
		//�����˵����ֲ�ѯ��Ӧ�Ŀγ���Ϣ
		
		Reader r = Resources.getResourceAsReader("myfirstbatis.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(r);
		SqlSession s = ssf.openSession();
		
		return s.selectList("pp.st", name);
	}
	
	
	public static List<People> se2(String name) throws Exception {
		//���ݿγ̵����ֲ�ѯ��Ӧ������Ϣ
		
		Reader r = Resources.getResourceAsReader("myfirstbatis.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(r);
		SqlSession s = ssf.openSession();
		
		return s.selectList("cc.st", name);
	}
	
	public static void main(String[] args) throws Exception {
//		List<Course> c = app.se1("����");
//		System.out.println("��ѧ����ѡ����"+c.size()+"�ſγ̣��ֱ��ǣ�");
//		for(Course cc : c){
//			System.out.print(cc.getName()+",�γ̱���ǣ�"+cc.getId()+";");
//		}
		
		
		List<People> ll = app.se2("java");
		System.out.println("���ſγ��Ѿ���"+ll.size()+"��ѧ��ѡ���ˣ��ֱ��ǣ�");
		for(People p : ll){
			System.out.println("ѧ���������ǣ�"+p.getName()+",ѧ���ı���ǣ�"+p.getId()+";");
		}
	}
}
