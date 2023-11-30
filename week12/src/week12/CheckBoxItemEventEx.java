package week12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckBoxItemEventEx extends JFrame {
	private JCheckBox[] fruits = new JCheckBox[3];
	private String[] names = {"사과","배","체리"};
	private int[] prices = {15000, 7000, 27000};
	
	private JLabel sumLabel;
	
	public CheckBoxItemEventEx() {
		setTitle("CheckBox and ItemEvent Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new JLabel("사과 15000원, 배 7000원, 체리 27000원"));
		
		MyItemListener itemListener = new MyItemListener();
		
		for(int i = 0; i < fruits.length; i++) {
			fruits[i] = new JCheckBox(names[i]);
			fruits[i].setBorderPainted(true);
			c.add(fruits[i]);
			fruits[i].addItemListener(itemListener);
		}
		
		sumLabel = new JLabel("현재 0 원 입니다.");
		c.add(sumLabel);
		setSize(250, 150);
		setVisible(true);
	}
	class MyItemListener implements ItemListener {
		private int sum = 0;
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				for(int i = 0; i < fruits.length; i++) {
					if(e.getItem() == fruits[i]) {
						sum += prices[i];
					}
				}
			} else {
				for(int i = 0; i < fruits.length; i++) {
					if(e.getItem() == fruits[i]) {
						sum -= prices[i];
					}
				}
			}
			sumLabel.setText("현재 " + sum + "원 입니다.");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CheckBoxItemEventEx();
	}

}
