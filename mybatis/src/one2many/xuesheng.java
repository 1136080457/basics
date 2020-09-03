package one2many;

public class xuesheng {

	private int id;
	private String name;
	private xueke xuek;	//用于接收查询的结果
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
