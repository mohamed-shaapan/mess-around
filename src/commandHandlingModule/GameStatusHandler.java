package commandHandlingModule;

import java.util.ArrayList;

import battlePiecesModule.Piece;
import gameEngineModule.ChessGame;

public class GameStatusHandler {

	//01_ATTRIBUTES
	//*********************************************************
	private boolean gameOver;
	private ChessGame gameBoard;
	private MoveValidator moveValidator;
	private String gameStatus;
	
	
	//02_CONSTRUCTOR
	//*********************************************************
	public GameStatusHandler(ChessGame gameBoard) {
		gameOver=false;
		this.gameBoard=gameBoard;
		moveValidator=new MoveValidator(gameBoard);
		gameStatus="ON GOING";
	}
	
	
	//03_INTERFACE METHODS
	//*********************************************************
	public boolean isGameOver(){
		return gameOver;
	}
	
	
	public String updateGameStatus(String nextPlayerTurn){
		//01_identify team to examine************
		Piece kingToTest;
		if(nextPlayerTurn.equalsIgnoreCase("white")){
			kingToTest=gameBoard.getWhiteTeam().getKing();
		}else{
			kingToTest=gameBoard.getBlackTeam().getKing();
		}
		//02_perform examinations****************
		if(isCheckMate(kingToTest)){
			gameOver=true;
			gameStatus="CHECK MATE!"+" - "+kingToTest.getEnemy()+" "+"Team Wins";
			//System.out.println("CHECK MATE! - GAME OVER");
			//System.out.printf("%s Team Wins!", kingToTest.getEnemy());
			return gameStatus;
		}else if(isStaleMate(kingToTest)){
			gameOver=true;
			gameStatus="STALE MATE!"+" - "+" GAME OVER NO WINNER!";
			//System.out.println("STALE MATE! - GAME OVER");
			return gameStatus;
		}else{
			boolean isKingInDanger=KingStatusHandler.isKingInDanger(gameBoard, kingToTest);
			if(isKingInDanger==true){
				gameStatus="CHECK!"+" - "+kingToTest.getTeam()+" "+"Team";
				//System.out.println("CHECK! - "+kingToTest.getTeam());
				return gameStatus;
			}
			gameStatus="ON GOING";
		}
		return gameStatus;
		
	}
	
	
	//04_INTERNAL METHODS
	//*********************************************************
	private boolean isCheckMate(Piece king){
		//01_king is in danger
		boolean isKingInDanger=KingStatusHandler.isKingInDanger(gameBoard, king);
		//02_no other piece has valid moves
		boolean noValidMoves=noMoreValidMoves(king.getTeam());
		//return test result
		if(isKingInDanger&&noValidMoves){
			return true;
		}
		return false;
	}
		
	//*********************************************************
	private boolean isStaleMate(Piece king){
		//01_king is not in danger
		boolean isKingInDanger=KingStatusHandler.isKingInDanger(gameBoard, king);
		//02_no other piece has valid moves
		boolean noValidMoves=noMoreValidMoves(king.getTeam());
		//return test result
		if((!isKingInDanger)&&noValidMoves){
			return true;
		}
		return false;
	}
		
	//*********************************************************
	private boolean noMoreValidMoves(String team){
		//identify team************************
		Piece[] teamPieces;
		if(team.equalsIgnoreCase("white")){
			teamPieces=gameBoard.getWhiteTeam().getWhiteTeam();
		}else{
			teamPieces=gameBoard.getBlackTeam().getBlackTeam();
		}
		//try out all team mates***************
		for(Piece mate:teamPieces){
			//skip if mate is dead
			if(mate.isActive()==false){
				continue;
			}
			//get current location
			int fromRow=mate.getCurrentRow(); int fromCol=mate.getCurrentColumn();
			//try all possible locations
			ArrayList<int[]> nextValidLocations=mate.generateNextValidLocations();
			int [][] avoidConcurrency = nextValidLocations.toArray(new int[nextValidLocations.size()][2]);
			/*
			 * we need to avoid ConcurrentModificationException
			 * because we're generating reference to nextValidLocations then
			 * modifying the this variable (ArrayList) as we iterate over its elemtns
			 * when we use .validateMove() function
			 */
			for(int[] cell:avoidConcurrency){
				int toRow=cell[0]; int toCol=cell[1];
				boolean isValidMove=moveValidator.validateMove(fromRow, fromCol, toRow, toCol);
				if(isValidMove==true){
					return false;
				}
			}
		}
		
		return true;
	}
	//*********************************************************
	
}
