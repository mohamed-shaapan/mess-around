package testing;

import commonsModule.BoardPrinter;
import gameEngineModule.ChessGame;

public class ConsoleTesting {

	//01_RUN TESTS
	//*****************************************************
	public static void main(String[] args) {
		
		genericTest();
	
	}

	//02_TEST CRITERIA
	//*****************************************************
	private static void genericTest(){
		ChessGame gameBoard=new ChessGame();
		BoardPrinter boardPrinter=new BoardPrinter(gameBoard);

		
		gameBoard.movePiece(3, 0, 4, 0);
		gameBoard.movePiece(6, 0, 4, 0);
		//gameBoard.movePiece(1, 2, 3, 2);
		//gameBoard.movePiece(4, 3, 3, 2);
		

		boardPrinter.drawBoard();
	}
	
	
	
	
	
	
}
