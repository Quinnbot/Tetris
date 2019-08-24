import java.util.TimerTask;
import java.util.Timer;




public class Controls extends Board {
	/**
	 * rotates right by getting the next state from the onePiece class.
	 */
	public Timer timer = new Timer();
	public void startTimer() {
		
		TimerTask autoDown = new TimerTask() {
	        public void run() {
	            moveD();
	        }
	    };
          
        timer.schedule(autoDown, 0, 1000);
		
	}
	
	public void stopTimer() {
		
		//timer.cancel();
		timer.purge();
		
	}
	
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
		collision();
	}
	
	public void moveR() {
		clearCurrent();
		update();
		if(checkBounds(posx+1, posy)) {//checks if the move will cause problems. 
			drawCurrent(posx+1, posy);//if it does then it will redraw the piece in the same spot.
		}else {
			drawCurrent(posx, posy);
		}
		update();
		collision();
	}
	
	public void moveL() {
		clearCurrent();
		update();
		if(checkBounds(posx-1, posy)) {//checks if the move will cause problems. 
			drawCurrent(posx-1, posy);//if it does then it will redraw the piece in the same spot.
		}else {
			drawCurrent(posx, posy);
		}
		update();
		collision();
	}
	
	public void moveD() {
		clearCurrent();
		update();
		if(checkBounds(posx, posy+1)) {//checks if the move will cause problems. 
			drawCurrent(posx, posy+1);//if it does then it will redraw the piece in the same spot.
		}else {
			drawCurrent(posx, posy);
		}
		update();
		collision();
	}
	/**
	 * debug tool prints out the entire board of ones and zeros
	 */
	public void printGrid(){
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		for(int x = 0; x<width; x++) {
			for(int y = 0; y<height; y++) {
				System.out.print(" "+board[x][y]+" ");
			}
			System.out.print("\n");
		}
	}
}
