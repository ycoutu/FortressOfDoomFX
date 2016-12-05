
package fortressofdoomfx.model;

//@author Team Minion Patrol

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;


public class Resources {
    public int power = 0;
    public int wood = 0;
    public int hut = 0;
    int hutCost = 100;
    int minion = 0;
    int minionCap = 0;
    public int trap = 0;
    int trapCost = 10;
    boolean cart = false;
     @FXML private TextArea messages;
    
    public Resources() {
        //Constructor doesn't do anything
    }
    
    public void incrementPower() {
        power += 2;
        System.out.println("Power: " + power);
    }
    
    public void incrementWood() {
        if (cart == false) {
            wood += 10;
        }
        else if (cart == true) {
            wood += 30;
        }
        else {
            System.out.println("U broked da wood");
        }
        System.out.println("Wood: " + wood);
    }
    
    public void incrementWoodOverTime()
    {
        if(minion > 1)
        {
            wood += 2 * minion; 
            System.out.println("Wood: " + wood);
        }
    }
    
    public void incrementCart() {
        if (cart == false && wood >= 30) {
            wood -= 30;
            cart = true;
        }
        System.out.println("Wood: " + wood);
    }
    
    public void setTrapCost() {
        if (trap == 0) {
            trapCost = 10;
        }
        if (trap == 1) {
            trapCost = 20;
        }
        if (trap == 2) {
            trapCost = 30;
        }
        if (trap == 3) {
            trapCost = 40;
        }
        if (trap == 4) {
            trapCost = 50;
        }
        if (trap == 5) {
            trapCost = 60;
        }
        if (trap == 6) {
            trapCost = 70;
        }
        if (trap == 7) {
            trapCost = 80;
        }
        if (trap == 8) {
            trapCost = 90;
        }
        if (trap == 9) {
            trapCost = 100;
        }
        if (trap == 10) {
            trapCost = 0;
        }
    }
    
    public void setHutCost() {
        if (hut == 0) {
            hutCost = 100;
        }
        else if (hut == 1) {
            hutCost = 150;
        }
        else if (hut == 2) {
            hutCost = 200;
        }
        else if (hut == 3) {
            hutCost = 250;
        }
        else if (hut == 4) {
            hutCost = 300;
        }
        else if (hut == 5) {
            hutCost = 350;
        }
        else if (hut == 6) {
            hutCost = 400;
        }
        else if (hut == 7) {
            hutCost = 450;
        }
        else if (hut == 8) {
            hutCost = 500;
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
    }
    
    public void incrementTrap() {
        this.setTrapCost();
        
        if (wood < trapCost) {
            System.out.println("Not enough wood!");
        }
        else if (trap >= 0 && trap < 10 && wood >= trapCost) {
            wood -= trapCost;
            trap += 1;
        }
        else if (trap >= 10) {
            System.out.println("Maxed out huts!");
        }
        else {
            System.out.println("Trapz y u no work?!?");
        }
        
        System.out.println("Trap: " + trap);
        System.out.println("Wood: " + wood);
        
        this.setTrapCost();
    }
    
    public void incrementHut() {
        this.setHutCost();
        
        if (wood < hutCost) {
            System.out.println("Not enough wood!");
        }
        else if (hut >= 0 && hut < 10 && wood >= hutCost) {
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
        System.out.println("Wood: " + wood);
        
        this.setHutCost();
    }
    
    public void incrementMinion()
    {
        minionCap = hut * 4;
        if(minion < minionCap)
        {
            minion += 2; 
         //messages.appendText("A loyal servant has joined your ranks.");
         if(minion == minionCap)
         {
             //messages.appendText("Minion Capacity reached");
             System.out.println("Minion capacity reached, build more huts");
             
         }
        }
        
        System.out.println(minion + " Minions exist with " + hut + " Huts in existence" );
    }
    
    public void purchaseWood() {
        power -= 1;
        wood += 10;
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
    
    public int getTrap() {
        return trap;
    }
    
    public int getTrapCost() {
        return trapCost;
    }
    
    public boolean getCart() {
        return cart;
    }
}
