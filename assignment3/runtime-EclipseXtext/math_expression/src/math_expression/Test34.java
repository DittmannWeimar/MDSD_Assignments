package math_expression;
	public class Test34 {
		
		public int sideA;
		public int sideB;
		public int sideC;
		public int perimeterTriangle;
		public int radius;
		public int perimeterCircle;

		public External external;
		
		public Test34(External external) {
			this.external = external;
		}
		
		public void compute(){
			sideA = 3;
			sideB = 4;
			int powA = this.external.pow(sideA, 2);  int powB = this.external.pow(sideB, 2);  
			sideC = this.external.sqrt(powA + powB);
			perimeterTriangle = sideA + sideB + sideC;
			radius = 5;
			int diameter = 2 * radius; 
			perimeterCircle = diameter * this.external.pi();
		}

		public interface External {
			public int pow(int a, int b);
			public int sqrt(int a);
			public int pi();
		}
	}