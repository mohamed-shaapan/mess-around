package battleTeamsModule;

import battlePiecesModule.Bishop;
import battlePiecesModule.King;
import battlePiecesModule.Knight;
import battlePiecesModule.Pawn;
import battlePiecesModule.Piece;
import battlePiecesModule.Queen;
import battlePiecesModule.Rook;
import gameEngineModule.ChessGame;

public class BlackTeam {
	
	//01_Attributes***********************
	//*************************************************************************
	private Piece[] blackTeam;
	
	//02_Constructor**********************
	//*************************************************************************
	public BlackTeam(ChessGame gameBoard){
		blackTeam=new Piece[16];
		blackTeam[0]=new King(gameBoard, "KNG", "king", "black", "white", 1, true, 0, 4, 0, 4);
		blackTeam[1]=new Queen(gameBoard, "QEN", "queen", "black", "white", 7, true, 0, 3, 0, 3);
		blackTeam[2]=new Bishop(gameBoard, "BSH", "bishop", "black", "white", 7, true, 0, 2, 0, 2);
		blackTeam[3]=new Bishop(gameBoard, "BSH", "bishop", "black", "white", 7, true, 0, 5, 0, 5);
		blackTeam[4]=new Knight(gameBoard, "KNT", "knight", "black", "white", 1, true, 0, 1, 0, 1);
		blackTeam[5]=new Knight(gameBoard, "KNT", "knight", "black", "white", 1, true, 0, 6, 0, 6);
		blackTeam[6]=new Rook(gameBoard, "ROK", "rook", "black", "white", 7, true, 0, 0, 0, 0);
		blackTeam[7]=new Rook(gameBoard, "ROK", "rook", "black", "white", 7, true, 0, 7, 0, 7);
		blackTeam[8]=new Pawn(gameBoard, "PWN", "pawn", "black", "white", 1, true, 1, 0, 1, 0);
		blackTeam[9]=new Pawn(gameBoard, "PWN", "pawn", "black", "white", 1, true, 1, 1, 1, 1);
		blackTeam[10]=new Pawn(gameBoard, "PWN", "pawn", "black", "white", 1, true, 1, 2, 1, 2);
		blackTeam[11]=new Pawn(gameBoard, "PWN", "pawn", "black", "white", 1, true, 1, 3, 1, 3);
		blackTeam[12]=new Pawn(gameBoard, "PWN", "pawn", "black", "white", 1, true, 1, 4, 1, 4);
		blackTeam[13]=new Pawn(gameBoard, "PWN", "pawn", "black", "white", 1, true, 1, 5, 1, 5);
		blackTeam[14]=new Pawn(gameBoard, "PWN", "pawn", "black", "white", 1, true, 1, 6, 1, 6);
		blackTeam[15]=new Pawn(gameBoard, "PWN", "pawn", "black", "white", 1, true, 1, 7, 1, 7);
	}
	
	//03_Methods**************************
	//*************************************************************************
	public Piece[] getBlackTeam(){
		return this.blackTeam;
	}
	public Piece getKing(){
		return blackTeam[0];
	}

}
