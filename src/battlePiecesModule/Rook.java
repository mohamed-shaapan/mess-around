package battlePiecesModule;

import gameEngineModule.ChessGame;
import validLocationGeneratorModule.RookValidLocations;

public class Rook extends Piece{
	
	
	//01_Constructor**********************
	//*************************************************************************
	public Rook(ChessGame gameBoard, String displayName, String type, String team, String enemy, int step,
			boolean active, int initialRow, int initialColumn, int currentRow, int currentColumn) {
		super(gameBoard, displayName, type, team, enemy, step, active, initialRow, initialColumn, currentRow, currentColumn);
		//valid locations object
		validLocations=new RookValidLocations(this, getGameBoard());
	}
	
	
}
