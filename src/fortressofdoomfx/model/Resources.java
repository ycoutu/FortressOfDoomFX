
package fortressofdoomfx.model;

//@author Team Minion Patrol

public class Resources {
    int power = 0;
    int wood = 0;
    int hut = 0;
    int hutCost = 100;
    
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
        if (hut == 0) {
            hutCost = 100;
        }
        else if (hut == 1) {
            hutCost = 150;
        }
        else if (hut == 3) {
            hutCost = 200;
        }
        else if (hut == 4) {
            hutCost = 250;
        }
        else if (hut == 5) {
            hutCost = 300;
        }
        else if (hut == 6) {
            hutCost = 350;
        }
        else if (hut == 7) {
            hutCost = 400;
        }
        else if (hut == 8) {
            hutCost = 450;
        }
        else if (hut == 9) {
            hutCost = 500;
        }
        else if (hut == 10) {
            hutCost = 0;
        }
        else {
            System.out.println("??????????");
        }
        
        if (wood < hutCost) {
            System.out.println("Not enough wood!");
        }
        else if (hut == 0 && wood >= hutCost) {
            wood -= hutCost;
            hut += 1;
        }
        else if (hut == 1 && wood >= hutCost) {
            wood -= hutCost;
            hut += 1;
        }
        else if (hut == 2 && wood >= hutCost) {
            wood -= hutCost;
            hut += 1;
        }  
        else if (hut == 3 && wood >= hutCost) {
            wood -= hutCost;
            hut += 1;
        }
        else if (hut == 4 && wood >= hutCost) {
            wood -= hutCost;
            hut += 1;
        } 
        else if (hut == 5 && wood >= hutCost) {
            wood -= hutCost;
            hut += 1;
        }
        else if (hut == 6 && wood >= hutCost) {
            wood -= hutCost;
            hut += 1;
        }
        else if (hut == 7 && wood >= hutCost) {
            wood -= hutCost;
            hut += 1;
        } 
        else if (hut == 8 && wood >= hutCost) {
            wood -= hutCost;
            hut += 1;
        }
        else if (hut == 9 && wood >= hutCost) {
            wood -= hutCost;
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
    
    public int getHut() {
        return hut;
    }
    
    public int getHutCost() {
        return hutCost;
    }
}
