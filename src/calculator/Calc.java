package calculator;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.math.MathContext;

import org.w3c.dom.Text;

public class Calc extends Frame {

	private boolean opFlag, resultFlag, num2Flag, dotFlag;
	
	StringBuffer num1 = new StringBuffer("0");
	StringBuffer num2 = new StringBuffer("0");
	String op, prevInput;
	BigDecimal tmp = null;
	
	Label tLabel = new Label("", Label.RIGHT);
	Label bLabel = new Label("0", Label.RIGHT);
	
	MyActionListener myActionListener = new MyActionListener();
	
	public Calc() {

		super("계산기");					// Frame 부모 클래스 생성자 호출
		
		// 상위 하위 패널 선언
		Panel pTop = new Panel(null);		// 레이아웃 null
		Panel pBottom = new Panel(null);	// 레이아웃 null
		
		// 상위 패널 설정
		pTop.setBounds(0, 0, 270, 135);
		pTop.setBackground(Color.GRAY);
		
		// 하위 패널 설정
		pBottom.setBounds(0, 135, 270, 255);
		pBottom.setBackground(Color.GRAY);
		pBottom.setSize(270, 255);

		// 레이블 설정
		tLabel.setBounds(20, 70, 232, 30);
		tLabel.setBackground(Color.LIGHT_GRAY);
		bLabel.setBounds(20, 100, 232, 30);
		bLabel.setBackground(Color.LIGHT_GRAY);
		
		// 레이블 상위 패널에 삽입
		pTop.add(tLabel);
		pTop.add(bLabel);
		
		// 버튼
		Button btn1 = new Button("MC");		btn1.setBounds(20, 5, 40, 32);  btn1.addActionListener(myActionListener);
		Button btn2 = new Button("MR");		btn2.setBounds(68, 5, 40, 32);	btn2.addActionListener(myActionListener);
		Button btn3 = new Button("MS"); 	btn3.setBounds(116, 5, 40, 32); btn3.addActionListener(myActionListener);
		Button btn4 = new Button("M+");		btn4.setBounds(164, 5, 40, 32); btn4.addActionListener(myActionListener);
		Button btn5 = new Button("M-");		btn5.setBounds(212, 5, 40, 32);	btn5.addActionListener(myActionListener);
		
		Button btn6 = new Button("<");		btn6.setBounds(20, 46, 40, 32); btn6.addActionListener(myActionListener);
		Button btn7 = new Button("CE");		btn7.setBounds(68, 46, 40, 32); btn7.addActionListener(myActionListener);
		Button btn8 = new Button("C");		btn8.setBounds(116, 46, 40, 32); btn8.addActionListener(myActionListener);
		Button btn9 = new Button("±");		btn9.setBounds(164, 46, 40, 32); btn9.addActionListener(myActionListener);
		Button btn10 = new Button("√");	btn10.setBounds(212, 46, 40, 32); btn10.addActionListener(myActionListener);
	
		Button btn11 = new Button("7");		btn11.setBounds(20, 87, 40, 32); btn11.addActionListener(myActionListener);
		Button btn12 = new Button("8");		btn12.setBounds(68, 87, 40, 32); btn12.addActionListener(myActionListener);
		Button btn13 = new Button("9");		btn13.setBounds(116, 87, 40, 32); btn13.addActionListener(myActionListener);
		Button btn14 = new Button("/");		btn14.setBounds(164, 87, 40, 32); btn14.addActionListener(myActionListener);
		Button btn15 = new Button("%");		btn15.setBounds(212, 87, 40, 32); btn15.addActionListener(myActionListener);
		
		Button btn16 = new Button("4");		btn16.setBounds(20, 128, 40, 32); btn16.addActionListener(myActionListener);
		Button btn17 = new Button("5");		btn17.setBounds(68, 128, 40, 32); btn17.addActionListener(myActionListener);
		Button btn18 = new Button("6");		btn18.setBounds(116, 128, 40, 32); btn18.addActionListener(myActionListener);
		Button btn19 = new Button("*");		btn19.setBounds(164, 128, 40, 32); btn19.addActionListener(myActionListener);
		Button btn20 = new Button("1/x");	btn20.setBounds(212, 128, 40, 32); btn20.addActionListener(myActionListener);
		
		Button btn21 = new Button("1");		btn21.setBounds(20, 169, 40, 32); btn21.addActionListener(myActionListener);
		Button btn22 = new Button("2");		btn22.setBounds(68, 169, 40, 32); btn22.addActionListener(myActionListener);
		Button btn23 = new Button("3");		btn23.setBounds(116, 169, 40, 32); btn23.addActionListener(myActionListener);
		Button btn24 = new Button("-");		btn24.setBounds(164, 169, 40, 32); btn24.addActionListener(myActionListener);
		Button btn25 = new Button("=");		btn25.setBounds(212, 169, 40, 73); btn25.addActionListener(myActionListener);
		
		Button btn26 = new Button("0");		btn26.setBounds(20, 210, 88, 32); btn26.addActionListener(myActionListener);
		Button btn27 = new Button(".");		btn27.setBounds(116, 210, 40, 32); btn27.addActionListener(myActionListener);
		Button btn28 = new Button("+");		btn28.setBounds(164, 210, 40, 32); btn28.addActionListener(myActionListener);
		
		// 버튼 하위 패널 삽입
		pBottom.add(btn1); 
		pBottom.add(btn2);
		pBottom.add(btn3);
		pBottom.add(btn4);
		pBottom.add(btn5);
		pBottom.add(btn6);
		pBottom.add(btn7);
		pBottom.add(btn8);
		pBottom.add(btn9);
		pBottom.add(btn10);
		pBottom.add(btn11);
		pBottom.add(btn12);
		pBottom.add(btn13);
		pBottom.add(btn14);
		pBottom.add(btn15);
		pBottom.add(btn16);
		pBottom.add(btn17);
		pBottom.add(btn18);
		pBottom.add(btn19);
		pBottom.add(btn20);
		pBottom.add(btn21);
		pBottom.add(btn22);
		pBottom.add(btn23);
		pBottom.add(btn24);
		pBottom.add(btn25);
		pBottom.add(btn26);
		pBottom.add(btn27);
		pBottom.add(btn28);
		
		setLayout(null);
		setSize(270, 390);
		setResizable(false);
		
		add(pTop);
		add(pBottom);
		
		setVisible(true);

		// WindowAdapter 익명 클래스 리스너
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});	
	}
	
	private class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() instanceof Button) {
				Button btn = (Button) e.getSource();
				String in = btn.getLabel();
				System.out.print(in);

				switch(in) {
				case "MC" : break;
				case "MR" : break;
				case "MS" : break;
				case "M+" : break;
				case "M-" : break;
				case "±" : break;
				case "√" : break;
				case "%" : break;
				case "1/x" : break;
				case "CE" : break;
				
				case "←" :
					// 연산자가 입력되기 전
					if(opFlag == false) {
						if(resultFlag == false) {
							if(num1.length() > 1) num1.deleteCharAt(num1.length() - 1);
							else { 
								num1.deleteCharAt(num1.length() - 1);
								num1.append(0);
							}
							bLabel.setText(num1.toString());
						}
					}
					
					// 연산자가 입력 된 이후
					else {
						// 바로 이전에 연산자가 입력되지 않았을 때
						if(prevInput != "*" && prevInput != "/" && prevInput != "+" && prevInput != "-") {
							// =을 누른 직후는 지워지면 안되며, 연산자 입력 직후도 지워지면 안된다.
							if(resultFlag == false && num2Flag == true) {	
								if(num2.length() > 1) num2.deleteCharAt(num2.length() - 1);
								else { 
									num2.deleteCharAt(num2.length() - 1);
									num2.append(0);
								}
								bLabel.setText(num2.toString());
							}
						}
					}
					break;
				
				// 초기화
				case "C" : 
					opFlag = resultFlag = num2Flag = false;
					num1.delete(0, num1.length()); num1.append(0);
					num2.delete(0, num2.length()); num2.append(0);
					bLabel.setText("0");
					tLabel.setText("");
				break;
				
				// 계산 완료
				case "=" : {
					BigDecimal n1 = new BigDecimal(num1.toString());
					BigDecimal result = new BigDecimal("0");
					
					// "6*=" 같이 num1과 연산자만 입력된 경우
					if(num2Flag == false && opFlag == true) {				
						switch(op) {
							case "+" : result = n1.add(tmp); break;
							case "-" : result = n1.subtract(tmp); break;
							case "*" : result = n1.multiply(tmp); break;
							case "/" : result = n1.divide(tmp); break;
						}
					}
					
					// 숫자만 입력되고 =이 입력된 경우
					else if(num2Flag == false && opFlag == false) result = n1;
					
					// 정상적으로 num1, op, num2 입력 후 =을 입력한 경우와 그 이후에 =을 입력한 경우
					else {				
						BigDecimal n2 = new BigDecimal(num2.toString());	// num2는 고정
						switch(op) {
							case "+" : result = n1.add(n2); break;
							case "-" : result = n1.subtract(n2); break;
							case "*" : result = n1.multiply(n2); break;
							case "/" : result = n1.divide(n2, MathContext.DECIMAL32); break;
						}
					}
					num1.delete(0, num1.length()); num1.append(result.toString());		// 계산 결과를 num1에 저장
					bLabel.setText(result.toString());									// 결과 표시
					tLabel.setText("");													// 계산식 초기화
					resultFlag = true;
					break;
				}
					
				// 소수점
				case "." : 
					// = 버튼을 누른 상황에서 . 버튼을 누르면 초기화
					if(resultFlag == true) {
						opFlag = resultFlag = num2Flag = false;
						bLabel.setText("0");
						num1.delete(0, num1.length()); num1.append(0);
						num2.delete(0, num2.length()); num2.append(0);
					}
					
					if(opFlag == false) {	
						if(num1.indexOf(".") == -1) {						// num1에 소숫점이 존재하지 않을 때
							bLabel.setText(bLabel.getText() + in);
							num1.append(".");
						}
					}
					else {													// 연산자를 쓴 이후
						if(num2.indexOf(".") == -1) {
							if(num2Flag == false) bLabel.setText("0.");		// 연산자 이후에 바로 .을 쓸 때
							else bLabel.setText(bLabel.getText() + ".");	// 연산자 이후 숫자를 쓰고 .을 쓸 때
							num2.append(".");
						}
					}
					break;
				
				// 사칙 연산
				case "+" : case "-" : case "*" : case "/" :
					// 연산자가 처음으로 입력되었을 때
					if(opFlag == false) {
						opFlag = true;
						if(prevInput == ".") {
							num1.deleteCharAt(num1.length() - 1);
							StringBuffer str = new StringBuffer(bLabel.getText());
							str.deleteCharAt(str.length() - 1);
							bLabel.setText(str.toString());
						}
						tLabel.setText(num1.toString() + " " + in);
					}
					
					// 연산자가 두 번째 부터
					else {
						if(resultFlag == false) {	// = 을 누르지 않았을 때
							// 바로 이전에 연산자가 입력되지 않았을 때
							if(prevInput != "*" && prevInput != "/" && prevInput != "+" && prevInput != "-") {	
								tLabel.setText(tLabel.getText() + " " + num2.toString() + " " + in);
								BigDecimal n1 = new BigDecimal(num1.toString());
								BigDecimal n2 = new BigDecimal(num2.toString());
								switch(op) {
									case "+" : n1 = n1.add(n2); break;
									case "-" : n1 = n1.subtract(n2); break;
									case "*" : n1 = n1.multiply(n2); break;
									case "/" : n1 = n1.divide(n2, MathContext.DECIMAL32); break;
								}
								num1.delete(0, num1.length()); num1.append(n1.toString());	
								num2.delete(0, num2.length()); num2.append(0); 		// num2 초기화
								num2Flag = false;									// num2Flag 초기화
								bLabel.setText(num1.toString());					
							}
							// 바로 이전에 연산자가 입력되었을 때 연산자 수정
							else {
								StringBuffer str = new StringBuffer(tLabel.getText());
								str.deleteCharAt(str.length() - 1);
								str.deleteCharAt(str.length() - 1);
								str.append(" "); str.append(in);
								tLabel.setText(str.toString());
							}
						}
						// = 을 눌러서 계산이 완료 된 상황에서 연산자를 눌렀을 때
						else {
							tLabel.setText(num1 + " " +in);
							num2.delete(0, num2.length());
							num2.append(0);
							num2Flag = false;
							resultFlag = false;		
						}
					}
					tmp = new BigDecimal(num1.toString());	// num1 저장
					op = in;								// 연산자 저장
					break;
					
				// 숫자 버튼	
				case "0" : case "1" : case "2" : case "3" : case "4" :
				case "5" : case "6" : case "7" : case "8" : case "9" :
					// = 버튼을 누른 상황에서 숫자 버튼을 누르면 초기화
					if(resultFlag == true) {
						opFlag = resultFlag = num2Flag = false;
						bLabel.setText("0");
						num1.delete(0, num1.length());
						num1.append(0);
						num2.delete(0, num2.length());
						num2.append(0);
					}
				
					// 화면에 연산자가 입력되기 전
					if(opFlag == false) {	
						if(num1.toString().compareTo("0") == 0) {	// StringBuffer num1이 "0" 이면 
							if(in != "0") {							// 입력되는 숫자가 0이 아니면, 앞의 0을 지우고 숫자 삽입
								num1.deleteCharAt(0);
								num1.append(in);
								bLabel.setText("");
								bLabel.setText(bLabel.getText() + in);
							}
						}
						else {										// StringBuffer num1이 "0" 이 아니면 
							num1.append(in);						// 숫자 추가
							bLabel.setText(bLabel.getText() + in);
						}
					}
					
					// 연산자가 한 번이라도 입력된 후
					else {
						num2Flag = true;
						if(num2.toString().compareTo("0") == 0) {	// StringBuffer num2가 "0" 이면
							bLabel.setText("");						// 화면 초기화
							if(in != "0") {							// 입력되는 숫자가 0이 아니면, 앞의 0을 지우고 숫자 삽입
								num2.deleteCharAt(0);
								num2.append(in);
								bLabel.setText(bLabel.getText() + in);
							}
							else {									// 입력되는 숫자가 0이면 화면에만 0 표시
								bLabel.setText("0");
							}
						}
						else {										// StringBuffer num2가 "0" 이 아니면
							num2.append(in);						// 숫자 추가
							bLabel.setText(bLabel.getText() + in);	
						}
					}
					break;
				}
				prevInput = in;										// 이전 핸들러에서 입력 값
			}
		}
	}
	
	public static void main(String[] args) {
		Calc c = new Calc();
	}
}