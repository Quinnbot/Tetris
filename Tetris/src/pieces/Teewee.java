package pieces;

public class Teewee implements Piece {
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
		@Override
		public int[][] get1() {
			return Teewee1;
		}
		@Override
		public int[][] get2() {
			return Teewee2;
		}
		@Override
		public int[][] get3() {
			return Teewee3;
		}
		@Override
		public int[][] get4() {
			return Teewee4;
		}
}
