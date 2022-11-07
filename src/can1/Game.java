import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.net.*;
import javax.swing. tree.*;

class Game implements ActionListener(
	JFrame jf;
	JPanel mainp, lp, rp;
	JButton btn[] [] = new JButton [6] [6];
	int board [] []= new int [6] [6];
	int result[] [] = new int [6] [6];
	int red=4, blue=4, r1=0, rr=0, b=0, bb=0;
	ImageIcon r = new ImageIcon ("1.gif");
	ImageIcon b1 = new ImageIcon ("2.gif");
	int turn=1;
	JLabel rpbred = new JLabel();
	JLabel rpbblue = new JLabel();
	JLabel redct = new JLabel(""+red);
	JLabel bluect = new JLabel(""+blue);
	JLabel left = new JLabel(" ");
	JLabel right = new JLabel(" ");
	
	Game () {
	jf = new JFrame ("세균전");
	mainp = new JPanel();
	lp = new JPanel();
	rp = new JPanel();
	mainp.setLayout (new GridLayout (1,1));
	lp.setLayout (new GridLayout (6, 6));
	rp.setLayout (new GridLayout (2,3));
	lp.setBackground (Color.BLUE);
	rp.setBackground (new Color (-12567));
	lp.setBackground (new Color (-12567));
	
	rpbred.setBackground (Color.WHITE);
	rpbblue.setBackground (Color.WHITE);
	
	rpbred.setIcon (new ImageIcon("1_1.gif"));
	rpbblue.setIcon (new ImageIcon("2_1.gif"));
	
	MenuBar mb = new MenuBar () ;
	Menu game = new Menu ("Game");
	MenuItem nturn = new MenuItem("턴넘기기");
	MenuItem exit = new MenuItem("종료");
	
	game.add(nturn);
	game.addSeparator ();
	game.add (exit);
	
	mb.add (game);
	jf.setMenuBar (mb);
	
	nturn.addActionListener(this);
	exit.addActionListener(this);
	
	rp.add(left);
	rp.add (rpbred);
	rp.add(redct);
	
	rp.add(right);
	rp.add(rpbblue);
	rp.add(bluect);
	
	setting();
	
	mainp.add(lp);
	mainp.add (rp);
	
	jf.add(mainp);
	
	jf.setBounds (100, 100, 600, 300);
	jf.show();
	
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

	private void setting() {
		// TODO Auto-generated method stub
		kjljkljkljk
		asfsafasf
		safasf
		
		
	}