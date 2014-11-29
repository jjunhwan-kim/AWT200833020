import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.concurrent.Delayed;


public class CarFrame extends Frame {
	
	public CarFrame() {
		MyListener listener = new MyListener();
		//addWindowListener(new MyWindowListener());
		addWindowListener(new MyWindowAdapter());
		Button btn1 = new Button("BTN1");
		Button btn2 = new Button("BTN2");
		Button btn3 = new Button("BTN3");
		Button btn4 = new Button("BTN4");
		Button btn5 = new Button("BTN5");
		//btn1.setLabel("BTN1");
		//btn1.setSize(40,15);
		//btn1.setLocation(50, 50);
		//btn1.setBounds(50, 50, 40, 15);
		
		btn1.addActionListener(listener);
		btn2.addActionListener(listener);
		btn3.addActionListener(listener);
		btn4.addActionListener(listener);
		btn5.addActionListener(listener);
//		this.add(btn1, "North");
//		this.add(new Button("BTN2"), BorderLayout.SOUTH);
//		this.add(new Button("BTN3"), "West");
//		this.add(new Button("BTN4"),  "East");
//		this.add(new Button("BTN5"), "Center");
	
		//FlowLayout layout = new FlowLayout();
		//setLayout(layout);
		//setLayout(new FlowLayout());
		//setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(Color.GREEN);
		//panel.setLayout(new BorderLayout());
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);
		
//		panel.add(new Button("BTN2"));
//		panel.add(new Button("BTN3"));
//		panel.add(new Button("BTN4"));
//		panel.add(new Button("BTN5"));

		this.add(panel, BorderLayout.NORTH);
		
		setTitle("Car Frame");
		setSize(300, 200);
		setVisible(true);
	}
	
	// 내부 클래스 리스너 구현
	class MyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Button button = (Button) e.getSource();			// 이벤트 소스를 받아옴
			if(button.getBackground() == Color.red)
				button.setBackground(Color.white);
			else button.setBackground(Color.red);
			System.out.println("Click..." + button.getLabel());
		}
		
	}
	
	class MyWindowListener implements WindowListener {

		@Override
		public void windowActivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent arg0) {
			// TODO Auto-generated method stub
			System.exit(0);
		}

		@Override
		public void windowDeactivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowOpened(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class MyWindowAdapter extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent arg0) {
			// TODO Auto-generated method stub
			//super.windowClosing(arg0);
			System.exit(0);
		}
		
	}
	public static void main(String [] args) {
		new CarFrame();
	}
	
}
