
package fortressofdoomfx.model;

//@author Team Minion Patrol

public class Resources {
    int power = 0;
    
    public Resources() {
        
    }
    
    public void incrementPower() {
        power += 2;
        System.out.println("Power: " + power);
    }
    
    public int getPower() {
        return power;
    }
}
