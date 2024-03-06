package algorithm;

abstract class Switch{
	boolean status;
	
	abstract void turnOn();
	abstract void turnOff();	
}

interface SensorLight{
	boolean isCondition();
}

class SwitchOld extends Switch{
	@Override
	void turnOff() {
		// TODO Auto-generated method stub
		
	}
	@Override
	void turnOn() {
		// TODO Auto-generated method stub
		
	}
}

class SwitchRecent extends Switch{
	@Override
	void turnOff() {
		// TODO Auto-generated method stub
		
	}
	@Override
	void turnOn() {
		// TODO Auto-generated method stub
		
	}
}

class SwitchDigital extends Switch{
	@Override
	void turnOff() {
		// TODO Auto-generated method stub
		
	}
	@Override
	void turnOn() {
		// TODO Auto-generated method stub
		
	}
}

// 다중 상속 안 되지 않나..?
class SwitchEnterance extends Switch implements SensorLight{
	@Override
	public boolean isCondition() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	void turnOff() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	void turnOn() {
		// TODO Auto-generated method stub
		
	}
	
	
}



public class Homenetworking50 {
	
	
	
	public static void main(String[] args) {
		
	}

}
