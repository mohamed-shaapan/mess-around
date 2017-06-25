package b_dynamicSortSearch;

import a_nonDynamicSortSearch.UsefulMethods;

public class HeapADT {
	
	
	//01_ATTRIBUTES
	//***************************************************
	private int length;
	private int heapSize;
	private int array[];
	
	//02_CONSTRUCTOR
	//***************************************************
	public HeapADT(int[] array){
		this.array=array;
		this.length=array.length;
		this.heapSize=array.length;	
	}

	
	//INSERT TOP BOTTOM
	//****************************************
	private void maxHeapify(int index){
		//add element from Top Bottom
		int leftChildIndex=(2*index)+1;
		int rightChildIndex=(2*index)+2;
		int largestChildIndex=heapSize;
		//Obtain index of largest child
		if(leftChildIndex<heapSize){
			largestChildIndex=leftChildIndex;
		}
		if(rightChildIndex<heapSize){
			if(array[rightChildIndex]>array[leftChildIndex]){
				largestChildIndex=rightChildIndex;
			}
		}
		//perform recursive insertion
		if(largestChildIndex<heapSize){
			if(array[largestChildIndex]>array[index]){
				UsefulMethods.swapNumbers(array, index, largestChildIndex);
				maxHeapify(largestChildIndex);
			}
		}
	}
	
	//GENERATE HEAP
	//****************************************
	public void buildMaxHeap(){
		//generate heap array
		heapSize=array.length;
		int start=(array.length/2)-1;
		for(int index=start; index>=0; index--){
			maxHeapify(index);
		}
	}
	
	//SORT HEAP
	//****************************************************************
	public void heapSort(){
		for(int i=length; i>=2; i--){
			UsefulMethods.swapNumbers(array, 0, heapSize-1);
			heapSize--;
			maxHeapify(0);
		}
	}

	
	

	
}
