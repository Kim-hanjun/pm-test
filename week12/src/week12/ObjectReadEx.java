package week12;

import java.io.*;

public class ObjectReadEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("c:\\Temp\\tmp.txt"));
			Object s = ois.readObject();
			Box mybox = (Box)ois.readObject();
			System.out.println(s);
			System.out.println("Box width: " + mybox.width);
			System.out.println("Box height: " + mybox.height);
			System.out.println("Box depth: " + mybox.depth);
			System.out.println("Double value : " + ois.readDouble());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
