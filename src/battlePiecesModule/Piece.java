package battlePiecesModule;

import java.util.ArrayList;

import gameEngineModule.ChessGame;
import validLocationGeneratorModule.ValidLocations;

public abstract class Piece {

	
	//01_Attributes***********************
	//*************************************************************************
	private String displayName;
	private String type;
	private String team;
	private String enemy;
		
	private int step;
	private boolean active;
	//private int teamArrayLocation;
		
	private int initialRow; private int initialColumn;
	private int currentRow; private int currentColumn;
	
	protected ValidLocations validLocations;
	private ChessGame gameBoard;
		
	//02_Constructor**********************
	//*************************************************************************
	public Piece(ChessGame gameBoard, String displayName, String type, String team, String enemy, int step, boolean active, int initialRow,
		int initialColumn, int currentRow, int currentColumn) {
		this.gameBoard=gameBoard;
		this.displayName = displayName;
		this.type = type;
		this.team = team;
		this.enemy = enemy;
		this.step = step;
		this.active = active;
		this.initialRow = initialRow;
		this.initialColumn = initialColumn;
		this.currentRow = currentRow;
		this.currentColumn = currentColumn;
	}
		
	//03_Methods**************************
	//*************************************************************************
	public ArrayList<int[]> generateNextValidLocations(){
		
		return validLocations.generateNextValidLocations();
		
	}

	
	
	
	//A_Setters
	public void setDisplayName(String displayName){
		this.displayName=displayName;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public void setEnemy(String enemy) {
		this.enemy = enemy;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public void setInitialRow(int initialRow) {
		this.initialRow = initialRow;
	}
	public void setInitialColumn(int initialColumn) {
		this.initialColumn = initialColumn;
	}
	public void setCurrentColumn(int currentColumn) {
		this.currentColumn = currentColumn;
	}
	public void setCurrentRow(int currentRow) {
		this.currentRow = currentRow;
	}
	
	//B_Getters*************************************************
	public String getDisplayName(){
		return this.displayName;
	}
	public String getType() {
		return type;
	}
	public String getTeam() {
		return team;
	}
	public String getEnemy() {
		return enemy;
	}
	public int getStep() {
		return step;
	}
	public boolean isActive() {
		return active;
	}
	public int getInitialRow() {
		return initialRow;
	}
	public int getInitialColumn() {
		return initialColumn;
	}
	public int getCurrentRow() {
		return currentRow;
	}
	public int getCurrentColumn() {
		return currentColumn;
	}
	public ChessGame getGameBoard(){
		return gameBoard;
	}
	
	
	
}
		
		
		
