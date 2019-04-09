package pieces;

public class ClevelandZ {

	private static int state0[][] = {
			{1,1,0},
			{0,1,1}};
	private static int state1[][] = {
			{1,1,0},
			{0,1,1}};
	private static int state2[][] = {
			{0,1},
			{1,1},
			{1,0}};
	
	public ClevelandZ(int state){
		
		if(state==1) {
			state0 = state1;
		}else if(state==2) {
			state0 = state2;
		}
		
	}
	public int[][] current(){
		return state0;
	}
	public int[][] next() {
		
		if(state0 == state1) {
			state0 = state2;
		}else if(state0 == state2) {
			state0 = state1;
		}
		
		return state0;
	}
	public int[][] last() {
		
		if(state0 == state1) {
			state0 = state2;
		}else if(state0 == state2) {
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
