package UIModule;


import java.io.FileNotFoundException;

import gameEngineModule.ChessGame;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import proprietaryGuiElements.JChessBoard;

public class ElementGenerator {

	
	//A_APP CONTROLS
	//******************************
	private Label appControlsLabel;
	private Button newGameButton;
	private Button saveGameButton;
	private Button loadGameButton;
	
	//A_GAME CONTROLS
	//******************************
	private Label gamePlayControlsLabel;
	private TextField movePieceFrom;
	private TextField movePieceTo;
	private Button movePieceButton;
	private Button undoMoveButton;
	private Button redoMoveButton;
	
	//D_GAME STATUS
	//******************************
	private Label gameStatusLabel;
	private Label gameStatusDisplayLabel;
	private Label playerTurnLabel;
	private Label gameDurationDisplayLabel;
	
	//C_KILLED PIECE BLOCK
	//******************************
	private Label killedWhitePiecesLabel;
	private TextArea killedWhitePiecesBox;
	private Label killedBlackPiecesLabel;
	private TextArea killedBlackPiecesBox;
	
	
	//G_LAYOUT ELEMENTS
	//******************************
	private BorderPane layout;
	private Pane canvas;
	//private ChessBoardUI boardUI;
	private JChessBoard chessBoard;
	
	//H_GAME ENGINE
	//******************************
	private ChessGame gameEngine;
	
	
	
	
	//***********************************************************************
	public void initialize() throws FileNotFoundException{
		
		//A_APP CONTROLS
		//******************************
		appControlsLabel=new Label("APP CONTROLS");
		newGameButton=new Button("New");
		saveGameButton=new Button("Save");
		loadGameButton=new Button("Load");

		//A_GAME CONTROLS
		//******************************
		gamePlayControlsLabel=new Label("Gameplay Controls");
		movePieceFrom=new TextField("from");
		movePieceTo=new TextField("to");
		movePieceButton=new Button("Move");
		undoMoveButton=new Button("Undo");
		redoMoveButton=new Button("Redo");

		//B_GAME STATUS
		//******************************
		gameStatusLabel=new Label("Game Status");
		gameStatusDisplayLabel=new Label("");
		playerTurnLabel=new Label("PLAYER TURN : WHITE");
		gameDurationDisplayLabel=new Label("17:43");
		
		//C_KILLED PIECE BLOCK
		//******************************
		killedWhitePiecesLabel=new Label("Killed White Pieces");
		killedWhitePiecesBox=new TextArea("QUEEN, PAWN");
		killedBlackPiecesLabel=new Label("Killed Black Pieces");
		killedBlackPiecesBox=new TextArea("QUEEN, PAWN");

		
		//E_LAYOUT ELEMENTS
		//******************************
		canvas=new Pane();
		layout=new BorderPane();
		chessBoard=new JChessBoard();
		
		//H_GAME ENGINE
		//******************************
		gameEngine=new ChessGame();
		
	}


	//03_GETTERS
	//*************************************************************
	//*************************************************************

	public Label getAppControlsLabel() {
		return appControlsLabel;
	}


	public Button getNewGameButton() {
		return newGameButton;
	}

	
	public Button getSaveGameButton() {
		return saveGameButton;
	}


	public Button getLoadGameButton() {
		return loadGameButton;
	}


	public Label getGamePlayControlsLabel() {
		return gamePlayControlsLabel;
	}


	public TextField getMovePieceFrom() {
		return movePieceFrom;
	}


	public TextField getMovePieceTo() {
		return movePieceTo;
	}


	public Button getMovePieceButton() {
		return movePieceButton;
	}


	public Button getUndoMoveButton() {
		return undoMoveButton;
	}


	public Button getRedoMoveButton() {
		return redoMoveButton;
	}


	public Label getGameStatusLabel() {
		return gameStatusLabel;
	}

	
	public Label getGameStatusDisplayLabel() {
		return gameStatusDisplayLabel;
	}
	
	
	public Label getPlayerTurnLabel() {
		return playerTurnLabel;
	}


	public Label getGameDurationDisplayLabel() {
		return gameDurationDisplayLabel;
	}


	public Label getKilledWhitePiecesLabel() {
		return killedWhitePiecesLabel;
	}


	public TextArea getKilledWhitePiecesBox() {
		return killedWhitePiecesBox;
	}


	public Label getKilledBlackPiecesLabel() {
		return killedBlackPiecesLabel;
	}


	public TextArea getKilledBlackPiecesBox() {
		return killedBlackPiecesBox;
	}

	
	public BorderPane getLayout() {
		return layout;
	}


	public Pane getCanvas() {
		return canvas;
	}


	public JChessBoard getChessBoard() {
		return chessBoard;
	}


	public ChessGame getGameEngine() {
		return gameEngine;
	}
	
	public void resetChessBoard() throws FileNotFoundException{
		chessBoard=new JChessBoard();
	}



	

	


	


	
	


	
	
}
