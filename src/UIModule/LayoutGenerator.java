package UIModule;


import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LayoutGenerator {

	//01_ATTRIBUTES
	//*************************************************************
	private ElementGenerator appElements;
		
		
	//02_CONSTRUCTOR
	//*************************************************************
	public LayoutGenerator(ElementGenerator appElements){
		this.appElements=appElements;
	}
		

	//03_METHODS
	//*************************************************************
	public void initialize(){
		
		
		//A_GAME STATUS
		//*****************************************************
		VBox gameStatusBlock=new VBox();
		appElements.getGameStatusLabel().setFont(Font.font("Verdana", FontWeight.BOLD, 17));
		appElements.getGameStatusLabel().setTextFill(Color.SLATEGREY);
		gameStatusBlock.getChildren().add(appElements.getGameStatusLabel());
		VBox tmp31=new VBox();
		tmp31.getChildren().add(appElements.getPlayerTurnLabel());
		tmp31.getChildren().add(appElements.getGameStatusDisplayLabel());
		appElements.getGameDurationDisplayLabel().setFont(Font.font(25));
		tmp31.getChildren().add(appElements.getGameDurationDisplayLabel());
		tmp31.setSpacing(15);
			
		Label b1=new Label("*****************************************");
		gameStatusBlock.getChildren().addAll(tmp31, b1);
		gameStatusBlock.setSpacing(10);
		gameStatusBlock.setPadding(new Insets(30,20,0,20));	
				
		
		//B_GAMEPLAY CONTROLS
		//*****************************************************
		VBox gameplayControlsBlock=new VBox();
		appElements.getGamePlayControlsLabel().setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		appElements.getGamePlayControlsLabel().setTextFill(Color.SLATEGREY);
		gameplayControlsBlock.getChildren().add(appElements.getGamePlayControlsLabel());
		
		HBox tmp21=new HBox();
		appElements.getMovePieceFrom().setMaxWidth(50);
		appElements.getMovePieceTo().setMaxWidth(50);
		appElements.getMovePieceButton().setPrefWidth(55);
		tmp21.setSpacing(15);
		tmp21.getChildren().addAll(appElements.getMovePieceFrom(), appElements.getMovePieceTo(), appElements.getMovePieceButton());
		
		HBox tmp22=new HBox();
		appElements.getUndoMoveButton().setPrefWidth(55);
		appElements.getRedoMoveButton().setPrefWidth(55);
		tmp22.setSpacing(10);
		tmp22.getChildren().addAll(appElements.getUndoMoveButton(), appElements.getRedoMoveButton());
		
		
		Label b2=new Label("*****************************************");
		gameplayControlsBlock.getChildren().addAll(tmp21, tmp22, b2);
		gameplayControlsBlock.setSpacing(10);
		gameplayControlsBlock.setPadding(new Insets(0,20,0,20));
		

		
		//D_KILLED PIECE BLOCK
		//*****************************************************
		VBox killedWhitePieceBlock=new VBox();
		appElements.getKilledWhitePiecesLabel().setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		appElements.getKilledWhitePiecesLabel().setTextFill(Color.SLATEGREY);
		killedWhitePieceBlock.getChildren().add(appElements.getKilledWhitePiecesLabel());

		VBox tmp41=new VBox();
		appElements.getKilledWhitePiecesBox().setPrefSize(100,70);
		appElements.getKilledWhitePiecesBox().setEditable(false);
		tmp41.getChildren().add(appElements.getKilledWhitePiecesBox());
		tmp41.setSpacing(15);
		
		killedWhitePieceBlock.getChildren().add(tmp41);
		killedWhitePieceBlock.setSpacing(10);
		killedWhitePieceBlock.setPadding(new Insets(0,20,5,20));
		
		//************************************
		
		VBox killedBlackPieceBlock=new VBox();
		appElements.getKilledBlackPiecesLabel().setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		appElements.getKilledBlackPiecesLabel().setTextFill(Color.SLATEGREY);
		killedBlackPieceBlock.getChildren().add(appElements.getKilledBlackPiecesLabel());

		VBox tmp51=new VBox();
		appElements.getKilledBlackPiecesBox().setPrefSize(100, 70);
		appElements.getKilledBlackPiecesBox().setEditable(false);
		tmp51.getChildren().add(appElements.getKilledBlackPiecesBox());
		tmp51.setSpacing(15);
		
		killedBlackPieceBlock.getChildren().add(tmp51);
		killedBlackPieceBlock.setSpacing(10);
		killedBlackPieceBlock.setPadding(new Insets(0,20,0,20));
		
		
		
		
		//A_APP CONTROLS
		//*****************************************************
		VBox appControlBlock=new VBox();
		Label b3=new Label("*****************************************");
		appControlBlock.getChildren().addAll(b3);
		
		HBox tmp11=new HBox();
		appElements.getNewGameButton().setPrefWidth(50);
		appElements.getSaveGameButton().setPrefWidth(50);
		appElements.getLoadGameButton().setPrefWidth(50);
		tmp11.setSpacing(10);
		tmp11.getChildren().addAll(appElements.getNewGameButton(), appElements.getSaveGameButton(), appElements.getLoadGameButton());
		
		appControlBlock.getChildren().addAll(tmp11);
		appControlBlock.setSpacing(10);
		appControlBlock.setPadding(new Insets(10,20,0,20));
		
		
		
		
		
		//ENTIRE SIDE PANEL
		//*****************************************************
		//*****************************************************
		
		
		VBox sidePanel=new VBox();
		sidePanel.getChildren().addAll(gameStatusBlock, gameplayControlsBlock, killedWhitePieceBlock, killedBlackPieceBlock, appControlBlock);
		sidePanel.setMinWidth(250);
		sidePanel.setMaxWidth(250);
		sidePanel.setStyle("-fx-background-color: white;");//#dddddd
		//*****************************************************
		//*****************************************************
		
		//E_DRAWING CANVAS
		//*****************************************************
		appElements.getCanvas().setMinSize(600, 400);
		appElements.getCanvas().setClip(new Rectangle(3000,3000));
		HBox tmp=new HBox();
		tmp.setPadding(new Insets(25,100,50,70));
		
		tmp.getChildren().add(appElements.getChessBoard().getDisplayBoard());
		//tmp.getChildren().add(appElements.getBoardUI().getBoard());
		appElements.getCanvas().getChildren().add(tmp);
		appElements.getCanvas().setPadding(new Insets(30,30,30,30));
		
		HBox drawingCanvas=new HBox();
		drawingCanvas.getChildren().add(appElements.getCanvas());
		drawingCanvas.setStyle("-fx-background-color: #eae7d7;");
		
		
		//*****************************************************
		appElements.getLayout().setLeft(sidePanel);
		appElements.getLayout().setCenter(drawingCanvas);
		appElements.getLayout().setPrefSize(900, 550);

	}
	
	
	
	
	
}
