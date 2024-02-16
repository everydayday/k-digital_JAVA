package ch07;

public class Practice_del2 extends Practice_del {
	private String dept;
	
	public Practice_del2(String dept) {
		super("이것",4);
		this.dept = dept;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
}
