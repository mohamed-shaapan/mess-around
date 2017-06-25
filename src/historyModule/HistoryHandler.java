package historyModule;


import java.util.LinkedList;


public class HistoryHandler<dataType>{
	
	//01_Attributes***********************
	//*************************************************************************
	private LinkedList<dataType> historyData;
	private int currentNodeIndex;
	
	
	//02_Constructor**********************
	//*************************************************************************
	public HistoryHandler() {
		historyData=new LinkedList<dataType>();
		currentNodeIndex=0;
	}
	
	
	//03_Methods**************************
	//*************************************************************************
	public dataType getNode(int index){
		return this.historyData.get(index);
	}
	
	//******************************************
	public void addNewHistoryEntry(dataType newExpression){
		//Case_01 - Empty List
		if(historyData.size()==0){
			historyData.add(newExpression);
			currentNodeIndex=1;
		}
			
		//Case_02 - Nothing in next
		else if(historyData.size()==currentNodeIndex){
			historyData.addLast(newExpression);
			currentNodeIndex+=1;
		}
			
		//Case_02 - Next has values
		else {
			historyData.add(currentNodeIndex, newExpression);
			currentNodeIndex+=1;
			//remove all next nexts
			int NumOfElementsToRemove=historyData.size()-currentNodeIndex;
			for(int i=1; i<=NumOfElementsToRemove; i++){
				historyData.removeLast();
			}
		}
	}
	
	//******************************************
	public dataType goBack(){
		//Case_01 - Can Go Back
		if(canGoBack()){
			dataType tmp=historyData.get(currentNodeIndex-2);
			currentNodeIndex-=1;
			return tmp;
		}
		//Case_02 - Can't go Back (Empty List or Reached Element 1)
		dataType tmp=historyData.get(currentNodeIndex-1);
		return tmp;
	}
	
	//******************************************
	public dataType goForward(){
		//Case_01 - You can go forward
		if(canGoForward()){
			dataType tmp=historyData.get(currentNodeIndex);
			currentNodeIndex+=1;
			return tmp;
		}
		//Case_02 - can't go forward - (Empty List or Reached the End)
		dataType tmp=historyData.get(currentNodeIndex-1);
		return tmp;
	}
	
	//******************************************
	public boolean canGoBack(){
		if(currentNodeIndex>=2){
			return true;
		}
		return false;
	}
		
	public boolean canGoForward(){
		if(currentNodeIndex<historyData.size()){
			return true;
		}
		return false;
	}
	//******************************************
	

}
