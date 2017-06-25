package proprietaryGuiElements;

import java.io.FileNotFoundException;

import javafx.scene.layout.Pane;

public class JChessBoard {
	
	
	private BoardElementsGenerator elementsGenerator;
	private BoardLayoutGenerator layoutGenerator;
	
	
	
	public JChessBoard() throws FileNotFoundException {
		elementsGenerator=new BoardElementsGenerator();
		layoutGenerator=new BoardLayoutGenerator(elementsGenerator);
		
		elementsGenerator.initializeBoardElements();
		layoutGenerator.generateLayout();
	}
	
	
	public BoardElementsGenerator getElements(){
		return elementsGenerator;
	}
	
	public Pane getDisplayBoard(){
		return elementsGenerator.getOverallBoardShape();
	}
	
	
	public void resetGameBoard() throws FileNotFoundException{
		layoutGenerator.resetLayout();
		//boardElements.getInnerBoard().add(king, 4, 0); boardElements.getBoardPieces()[0][4]=king;
	}
	

}
