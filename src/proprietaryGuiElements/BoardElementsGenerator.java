package proprietaryGuiElements;

import java.util.HashMap;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

public class BoardElementsGenerator {

	
	//01_ELEMENTS
	//**************************************************
	final int cellSize=65;
	private Rectangle[] whiteBlocks;
	private Rectangle[] blackBlocks;
	private GridPane innerBoard;
	private ImageView boardPieces[][];
	private HashMap<Rectangle, Integer[]> boardCells;
	private GridPane overallBoardShape;
	
	//02_CONSTRUCTOR
	//**************************************************
	public void initializeBoardElements(){
		boardPieces=new ImageView[8][8];
		boardCells=new HashMap<Rectangle, Integer[]>();
		whiteBlocks=new Rectangle[32];
		blackBlocks=new Rectangle[32];
		innerBoard=new GridPane();
		overallBoardShape=new GridPane();
	}

	
	//03_GETTERS
	//**************************************************
	public int getCellSize() {
		return cellSize;
	}

	public Rectangle[] getWhiteBlocks() {
		return whiteBlocks;
	}

	public Rectangle[] getBlackBlocks() {
		return blackBlocks;
	}

	public GridPane getInnerBoard() {
		return innerBoard;
	}

	public ImageView[][] getBoardPieces() {
		return boardPieces;
	}

	public HashMap<Rectangle, Integer[]> getBoardCells() {
		return boardCells;
	}

	public GridPane getOverallBoardShape() {
		return overallBoardShape;
	}
	
	

	
	
}
