package validLocationGeneratorModule;

import java.util.ArrayList;

import battlePiecesModule.Piece;
import gameEngineModule.ChessGame;

public class PawnValidLocations implements ValidLocations{

	//01_Attributes***********************
	//*************************************************************************
	private ArrayList<int[]> nextValidLocations;
	private Piece piece;
	private ChessGame gameSet;
	private int currentRow; private int currentCol;
	private LocationGenerator locationGenerator;
	
	
	//02_Constructor**********************
	//*************************************************************************
	public PawnValidLocations(Piece piece, ChessGame gameSet) {
		this.piece=piece;
		this.gameSet=gameSet;
		nextValidLocations=new ArrayList<int[]>();
		currentRow=-1; currentCol=-1;
		locationGenerator=new LocationGenerator(gameSet);
		
	}
	
	
	//03_Methods**************************
	//*************************************************************************
	@Override
	public ArrayList<int[]> generateNextValidLocations() {
		nextValidLocations.clear();
		currentRow=piece.getCurrentRow(); 
		currentCol=piece.getCurrentColumn();
		generateVerticalMoves();
		generateFirstDiagonalMoves();
		generateSecondDiagonalMoves();
		return nextValidLocations;
	}

	//GENERATE DIRECTIONAL MOVES
	//*********************************************************	
	private void generateVerticalMoves(){
		try{
			if(piece.getTeam().equalsIgnoreCase("white")){
				if(currentRow==piece.getInitialRow()){
					String targetTeam=gameSet.getGameBoard()[currentRow-2][currentCol].getTeam();
					if(targetTeam.equalsIgnoreCase("black")){
						return;
					}
					nextValidLocations.addAll(locationGenerator.generateUpMoves(currentRow, currentCol, piece.getTeam(), 2));
				}else{
					String targetTeam=gameSet.getGameBoard()[currentRow-1][currentCol].getTeam();
					if(targetTeam.equalsIgnoreCase("black")){
						return;
					}
					nextValidLocations.addAll(locationGenerator.generateUpMoves(currentRow, currentCol, piece.getTeam(), 1));
				}
			}else{
				if(currentRow==piece.getInitialRow()){
					String targetTeam=gameSet.getGameBoard()[currentRow+2][currentCol].getTeam();
					if(targetTeam.equalsIgnoreCase("white")){
						return;
					}
					nextValidLocations.addAll(locationGenerator.generateDownMoves(currentRow, currentCol, piece.getTeam(), 2));
				}else{
					String targetTeam=gameSet.getGameBoard()[currentRow+1][currentCol].getTeam();
					if(targetTeam.equalsIgnoreCase("white")){
						return;
					}
					nextValidLocations.addAll(locationGenerator.generateDownMoves(currentRow, currentCol, piece.getTeam(), 1));
				}
			}
		}catch(Exception ex){}
	}
	

	//*********************************************************
	private void generateFirstDiagonalMoves(){
		try{
			if(piece.getTeam().equalsIgnoreCase("white")){
				//moving 2 o'clock
				boolean enemyExists=gameSet.getGameBoard()[currentRow-1][currentCol+1].getTeam().equalsIgnoreCase(piece.getEnemy());
				if(enemyExists==true){
					nextValidLocations.addAll(locationGenerator.generateDiagonalMovesA(currentRow, currentCol, piece.getTeam(), 1));
				}
			}else{
				//moving 4 o'clock
				boolean enemyExists=gameSet.getGameBoard()[currentRow+1][currentCol+1].getTeam().equalsIgnoreCase(piece.getEnemy());
				if(enemyExists==true){
					nextValidLocations.addAll(locationGenerator.generateDiagonalMovesB(currentRow, currentCol, piece.getTeam(), 1));
				}
			}
		}catch(Exception ex){}
	}
	
	//*********************************************************
	private void generateSecondDiagonalMoves(){
		try{
			if(piece.getTeam().equalsIgnoreCase("white")){
				//moving 10 o'clock
				boolean enemyExists=gameSet.getGameBoard()[currentRow-1][currentCol-1].getTeam().equalsIgnoreCase(piece.getEnemy());
				if(enemyExists==true){
					nextValidLocations.addAll(locationGenerator.generateDiagonalMovesD(currentRow, currentCol, piece.getTeam(), 1));
				}
			}else{
				//moving 8 o'clock
				boolean enemyExists=gameSet.getGameBoard()[currentRow+1][currentCol-1].getTeam().equalsIgnoreCase(piece.getEnemy());
				if(enemyExists==true){
					nextValidLocations.addAll(locationGenerator.generateDiagonalMovesC(currentRow, currentCol, piece.getTeam(), 1));
				}
			}
		}catch(Exception ex){}
	}
	//*********************************************************

	
	
}
