import java.util.Random;
import pieces.*;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Board{
	
	private static OnePiece next;
	private static OnePiece current;
	
	private static int[][] nextint;
	private static int[][] Currentint;
	
	private static int deX = 30;
	private static int deY = 30;
	private static int sep = 0;
	
	private static int posx = 3;
	private static int posy = 0;
	
	private static int width = 10;
	private static int hight = 20;
	
	private static int board[][] = new int[width][hight];
	private static Rectangle MainBoard[][] = new Rectangle[width][hight];
	
	public Board(){
		
		for(int x = 0; x<width; x++) {
			for(int y = 0; y<hight; y++) {
				MainBoard[x][y] = new Rectangle((deX*x)+sep,(deY*y)+sep,deX,deY);
				MainBoard[x][y].setFill(Color.WHITE);
				MainBoard[x][y].setStroke(Color.BLACK);
				MainBoard[x][y].setStrokeWidth(.5);
			}
		}
		
		setNext();
		setCurrent();
		
	}
	
	public void newPiece() {
		drawCurrent(posx, posy);
		setCurrent();
		setNext();
		posx=3;
		posy=0;
		updateCurrent();
	}

	public void collision() {
		if (Currentint[0].length + posy == 20) {
			newPiece();
		} else {

			if (Currentint.length == 1) {

				if (board[Currentint.length + posx - 1][Currentint[0].length + posy] == 1) {
					newPiece();
				}

			} else if (Currentint.length == 2) {
				
				if (board[Currentint.length + posx - 1][Currentint[0].length + posy - 1] == 1
						&& board[Currentint.length + posx - 2][Currentint[0].length + posy] == 0
						&&!(board[Currentint.length + posx - 1][Currentint[0].length + posy] == 0
						&& board[Currentint.length + posx - 2][Currentint[0].length + posy]==0)) {
					newPiece();
				}else if (board[Currentint.length + posx - 1][Currentint[0].length + posy] == 0
						&& board[Currentint.length + posx - 2][Currentint[0].length + posy-1] == 1
						&&!(board[Currentint.length + posx - 1][Currentint[0].length + posy] == 0
						&& board[Currentint.length + posx - 2][Currentint[0].length + posy]==0)) {
					newPiece();
				}else if(board[Currentint.length + posx - 1][Currentint[0].length + posy] == 1
						&& board [Currentint.length + posx - 2][Currentint[0].length + posy]==1){
					newPiece();
				}

			} else if (Currentint.length == 3) {
				
				if (board[Currentint.length + posx - 1][Currentint[0].length + posy] == 1
						|| board[Currentint.length + posx - 2][Currentint[0].length + posy] == 1
						|| board[Currentint.length + posx - 3][Currentint[0].length + posy] == 1) {
					newPiece();
				}

			} else if (Currentint.length == 4) {

				if (board[Currentint.length + posx - 1][Currentint[0].length + posy] == 1
						|| board[Currentint.length + posx - 2][Currentint[0].length + posy] == 1
						|| board[Currentint.length + posx - 3][Currentint[0].length + posy] == 1
						|| board[Currentint.length + posx - 4][Currentint[0].length + posy] == 1) {
					newPiece();
				}

			}

		}
	}
	
	public void update() {
		
		for(int x = 0; x<width; x++) {
			for(int y = 0; y<hight; y++) {
				if(board[x][y]==1) {
					MainBoard[x][y].setFill(Color.BLACK);
				}
				if(board[x][y]==0) {
					MainBoard[x][y].setFill(Color.WHITE);
				}
			}
			
		}	
		
	}
	
	public void changeBoard(int x,int y,int val) {
		
		board[x-1][y-1] = val;
		
	}
	
	public Rectangle[][] getMain() {
		return MainBoard;
	}
	
	public boolean checkBounds(int x, int y) {
		if(Currentint.length+x<=10&&Currentint[0].length+y<=20) {
			if((Currentint.length+x<=width&&Currentint[0].length+y<=hight)&&x>=0&&y>0) {
				//if(board[Currentint.length+x][Currentint[1].length+y]!=1) {
					return true;
				//}
			}
		}
		return false;
	}
	
	public void clearCurrent() {
		for(int delx = 0; delx<Currentint.length; delx++) {
			for(int dely = 0; dely<Currentint[0].length; dely++) {
				if(board[posx+delx][posy+dely] !=0) {
				board[posx+delx][posy+dely] = 0;
				}
			}
		}
	}
	
	public void drawCurrent(int x, int y){
		for(int delx = 0; delx<Currentint.length; delx++) {
			for(int dely = 0; dely<Currentint[0].length; dely++) {
				if(Currentint[delx][dely]!=0) {
				board[x+delx][y+dely] = Currentint[delx][dely];
				}
			}
		}
		posx = x;
		posy = y;
	}
	
	public void setNext() {
		next = getRandPiece();
		nextint = next.getArray();
	}
	
	public void setCurrent() {
		current = next;
		Currentint = current.getArray();
		//setNext();
		
	}
	
	public void updateCurrent() {
		Currentint = current.getArray();
	}
	
	public void rotateR() {
		clearCurrent();
		update();
		current.next();
		updateCurrent();
		if(checkBounds(posx, posy)) {
			drawCurrent(posx, posy);
		}else {
			current.last();
			updateCurrent();
			drawCurrent(posx, posy);
		}
		update();
		
	}
	
	public void rotateL() {
		clearCurrent();
		update();
		current.last();
		updateCurrent();
		if(checkBounds(posx, posy)) {
			drawCurrent(posx, posy);
		}else {
			current.next();
			updateCurrent();
			drawCurrent(posx, posy);
		}
		update();
		collision();
	}
	
	public void moveR() {
		clearCurrent();
		update();
		if(checkBounds(posx+1, posy)) {
			drawCurrent(posx+1, posy);
		}else {
			drawCurrent(posx, posy);
		}
		update();
		collision();
	}
	
	public void moveL() {
		clearCurrent();
		update();
		if(checkBounds(posx-1, posy)) {
			drawCurrent(posx-1, posy);
		}else {
			drawCurrent(posx, posy);
		}
		update();
		collision();
	}
	
	public void moveD() {
		clearCurrent();
		update();
		if(checkBounds(posx, posy+1)) {
			drawCurrent(posx, posy+1);
		}else {
			drawCurrent(posx, posy);
		}
		update();
		collision();
	}
	
	public int getDeX() {
		return deX;
	}
	public int getDey() {
		return deY;
	}
	public int getSep() {
		return sep;
	}
	public void printGrid(){
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		for(int x = 0; x<width; x++) {
			for(int y = 0; y<hight; y++) {
				System.out.print(" "+board[x][y]+" ");
			}
			System.out.print("\n");
		}
	}
	
	public static OnePiece getRandPiece() {
		
		Random ran = new Random();
		
		int n = ran.nextInt(7); 
		
		return new OnePiece(n+1);
		
	}
	
}
