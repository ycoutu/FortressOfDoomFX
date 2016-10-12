
package fortressofdoomfx.model;

//@author Team Minion Patrol

public class Resources {
    int power = 0;
    int wood = 0;
    
    public Resources() {
        //Constructor doesn't do anything
    }
    
    public void incrementPower() {
        power += 2;
        System.out.println("Power: " + power);
    }
    
    public void incrementWood() {
        wood += 10;
        System.out.println("Wood: " + wood);
    }
    
    public int getPower() {
        return power;
    }
    
    public int getWood() {
        return wood;
    }
}
