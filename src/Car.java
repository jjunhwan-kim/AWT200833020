import java.awt.Frame;


public class Car {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f = new Frame();
		
		f.setLocation(600, 400);

		//f.setTitle("Car Frame");
		f.setTitle(f.getTitle());
		
		f.setSize(300, 300);
		f.setVisible(true);
	}

}
