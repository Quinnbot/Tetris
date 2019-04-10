package pieces;


public class Hero implements Piece {

	//Hero
		private static int Hero1[][] = {
				{1},
				{1},
				{1},
				{1}};
		private static int Hero2[][] = {
				{1,1,1,1}};
		@Override
		public int[][] get1() {
			return Hero1;
		}
		@Override
		public int[][] get2() {
			return Hero2;
		}
		@Override
		public int[][] get3() {
			return Hero1;
		}
		@Override
		public int[][] get4() {
			return Hero2;
		}
	
}
