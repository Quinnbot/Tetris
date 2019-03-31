import pieces.Hero;
import java.util.Random;

public class PieceHandler {

	public static void main(String[] args) {
		

	}
	
	public static Object getRandPiece() {
		
		Object test;
		
		Random ran = new Random();
		
		int n = ran.nextInt(7); 
		
		switch (n) {
		case 0:
			
			return Hero(1);
			
			break;
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
				
		}
				
		return "how did you get here... you should never get here.";
		
	}

}
