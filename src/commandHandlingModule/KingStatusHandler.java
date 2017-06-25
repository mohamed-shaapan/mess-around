package commandHandlingModule;

import java.util.ArrayList;

import battlePiecesModule.Piece;
import gameEngineModule.ChessGame;

public class KingStatusHandler {
	
	

	//*************************************************************************
	public static boolean isKingInDanger(ChessGame gameBoard, Piece king){
		//System.out.println("**********************");
		boolean verticalTest=isVerticalDangerous(gameBoard, king);
		boolean horizontalTest=isHorizotalDnagerous(gameBoard, king);
		boolean diagonalATest=isFirstDiagonalDangerous(gameBoard, king);
		boolean diagonalBTest=isDiagonalBDangerous(gameBoard, king);
		boolean knightLocationTest=isKnightDangerous(gameBoard, king);
		/*System.out.println("VDang "+verticalTest);
		System.out.println("HDang "+horizontalTest);
		System.out.println("D1Dang "+diagonalATest);
		System.out.println("D2Dang "+diagonalBTest);
		System.out.println("KNDang "+knightLocationTest);*/
		if(verticalTest||horizontalTest||diagonalATest||diagonalBTest||knightLocationTest){
			return true;
		}
		return false;
	}
	
	
	//01_Test Vertical Dangerous
	//**********************************************************************************
	private static boolean isVerticalDangerous(ChessGame gameBoard, Piece king){
		boolean upTest=isUpDangerous(gameBoard, king);
		boolean downTest=isDownDangerous(gameBoard, king);
		if(upTest||downTest){
			return true;
		}
		return false;
	}
	
	private static boolean isUpDangerous(ChessGame gameBoard, Piece king){
		int currentRow=king.getCurrentRow(); int currentColumn=king.getCurrentColumn();
		for(int i=1; i<=7; i++){
			currentRow--;
			try{
				Piece currentCell=gameBoard.getGameBoard()[currentRow][currentColumn];
				if(currentCell.getType().equalsIgnoreCase("blank")){
					continue;
				}
				if(currentCell.getTeam().equalsIgnoreCase(king.getTeam())){
					break;
				}
				int kingLocation[]={king.getCurrentRow(), king.getCurrentColumn()};
				boolean isThreat=isKingATarget(currentCell.generateNextValidLocations(), kingLocation);
				if(isThreat==true){
					return true;
				}
				return false;
			}catch(Exception ex){}
		}
		return false;
	}
	
	private static boolean isDownDangerous(ChessGame gameBoard, Piece king){
		int currentRow=king.getCurrentRow(); int currentColumn=king.getCurrentColumn();
		for(int i=1; i<=7; i++){
			currentRow++;
			try{
				Piece currentCell=gameBoard.getGameBoard()[currentRow][currentColumn];
				if(currentCell.getType().equalsIgnoreCase("blank")){
					continue;
				}
				if(currentCell.getTeam().equalsIgnoreCase(king.getTeam())){
					break;
				}
				int kingLocation[]={king.getCurrentRow(), king.getCurrentColumn()};
				boolean isThreat=isKingATarget(currentCell.generateNextValidLocations(), kingLocation);
				if(isThreat==true){
					return true;
				}
				return false;
			}catch(Exception ex){}
		}
		return false;
	}
	
	//02_Test Horizontal Dangerous
	//**********************************************************************************
	private static boolean isHorizotalDnagerous(ChessGame gameBoard, Piece king){
		boolean leftTest=isLeftDangerous(gameBoard, king);
		boolean rightTest=isRightDangerous(gameBoard, king);
		if(leftTest||rightTest){
			return true;
		}
		return false;
	}
	
