package eyes;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;

public class Eyes extends Frame implements MouseMotionListener{

	EyeBall e1 = new EyeBall();
	EyeBall e2 = new EyeBall();
	
	public Eyes() {
		super("Eyes");
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.exit(0);
			}
		});
		addMouseMotionListener(this);
		setSize(800, 800);
		setVisible(true);
		
	}
	
	public void paint(Graphics g) {
		
		e1.geteyes(380, 380, 30);
		e2.geteyes(310, 380, 30);
		
		g.drawOval(350, 350, 75, 80);
		g.drawOval(280, 350, 75, 80); 
		
		g.fillOval(e1.give_eyeballx(), e1.give_eyebally(), 20, 20);
		g.fillOval(e2.give_eyeballx(), e2.give_eyebally(), 20, 20);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		int xm  = e.getY();
		int ym = e.getX();
		
		e1.getmouse(xm, ym);
		e2.getmouse(xm, ym);
		
		//repaint();		// 윈도우가 가려지면 다시 호출
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Eyes();
	}

}
