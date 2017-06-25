package UIModule;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

public class HotKeysGenerator {
	
	//01_ATTRIBUTES
	//*************************************************************
	private ElementGenerator appElements;
	
	//02_CONSTRUCTOR
	//*************************************************************
	public HotKeysGenerator(ElementGenerator appElements){
		this.appElements=appElements;
	}

	//03_RUN CLASS
	//*************************************************************
	public void initialize(){
		//APPLY MOVE
		appElements.getMovePieceButton().getScene().getAccelerators().put(
			new KeyCodeCombination(KeyCode.M, KeyCombination.CONTROL_DOWN), 
			new Runnable() {
				@Override public void run() {
					//appElements.getMovePieceButton().pressedProperty();
				}
			}
		);
		
		//UNDO MOVE
		appElements.getUndoMoveButton().getScene().getAccelerators().put(
			new KeyCodeCombination(KeyCode.Z, KeyCombination.CONTROL_DOWN), 
			new Runnable() {
				@Override public void run() {
					
				}
			}
		);

		//REDO MOVE
		appElements.getRedoMoveButton().getScene().getAccelerators().put(
			new KeyCodeCombination(KeyCode.Y, KeyCombination.CONTROL_DOWN), 
			new Runnable() {
				@Override public void run() {
					
				}
			}
		);

		//START NEW GAME
		appElements.getNewGameButton().getScene().getAccelerators().put(
			new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN), 
			new Runnable() {
				@Override public void run() {
					
				}
			}
		);

		//SAVE GAME
		appElements.getSaveGameButton().getScene().getAccelerators().put(
			new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN), 
			new Runnable() {
				@Override public void run() {
					
				}
			}
		);
		
		//LOAD SAVED GAME
		appElements.getLoadGameButton().getScene().getAccelerators().put(
			new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN), 
			new Runnable() {
				@Override public void run() {
					
				}
			}
		);
		
	}
	
	
}
