

import pieces.*;

public class OnePiece  {
	private static Piece use;
	
	private static int state  = 1;
	
	public OnePiece(int state){
		System.out.print(state+"\n");
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