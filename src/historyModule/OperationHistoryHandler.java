package historyModule;

public interface OperationHistoryHandler {

	public void addOperationEntry();
	public void undoMove();
	public void redoMove();
	
}
