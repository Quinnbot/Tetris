import java.util.TimerTask;
import java.util.Timer;




public class Controls extends Board {
	
	public Timer timer;
	
	public void startTimer() {
		
		timer = new Timer();
		
		TimerTask autoDown = new TimerTask() {
	        public void run() {
	            moveD();
	            printGrid();
	        }
	    };
          
        timer.schedule(autoDown, 1000, 1000);
		
	}
	
	public void stopTimer() {
		
		timer.cancel();
		timer.purge();
		
	}
	
	/**
	 * rotates right by getting the next state from the onePiece class.
	 */
	
	public void rotateR() {
		clearCurrent();
		update();
		current.next();
		updateCurrent();
		if(checkBounds(posx, posy)) {//checks if the move will cause problems. 
			drawCurrent(posx, posy);//if it does then it will redraw the piece in the same spot.
		}else {
			current.last();
			updateCurrent();
			drawCurrent(posx, posy);
		}
		update();
		
	}
	/**
	 * rotates right by getting the next state from the onePiece class.
	 */
	public void rotateL() {
		clearCurrent();
		update();
		current.last();
		updateCurrent();
		if(checkBounds(posx, posy)) {//checks if the move will cause problems. 
			drawCurrent(posx, posy);//if it does then it will redraw the piece in the same spot.
		}else {
			current.next();
			updateCurrent();
			drawCurrent(posx, posy);
		}
		
		update();
		
	}
	
	public void moveR() {
		clearCurrent();
		update();
		if(checkBounds(posx+1, posy) && collision(posx+1, posy)) {//checks if the move will cause problems. 
			drawCurrent(posx+1, posy);//if it does then it will redraw the piece in the same spot.
		}else {
			drawCurrent(posx, posy);
		}
		update();
	}
	
	public void moveL() {
		clearCurrent();
		update();
		if(checkBounds(posx-1, posy) && collision(posx-1, posy)) {//checks if the move will cause problems. 
			drawCurrent(posx-1, posy);//if it does then it will redraw the piece in the same spot.
		}else {
			
			drawCurrent(posx, posy);
		}
		update();
	}
	
	public void moveD() {
		clearCurrent();
		update();
		if(checkBounds(posx, posy+1) && collision(posx, posy+1)) {//checks if the move will cause problems. 
			drawCurrent(posx, posy+1);//if it does then it will redraw the piece in the same spot.
		}else {
			drawCurrent(posx, posy);
			newPiece();
		}
		update();
	}
	/**
	 * debug tool prints out the entire board of ones and zeros
	 */
	public void printGrid(){
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		for(int x = 0; x<height; x++) {
			for(int y = 0; y<width; y++) {
				System.out.print(""+board[y][x]+"");
			}
			System.out.print("\n");
		}
	}
}
