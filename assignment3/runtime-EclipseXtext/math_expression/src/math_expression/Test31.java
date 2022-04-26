package math_expression;
	public class Test31 {
		
		public int x;
		public int y;

		public External external;
		
		public Test31(External external) {
			this.external = external;
		}
		
		public void compute(){
			x = 5;
			int i = x; 
			y = 2 + this.external.pow(i - 3, 3 * 2);
		}

		public interface External {
			public int pow(int a, int b);
		}
	}