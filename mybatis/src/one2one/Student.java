package one2one;

public class Student {

	//如果字段名和属性名不一样，还需要提供无参构造器初始化哦
	private Integer id;
	private String name;
	private IDcard card;
	
	public Student() {}
	public Student(Integer id,String name,IDcard card) {
		this.id = id;
		this.name = name;
		this.card = card;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public IDcard getCard() {
		return card;
	}
	public void setCard(IDcard card) {
		this.card = card;
	}
	
	
}
