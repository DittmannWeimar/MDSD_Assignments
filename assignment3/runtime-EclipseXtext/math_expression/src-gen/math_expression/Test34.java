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
			sideC = ;
			perimeterTriangle = sideA + sideB + sideC;
			radius = 5;
			perimeterCircle = ;
		}

		public interface External {
			public int pow(int a, int b);
			public int sqrt(int a);
			public int pi();
		}
	}