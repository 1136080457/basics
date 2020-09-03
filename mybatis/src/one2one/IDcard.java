package one2one;

public class IDcard {

	private Integer id;
	private String num;
	
	public IDcard() {
	}
	public IDcard(Integer id,String num) {
		this.id = id;
		this.num = num;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	
}
