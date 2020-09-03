package many2many;

import java.util.List;

public class People {

	private int id;
	private String name;
	private List<Course> ll;
	public People() {
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
	public List<Course> getLl() {
		return ll;
	}
	public void setLl(List<Course> ll) {
		this.ll = ll;
	}
	
}
