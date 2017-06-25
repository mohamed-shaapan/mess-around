package storageModule;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import gameEngineModule.ChessGame;

public class BinaryFormatHandler{

	
	
	//01_SAVE GAME
	//**************************************************************
	protected static boolean saveGame(ChessGame gameSet, File chosenFile) {
		try{
			//open file
			FileOutputStream tmp=new FileOutputStream(chosenFile);
			ObjectOutputStream fileWriter=new ObjectOutputStream(tmp);
			//write to file
			fileWriter.writeObject(gameSet);
			//close file
			fileWriter.close();
			tmp.close();
			return true;
		}catch(Exception e){
			System.out.println("Error creating or opening file");
			return false;
		}
	}
		
		
	//02_LOAD GAME
	//**************************************************************
	protected static ChessGame loadGame(String fileDirectory){
		File gameProgressFile=new File(fileDirectory);
		try{
			//open file
			FileInputStream tmp=new FileInputStream(gameProgressFile);
			ObjectInputStream fileReader=new ObjectInputStream(tmp);
			//read from file
			ChessGame gameSet=(ChessGame)fileReader.readObject();
			//close file
			fileReader.close();
			tmp.close();
			return gameSet;
		}catch (Exception e){
			System.out.println("Error loading file");
			return null;
		}
	}
	
	//**************************************************************
	
	
	
	
	
}
