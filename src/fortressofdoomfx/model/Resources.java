
package fortressofdoomfx.model;

//@author Team Minion Patrol

public class Resources {
    int power = 0;
    int wood = 0;
    int hut = 0;
    int woodLimit = 100;
    
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
    
    public void incrementHut() {
        if (wood < woodLimit) {
            System.out.println("Not enough wood!");
        }
        else if (hut == 0 && wood >= woodLimit) {
            wood -= woodLimit;
            woodLimit = 150;
            hut += 1;
        }
        else if (hut == 1 && wood >= woodLimit) {
            wood -= woodLimit;
            woodLimit = 200;
            hut += 1;
        }
        else if (hut == 2 && wood >= woodLimit) {
            wood -= woodLimit;
            woodLimit = 250;
            hut += 1;
        }  
        else if (hut == 3 && wood >= woodLimit) {
            wood -= woodLimit;
            woodLimit = 300;
            hut += 1;
        }
        else if (hut == 4 && wood >= woodLimit) {
            wood -= woodLimit;
            woodLimit = 350;
            hut += 1;
        } 
        else if (hut == 5 && wood >= woodLimit) {
            wood -= woodLimit;
            woodLimit = 400;
            hut += 1;
        }
        else if (hut == 6 && wood >= woodLimit) {
            wood -= woodLimit;
            woodLimit = 500;
            hut += 1;
        }
        else if (hut == 7 && wood >= woodLimit) {
            wood -= woodLimit;
            woodLimit = 600;
            hut += 1;
        } 
        else if (hut == 8 && wood >= woodLimit) {
            wood -= woodLimit;
            woodLimit = 700;
            hut += 1;
        }
        else if (hut == 9 && wood >= woodLimit) {
            wood -= woodLimit;
            hut += 1;
        }
        else if (hut >= 10) {
            //Don't add any more huts!
            System.out.println("Maxed out huts!");
        }
        else {
            System.out.println("DoEs NOt CoMPuTe");
        }
        
        System.out.println("Huts: " + hut);
    }
    
    public int getPower() {
        return power;
    }
    
    public int getWood() {
        return wood;
    }
}
