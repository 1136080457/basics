package one2one;

public class Student {

	//����ֶ�������������һ��������Ҫ�ṩ�޲ι�������ʼ��Ŷ
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
