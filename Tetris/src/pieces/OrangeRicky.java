package pieces;

public class OrangeRicky implements Piece{
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
		
		@Override
		public int[][] get1() {
			return OrangeRicky1;
		}
		@Override
		public int[][] get2() {
			return OrangeRicky2;
		}
		@Override
		public int[][] get3() {
			return OrangeRicky3;
		}
		@Override
		public int[][] get4() {
			return OrangeRicky4;
		}
		
}
