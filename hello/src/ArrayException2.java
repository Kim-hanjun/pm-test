
public class ArrayException2 {

	public static void main(String[] args) {
		
		
		int[] intArray = new int[5];
		intArray[0] = 0;
		
		for (int i = 0; i < 5; i++) {
			try {
					intArray[i+1] = i + 1 + intArray[i];
					System.out.println("intArray[" + i + "] = " + intArray[i]);
					
					if (i==2) {
						System.out.println(intArray[i] / 0);
					}
					
					// intentionally raise an exception
					if (i ==1) {
						ArithmeticException e = new ArithmeticException("intentionally raise");
						throw e;
						// throw new ArithmeticException("intentionally raise");
					}
					if (i==0) {
						throw new MyException("myException");
					}
					
			} catch (ArrayIndexOutOfBoundsException e1) {
				System.out.println("Exception: ArrayIndexOutOfBounds");
			} catch (ArithmeticException e2) {
				System.out.println("0");
				System.out.println(e2.getMessage());
				e2.printStackTrace();
			} catch (MyException e3) {
				e3.printStackTrace();
			}
		}

	}

}
