package storageModule;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import gameEngineModule.ChessGame;

public class XMLFileHandler{

	//02_LOAD GAME
	//**************************************************************
	protected static ChessGame loadGame(String fileLocation){
		try {
			//01_Open file
			XMLDecoder inputFile=new XMLDecoder(new BufferedInputStream(new FileInputStream(fileLocation)));
			//02_Write to file
			ChessGame tmp=(ChessGame)(inputFile.readObject());
			//03_Close file
			inputFile.close();
			return tmp;
		} catch (Exception e) {
			System.out.println("Error loading file");
			return null;
		}
	}
	
	//**************************************************************
	
	
}
