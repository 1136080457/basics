package dongtai;

public class empl {

	private Integer eid;
	private String ename;
	private Integer eage;
	public empl(Integer eid,String ename,Integer eage) {
		this.eage = eage;
		this.eid = eid;
		this.ename = ename;
	}
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Integer getEage() {
		return eage;
	}
	public void setEage(Integer eage) {
		this.eage = eage;
	}
	
	
}
