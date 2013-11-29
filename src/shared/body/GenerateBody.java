package shared.body;

public interface GenerateBody {
    
	
	public static enum BodyType {
		QUEEN, SOLDIER, WORKER, MALE
	}
	
	public BodyType getBodyType();
	
	//public boolean isFullTurnAction();
}

    