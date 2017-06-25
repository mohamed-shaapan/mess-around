package battleTeamsModule;

import battlePiecesModule.Bishop;
import battlePiecesModule.King;
import battlePiecesModule.Knight;
import battlePiecesModule.Pawn;
import battlePiecesModule.Piece;
import battlePiecesModule.Queen;
import battlePiecesModule.Rook;
import gameEngineModule.ChessGame;

public class WhiteTeam {
	
	//01_Attributes***********************
	//*************************************************************************
	private Piece[] whiteTeam;
	
	//02_Constructor**********************
	//*************************************************************************
	public WhiteTeam(ChessGame gameBoard){
		whiteTeam=new Piece[16];
		whiteTeam[0]=new King(gameBoard, "KNG", "king", "white", "black", 1, true, 7, 4, 7, 4);
		whiteTeam[1]=new Queen(gameBoard, "QEN", "queen", "white", "black", 7, true, 7, 3, 7, 3);
		whiteTeam[2]=new Bishop(gameBoard, "BSH", "bishop", "white", "black", 7, true, 7, 2, 7, 2);
		whiteTeam[3]=new Bishop(gameBoard, "BSH", "bishop", "white", "black", 7, true, 7, 5, 7, 5);
		whiteTeam[4]=new Knight(gameBoard, "KNT", "knight", "white", "black", 1, true, 7, 1, 7, 1);
		whiteTeam[5]=new Knight(gameBoard, "KNT", "knight", "white", "black", 1, true, 7, 6, 7, 6);
		whiteTeam[6]=new Rook(gameBoard, "ROK", "rook", "white", "black", 7, true, 7, 0, 7, 0);
		whiteTeam[7]=new Rook(gameBoard, "ROK", "rook", "white", "black", 7, true, 7, 7, 7, 7);
		whiteTeam[8]=new Pawn(gameBoard, "PWN", "pawn", "white", "black", 1, true, 6, 0, 6, 0);
		whiteTeam[9]=new Pawn(gameBoard, "PWN", "pawn", "white", "black", 1, true, 6, 1, 6, 1);
		whiteTeam[10]=new Pawn(gameBoard, "PWN", "pawn", "white", "black", 1, true, 6, 2, 6, 2);
		whiteTeam[11]=new Pawn(gameBoard, "PWN", "pawn", "white", "black", 1, true, 6, 3, 6, 3);
		whiteTeam[12]=new Pawn(gameBoard, "PWN", "pawn", "white", "black", 1, true, 6, 4, 6, 4);
		whiteTeam[13]=new Pawn(gameBoard, "PWN", "pawn", "white", "black", 1, true, 6, 5, 6, 5);
		whiteTeam[14]=new Pawn(gameBoard, "PWN", "pawn", "white", "black", 1, true, 6, 6, 6, 6);
		whiteTeam[15]=new Pawn(gameBoard, "PWN", "pawn", "white", "black", 1, true, 6, 7, 6, 7);
	}
	
	//03_Methods**************************
	//*************************************************************************
	public Piece[] getWhiteTeam(){
		return this.whiteTeam;
	}
	public Piece getKing(){
		return whiteTeam[0];
	}

}
