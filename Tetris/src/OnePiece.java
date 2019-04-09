public class OnePiece {
	//basic
	private static int state0[][] = {
			{1}};
	private static int state1[][] = {
			{1}};
	private static int state2[][] = {
			{1}};
	private static int state3[][] = {
			{1}};
	private static int state4[][] = {
			{1}};
	
	//Teewee
	private static int Teewee1[][] = {
			{0,1,0},
			{1,1,1}};
	private static int Teewee2[][] = {
			{1,0},
			{1,1},
			{1,0}};
	private static int Teewee3[][] = {
			{1,1,1},
			{0,1,0}};
	private static int Teewee4[][] = {
			{0,1},
			{1,1},
			{0,1}};
	
	//blueRicky
	private static int BlueRicky1[][] = {
			{1,0,0},
			{1,1,1}};
	private static int BlueRicky2[][] = {
			{1,1},
			{1,0},
			{1,0}};
	private static int BlueRicky3[][] = {
			{1,1,1},
			{0,0,1}};
	private static int BlueRicky4[][] = {
			{0,1},
			{0,1},
			{1,1}};
	
	//OrangeRicky
	private static int OrangeRicky1[][] = {
			{0,0,1},
			{1,1,1}};
	private static int OrangeRicky2[][] = {
			{1,0},
			{1,0},
			{1,1}};
	private static int OrangeRicky3[][] = {
			{1,1,1},
			{1,0,0}};
	private static int OrangeRicky4[][] = {
			{1,1},
			{0,1},
			{0,1}};
	
	//CleveLandZ
	private static int ClevelandZ1[][] = {
			{1,1,0},
			{0,1,1}};
	private static int ClevelandZ2[][] = {
			{0,1},
			{1,1},
			{1,0}};
	
	//RhodeIslandZ
	private static int RhodeIslandZ1[][] = {
			{0,1,1},
			{1,1,0}};
	private static int RhodeIslandZ2[][] = {
			{1,0},
			{1,1},
			{0,1}};
	
	//Hero
	private static int Hero1[][] = {
			{1},
			{1},
			{1},
			{1}};
	private static int Hero2[][] = {
			{1,1,1,1}};
	
	//Smashboy
	private static int SmashBoy1[][] = {
			{1,1},
			{1,1}};
	
	public OnePiece(int state){
		
		if(state==1) {
			state0 = Teewee1;
			state1 = Teewee1;
			state2 = Teewee2;
			state3 = Teewee3;
			state4 = Teewee4;
		}else if(state==2) {
			state0 = Hero1;
			state1 = Hero1;
			state2 = Hero2;
			state3 = Hero1;
			state4 = Hero2;
		}else if(state==3) {
			state0 = SmashBoy1;
			state1 = SmashBoy1;
			state2 = SmashBoy1;
			state3 = SmashBoy1;
			state4 = SmashBoy1;
		}else if(state==4) {
			state0 = OrangeRicky1;
			state1 = OrangeRicky1;
			state2 = OrangeRicky2;
			state3 = OrangeRicky1;
			state4 = OrangeRicky2;
		}else if(state==5) {
			state0 = BlueRicky1;
			state1 = BlueRicky1;
			state2 = BlueRicky2;
			state3 = BlueRicky3;
			state4 = BlueRicky4;
		}else if(state==6) {
			state0 = ClevelandZ1;
			state1 = ClevelandZ1;
			state2 = ClevelandZ2;
			state3 = OrangeRicky1;
			state4 = ClevelandZ2;
		}else if(state==7) {
			state0 = RhodeIslandZ1;
			state1 = RhodeIslandZ1;
			state2 = RhodeIslandZ2;
			state3 = RhodeIslandZ1;
			state4 = RhodeIslandZ2;
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