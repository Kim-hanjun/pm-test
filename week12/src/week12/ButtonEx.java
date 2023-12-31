package week12;

import javax.swing.*;
import java.awt.*;

public class ButtonEx extends JFrame{
	public ButtonEx() {
		setTitle("Button Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		ImageIcon normalIcon = new ImageIcon("image/normalIcon.gif");
		ImageIcon rolloverIcon = new ImageIcon("image/rolloverIcon.gif");
		ImageIcon pressedIcon = new ImageIcon("image/pressedIcon.gif");
		
		JButton btn = new JButton("call~~~", normalIcon);
		btn.setPressedIcon(pressedIcon);
		btn.setRolloverIcon(rolloverIcon);
		
		c.add(btn);
		setSize(250,150);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ButtonEx();
	}

}
