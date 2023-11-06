import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MayinTarlasi implements MouseListener {
	JFrame frame;
	Btn[][] board = new Btn[10][10];
	int openCount;
	int mineCount;
	
	public MayinTarlasi() {
		 frame = new JFrame("Mayin Tarlasi");
		 frame.setSize(800, 800);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setLayout(new GridLayout(10,10));
		 
		 openCount=0;
		 for(int row = 0; row < board.length; row++) {
			 for(int col = 0; col< board[0].length; col++) {
				 Btn b = new Btn(row,col);
				 frame.add(b);
				 
				 board[row][col] = b; 
				 b.addMouseListener(this);
			 }
		 }
		
		 mineCount = 10;
		 generateMine(mineCount);
		 
		
		 
		 
		 //print();
		 
		 frame.setVisible(true);
		
	}
	
	
	 
	 public void generateMine(int mineCount){
		 
		 Random rnd = new Random();
		 
		 
		 int row = 0; int col = 0;
		 while(mineCount > 0) {
			 
			 int random = rnd.nextInt(board[0].length);
			 
			 while(board[row][random].isMine()) {
				 random = rnd.nextInt(board[0].length);
			 }
			 
			 board[row][random].setMine(true);
			 mineCount--;
			 row++;
			 
			 if(row>= board.length) {
				 row = 0;
			 }
			 
						 
		 }
		 
		 updateCount();
	 }
	 

	 
	 public void print() {
		 for(int row = 0; row < board.length; row++) {
			 for(int col = 0; col< board[0].length; col++) {
				 if(board[row][col].isMine()) {
					 board[row][col].setIcon(new ImageIcon("mine.png"));
				 }
				 else {
					 board[row][col].setText(Integer.toString(board[row][col].getCount()));
				 }
			 }
		 }
	 }


	 public void updateCount() {
		 for(int row = 0; row < board.length; row++) {
			 for(int col = 0; col< board[0].length; col++) {
				 if(board[row][col].isMine()) {
					 counting(row,col);
				 }
			 }
		 }
	 }

	public void counting(int row, int col) {
		 for(int i = row -1 ; i <= row+1; i++) {
			 for(int j = col-1; j<= col+1; j++) {
				 
				 try {
					 if(!board[i][j].isMine()) {
						 board[i][j].setCount(board[i][j].getCount()+1);
					 }
				 }
				 catch(Exception e) {
					 
				 }
				 
				 /*if(i>=0 && j>=0 && i<10 && j <10) {
					 if(!board[i][j].isMine()) {
						 board[i][j].setCount(board[i][j].getCount()+1);
					 }
				 }*/
			 }
		 }
	}
	
	public void openBox(int r, int c) {

		if (r < 0 || r>= board.length || c < 0 || c >= board[0].length || board[r][c].getText().equals(null) || board[r][c].isEnabled() == false) {
			 return;
		}
		else if (board[r][c].getCount() != 0) {
			board[r][c].setText(board[r][c].getCount()+"");
			board[r][c].setEnabled(false);
			openCount++;
		}else {
			board[r][c].setEnabled(false);
			openCount++;
			openBox(r-1,c);
			openBox(r+1,c);
			openBox(r,c-1);
			openBox(r,c+1);
		}
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
		Btn b = (Btn) e.getComponent();		
		
		if(e.getButton() == 1) {
			
			if(b.isMine()) {
				JOptionPane.showMessageDialog(frame, "Mayına bastınız Oyun Bitti");
				print();
			}
			else {
				 openBox(b.getRow(), b.getCol());
				 if(openCount == (board.length * board[0].length) - mineCount) {
					 JOptionPane.showMessageDialog(frame, "Tebrikler oyunu kazandınız" );
				 }
			}
			
		}
		else if(e.getButton() == 3) {
			System.out.println("Sağ tık");
			if(!b.isFlag()) {
				b.setIcon(new ImageIcon("flag.png"));
				b.setFlag(true);
			}
			else {
				b.setIcon(null);
				b.setFlag(false);
			}
		}
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	 
}
