
package body;

public abstract class worker implements GenerateBody{
    
    public BodyType getActionType() {
		return BodyType.WORKER;
	}
	
}