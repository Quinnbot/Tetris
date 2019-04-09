package pieces;

public class Teewee {

	private static int state0[][] = {
			{0,1,0},
			{1,1,1}};
	private static int state1[][] = {
			{0,1,0},
			{1,1,1}};
	private static int state2[][] = {
			{1,0},
			{1,1},
			{1,0}};
	private static int state3[][] = {
			{1,1,1},
			{0,1,0}};
	private static int state4[][] = {
			{0,1},
			{1,1},
			{0,1}};
	
	public Teewee(int state){
		
		if(state==1) {
			state0 = state1;
		}else if(state==2) {
			state0 = state2;
		}else if(state==3) {
			state0 = state3;
		}else if(state==4) {
			state0 = state4;
		}
		
	}
	public int[][] current(){
		return state0;
	}
	public int[][] next() {
		
		if(state0 == state1) {
			state0 = state2;
		}else if(state0 == state2) {
			state0 = state3;
		}else if(state0 == state3) {
			state0 = state4;
		}else if(state0 == state4) {
			state0 = state1;
		}
		
		return state0;
	}
	public int[][] last() {
		
		if(state0 == state1) {
			state0 = state4;
		}else if(state0 == state2) {
			state0 = state1;
		}else if(state0 == state3) {
			state0 = state2;
		}else if(state0 == state4) {
			state0 = state3;
		}
		
		return state0;
	}
	
	public int getWidth() {
		return state0.length;
	}
	
	public int getHight() {
		return state0[1].length;
	}

}
