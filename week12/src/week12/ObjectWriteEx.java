package week12;
import java.io.*;

class Box implements Serializable{
	public int width;
	public int height;
	public int depth;
	
	public Box(int w, int h, int d) {
		width = w;
		height = h;
		depth = d;
	}
}


public class ObjectWriteEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "*** 박스의 가로, 세로, 높이 ***";
		Box mybox = new Box(10,20,30);
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("c:\\temp\\tmp.txt"));
			oos.writeObject(s);
			oos.writeObject(mybox);
			oos.writeDouble(123.456);
			oos.close();
			System.out.println("object file stored to c:\\temp\\tmp.txt");
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
