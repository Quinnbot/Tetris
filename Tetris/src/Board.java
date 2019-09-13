import java.util.Random;
import pieces.*;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Board{
	
	protected static OnePiece next;//next piece
	protected static OnePiece current;//current piece
	
	protected static int[][] nextInt;//next piece int array
	protected static int[][] currentInt;//current picec 
	
	protected static int deX = 30;//box size x
	protected static int deY = 30;//box size y
	protected static int sep = 0;//window padding
	
	protected static int posx = 3;//position of the current piece x
	protected static int posy = 0;//position of the current piece y
	
	protected static int width = 10;//width of the game board
	protected static int height = 20;//Hight of the game board
	
	protected static int board[][] = new int[width][height];//int array of the board
	protected static Rectangle mainBoard[][] = new Rectangle[width][height];//rectangle array of the board
	/**
	 * shows the array of squares. and sets up the first piece.
	 */
	public Board(){
		
		for(int x = 0; x<width; x++) {
			for(int y = 0; y<height; y++) {
				mainBoard[x][y] = new Rectangle((deX*x)+sep,(deY*y)+sep,deX,deY);
				mainBoard[x][y].setFill(Color.WHITE);
				mainBoard[x][y].setStroke(Color.BLACK);
				mainBoard[x][y].setStrokeWidth(.5);
			}
		}
		
		setNext();
		setCurrent();
		
	}
	
	
	/**
	 * leaves the current piece where it is and gets a new one.
	 */
	public void newPiece() {
		drawCurrent(posx, posy);
		setCurrent();
		setNext();
		posx=3;
		posy=0;
		updateCurrent();
	}

	/**
	 * pass in an x and y and see if the current piece would fit.
	 */
	public boolean collision(int x, int y) {
		
		if (currentInt[0].length + posy <= 20) {
			return false;
		}else {
			int[][] boardCopy = board;
			
			for(int delx = 0; delx<currentInt.length; delx++) {
				for(int dely = 0; dely<currentInt[0].length; dely++) {
					if(currentInt[delx][dely]!=0) {
					board[x+delx][y+dely] = currentInt[delx][dely];
					}
				}
			}
			return true;
			
		}
		
		
		
//		if (currentInt[0].length + posy == 20) {
//			newPiece();
//		} else {
//
//			if (currentInt.length == 1) {//1 wide pieces
//
//				if (board[currentInt.length + posx - 1][currentInt[0].length + posy] == 1) {
//					newPiece();
//				}
//
//			} else if (currentInt.length == 2) {//2 wide pieces
//				
//				if (board[currentInt.length + posx - 1][currentInt[0].length + posy - 1] == 1
//						&& board[currentInt.length + posx - 2][currentInt[0].length + posy] == 0
//						&&!(board[currentInt.length + posx - 1][currentInt[0].length + posy] == 0//checks for a right corner
//						&& board[currentInt.length + posx - 2][currentInt[0].length + posy]==0)) {
//					newPiece();
//				}else if (board[currentInt.length + posx - 1][currentInt[0].length + posy] == 0
//						&& board[currentInt.length + posx - 2][currentInt[0].length + posy-1] == 1//checks for a left corner
//						&&!(board[currentInt.length + posx - 1][currentInt[0].length + posy] == 0
//						&& board[currentInt.length + posx - 2][currentInt[0].length + posy]==0)) {
//					newPiece();
//				}else if(board[currentInt.length + posx - 1][currentInt[0].length + posy] == 1
//						&& board [currentInt.length + posx - 2][currentInt[0].length + posy]==1){//checks for a flat surface
//					newPiece();
//				}
//
//			} else if (currentInt.length == 3) {//3 wide pieces
//				
//				if (board[currentInt.length + posx - 1][currentInt[0].length + posy] == 1
//						|| board[currentInt.length + posx - 2][currentInt[0].length + posy] == 1
//						|| board[currentInt.length + posx - 3][currentInt[0].length + posy] == 1) {
//					newPiece();
//				}
//
//			} else if (currentInt.length == 4) {//4 wide pieces
//
//				if (board[currentInt.length + posx - 1][currentInt[0].length + posy] == 1
//						|| board[currentInt.length + posx - 2][currentInt[0].length + posy] == 1
//						|| board[currentInt.length + posx - 3][currentInt[0].length + posy] == 1
//						|| board[currentInt.length + posx - 4][currentInt[0].length + posy] == 1) {
//					newPiece();
//				}
//
//			}
//
//		}
	}
	/**
	 * this translates the ones and zeros in the board array to the frame.
	 */
	public void update() {
		
		for(int x = 0; x<width; x++) {
			for(int y = 0; y<height; y++) {
				if(board[x][y]==1) {
					mainBoard[x][y].setFill(Color.BLACK);
				}
				if(board[x][y]==0) {
					mainBoard[x][y].setFill(Color.WHITE);
				}
			}
			
		}	
		
	}
	/**
	 * change a the pixel at (x, y) to the value of val
	 * 
	 * @param x	x coordinate
	 * @param y	y coordinate
	 * @param val	what it changes to
	 */
	public void changeBoard(int x,int y,int val) {
		
		board[x-1][y-1] = val;
		
	}
	
	/**
	 * @return the main array of rectangle objects.
	 */
	public Rectangle[][] getMain() {
		return mainBoard;
	}
	
	/**
	 * supply x and y checks if the breaks and rules like out of bounds.
	 * @param x	x coordinate
	 * @param y	y coordinate
	 * @return true if the move is legal, false if its not
	 */
	public boolean checkBounds(int x, int y) {
		if(currentInt.length+x<=10&&currentInt[0].length+y<=20) {
			if((currentInt.length+x<=width&&currentInt[0].length+y<=height)&&x>=0&&y>0) {
				//if(board[Currentint.length+x][Currentint[1].length+y]!=1) {
					return true;
				//}
			}
		}
		return false;
	}
	
	/**
	 * clears the current piece thats being used from the board.
	 */
	public void clearCurrent() {
		for(int delx = 0; delx<currentInt.length; delx++) {
			for(int dely = 0; dely<currentInt[0].length; dely++) {
				if(board[posx+delx][posy+dely] !=0) {
				board[posx+delx][posy+dely] = 0;
				}
			}
		}
	}
	/**
	 * draws the current piece at (x, y)
	 * @param x	x coordinate
	 * @param y	y coordinate
	 */
	public void drawCurrent(int x, int y){
		for(int delx = 0; delx<currentInt.length; delx++) {
			for(int dely = 0; dely<currentInt[0].length; dely++) {
				if(currentInt[delx][dely]!=0) {
				board[x+delx][y+dely] = currentInt[delx][dely];
				}
			}
		}
		posx = x;
		posy = y;
	}
	/**
	 * sets the next piece to be used.
	 */
	public void setNext() {
		next = getRandPiece();
		nextInt = next.getArray();
	}
	/**
	 * sets the current piece from the next one.
	 */
	public void setCurrent() {
		current = next;
		currentInt = current.getArray();
		//setNext();
		
	}
	/**
	 * gets the current array for the piece from the onePiece class. 
	 */
	public void updateCurrent() {
		currentInt = current.getArray();
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
	
	/**
	 * @return gets a random piece from the onePiece class.
	 */
	public static OnePiece getRandPiece() {
		
		Random ran = new Random();
		
		int n = ran.nextInt(7); 
		
		return new OnePiece(n+1);
		
	}
	
}
