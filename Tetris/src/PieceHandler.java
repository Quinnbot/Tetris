//import pieces.*;
import java.util.Random;

public class PieceHandler {
	
	public static OnePiece getRandPiece() {
		
		Random ran = new Random();
		
		int n = ran.nextInt(7); 
		
		return new OnePiece(n+1);
		
	}

}