	private static boolean isLeftDangerous(ChessGame gameBoard, Piece king){
		int currentRow=king.getCurrentRow(); int currentColumn=king.getCurrentColumn();
		for(int i=1; i<=7; i++){
			currentColumn--;
			try{
				Piece currentCell=gameBoard.getGameBoard()[currentRow][currentColumn];
				if(currentCell.getType().equalsIgnoreCase("blank")){
					continue;
				}
				if(currentCell.getTeam().equalsIgnoreCase(king.getTeam())){
					break;
				}
				int kingLocation[]={king.getCurrentRow(), king.getCurrentColumn()};
				boolean isThreat=isKingATarget(currentCell.generateNextValidLocations(), kingLocation);
				if(isThreat==true){
					return true;
				}
				return false;
			}catch(Exception ex){}
		}
		return false;
	}
	
	private static boolean isRightDangerous(ChessGame gameBoard, Piece king){
		int currentRow=king.getCurrentRow(); int currentColumn=king.getCurrentColumn();
		for(int i=1; i<=7; i++){
			currentColumn++;
			try{
				Piece currentCell=gameBoard.getGameBoard()[currentRow][currentColumn];
				if(currentCell.getType().equalsIgnoreCase("blank")){
					continue;
				}
				if(currentCell.getTeam().equalsIgnoreCase(king.getTeam())){
					break;
				}
				int kingLocation[]={king.getCurrentRow(), king.getCurrentColumn()};
				boolean isThreat=isKingATarget(currentCell.generateNextValidLocations(), kingLocation);
				if(isThreat==true){
					return true;
				}
				return false;
			}catch(Exception ex){}
		}
		return false;
	}
	
	
	//03_Test DiagonalA Dangerous
	//**********************************************************************************
	private static boolean isFirstDiagonalDangerous(ChessGame gameBoard, Piece king){
		boolean d1Test=isD1Dangerous(gameBoard, king);
		boolean d2Test=isD2Dangerous(gameBoard, king);
		if(d1Test||d2Test){
			return true;
		}
		return false;
	}
	
	private static boolean isD1Dangerous(ChessGame gameBoard, Piece king){
		int currentRow=king.getCurrentRow(); int currentColumn=king.getCurrentColumn();
		for(int i=1; i<=7; i++){
			currentRow--;
			currentColumn++;
			try{
				Piece currentCell=gameBoard.getGameBoard()[currentRow][currentColumn];
				if(currentCell.getType().equalsIgnoreCase("blank")){
					continue;
				}
				if(currentCell.getTeam().equalsIgnoreCase(king.getTeam())){
					break;
				}
				int kingLocation[]={king.getCurrentRow(), king.getCurrentColumn()};
				boolean isThreat=isKingATarget(currentCell.generateNextValidLocations(), kingLocation);
				if(isThreat==true){
					return true;
				}
				return false;
			}catch(Exception ex){}
		}
		return false;
	}
	
	private static boolean isD2Dangerous(ChessGame gameBoard, Piece king){
		int currentRow=king.getCurrentRow(); int currentColumn=king.getCurrentColumn();
		for(int i=1; i<=7; i++){
			currentRow++;
			currentColumn--;
			try{
				Piece currentCell=gameBoard.getGameBoard()[currentRow][currentColumn];
				if(currentCell.getType().equalsIgnoreCase("blank")){
					continue;
				}
				if(currentCell.getTeam().equalsIgnoreCase(king.getTeam())){
					break;
				}
				int kingLocation[]={king.getCurrentRow(), king.getCurrentColumn()};
				boolean isThreat=isKingATarget(currentCell.generateNextValidLocations(), kingLocation);
				if(isThreat==true){
					return true;
				}
				return false;
			}catch(Exception ex){}
		}
		return false;
	}
	
	//04_Test DiagonalB Dangerous
	//**********************************************************************************
	private static boolean isDiagonalBDangerous(ChessGame gameBoard, Piece king){
		boolean d3Test=isD3Dangerous(gameBoard, king);
		boolean d4Test=isD4Dangerous(gameBoard, king);
		if(d3Test||d4Test){
			return true;
		}
		return false;
	}
	
