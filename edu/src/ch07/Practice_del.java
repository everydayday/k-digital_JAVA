package ch07;

public class Practice_del {
	private String name;
	private int num;
	
	public Practice_del(){
		
	}
	
	public Practice_del(String name, int num) {
		this.name = name;
		setNum(num);
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	

}
