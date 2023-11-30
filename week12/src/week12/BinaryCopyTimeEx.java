package week12;
import java.io.*;

class BinaryCopy {
	private File src;
	private File dst;
	
	public BinaryCopy(String srcPath) {
		src = new File(srcPath);
	}
	
	public void charCopy() throws IOException {
		dst = new File("C:\\Temp\\charCopyImg.jpg");
		
		FileInputStream fi = new FileInputStream(src);
		FileOutputStream fo = new FileOutputStream(dst);
		
		int c;
		
		while((c = fi.read()) != -1) {
			fo.write((byte)c);
		}
		
		fi.close();
		fo.close();
	}
	public void blockCopy() throws IOException {
		dst = new File("C:\\Temp\\blockCopyImg.jpg");
				
		FileInputStream fi = new FileInputStream(src);
		FileOutputStream fo = new FileOutputStream(dst);
		
		byte[] buf = new byte [1024*10];
		
		while(true) {
			int n = fi.read(buf);
			
			fo.write(buf, 0, n);
			if(n < buf.length) break;
		}
		
		fi.close();
		fo.close();
		
	}
}

public class BinaryCopyTimeEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryCopy bcopy = new BinaryCopy("C:\\Windows\\Web\\Wallpaper\\Theme1\\img1.jpg");
		try {
			long endTime, startTime;
			long charCopyDuration, blockCopyDuration;
			
			startTime = System.nanoTime();
			bcopy.charCopy();
			endTime = System.nanoTime();
			charCopyDuration = endTime - startTime;
			
			startTime = System.nanoTime();
			bcopy.blockCopy();
			endTime = System.nanoTime();
			blockCopyDuration = endTime - startTime;
			
			System.out.println("time for charCopy: " + charCopyDuration);
			System.out.println("time for blockCopy: " + blockCopyDuration);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
