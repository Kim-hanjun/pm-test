package week12;
import java.io.*;
import java.util.Scanner;


public class FileWriterEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sin = new Scanner(System.in);
		
		String source = "많고 많은 사람 중에 그대 한 사람 \n"
				+ "너무 맑고 초롱한 그 중 하나 별이야\n"
				+ "그대만큼 사랑스러운 사람을 본 일이 없다\n";
		System.out.print("Enter filename: ");
		String s = sin.next();
		
		try {
			FileWriter fw = new FileWriter(s);
			
			fw.write(source);
			fw.close();
			
			System.out.print(s + " file created");
		} catch (IOException e) {
			System.out.println("Failed to create file : " + s + e.getMessage());
			e.printStackTrace();
		}
	}

}