	private static boolean isD3Dangerous(ChessGame gameBoard, Piece king){
		int currentRow=king.getCurrentRow(); int currentColumn=king.getCurrentColumn();
		for(int i=1; i<=7; i++){
			currentRow--;
			currentColumn--;
			try{
				Piece currentCell=gameBoard.getGameBoard()[currentRow][currentColumn];
				if(currentCell.getType().equalsIgnoreCase("blank")){
					continue;
				}
				if(currentCell.getTeam().equalsIgnoreCase(king.getTeam())){
					break;
				}
				int kingLocation[]={king.getCurrentRow(), king.getCurrentColumn()};
				boolean isThreat=isKingATarget(currentCell.generateNextValidLocations(), kingLocation);
				if(isThreat==true){
					return true;
				}
				return false;
			}catch(Exception ex){}
		}
		return false;
	}
	
	private static boolean isD4Dangerous(ChessGame gameBoard, Piece king){
		int currentRow=king.getCurrentRow(); int currentColumn=king.getCurrentColumn();
		for(int i=1; i<=7; i++){
			currentRow++;
			currentColumn++;
			try{
				Piece currentCell=gameBoard.getGameBoard()[currentRow][currentColumn];
				if(currentCell.getType().equalsIgnoreCase("blank")){
					continue;
				}
				if(currentCell.getTeam().equalsIgnoreCase(king.getTeam())){
					break;
				}
				int kingLocation[]={king.getCurrentRow(), king.getCurrentColumn()};
				boolean isThreat=isKingATarget(currentCell.generateNextValidLocations(), kingLocation);
				if(isThreat==true){
					return true;
				}
				return false;
			}catch(Exception ex){}
		}
		return false;
	}
	
	//05_Test Knight Dangerous
	//**********************************************************************************
	private static boolean isKnightDangerous(ChessGame gameBoard, Piece king){
		int kingRow=king.getCurrentRow(); int kingCol=king.getCurrentColumn();
		boolean knight1=isKnightDangerousGeneric(gameBoard, king, kingRow-2, kingCol+1);
		boolean knight2=isKnightDangerousGeneric(gameBoard, king, kingRow-1, kingCol+2);
		boolean knight3=isKnightDangerousGeneric(gameBoard, king, kingRow+1, kingCol+2);
		boolean knight4=isKnightDangerousGeneric(gameBoard, king, kingRow+2, kingCol+1);
		boolean knight5=isKnightDangerousGeneric(gameBoard, king, kingRow+2, kingCol-1);
		boolean knight6=isKnightDangerousGeneric(gameBoard, king, kingRow+1, kingCol-2);
		boolean knight7=isKnightDangerousGeneric(gameBoard, king, kingRow-1, kingCol-2);
		boolean knight8=isKnightDangerousGeneric(gameBoard, king, kingRow-2, kingCol-1);
		if(knight1||knight2||knight3||knight4||knight5||knight6||knight7||knight8){
			return true;
		}
		return false;
	}
	
	private static boolean isKnightDangerousGeneric(ChessGame gameBoard, Piece king, int knightRow, int knightCol){
		try{
			Piece currentCell=gameBoard.getGameBoard()[knightRow][knightCol];
			if(currentCell.getTeam().equalsIgnoreCase(king.getEnemy())){
				currentCell.generateNextValidLocations();
				int kingLocation[]={king.getCurrentRow(), king.getCurrentColumn()};
				boolean isThreat=isKingATarget(currentCell.generateNextValidLocations(), kingLocation);
				if(isThreat==true){
					return true;
				}
			}
		}catch(Exception ex){}
		return false;
	}
	
	
	//*********************************************************************
	//*********************************************************************
	private static boolean isKingATarget(ArrayList<int[]> nextValidLocations, int kingLocation[]){
		for(int[] validCell:nextValidLocations){
			boolean rowTest=validCell[0]==kingLocation[0];
			boolean colTest=validCell[1]==kingLocation[1];
			if(rowTest&&colTest){
				return true;
			}
		}
		return false;
	}
	
	
	
}
