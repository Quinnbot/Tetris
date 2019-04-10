package pieces;

public class blueRicky implements Piece {
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
		@Override
		public int[][] get1() {
			return BlueRicky1;
		}
		@Override
		public int[][] get2() {
			return BlueRicky2;
		}
		@Override
		public int[][] get3() {
			return BlueRicky3;
		}
		@Override
		public int[][] get4() {
			return BlueRicky4;
		}
		
}
