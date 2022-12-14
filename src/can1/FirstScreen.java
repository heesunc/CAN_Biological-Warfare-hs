package can1;

import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.net.*;
import javax.swing.tree.*;

class Cell implements ActionListener{
	JFrame jf;
	JPanel mainp, lp, rp;
	JButton btn[][] = new JButton[6][6];
	int board[][] = new int[6][6];
	int result[][] = new int[6][6];
	int red = 4, blue = 4, r1 = 0, rr = 0, b = 0, bb = 0;
	ImageIcon r = new ImageIcon("1.gif");
	ImageIcon bl = new ImageIcon("2.gif");
	int turn = 1;
	JLabel rpbred = new JLabel();
	JLabel rpbblue = new JLabel();
	JLabel redct = new JLabel("" + red);
	JLabel bluect = new JLabel("" + blue);
	JLabel left = new JLabel(" ");
	JLabel right = new JLabel(" ");

	Cell() {
		jf = new JFrame("세균전");
		mainp = new JPanel();
		lp = new JPanel();
		rp = new JPanel();
		mainp.setLayout(new GridLayout(1, 1));
		lp.setLayout(new GridLayout(6, 6));
		rp.setLayout(new GridLayout(2, 3));
		lp.setBackground(Color.BLUE);
		rp.setBackground(new Color(-12567));
		lp.setBackground(new Color(-12567));

		rpbred.setBackground(Color.WHITE);
		rpbblue.setBackground(Color.WHITE);

		rpbred.setIcon(new ImageIcon("1_1.gif"));
		rpbblue.setIcon(new ImageIcon("2_1.gif"));

		MenuBar mb = new MenuBar();
		Menu game = new Menu("Game");
		MenuItem nturn = new MenuItem("턴넘기기");
		MenuItem exit = new MenuItem("종료");

		game.add(nturn);
		game.addSeparator();
		game.add(exit);

		mb.add(game);
		jf.setMenuBar(mb);

		nturn.addActionListener(this);
		exit.addActionListener(this);

		rp.add(left);
		rp.add(rpbred);
		rp.add(redct);

		rp.add(right);
		rp.add(rpbblue);
		rp.add(bluect);

		setting();

		mainp.add(lp);
		mainp.add(rp);

		jf.add(mainp);

		jf.setBounds(100, 100, 600, 300);
		jf.show();
		
		jf.setVisible(true);
		jf.setResizable(false);	//사이즈 재조정 불가능
		jf.setLocationRelativeTo(null);	//창이 가운데에 뜨도록 함
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void setting() {
		red=4;
		blue=4;
		
		for (int i=0; i<6; i++) {
			for (int j = 0; j<6; j++){
				if(i < 2 && j<2) {
					btn [i][j] = new JButton ("red");
					btn [i][j].setIcon (r);
					btn [i][j].setBackground (Color.WHITE);
					result[i][j]=1;
		}else if (i>3 && j>3) {
			btn [i][j] = new JButton ("blue");
			btn[i][j].setIcon (bl);
			btn [i][j].setBackground (Color.WHITE);
			result[i][j] =2;
		}else{
			btn [i][j] = new JButton();
			btn [i][j].setIcon (null);
			btn [i][j].setBackground (Color.WHITE);
			result[i][j] = 0;
		}
		board[i][j] = 0;
		btn [i][j].addActionListener(this);
		lp.add (btn [i][j]);
	}
}
}

void select (String s, JButton b) {
	for (int i=0; i<6; i++) {
		for (int j = 0; j<6; j++){
			btn [i][j].setBackground (Color.WHITE);
		}
	}
	
	for (int i=0; i<6; i++) {
		for	(int j = 0; j<6; j++){
		if (btn [i][j] == b && s.equals("red") && turn==1 && result[i][j]==1) {
			board[i][j]=9;
			try {
				btn [i][j+1].setBackground (Color.RED);
				board[i] [j+1] = 1;
			} catch (ArrayIndexOutOfBoundsException e) {}
			try {
				btn [i][j-1].setBackground (Color.RED);
				board[i] [j-1]=1;
			} catch (ArrayIndexOutOfBoundsException e) {}
			try {
				btn [i+1] [j].setBackground (Color.RED);
				board [i+1] [j] =1;
			} catch (ArrayIndexOutOfBoundsException e) {}
			try{
				btn [i+1] [j+1].setBackground (Color.RED);
				board [i+1] [j+1] =1;
			} catch (ArrayIndexOutOfBoundsException e) {}
			try{
				btn [i+1] [j-1].setBackground (Color.RED);
				board [i+1] [j-1]=1;
			} catch (ArrayIndexOutOfBoundsException e) {}
			try{
				btn [i-1] [j].setBackground (Color.RED);
				board [i-1] [j] =1;
			} catch (ArrayIndexOutOfBoundsException e) {}
			try{
				btn [i-1] [j+1].setBackground (Color.RED);
				board [i-1] [j+1] =1;
			} catch (ArrayIndexOutOfBoundsException e) {}
			try{
				btn [i-1] [j-1].setBackground (Color.RED);
				board [i-1] [j-1] =1;
			} catch (ArrayIndexOutOfBoundsException e) {}
			
			try{
				btn [i+2] [j].setBackground (Color.YELLOW);
				board [i+2] [j] =3;
			} catch (ArrayIndexOutOfBoundsException e) {}
			try{
				btn [i-2] [j].setBackground (Color.YELLOW);
				board [i-2] [j] =3;
			} catch (ArrayIndexOutOfBoundsException e) {}
			try{
				btn [i] [j-2].setBackground (Color.YELLOW);
				board [i] [j-2] =3;
			} catch (ArrayIndexOutOfBoundsException e) {}
			try{
				btn [i] [j+2].setBackground (Color.YELLOW);
				board [i] [j+2] =3;
			} catch (ArrayIndexOutOfBoundsException e) {}
			
		}else if(btn[i][j]==b && s.equals("blue") && turn==2 && result[i][j]==2) {
			board[i][j]=9;
			try {
				btn [i][j+1].setBackground (Color.BLUE);
				board[i] [j+1] = 2;
			} catch (ArrayIndexOutOfBoundsException e) {}
			try {
				btn [i][j-1].setBackground (Color.BLUE);
				board[i] [j-1]=2;
			} catch (ArrayIndexOutOfBoundsException e) {}
			try {
				btn [i+1] [j].setBackground (Color.BLUE);
				board [i+1] [j] =2;
			} catch (ArrayIndexOutOfBoundsException e) {}
			try{
				btn [i+1] [j+1].setBackground (Color.BLUE);
				board [i+1] [j+1] =2;
			} catch (ArrayIndexOutOfBoundsException e) {}
			try{
				btn [i+1] [j-1].setBackground (Color.BLUE);
				board [i+1] [j-1]=2;
			} catch (ArrayIndexOutOfBoundsException e) {}
			try{
				btn [i-1] [j].setBackground (Color.BLUE);
				board [i-1] [j] =2;
			} catch (ArrayIndexOutOfBoundsException e) {}
			try{
				btn [i-1] [j+1].setBackground (Color.BLUE);
				board [i-1] [j+1] =2;
			} catch (ArrayIndexOutOfBoundsException e) {}
			try{
				btn [i-1] [j-1].setBackground (Color.BLUE);
				board [i-1] [j-1] =2;
			} catch (ArrayIndexOutOfBoundsException e) {}
			
			try{
				btn [i+2] [j].setBackground (Color.YELLOW);
				board [i+2] [j] =4;
			} catch (ArrayIndexOutOfBoundsException e) {}
			try{
				btn [i-2] [j].setBackground (Color.YELLOW);
				board [i-2] [j] =4;
			} catch (ArrayIndexOutOfBoundsException e) {}
			try{
				btn [i] [j-2].setBackground (Color.YELLOW);
				board [i] [j-2] =4;
			} catch (ArrayIndexOutOfBoundsException e) {}
			try{
				btn [i] [j+2].setBackground (Color.YELLOW);
				board [i] [j+2] =4;
			} catch (ArrayIndexOutOfBoundsException e) {}
		}
	}
}
	
}

	void del() {
		rr=0;
		bb=0;
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
				if(board[i][j]==9) {
					btn[i][j].setIcon(null);
					btn[i][j].setLabel("");
					result[i][j]=0;
					board[i][j]=0;
				}
				}
			}
		}
	
	void sel() {
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++)
				board[i][j]=0;
		}
	}
	
	void copy () {
		r1=0;
		b=0;
		for (int i=0; i<6; i++) {
			for (int j = 0; j<6; j++){
				if (board [i][j] ==7) {
					if (result[i][j] ==1) {
						try {
							if (result[i][j]-result[i-1] [j-1]<0) {
									btn [i-1] [j-1].setIcon (r);
									btn [i-1] [j-1].setLabel("red");
									result[i-1] [j-1] =1;
									r1++;
								}	
							} catch (ArrayIndexOutOfBoundsException e) {}
								try{
									if (result[i][j]-result[i-1] [j]<0) {
									btn [i-1] [j].setIcon (r);
									btn [i-1] [j].setLabel("red");
									result[i-1] [j] = 1;
									r1++;
									}
								} catch (ArrayIndexOutOfBoundsException e) {}
								try{
									if (result[i][j]-result[i-1] [j+1] <0) {
									btn [i-1] [j+1].setIcon (r);
									btn [i-1] [j+1].setLabel("red");
									result[i-1] [j+1] = 1;
									r1++;
									}
								} catch (ArrayIndexOutOfBoundsException e) {}
								try{
									if (result[i][j]-result[i] [j-1] <0) {
									btn [i] [j-1].setIcon (r);
									btn [i] [j-1].setLabel("red");
									result[i] [j-1] = 1;
									r1++;
									}
								} catch (ArrayIndexOutOfBoundsException e) {}
								try{
									if (result[i][j]-result[i] [j+1] <0) {
									btn [i] [j+1].setIcon (r);
									btn [i] [j+1].setLabel("red");
									result[i] [j+1] = 1;
									r1++;
									}
								} catch (ArrayIndexOutOfBoundsException e) {}
								try{
									if (result[i][j]-result[i+1] [j-1] <0) {
									btn [i+1] [j-1].setIcon (r);
									btn [i+1] [j-1].setLabel("red");
									result[i+1] [j-1] = 1;
									r1++;
									}
								} catch (ArrayIndexOutOfBoundsException e) {}
								try{
									if (result[i][j]-result[i+1] [j] <0) {
									btn [i+1] [j].setIcon (r);
									btn [i+1] [j].setLabel("red");
									result[i+1] [j] = 1;
									r1++;
									}
								} catch (ArrayIndexOutOfBoundsException e) {}
								try{
									if (result[i][j]-result[i+1] [j+1] <0) {
									btn [i+1] [j+1].setIcon (r);
									btn [i+1] [j+1].setLabel("red");
									result[i+1] [j+1] = 1;
									r1++;
									}
								} catch (ArrayIndexOutOfBoundsException e) {}
					}
					else {
						try {
							if (result[i][j]-result[i-1] [j-1]==1) {
									btn [i-1] [j-1].setIcon (bl);
									btn [i-1] [j-1].setLabel("blue");
									result[i-1] [j-1] =2;
									b++;
								}	
							} catch (ArrayIndexOutOfBoundsException e) {}
								try{
									if (result[i][j]-result[i-1] [j]==1) {
									btn [i-1] [j].setIcon (bl);
									btn [i-1] [j].setLabel("blue");
									result[i-1] [j] = 2;
									b++;
									}
								} catch (ArrayIndexOutOfBoundsException e) {}
								try{
									if (result[i][j]-result[i-1] [j+1]==1) {
									btn [i-1] [j+1].setIcon (bl);
									btn [i-1] [j+1].setLabel("blue");
									result[i-1] [j+1] = 2;
									b++;
									}
								} catch (ArrayIndexOutOfBoundsException e) {}
								try{
									if (result[i][j]-result[i] [j-1]==1) {
									btn [i] [j-1].setIcon (bl);
									btn [i] [j-1].setLabel("blue");
									result[i] [j-1] = 2;
									b++;
									}
								} catch (ArrayIndexOutOfBoundsException e) {}
								try{
									if (result[i][j]-result[i] [j+1]==1) {
									btn [i] [j+1].setIcon (bl);
									btn [i] [j+1].setLabel("blue");
									result[i] [j+1] = 2;
									b++;
									}
								} catch (ArrayIndexOutOfBoundsException e) {}
								try{
									if (result[i][j]-result[i+1] [j-1]==1) {
									btn [i+1] [j-1].setIcon (bl);
									btn [i+1] [j-1].setLabel("blue");
									result[i+1] [j-1] = 2;
									b++;
									}
								} catch (ArrayIndexOutOfBoundsException e) {}
								try{
									if (result[i][j]-result[i+1] [j]==1) {
									btn [i+1] [j].setIcon (bl);
									btn [i+1] [j].setLabel("blue");
									result[i+1] [j] = 2;
									b++;
									}
								} catch (ArrayIndexOutOfBoundsException e) {}
								try{
									if (result[i][j]-result[i+1] [j+1]==1) {
									btn [i+1] [j+1].setIcon (bl);
									btn [i+1] [j+1].setLabel("blue");
									result[i+1] [j+1] = 2;
									b++;
									}
								} catch (ArrayIndexOutOfBoundsException e) {}
					}
				}
			}
		}
		if(r1 != 0) {
			red += r1;
			blue -= r1;
		}
		else if(b!=0) {
			blue += b;
			red -= b;
		}
		r1=0;
		b=0;
		
		if((blue+red)==36 || red==0 || blue==0) {
			System.exit(0);
		}
	}
	
	public void actionPerformed (ActionEvent e) {
		String s = e.getActionCommand();
		
		if (s.equals("턴넘기기")) {
			if (turn==1) {
				turn=2;
				rp.setBackground (new Color (-12333333));
			}
			else {
				turn=1;
				rp.setBackground (new Color (-12567));
			}
		}
		else if (s.equals("종료"))
			System.exit(0);
		else {
			JButton b=(JButton)e.getSource();
			
			for (int i=0; i<6; i++) {
				for	(int j=0; j<6 ;j++){
					if (b==btn [i][j] && board[i][j]==1 && btn[i][j].getLabel() !="blue" && result[i][j] !=1) {
					red++;
					btn [i][j].setIcon (r);
					btn [i][j].setLabel("red");
					result[i][j] =1;
					turn=2;
					rp.setBackground (new Color (-12333333));
					lp.setBackground (new Color (-12333333));
					sel();
					board[i][j] =7;
					copy();
				} else if (b==btn [i][j] && board[i][j]==2 && btn[i][j].getLabel() !="red" && result[i][j] !=2) {
					blue++;
					btn [i][j].setIcon (bl);
					btn [i][j].setLabel("blue");
					result[i][j] =2;
					turn=1;
					rp.setBackground (new Color (-12567));
					lp.setBackground (new Color (-12567));
					sel();
					board[i][j] =7;
					copy();
				} else if (b==btn [i][j] && board[i][j]==3 && btn[i][j].getLabel() !="blue" && result[i][j] !=3) {
					del();
					btn [i][j].setIcon (r);
					btn [i][j].setLabel("red");
					result[i][j] =1;
					turn=2;
					rp.setBackground (new Color (-12333333));
					lp.setBackground (new Color (-12333333));
					sel();
					board[i][j] =7;
					copy();
				} else if (b==btn [i][j] && board[i][j]==4 && btn[i][j].getLabel() !="red" && result[i][j] !=4) {
					del();
					btn [i][j].setIcon (bl);
					btn [i][j].setLabel("blue");
					result[i][j] =2;
					turn=1;
					rp.setBackground (new Color (-12567));
					lp.setBackground (new Color (-12567));
					sel();
					board[i][j] =7;
					copy();
				} else if (b==btn[i][j]&&(board[i][j]>4 || board[i][j]==0)) {
					sel();
				}
			}
		}
		select(s,b);
		redct.setText(""+red);
		bluect.setText(""+blue);
		if(blue+red==36)
			jf.dispose();
			
	}
	
	}
}


