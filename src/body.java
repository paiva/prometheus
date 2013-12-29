/**
 * Body Class in Prometheus Architecture
 * @author Santiago Paiva
 * @version 1.0
 */

public class body {
 
    // Expression x;
    
    // Genes Y; 
    
    // AI ai; 
    
    // Sensor methods
    
    // Actuators methods 
    
    /**
    * Contains four parameters for direction and one parameter for speed
    * Side Effect: Energy level decreases 
    * @param up
    * @param down
    * @param left
    * @param right
    * @param speed
    * @return Success(0)/Failure(1)
    */
    public static int move(int up, int down, int left, int right, int speed){
            
        //Return 
        return 0; 
        
        //Decrease Energy level 
        
    }
    
    /**
    * Contains one parameter for type of pheromone
    * Side Effect: Energy level slightly decreases 
    * @param type
    * @return type
    */
    public static int releasePheromone(int type){
        
        //Return 
        return type;
        
        //Decrease energy level 
    }
    
    /**
    * Contains one parameter for the strength 
    * Side Effect: Store the object being held
    * @param strength
    * @return Success(0)/Failure(1)
    */
    public static int pickUp(int strength){
        
        //Return 
        return 0;
        
        //Store Object being held
    }
    
    /**
    * Contain no parameters 
    * Side Effect: Energy level increases
    * @return Success(0)/Failure(1)
    */
    public static int eat(){
        
        //Return 
        return 0;
        
        //Energy level increases
    }
    
    /**
    * Contains no parameters
    * Side Effect: Energy level decreases
    * @return Success(0)/Failure(1)
    */
    public static int bite(){
        
        //Return 
        return 0;
        
        //Energy level decreases
        
    }
    
    /**
    * Contains three parameters: smell to the left, right, or front
    * Side Effect: Change State 
    * @param left
    * @param right
    * @param front
    * @return Success(0)/Failure(1)
    */
    public static int smell(int left, int right, int front){
        
        //Return 
        return 0;
        
        //State Change
        
    }
 
    
    /**
    * Contains three parameters: touch to the left, right, or front
    * Side Effect: Change State 
    * @param left
    * @param right
    * @param front
    * @return Success(0)/Failure(1)
    */
    public static int touch(int left,int right,int front){
    
        //Return 
        return 0;
        
        //State Change
        
    }
    
}

