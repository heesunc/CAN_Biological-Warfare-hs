import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.net.*;
import javax.swing.tree.*;

class Game implements ActionListener(
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

Game() {
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
				board[i] [j+1] = 1;
			} catch (ArrayIndexOutOfBoundsException e) {}
			try {
				btn [i][j-1].setBackground (Color.BLUE);
				board[i] [j-1]=1;
			} catch (ArrayIndexOutOfBoundsException e) {}
			try {
				btn [i+1] [j].setBackground (Color.BLUE);
				board [i+1] [j] =1;
			} catch (ArrayIndexOutOfBoundsException e) {}
			try{
				btn [i+1] [j+1].setBackground (Color.BLUE);
				board [i+1] [j+1] =1;
			} catch (ArrayIndexOutOfBoundsException e) {}
			try{
				btn [i+1] [j-1].setBackground (Color.BLUE);
				board [i+1] [j-1]=1;
			} catch (ArrayIndexOutOfBoundsException e) {}
			try{
				btn [i-1] [j].setBackground (Color.BLUE);
				board [i-1] [j] =1;
			} catch (ArrayIndexOutOfBoundsException e) {}
			try{
				btn [i-1] [j+1].setBackground (Color.BLUE);
				board [i-1] [j+1] =1;
			} catch (ArrayIndexOutOfBoundsException e) {}
			try{
				btn [i-1] [j-1].setBackground (Color.BLUE);
				board [i-1] [j-1] =1;
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
	
	
}