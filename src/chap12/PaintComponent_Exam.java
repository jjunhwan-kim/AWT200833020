package chap12;

import javax.swing.*;
import java.awt.*;

public class PaintComponent_Exam extends JFrame {
	
	PaintComponent_Exam() {
		setTitle("paintConponentExample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		OurPanel op = new OurPanel(); 		// 패널을 생성
		add(op, BorderLayout.CENTER); 		// 패널을 프레임에붙임
		setSize(300, 300);
		setVisible(true);
	}

	class OurPanel extends JPanel {
		public void paintComponent(Graphics g) {
			// 패널에 도형을 그림
			super.paintComponent(g);		// JPanel의paintComponent()를호출
			g.setColor(Color.YELLOW);		// 노랑색 설정
			g.fillRect(30, 30, 50, 50);		// (30,30) 위치에 50*50크기의 채워진 사각형그림
			g.setColor(Color.GREEN);		// 초록생 설정
			g.fillOval(70, 70, 50, 50);		// (70,70) 위치에 50*50 크기의 채워진 원그림
		}
	}

	public static void main(String[] args) {
		new PaintComponent_Exam();
	}
}