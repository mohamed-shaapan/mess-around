package commandHandlingModule;

import battlePiecesModule.BlankPiece;
import battlePiecesModule.Piece;
import gameEngineModule.ChessGame;

public class MovePieceCommand {
	
	//01_ATTRIBUTES
	//*************************************************************************
	private ChessGame gameSet;
	private int fromRow; private int fromCol;
	private int toRow; private int toCol;
	
	
	//02_CONSTRUCTOR
	//*************************************************************************
	public MovePieceCommand(ChessGame chessBoard, int fromRow, int fromCol, int toRow, int toCol){
		this.gameSet=chessBoard;
		this.fromRow=fromRow;
		this.fromCol=fromCol;
		this.toRow=toRow;
		this.toCol=toCol;
	}
	
	
	//03_INTERFACE METHODS
	//*************************************************************************
	public void execute(){
		//make old location blank
		Piece pieceToMove=gameSet.getGameBoard()[fromRow][fromCol];
		gameSet.getGameBoard()[fromRow][fromCol]=new BlankPiece();
		
		//kill target enemy (if exists)
		String enemy=gameSet.getGameBoard()[fromRow][fromCol].getEnemy();
		String targetCellTeam=gameSet.getGameBoard()[toRow][toCol].getTeam();
		if(targetCellTeam.equalsIgnoreCase(enemy)){
			gameSet.getGameBoard()[fromRow][fromCol].setActive(false);
		}
		
		//move piece to specified location
		gameSet.getGameBoard()[toRow][toCol]=pieceToMove;
		pieceToMove.setCurrentRow(toRow); pieceToMove.setCurrentColumn(toCol);
		
		//examine promotion eligibility
		//
		
	}
	
	
	
	
}
