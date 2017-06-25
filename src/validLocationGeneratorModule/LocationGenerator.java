package validLocationGeneratorModule;

import java.util.ArrayList;

import gameEngineModule.ChessGame;

public class LocationGenerator {
	
	
	//01_ATTRIBUTES
	//**************************************************************
	private ChessGame gameSet;
	
	//02_CONSTRUCTOR
	//**************************************************************
	public LocationGenerator(ChessGame gameSet) {
		this.gameSet=gameSet;
	}
	
	
	
	//03_METHODS
	//**************************************************************
	public ArrayList<int[]> generateUpMoves(int currentRow, int currentCol, String team,int step){
		ArrayList<int[]> result=new ArrayList<int[]>();
		
		int row=currentRow-step-1;
		int col=currentCol;
		//System.out.printf("CurRow : %s, CurCol : %s\n", currentRow, currentCol);
		//System.out.printf("Row : %s, Col : %s\n", row, col);
		for(int i=1; i<=step; i++){
			//System.out.println("ITERATION: "+i);
			try{
				row=row+1;
				//System.out.println("ROW : "+row);
				boolean freeRoute=FreeRouteExaminer.freeVerticalRoute(gameSet, currentRow, currentCol, row, col);
				boolean withinBoardLimits=(col>=0)&&(col<=7)&&(row>=0)&&(row<=7);
				boolean noTeamMate=!(gameSet.getGameBoard()[row][col].getTeam().equalsIgnoreCase(team));
				//System.out.println("team "+team+", target : "+gameSet.getGameBoard()[row][col].getTeam());
				boolean differentCell=(currentRow!=row);
				if(freeRoute&&withinBoardLimits&&noTeamMate&&differentCell){	
					result.add(new int[]{row, col});
				}
			}catch(Exception ex){}
		}
		
		//System.out.println("*********************************");
		return result;
	}
	
	//**************************************************************
	public ArrayList<int[]> generateDownMoves(int currentRow, int currentCol, String team,int step){
		ArrayList<int[]> result=new ArrayList<int[]>();
		
		int row=currentRow+step+1;
		int col=currentCol;
		for(int i=1; i<=step; i++){
			try{
				row=row-1;
				boolean freeRoute=FreeRouteExaminer.freeVerticalRoute(gameSet, currentRow, currentCol, row, col);
				boolean withinBoardLimits=(col>=0)&&(col<=7)&&(row>=0)&&(row<=7);
				boolean noTeamMate=!(gameSet.getGameBoard()[row][col].getTeam().equalsIgnoreCase(team));
				boolean differentCell=(currentRow!=row);
				if(freeRoute&&withinBoardLimits&&noTeamMate&&differentCell){
					result.add(new int[]{row, col});
				}
			}catch(Exception ex){}
		}
		
		return result;
	}
	
	//**************************************************************
	public ArrayList<int[]> generateRightMoves(int currentRow, int currentCol, String team,int step){
		ArrayList<int[]> result=new ArrayList<int[]>();
		
		int row=currentRow;
		int col=currentCol+step+1;
		for(int i=1; i<=step; i++){
			try{
				col=col-1;
				boolean freeRoute=FreeRouteExaminer.freeHorizontalRoute(gameSet, currentRow, currentCol, row, col);
				boolean withinBoardLimits=(col>=0)&&(col<=7)&&(row>=0)&&(row<=7);
				boolean noTeamMate=!(gameSet.getGameBoard()[row][col].getTeam().equalsIgnoreCase(team));
				boolean differentCell=(currentCol!=col);
				if(freeRoute&&withinBoardLimits&&noTeamMate&&differentCell){
					result.add(new int[]{row, col});
				}
			}catch(Exception ex){}
		}
		
		return result;
	}
	
	//**************************************************************
	public ArrayList<int[]> generateLeftMoves(int currentRow, int currentCol, String team,int step){
		ArrayList<int[]> result=new ArrayList<int[]>();
		
		int row=currentRow;
		int col=currentCol-step-1;
		for(int i=1; i<=step; i++){
			
			try{
				col=col+1;
				boolean freeRoute=FreeRouteExaminer.freeHorizontalRoute(gameSet, currentRow, currentCol, row, col);
				boolean withinBoardLimits=(col>=0)&&(col<=7)&&(row>=0)&&(row<=7);
				boolean noTeamMate=!(gameSet.getGameBoard()[row][col].getTeam().equalsIgnoreCase(team));
				boolean differentCell=(currentCol!=col);
				//System.out.printf("Route(%s), Limits(%s), Mate(%s)\n", freeRoute, withinBoardLimits, noTeamMate);
				if(freeRoute&&withinBoardLimits&&noTeamMate&&differentCell){
					result.add(new int[]{row, col});
				}
			}catch(Exception ex){}
		}
		
		return result;
	}
	

