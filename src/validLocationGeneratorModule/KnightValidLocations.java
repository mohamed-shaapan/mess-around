package validLocationGeneratorModule;

import java.util.ArrayList;

import battlePiecesModule.Piece;
import gameEngineModule.ChessGame;

public class KnightValidLocations implements ValidLocations{

	//01_Attributes***********************
	//*************************************************************************
	private ArrayList<int[]> nextValidLocations;
	private Piece piece;
	private ChessGame gameBoard;
	private int currentRow; private int currentCol;
	
	
	//02_Constructor**********************
	//*************************************************************************
	public KnightValidLocations(Piece piece, ChessGame gameBoard) {
		this.piece=piece;
		this.gameBoard=gameBoard;
		nextValidLocations=new ArrayList<int[]>();
		currentRow=-1; currentCol=-1;
	}
	
	
	//03_Methods**************************
	//*************************************************************************
	@Override
	public ArrayList<int[]> generateNextValidLocations() {
		nextValidLocations.clear();
		currentRow=piece.getCurrentRow(); 
		currentCol=piece.getCurrentColumn();
		
		
		generateKnightSingleCell(currentRow-2, currentCol+1);
		generateKnightSingleCell(currentRow-2, currentCol-1);
		
		generateKnightSingleCell(currentRow+2, currentCol+1);
		generateKnightSingleCell(currentRow+2, currentCol-1);
		
		generateKnightSingleCell(currentRow-1, currentCol+2);
		generateKnightSingleCell(currentRow-1, currentCol-2);
		
		generateKnightSingleCell(currentRow+1, currentCol+2);
		generateKnightSingleCell(currentRow+1, currentCol-2);
		
		//System.out.printf("CurROW(%s), CurCOL(%s)\n", currentRow, currentCol);
		//GenericPrinter.printValidLocations(nextValidLocations);
		
		return nextValidLocations;
	}

		
	//***********************************************************
	private void generateKnightSingleCell(int row, int col){
		try{
			boolean withinBoardLimits=(col>=0)&&(col<=7)&&(row>=0)&&(row<=7);
			boolean noTeamMate=!(gameBoard.getGameBoard()[row][col].getTeam().equalsIgnoreCase(piece.getTeam()));
			//System.out.printf("Limits(%s), Mate(%s)\n", withinBoardLimits, noTeamMate);
			if(withinBoardLimits&&noTeamMate){
				nextValidLocations.add(new int[]{row, col});
			}
		}catch(Exception ex){}
	}
	
	
	
	
	
	
}
