package gameEngineModule;

import java.io.File;

import battlePiecesModule.BlankPiece;
import battlePiecesModule.Piece;
import battleTeamsModule.BlackTeam;
import battleTeamsModule.WhiteTeam;
import commandHandlingModule.GameStatusHandler;
import commandHandlingModule.MovePieceCommand;
import commandHandlingModule.MoveValidator;
import storageModule.GameStorageHandler;

public class ChessGame implements IChessGame{

	//01_ATTRIBUTES
	//*********************************************************
	private Piece[][] gameBoard;
	private WhiteTeam whiteTeam;
	private BlackTeam blackTeam;
	private String playerTurn;
	private String gameStatus;
	private MoveValidator moveValidator;
	private GameStatusHandler gameStatusHandler;
	private GameStorageHandler gameStorageHandler;
		
		
	//02_CONSTRUCTOR
	//*********************************************************
	public ChessGame(){
		gameBoard=new Piece[8][8];
		whiteTeam=new WhiteTeam(this);
		blackTeam=new BlackTeam(this);
		initializeBoardCells();
		playerTurn="white";
		gameStatus="ON GOING";
		moveValidator=new MoveValidator(this);
		gameStatusHandler=new GameStatusHandler(this);
		gameStorageHandler=new GameStorageHandler(this);
	}
	//************************************
	private void initializeBoardCells(){
		for(int row=1; row<=8; row++){
			for(int col=1; col<=8; col++){
				gameBoard[row-1][col-1]=new BlankPiece();
			}
		}
		for(int i=1; i<=16; i++){
			int row=whiteTeam.getWhiteTeam()[i-1].getInitialRow();
			int column=whiteTeam.getWhiteTeam()[i-1].getInitialColumn();
			gameBoard[row][column]=whiteTeam.getWhiteTeam()[i-1];
		}
		for(int i=1; i<=16; i++){
			int row=blackTeam.getBlackTeam()[i-1].getInitialRow();
			int column=blackTeam.getBlackTeam()[i-1].getInitialColumn();
			gameBoard[row][column]=blackTeam.getBlackTeam()[i-1];
		}
	}
	
	
	//03_INTERFACE METHODS
	//*************************************************************************
	@Override
	public boolean movePiece(int fromRow, int fromCol, int toRow, int toCol) {
		if(!gameStatusHandler.isGameOver()){
			//validate move
			boolean validMove=moveValidator.validateMove(fromRow, fromCol, toRow, toCol);
			if(validMove!=true){
				System.out.println("Invalid Move!!");
				return false;
			}
			//System.out.println("Move Approved");
			//apply move
			MovePieceCommand moveOperation=new MovePieceCommand(this, fromRow, fromCol, toRow, toCol);
			moveOperation.execute();
			//change player turn
			playerTurn=gameBoard[toRow][toCol].getEnemy();
			//update game status
			gameStatus=gameStatusHandler.updateGameStatus(playerTurn);
			return true;
		}
		return false;
	}
	@Override
	public void promotePawn(int row, int column) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void undoMove() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void redoMove() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void startNewGame() {
		gameBoard=new Piece[8][8];
		whiteTeam=new WhiteTeam(this);
		blackTeam=new BlackTeam(this);
		initializeBoardCells();
		playerTurn="white";
		gameStatus="ONGOING";
		moveValidator=new MoveValidator(this);
		gameStatusHandler=new GameStatusHandler(this);
	}
	@Override
	public void saveGameProgress(File chosenFile) {
		gameStorageHandler.saveGame(chosenFile);
		
	}
	@Override
	public void loadSavedGame(String fileName) {
		// TODO Auto-generated method stub
		
	}
	
	//04_INTERNAL METHODS
	//*************************************************************************
	public Piece[][] getGameBoard() {
		return gameBoard;
	}
	public WhiteTeam getWhiteTeam() {
		return whiteTeam;
	}
	public BlackTeam getBlackTeam() {
		return blackTeam;
	}
	public String getPlayerTurn() {
		return playerTurn;
	}
	public String getGameStatus(){
		return gameStatus;
	}
	
	
	
	
		
		
		
		
		
	

}
