import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Keypad extends Frame implements ActionListener {

	TextField display = new TextField();
	
	public Keypad() {
		
		//add(display, "North");
		add(display, BorderLayout.NORTH);
		add(buildKeypanel(), BorderLayout.CENTER);
		
		setSize(300, 400);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	private Panel buildKeypanel() {
		Panel panel = new Panel();
		
		panel.setLayout(new GridLayout(4, 3));
		
/*		Button btn1 = new Button("1"); btn1.addActionListener(listener);
		Button btn2 = new Button("2"); btn2.addActionListener(listener);
		Button btn3 = new Button("3"); btn3.addActionListener(listener);
		Button btn4 = new Button("4"); btn4.addActionListener(listener);
		Button btn5 = new Button("5"); btn5.addActionListener(listener);
		Button btn6 = new Button("6"); btn6.addActionListener(listener);
		Button btn7 = new Button("7"); btn7.addActionListener(listener);
		Button btn8 = new Button("8"); btn8.addActionListener(listener);
		Button btn9 = new Button("9"); btn9.addActionListener(listener);
		Button btn10 = new Button("*"); btn10.addActionListener(listener);
		Button btn11 = new Button("0"); btn11.addActionListener(listener);
		Button btn12 = new Button("#"); btn12.addActionListener(listener);
		
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);
		panel.add(btn6);
		panel.add(btn7);
		panel.add(btn8);
		panel.add(btn9);
		panel.add(btn10);
		panel.add(btn11);
		panel.add(btn12);*/
		
		panel.add(new KeyButton("1"));
		panel.add(new KeyButton("2"));
		panel.add(new KeyButton("3"));
		panel.add(new KeyButton("4"));
		panel.add(new KeyButton("5"));
		panel.add(new KeyButton("6"));
		panel.add(new KeyButton("7"));
		panel.add(new KeyButton("8"));
		panel.add(new KeyButton("9"));
		panel.add(new KeyButton("*"));
		panel.add(new KeyButton("0"));
		panel.add(new KeyButton("#"));
		
		
		return panel;
	}
	
	// 다시 얘기 다음시간에
	
	
	class KeyButton extends Button { //implements ActionListener {

		public KeyButton(String label) {
			super(label);
			addActionListener(Keypad.this);	// 다음시간
		}
		
		/*@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() instanceof Button) {
				Button btn = (Button) e.getSource();
				display.setText(display.getText() + btn.getLabel());
			}
		}*/	
	}
	
	/*class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() instanceof Button) {
				Button btn = (Button) e.getSource();
				display.setText(display.getText() + btn.getLabel());
			}
		}
	}
	
	MyActionListener listener = new MyActionListener();*/
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() instanceof Button) {
			Button btn = (Button) e.getSource();
			display.setText(display.getText() + btn.getLabel());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Keypad();
	}
	
}