	//**************************************************************
	public ArrayList<int[]> generateDiagonalMovesA(int currentRow, int currentCol, String team,int step){
		//moving 2 o'clock
		ArrayList<int[]> result=new ArrayList<int[]>();
		
		int row=currentRow-step-1;
		int col=currentCol+step+1;
		for(int i=1; i<=step; i++){
			try{
				row=row+1; col=col-1;
				boolean freeRoute=FreeRouteExaminer.freeFirstDiagonal(gameSet, currentRow, currentCol, row, col);
				boolean withinBoardLimits=(col>=0)&&(col<=7)&&(row>=0)&&(row<=7);
				boolean noTeamMate=!(gameSet.getGameBoard()[row][col].getTeam().equalsIgnoreCase(team));
				boolean differentCell=(currentRow!=row)&&(currentCol!=col);
				if(freeRoute&&withinBoardLimits&&noTeamMate&&differentCell){
					result.add(new int[]{row, col});
				}
			}catch(Exception ex){}
		}
		
		return result;
	}
	
	//**************************************************************
	public ArrayList<int[]> generateDiagonalMovesB(int currentRow, int currentCol, String team,int step){
		//moving 4 o'clock
		ArrayList<int[]> result=new ArrayList<int[]>();
		
		int row=currentRow+step+1;
		int col=currentCol+step+1;
		for(int i=1; i<=step; i++){
			try{
				row=row-1; col=col-1;
				boolean freeRoute=FreeRouteExaminer.freeSecondDiagonal(gameSet, currentRow, currentCol, row, col);
				boolean withinBoardLimits=(col>=0)&&(col<=7)&&(row>=0)&&(row<=7);
				boolean noTeamMate=!(gameSet.getGameBoard()[row][col].getTeam().equalsIgnoreCase(team));
				boolean differentCell=(currentRow!=row)&&(currentCol!=col);
				if(freeRoute&&withinBoardLimits&&noTeamMate&&differentCell){
					result.add(new int[]{row, col});
				}
			}catch(Exception ex){}
		}
		
		return result;
	}
	
	//**************************************************************
	public ArrayList<int[]> generateDiagonalMovesC(int currentRow, int currentCol, String team,int step){
		//moving 8 o'clock
		ArrayList<int[]> result=new ArrayList<int[]>();
		
		int row=currentRow+step+1;
		int col=currentCol-step-1;
		for(int i=1; i<=step; i++){
			try{
				row=row-1; col=col+1;
				boolean freeRoute=FreeRouteExaminer.freeFirstDiagonal(gameSet, currentRow, currentCol, row, col);
				boolean withinBoardLimits=(col>=0)&&(col<=7)&&(row>=0)&&(row<=7);
				boolean noTeamMate=!(gameSet.getGameBoard()[row][col].getTeam().equalsIgnoreCase(team));
				boolean differentCell=(currentRow!=row)&&(currentCol!=col);
				if(freeRoute&&withinBoardLimits&&noTeamMate&&differentCell){
					result.add(new int[]{row, col});
				}
			}catch(Exception ex){}
		}
		
		return result;
	}
	
	//**************************************************************
	public ArrayList<int[]> generateDiagonalMovesD(int currentRow, int currentCol, String team,int step){
		//moving 10 o'clock
		ArrayList<int[]> result=new ArrayList<int[]>();
		
		int row=currentRow-step-1;
		int col=currentCol-step-1;
		for(int i=1; i<=step; i++){
			try{
				row=row+1; col=col+1;
				boolean freeRoute=FreeRouteExaminer.freeSecondDiagonal(gameSet, currentRow, currentCol, row, col);
				boolean withinBoardLimits=(col>=0)&&(col<=7)&&(row>=0)&&(row<=7);
				boolean noTeamMate=!(gameSet.getGameBoard()[row][col].getTeam().equalsIgnoreCase(team));
				boolean differentCell=(currentRow!=row)&&(currentCol!=col);
				//System.out.printf("Route(%s), Limits(%s), Mate(%s)\n", freeRoute, withinBoardLimits, noTeamMate);
				if(freeRoute&&withinBoardLimits&&noTeamMate&&differentCell){
					result.add(new int[]{row, col});
				}
			}catch(Exception ex){}
		}
		
		return result;
	}
	//**************************************************************
	
	
	
	
	/*
	public ArrayList<int[]> generateLocations(int currentRow, int currentCol, String team,int step, int rowSign, int colSign){
		//moving 10 o'clock
		ArrayList<int[]> result=new ArrayList<int[]>();
		
		int row=currentRow-step-1;
		int col=currentCol-step-1;
		for(int i=1; i<=step; i++){
			try{
				row=row+i; col=col+i;
				boolean freeRoute=FreeRouteExaminer.freeDiagonalRouteA(gameSet, currentRow, currentCol, row, col);
				boolean withinBoardLimits=(col>=0)&&(col<=7)&&(row>=0)&&(row<=7);
				boolean noTeamMate=!(gameSet.getGameBoard()[row][col].getTeam().equalsIgnoreCase(team));
				boolean differentCell=(currentRow!=row)&&(currentCol!=col);
				if(freeRoute&&withinBoardLimits&&noTeamMate&&differentCell){
					result.add(new int[]{row, col});
				}
			}catch(Exception ex){}
		}
		
		return result;
	}
	*/
	
	
	
	
	

}
