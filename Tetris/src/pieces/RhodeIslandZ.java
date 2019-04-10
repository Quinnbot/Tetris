package pieces;

public class RhodeIslandZ implements Piece {
	//RhodeIslandZ
		private static int RhodeIslandZ1[][] = {
				{0,1,1},
				{1,1,0}};
		private static int RhodeIslandZ2[][] = {
				{1,0},
				{1,1},
				{0,1}};
		@Override
		public int[][] get1() {
			return RhodeIslandZ1;
		}
		@Override
		public int[][] get2() {
			return RhodeIslandZ2;
		}
		@Override
		public int[][] get3() {
			return RhodeIslandZ1;
		}
		@Override
		public int[][] get4() {
			return RhodeIslandZ2;
		}
}
