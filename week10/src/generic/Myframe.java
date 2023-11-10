package generic;
import javax.swing.*;
import java.awt.*;

public class Myframe extends JFrame{
	public Myframe() {
		setTitle("First Frame");
		setSize(300,300);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		Myframe frame = new Myframe();
	}

}
