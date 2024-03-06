package algorithm;

public class IntersectOfLines28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GetIntersect gi = new GetIntersect(3, 4, 1, 6, 5, 8, 9, 10);
		gi.printIntersect();
		
		
	}
	
	
	
	public static class GetIntersect {
		public double x1,y1,x2,y2,x3,y3,x4,y4;	// 정수가 아닐 수도 있어
		
		public GetIntersect(double x1,double y1,double x2,double y2,double x3,double y3,double x4,double y4) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
			this.x3 = x3;
			this.y3 = y3;
			this.x4 = x4;
			this.y4 = y4;
			
		}
		
		
	
		public void printIntersect() {
			
			// 기울기 m
			double m1 = (y2 - y1) / (x2 - x1);
			double m2 = (y4 - y3) / (x4 - x3);
			// y 절편 b
			double b1 = y1 - m1 * x1;
			double b2 = y3 - m2 * x3;
		
			double ans_x = (b2 - b1) / (m1 - m2);
			double ans_y = m1 * ans_x + b1;
			
			String result = String.format("(%.1f,%.1f)-(%.1f,%.1f), (%.1f,%.1f)-(%.1f,%.1f) : (%.1f,%.1f)",x1,y1,x2,y2,x3,y3,x4,y4,ans_x,ans_y);
			
		
			
			System.out.println(result);
			
			
		}
		
	}

}
