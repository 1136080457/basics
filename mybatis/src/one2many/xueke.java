package one2many;

import java.util.List;

public class xueke {

	private int id;
	private String name;
	private List<xuesheng> sheng; //用于接收查询的结果
	
	public xueke() {
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
	public List<xuesheng> getSheng() {
		return sheng;
	}
	public void setSheng(List<xuesheng> sheng) {
		this.sheng = sheng;
	}
	
}
