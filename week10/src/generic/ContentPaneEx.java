package generic;
import javax.swing.*;
import java.awt.*;

public class ContentPaneEx extends JFrame {
	public ContentPaneEx() {
		setTitle("ContentPane and JFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container cp = getContentPane();
		cp.setBackground(Color.cyan);
		cp.setLayout(new FlowLayout());
		
		cp.add(new JButton("OK"));
		cp.add(new JButton("Cancel"));
		cp.add(new JButton("Ignore"));
		
		setSize(300,150);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ContentPaneEx();
	}

}