// 첫 화면 GUI 코드 =======================================================
public class FirstScreen extends JFrame {
	public FirstScreen(){
		setTitle("세균전");
		
		// 게임 시작 버튼
		JPanel pan1 = new JPanel();
		JButton btn1 = new JButton("게임 시작");
		
		btn1.setBounds(95,70,100,50);
		pan1.add(btn1);	
		add(btn1);
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Cell();
				setVisible(false);
			}
		});
		
		// 게임 저장 버튼
		JPanel pan2 = new JPanel();
		JButton btn2 = new JButton("게임 로드");
		
		btn2.setBounds(95,140,100,50);
		
		pan2.add(btn2);
		add(btn2);
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(fc);
				//게임 불러오기에서 PC의 디렉토리에서 파일을 찾을 수 있도록 GUI를 제공해야 한다.
				//게임 저장 시 파일명을 지정하고, 파일의 위치를 선택할 수 있어야 한다.
				setVisible(false);
			}
		});
		
		// 게임 종료 버튼
		JPanel pan3 = new JPanel();
		JButton btn3 = new JButton("게임 종료");
		
		btn3.setBounds(95,210,100,50);
		pan3.add(btn3);	
		add(btn3);
		
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDefaultCloseOperation(EXIT_ON_CLOSE);
				setVisible(false);
			}
		});
		
		setLayout(null);
		setVisible(true);	//창을 눈에 보이도록 함
		setSize(300, 400);	//사이즈 정의
		setResizable(false);	//사이즈 재조정 불가능
		setLocationRelativeTo(null);	//창이 가운데에 뜨도록 함
		setDefaultCloseOperation(EXIT_ON_CLOSE);	//창을 끄면 프로그램을 종료
	}
}

//======================================================================

class GameStart{ 
	public static void main(String[] args) {
		//new Cell();
		new FirstScreen();
	}
}