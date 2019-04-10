package pieces;

public class CleveLandZ implements Piece{
	//CleveLandZ
		private static int ClevelandZ1[][] = {
				{1,1,0},
				{0,1,1}};
		private static int ClevelandZ2[][] = {
				{0,1},
				{1,1},
				{1,0}};
		@Override
		public int[][] get1() {
			return ClevelandZ1;
		}
		@Override
		public int[][] get2() {
			return ClevelandZ2;
		}
		@Override
		public int[][] get3() {
			return ClevelandZ1;
		}
		@Override
		public int[][] get4() {
			return ClevelandZ1;
		}
		
}
