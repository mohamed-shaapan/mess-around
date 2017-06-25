package validLocationGeneratorModule;

import java.util.ArrayList;

import battlePiecesModule.Piece;
import gameEngineModule.ChessGame;

public class KingValidLocations implements ValidLocations{

	//01_Attributes***********************
	//*************************************************************************
	private ArrayList<int[]> nextValidLocations;
	private Piece piece;
	private int currentRow; private int currentCol;
	private LocationGenerator locationGenerator;
	
	
	//02_Constructor**********************
	//*************************************************************************
	public KingValidLocations(Piece piece, ChessGame gameSet) {
		this.piece=piece;
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
		generateHorizontalMoves();
		generateFirstDiagonalMoves();
		generateSecondDiagonalMoves();
		//GenericPrinter.printValidLocations(nextValidLocations);
		return nextValidLocations;
	}

	//01_setup directional moves
	//*********************************************************
	
	private void generateVerticalMoves(){
		nextValidLocations.addAll(locationGenerator.generateUpMoves(currentRow, currentCol, piece.getTeam(), 1));
		nextValidLocations.addAll(locationGenerator.generateDownMoves(currentRow, currentCol, piece.getTeam(), 1));
	}
	
	private void generateHorizontalMoves(){
		nextValidLocations.addAll(locationGenerator.generateLeftMoves(currentRow, currentCol, piece.getTeam(), 1));
		nextValidLocations.addAll(locationGenerator.generateRightMoves(currentRow, currentCol, piece.getTeam(), 1));
	}
	
	private void generateFirstDiagonalMoves(){
		nextValidLocations.addAll(locationGenerator.generateDiagonalMovesA(currentRow, currentCol, piece.getTeam(), 1));
		nextValidLocations.addAll(locationGenerator.generateDiagonalMovesC(currentRow, currentCol, piece.getTeam(), 1));
	}
	
	private void generateSecondDiagonalMoves(){
		nextValidLocations.addAll(locationGenerator.generateDiagonalMovesB(currentRow, currentCol, piece.getTeam(), 1));
		nextValidLocations.addAll(locationGenerator.generateDiagonalMovesD(currentRow, currentCol, piece.getTeam(), 1));
	}

	
	
}
