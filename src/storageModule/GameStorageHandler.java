package storageModule;

import java.io.File;

import gameEngineModule.ChessGame;

public class GameStorageHandler {
	
	
	//ATTRIBUTES
	//*********************************************************
	private ChessGame gameSet;
	
	
	//CONSTRUCTOR
	//*********************************************************
	public GameStorageHandler(ChessGame gameSet) {
		// TODO Auto-generated constructor stub
		this.gameSet=gameSet;
	}

	
	//01_SAVE GAME
	//**************************************************************
	public boolean saveGame(File chosenFile) {
		
		if(getFileExtension(chosenFile).equalsIgnoreCase("bin")){
			BinaryFormatHandler.saveGame(gameSet, chosenFile);
			
		}else if(getFileExtension(chosenFile).equalsIgnoreCase("xml")){
			XMLFileHandler.saveGame(gameSet, chosenFile);
			
		}
		return false;
	}
	
	
	
	//02_LOAD GAME
	//**************************************************************
	public ChessGame loadGame(String fileDirectory) {

		return null;
	}

	
	
	//PRIVATE METHODS
	//**************************************************************
	private static String getFileExtension(File file) {
		String fileName = file.getName();
		if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
			return fileName.substring(fileName.lastIndexOf(".") + 1);
		else
			return "";
	}

}
