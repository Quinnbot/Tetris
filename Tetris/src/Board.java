import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Board extends PieceHandler{
	
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
	
//	public boolean Check(int x, int y) {
//		
//		if()
//		
//		return false;
//	}
	
	public void clearCurrent() {
		for(int delx = 0; delx<Currentint.length; delx++) {
			for(int dely = 0; dely<Currentint[1].length; dely++) {
				board[posx+delx][posy+dely] = 0;
				
			}
		}
	}
	
	public void drawCurrent(int x, int y){
		for(int delx = 0; delx<Currentint.length; delx++) {
			for(int dely = 0; dely<Currentint[1].length; dely++) {
				board[x+delx][y+dely] = Currentint[delx][dely];
				
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
		drawCurrent(posx, posy);
		update();
	}
	
	public void rotateL() {
		clearCurrent();
		update();
		current.last();
		updateCurrent();
		drawCurrent(posx, posy);
		update();
	}
	
	public void moveR() {
		clearCurrent();
		update();
		drawCurrent(posx+1, posy);
		update();
	}
	
	public void moveL() {
		clearCurrent();
		update();
		drawCurrent(posx-1, posy);
		update();
	}
	
	public void moveD() {
		clearCurrent();
		update();
		drawCurrent(posx, posy+1);
		update();
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
	
}
