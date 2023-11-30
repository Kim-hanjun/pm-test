package week12;
import java.io.*;
import java.util.Scanner;


public class FileReaderEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sin = new Scanner(System.in);
		System.out.print("Filename to read : ");
		
		String s = sin.next();
		
		try {
			FileReader fr = new FileReader(s);
			int i;
			while((i = fr.read()) != -1) {
				System.out.print((char)i);
			}
			fr.close();
		} catch (IOException e) {
			System.out.println("Failed to read file " + s + e.getMessage());
			e.printStackTrace();
		}
	}

}
