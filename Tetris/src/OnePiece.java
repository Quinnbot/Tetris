

import pieces.*;

public class OnePiece  {
	private static Piece use;//Variable to store the interface of the piece
	
	private static int state  = 1;//what rotation state the piece is in
	/**
	 * picks witch piece this object will represent
	 * @param state
	 */
	public OnePiece(int state){
		if(state==1) {
			use = new Teewee();
		}else if(state==2) {
			use = new Hero();
		}else if(state==3) {
			use = new Smashboy();
		}else if(state==4) {
			use = new OrangeRicky();
		}else if(state==5) {
			use = new blueRicky();
		}else if(state==6) {
			use = new CleveLandZ();
		}else if(state==7) {
			use = new RhodeIslandZ();
		}
		
	}
	/**
	 * @return gets the current array state
	 */
	public int[][] getArray(){
		if(state == 1) {
			return use.get1();
		}else if(state == 2) {
			return use.get2();
		}else if(state == 3) {
			return use.get3();
		}else if(state == 4) {
			return use.get4();
		}
		return null;
	}
	/**
	 * @param s	which state you want from 1 to 4.
	 * @return returns the array for that state.
	 */
	public int[][] setState(int s) {
		state = s;
		
		if(state == 1) {
			return use.get1();
		}else if(state == 2) {
			return use.get2();
		}else if(state == 3) {
			return use.get3();
		}else if(state == 4) {
			return use.get4();
		}
		return null;
		
	}
	/**
	 * cycles through the states forward.
	 * @return next array
	 */
	public int[][] next() {
		if(state == 1) {
			state++;
			return use.get1();
		}else if(state == 2) {
			state++;
			return use.get2();
		}else if(state == 3) {
			state++;
			return use.get3();
		}else if(state == 4) {
			state=1;
			return use.get4();
		}
		return null;
	}
	
	/**
	 * cycles through the states backwards.
	 * @return next array
	 */
	public int[][] last() {
		
		if(state == 1) {
			state=4;
			return use.get1();
		}else if(state == 2) {
			state--;
			return use.get2();
		}else if(state == 3) {
			state--;
			return use.get3();
		}else if(state == 4) {
			state--;
			return use.get4();
		}
		return null;
	}

}