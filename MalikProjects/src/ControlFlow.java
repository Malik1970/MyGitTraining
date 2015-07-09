
public class ControlFlow {
//	public class ControlFlow {

		/**
		 * @param args
		 */
		public static void main(String[] args) {
			
			//if () -then statement
			int n=11;
			
			if (n%2==0) {
				System.out.println("Even number!");
			} else {
				System.out.println("Odd number!");			
			}
			
			if (true) {
				System.out.println("Always true!");
			} 
			
			n=3;
			int t=2;
			if (n==1) {
				System.out.println("Monday");
				if (t==2) {
					System.out.println("t is 2");
				}
				
			} else if (n==2) {
				System.out.println("Tuesday");
			} else if (n==3) {
				System.out.println("Wed");			
			} else if (n==4) {
				System.out.println("Thur");			
			} else {
				System.out.println("Unknown day!");
			}
			
			
			n=5;
			switch (n) {
			case 1 : System.out.println("Monday");
			        break;
			case  2 : System.out.println("Tuesday");
			        break;
			case   3 : System.out.println("Wed");
			       break;
			    default: System.out.println("Unkown");   
			}
			
			
			// number of times
			// for (init; condition ; increment/decrement) { ...}
			for (int m=1; m<=10; m++) {
				System.out.println(m);
			}
			
			int index = 1;
			for (; ; ) {
				if (index++<=10) {
					System.out.println("Hello...");
				} else {
					break;
				}
			}
			
			// nested for loop
			// 2x1 = 2
			// 10
			for (int i=2;i<=10;i++) {
				System.out.println("----- Table "+i +"-----");
				for (int j=1;j<=10;j++) {
					//System.out.println("Hello "+i+","+j);
					if (j==10) break; 
					System.out.println(i+"x"+j+"="+(i*j));
				}
			}
			
			//while (condition) { }
			
			int k = 1;
			while (k<=10) {
				System.out.println(k++);
			}
			
			k = 10;
			while (k>=1) {
				System.out.println(k--);
				///
			}
			
			int l=1;
			// do - while
			do {
				System.out.println(l++);			
			} while (l<=10);

			System.out.println("Print odd numbers");
			k = 10;
			while (k>=1) {
				if (k%2!=0) {
					System.out.println(k);
				}
				k--;
				///
			}

			System.out.println("Print odd numbers until 5");
			k = 10;
			while (k>=1) {
				if (k%2!=0) {
					System.out.println(k);
				}
				if (k<5) {
					break;
				} 
				k--;
				///
			}
			
			System.out.println("Print odd numbers until 5");
			k = 10;
			while (k>=1) {
				if (k%2!=0) {
					System.out.println(k);
				}
				
				k--;
				///
			}
			
		}

	}

//}
