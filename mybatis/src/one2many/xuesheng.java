package one2many;

public class xuesheng {

	private int id;
	private String name;
	private xueke xuek;	//���ڽ��ղ�ѯ�Ľ��
	public xuesheng() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setXuek(xueke xuek) {
		this.xuek = xuek;
	}
	public xueke getXuek() {
		return xuek;
	}
	
}
