package many2many;

import java.util.List;

public class Course {

	private int id;
	private String name;
	private List<People> l;
	public Course() {
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
	public List<People> getL() {
		return l;
	}
	public void setL(List<People> l) {
		this.l = l;
	}
	
}
