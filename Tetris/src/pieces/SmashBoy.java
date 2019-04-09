package pieces;

public class SmashBoy {

	private static int state0[][] = {
			{1,1},
			{1,1}};
	
	public SmashBoy(int state){
		
	}
	public int[][] current(){
		return state0;
	}
	public int[][] next() {
		return state0;
	}
	
	public int[][] last() {
		return state0;
	}
	
	public int getWidth() {
		return 2;
	}

	public int getHight() {
		return 2;
	}
}
