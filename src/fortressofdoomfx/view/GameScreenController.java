/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fortressofdoomfx.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import fortressofdoomfx.FortressOfDoomFX;
import java.util.Timer;
import java.util.TimerTask;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;


/**
 * FXML Controller class
 *
 * @author Team Minion Patrol
 */
public class GameScreenController implements Initializable {

    @FXML private Tab forestTab;
    @FXML private Button gatherPowerButton;
    @FXML private Button gatherWoodButton;
    @FXML private Button buildHutButton;
    @FXML private Button buildTrapButton;
    @FXML private Button buildCartButton;
    @FXML private Label buildLabel;
    @FXML private TextArea messages;

    fortressofdoomfx.model.Resources resource = new fortressofdoomfx.model.Resources();
    /**
     * Initializes the controller class.
     */
    //fortressofdoomfx.model.Resources resource;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Append this message on game startup
        messages.appendText("old bones shiver in the dark." + "\n" + 
                "the shadows coalesce." + "\n" + "they form a being." +
                "\n" + "you." + "\n");
    }
    
//    public void buttonCooldown(Button button, int duration)
//    {
//        //Disable Button
//        button.setDisable(true);
//        
//        //Create task
//        TimerTask tTask = new TimerTask()
//        {
//            @Override
//            public void run()
//            {
//                //Enable Button
//                button.setDisable(false);
//                //System.out.println("Inside of TimerTask");
//            }
//        };
//        //Set timer
//        Timer timer = new Timer();
//        //Set timer schedule run tTask after duration=time
//        timer.schedule(tTask, duration);
//    }
    
    public void gatherPowerClicked() {
        //Debug text
        System.out.println("Gather power button was clicked");
        
        //Append this message to the textarea when the button is clicked
        messages.appendText("your power is growing..." + "\n");
                
        //resource = MainGameModel.getResourceClass();
        
        //Increment the power up by 2 per button press using Resources'
        //incrementPower() method
        resource.incrementPower();
        
        //Unhide and enable the Dark Forest tab
        if(resource.getPower() > 6) {
            //btnGatherStone.setVisible(true);
            forestTab.setDisable(false);
            forestTab.setStyle("visibility: visible;");
        }
        
        //this.buttonCooldown(gatherPowerButton,5000);
    }
    
    public void gatherWoodClicked() {
        //Increment wood up by 10 per button press using Resources'
        //incrementWood() method
        resource.incrementWood();
        
        //Append this message to the textarea when the button is clicked
        messages.appendText("not very glamorous, but wood is useful." + "\n");
        
        //Unhide build hut button
        if (resource.getWood() >= 10) {
            buildLabel.setStyle("visibility: visible;");
            buildTrapButton.setDisable(false);
            buildTrapButton.setStyle("visibility: visible;");
        }
        if (resource.getWood() >= 30 && resource.getCart() == false) {
            buildCartButton.setDisable(false);
            buildCartButton.setStyle("visibility: visible;");
        }
        if (resource.getWood() >= 100) {
            buildHutButton.setDisable(false);
            buildHutButton.setStyle("visibility: visible;");
        }
    }
    
     public void cartClicked() {
        if (resource.getCart() == false) {
            resource.incrementCart();
            messages.appendText("the rickety cart will carry more wood from the forest."
        + "\n");
        }
        else {
            System.out.println("heyo, you already have a cart!");
        }
        
        buildCartButton.setDisable(true);
    }
     
     public void buildTrapClicked() {
         if (resource.getTrap() < 10 && (resource.getWood() >= resource.getTrapCost())) {
             resource.incrementTrap();
             messages.appendText("more traps to catch more creatures." + "\n");
             if (resource.getTrap() == 10) {
                 buildTrapButton.setDisable(true);
             }
         }
         else if (resource.getTrap() < 10 && (resource.getWood() < resource.getTrapCost())) {
             messages.appendText("can't build a trap. not enough wood." + "\n");
         }
         else {
             System.out.println("Something is broken.");
         }
     }
    
    
    public void buildHutClicked() {
        

        //Append this message to the textarea when the button is clicked
        if (resource.getHut() < 10 && (resource.getWood() >= resource.getHutCost())) {
            resource.incrementHut();
            messages.appendText("a hut is built, now minions will come." + "\n");
            if (resource.getHut() == 10) {
                buildHutButton.setDisable(true);
            }
        }
        else if (resource.getHut() < 10 && (resource.getWood() < resource.getHutCost())) {
            messages.appendText("can't build a hut. not enough wood." + "\n");
        }
        else {
            System.out.println("Unknown Error: Someone dun goofed.");
        }        
    }
}
