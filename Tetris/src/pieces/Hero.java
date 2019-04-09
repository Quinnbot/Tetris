package pieces;

public class Hero {

	private static int state0[][] = {
			{1},
			{1},
			{1},
			{1}};
	
	private static int state1[][] = {
			{1},
			{1},
			{1},
			{1}};
	private static int state2[][] = {
			{1,1,1,1}};
	
	
	public Hero(int state){
		
	}
	public int[][] current(){
		return state0;
	}
	public int[][] next() {
		
		if(state0 == state1) {
			state0 = state2;
		}if(state0 == state2) {
			state0 = state1;
		}
		
		return state0;
	}
	
	public int[][] last() {
		
		if(state0 == state1) {
			state0 = state2;
		}if(state0 == state2) {
			state0 = state1;
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