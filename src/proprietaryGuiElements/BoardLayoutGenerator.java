package proprietaryGuiElements;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class BoardLayoutGenerator {
	
	
	//01_ATTRIBUTES
	//********************************************************
	private BoardElementsGenerator boardElements;

	//02_CONSTRUCTOR
	//********************************************************
	public BoardLayoutGenerator(BoardElementsGenerator boardElements) {
		this.boardElements=boardElements;
	}
	
	//03_INTERFACE METHODS
	//********************************************************
	public void generateLayout() throws FileNotFoundException{
		setBoardStyling();
		initializeBoardLayout();
		createOverallBoard();
	}
	
	
	//04_INTERNAL METHODS
	//********************************************************
	private void setBoardStyling(){
		createBoardBlocks();
		boardElements.getInnerBoard().setGridLinesVisible(true);
	}
	
	//*********************************************************
	private void initializeBoardLayout() throws FileNotFoundException{
		addBlocksToLayout();
		addPiecesToLayout();
	}

	//*********************************************************
	private void createBoardBlocks(){
		for(int i=1; i<=32; i++){
			Rectangle whiteBlock=new Rectangle(boardElements.getCellSize(),boardElements.getCellSize());
			whiteBlock.setFill(Color.SANDYBROWN);
			boardElements.getWhiteBlocks()[i-1]=whiteBlock;
			
			Rectangle coloredBlock=new Rectangle(boardElements.getCellSize(),boardElements.getCellSize());
			coloredBlock.setFill(Color.CHOCOLATE);
			boardElements.getBlackBlocks()[i-1]=coloredBlock;
		}
	}
	
	//*********************************************************
	private void addBlocksToLayout(){
		int pointer1=1;
		int pointer2=1;
		for(int row=1; row<=8; row++){
			if(row%2==0){
				for(int col=1; col<=8; col++){
					if(col%2==0){
						boardElements.getInnerBoard().add(boardElements.getWhiteBlocks()[pointer1-1], row-1, col-1);
						boardElements.getBoardCells().put(boardElements.getWhiteBlocks()[pointer1-1], new Integer[]{row-1, col-1});
						pointer1++;
					}else{
						boardElements.getInnerBoard().add(boardElements.getBlackBlocks()[pointer2-1], row-1, col-1);
						boardElements.getBoardCells().put(boardElements.getBlackBlocks()[pointer2-1], new Integer[]{row-1, col-1});
						pointer2++;
					}
				}
			}else{
				for(int col=1; col<=8; col++){
					if(col%2==0){
						boardElements.getInnerBoard().add(boardElements.getBlackBlocks()[pointer2-1], row-1, col-1);
						boardElements.getBoardCells().put(boardElements.getBlackBlocks()[pointer2-1], new Integer[]{row-1, col-1});
						pointer2++;
					}else{
						boardElements.getInnerBoard().add(boardElements.getWhiteBlocks()[pointer1-1], row-1, col-1);
						boardElements.getBoardCells().put(boardElements.getWhiteBlocks()[pointer1-1], new Integer[]{row-1, col-1});
						pointer1++;
					}
				}
			}
		}
		
	}
	
	//*********************************************************
	private void addPiecesToLayout() throws FileNotFoundException{
		createWhitePieces();
		createBlackPieces();
	}
	
	//*********************************************************
	private void createWhitePieces() throws FileNotFoundException{
		String whiteTeamLoc="resources/images/white_team/";
		
        ImageView king=new ImageView(new Image(new FileInputStream(whiteTeamLoc+"king.png")));
        ImageView queen=new ImageView(new Image(new FileInputStream(whiteTeamLoc+"queen.png")));
        ImageView bishop1=new ImageView(new Image(new FileInputStream(whiteTeamLoc+"bishop.png")));
        ImageView bishop2=new ImageView(new Image(new FileInputStream(whiteTeamLoc+"bishop.png")));
        ImageView knight1=new ImageView(new Image(new FileInputStream(whiteTeamLoc+"knight.png")));
        ImageView knight2=new ImageView(new Image(new FileInputStream(whiteTeamLoc+"knight.png")));
        ImageView rook1=new ImageView(new Image(new FileInputStream(whiteTeamLoc+"rook.png")));
        ImageView rook2=new ImageView(new Image(new FileInputStream(whiteTeamLoc+"rook.png")));
        ImageView pawn1=new ImageView(new Image(new FileInputStream(whiteTeamLoc+"pawn.png")));
        ImageView pawn2=new ImageView(new Image(new FileInputStream(whiteTeamLoc+"pawn.png")));
        ImageView pawn3=new ImageView(new Image(new FileInputStream(whiteTeamLoc+"pawn.png")));
        ImageView pawn4=new ImageView(new Image(new FileInputStream(whiteTeamLoc+"pawn.png")));
        ImageView pawn5=new ImageView(new Image(new FileInputStream(whiteTeamLoc+"pawn.png")));
        ImageView pawn6=new ImageView(new Image(new FileInputStream(whiteTeamLoc+"pawn.png")));
        ImageView pawn7=new ImageView(new Image(new FileInputStream(whiteTeamLoc+"pawn.png")));
        ImageView pawn8=new ImageView(new Image(new FileInputStream(whiteTeamLoc+"pawn.png")));
        
        boardElements.getInnerBoard().add(king, 4, 7); boardElements.getBoardPieces()[7][4]=king;
        boardElements.getInnerBoard().add(queen, 3, 7); boardElements.getBoardPieces()[7][3]=queen;
        boardElements.getInnerBoard().add(bishop1, 2, 7); boardElements.getBoardPieces()[7][2]=bishop1;
        boardElements.getInnerBoard().add(bishop2, 5, 7); boardElements.getBoardPieces()[7][5]=bishop2;
        boardElements.getInnerBoard().add(knight1, 1, 7); boardElements.getBoardPieces()[7][1]=knight1;
        boardElements.getInnerBoard().add(knight2, 6, 7); boardElements.getBoardPieces()[7][6]=knight2;
        boardElements.getInnerBoard().add(rook1, 0, 7); boardElements.getBoardPieces()[7][0]=rook1;
        boardElements.getInnerBoard().add(rook2, 7, 7); boardElements.getBoardPieces()[7][7]=rook2;
        boardElements.getInnerBoard().add(pawn1, 0, 6); boardElements.getBoardPieces()[6][0]=pawn1;
        boardElements.getInnerBoard().add(pawn2, 1, 6); boardElements.getBoardPieces()[6][1]=pawn2;
        boardElements.getInnerBoard().add(pawn3, 2, 6); boardElements.getBoardPieces()[6][2]=pawn3;
        boardElements.getInnerBoard().add(pawn4, 3, 6); boardElements.getBoardPieces()[6][3]=pawn4;
        boardElements.getInnerBoard().add(pawn5, 4, 6); boardElements.getBoardPieces()[6][4]=pawn5;
        boardElements.getInnerBoard().add(pawn6, 5, 6); boardElements.getBoardPieces()[6][5]=pawn6;
        boardElements.getInnerBoard().add(pawn7, 6, 6); boardElements.getBoardPieces()[6][6]=pawn7;
        boardElements.getInnerBoard().add(pawn8, 7, 6); boardElements.getBoardPieces()[6][7]=pawn8;
	}
	
	//*********************************************************
	private void createBlackPieces() throws FileNotFoundException{
		String blackTeamLoc="resources/images/black_team/";
		
        ImageView king=new ImageView(new Image(new FileInputStream(blackTeamLoc+"king.png")));
        ImageView queen=new ImageView(new Image(new FileInputStream(blackTeamLoc+"queen.png")));
        ImageView bishop1=new ImageView(new Image(new FileInputStream(blackTeamLoc+"bishop.png")));
        ImageView bishop2=new ImageView(new Image(new FileInputStream(blackTeamLoc+"bishop.png")));
        ImageView knight1=new ImageView(new Image(new FileInputStream(blackTeamLoc+"knight.png")));
        ImageView knight2=new ImageView(new Image(new FileInputStream(blackTeamLoc+"knight.png")));
        ImageView rook1=new ImageView(new Image(new FileInputStream(blackTeamLoc+"rook.png")));
        ImageView rook2=new ImageView(new Image(new FileInputStream(blackTeamLoc+"rook.png")));
        ImageView pawn1=new ImageView(new Image(new FileInputStream(blackTeamLoc+"pawn.png")));
        ImageView pawn2=new ImageView(new Image(new FileInputStream(blackTeamLoc+"pawn.png")));
        ImageView pawn3=new ImageView(new Image(new FileInputStream(blackTeamLoc+"pawn.png")));
        ImageView pawn4=new ImageView(new Image(new FileInputStream(blackTeamLoc+"pawn.png")));
        ImageView pawn5=new ImageView(new Image(new FileInputStream(blackTeamLoc+"pawn.png")));
        ImageView pawn6=new ImageView(new Image(new FileInputStream(blackTeamLoc+"pawn.png")));
        ImageView pawn7=new ImageView(new Image(new FileInputStream(blackTeamLoc+"pawn.png")));
        ImageView pawn8=new ImageView(new Image(new FileInputStream(blackTeamLoc+"pawn.png")));
        
        boardElements.getInnerBoard().add(king, 4, 0); boardElements.getBoardPieces()[0][4]=king;
        boardElements.getInnerBoard().add(queen, 3, 0); boardElements.getBoardPieces()[0][3]=queen;
        boardElements.getInnerBoard().add(bishop1, 2, 0); boardElements.getBoardPieces()[0][2]=bishop1;
        boardElements.getInnerBoard().add(bishop2, 5, 0); boardElements.getBoardPieces()[0][5]=bishop2;
        boardElements.getInnerBoard().add(knight1, 1, 0); boardElements.getBoardPieces()[0][1]=knight1;
        boardElements.getInnerBoard().add(knight2, 6, 0); boardElements.getBoardPieces()[0][6]=knight2;
        boardElements.getInnerBoard().add(rook1, 0, 0); boardElements.getBoardPieces()[0][0]=rook1;
        boardElements.getInnerBoard().add(rook2, 7, 0); boardElements.getBoardPieces()[0][7]=rook2;
        boardElements.getInnerBoard().add(pawn1, 0, 1); boardElements.getBoardPieces()[1][0]=pawn1;
        boardElements.getInnerBoard().add(pawn2, 1, 1); boardElements.getBoardPieces()[1][1]=pawn2;
        boardElements.getInnerBoard().add(pawn3, 2, 1); boardElements.getBoardPieces()[1][2]=pawn3;
        boardElements.getInnerBoard().add(pawn4, 3, 1); boardElements.getBoardPieces()[1][3]=pawn4;
        boardElements.getInnerBoard().add(pawn5, 4, 1); boardElements.getBoardPieces()[1][4]=pawn5;
        boardElements.getInnerBoard().add(pawn6, 5, 1); boardElements.getBoardPieces()[1][5]=pawn6;
        boardElements.getInnerBoard().add(pawn7, 6, 1); boardElements.getBoardPieces()[1][6]=pawn7;
        boardElements.getInnerBoard().add(pawn8, 7, 1); boardElements.getBoardPieces()[1][7]=pawn8;
	}
	
	//*********************************************************
	private void createOverallBoard(){
		
		//row names
		boardElements.getOverallBoardShape().add(new Label("a"), 1, 0); boardElements.getOverallBoardShape().add(new Label("a"), 1, 9);
		boardElements.getOverallBoardShape().add(new Label("b"), 2, 0); boardElements.getOverallBoardShape().add(new Label("b"), 2, 9);
		boardElements.getOverallBoardShape().add(new Label("c"), 3, 0); boardElements.getOverallBoardShape().add(new Label("c"), 3, 9);
		boardElements.getOverallBoardShape().add(new Label("d"), 4, 0); boardElements.getOverallBoardShape().add(new Label("d"), 4, 9);
		boardElements.getOverallBoardShape().add(new Label("e"), 5, 0); boardElements.getOverallBoardShape().add(new Label("e"), 5, 9);
		boardElements.getOverallBoardShape().add(new Label("f"), 6, 0); boardElements.getOverallBoardShape().add(new Label("f"), 6, 9);
		boardElements.getOverallBoardShape().add(new Label("g"), 7, 0); boardElements.getOverallBoardShape().add(new Label("g"), 7, 9);
		boardElements.getOverallBoardShape().add(new Label("h"), 8, 0); boardElements.getOverallBoardShape().add(new Label("h"), 8, 9);
		for(Node tmp: boardElements.getOverallBoardShape().getChildren()){
			Label label=(Label)tmp;
			label.setMinSize(boardElements.getCellSize(), 40);
			label.setAlignment(Pos.CENTER); //GridPane.setHalignment(label, HPos.RIGHT);
			label.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
		}

		//column names
		boardElements.getOverallBoardShape().add(new Label("8"), 0, 1); boardElements.getOverallBoardShape().add(new Label("8"), 9, 1);
		boardElements.getOverallBoardShape().add(new Label("7"), 0, 2); boardElements.getOverallBoardShape().add(new Label("7"), 9, 2);
		boardElements.getOverallBoardShape().add(new Label("6"), 0, 3); boardElements.getOverallBoardShape().add(new Label("6"), 9, 3);
		boardElements.getOverallBoardShape().add(new Label("5"), 0, 4); boardElements.getOverallBoardShape().add(new Label("5"), 9, 4);
		boardElements.getOverallBoardShape().add(new Label("4"), 0, 5); boardElements.getOverallBoardShape().add(new Label("4"), 9, 5);
		boardElements.getOverallBoardShape().add(new Label("3"), 0, 6); boardElements.getOverallBoardShape().add(new Label("3"), 9, 6);
		boardElements.getOverallBoardShape().add(new Label("2"), 0, 7); boardElements.getOverallBoardShape().add(new Label("2"), 9, 7);
		boardElements.getOverallBoardShape().add(new Label("1"), 0, 8); boardElements.getOverallBoardShape().add(new Label("1"), 9, 8);
		for(int index=16; index<boardElements.getOverallBoardShape().getChildren().size(); index++){
			Node tmp=boardElements.getOverallBoardShape().getChildren().get(index);
			Label label=(Label)tmp;
			label.setMinSize(40, boardElements.getCellSize());
			label.setAlignment(Pos.CENTER); //GridPane.setHalignment(label, HPos.RIGHT);
			label.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
		}
		
		//actual board
		boardElements.getOverallBoardShape().add(boardElements.getInnerBoard(), 1, 1, 8, 8);
		
	}
	//*********************************************************
	protected void resetLayout() throws FileNotFoundException{
		//remove old pieces
		for(int row=1; row<=8; row++){
			for(int col=1; col<=8; col++){
				ImageView pieceToRemove=boardElements.getBoardPieces()[row-1][col-1];
				boardElements.getInnerBoard().getChildren().remove(pieceToRemove);
				boardElements.getBoardPieces()[row-1][col-1]=null;
			}
		}
		//add start layout
		createWhitePieces();
		createBlackPieces();
	}
	
	
}
