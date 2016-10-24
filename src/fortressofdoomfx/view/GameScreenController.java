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
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
        if(resource.getPower() > 12) {
            //btnGatherStone.setVisible(true);
            forestTab.setDisable(false);
            forestTab.setStyle("visibility: visible;");
        }
    }
    
    public void gatherWoodClicked() {
        //Increment wood up by 10 per button press using Resources'
        //incrementWood() method
        resource.incrementWood();
        
        //Append this message to the textarea when the button is clicked
        messages.appendText("not very glamorous, but wood is useful." + "\n");
        
        //Unhide build hut button
        if (resource.getWood() >= 50) {
            buildHutButton.setDisable(false);
            buildHutButton.setStyle("visibility: visible;");
        }
    }
    
    public void buildHutClicked() {
        //Append this message to the textarea when the button is clicked
        if (resource.getHut() < 10 && (resource.getWood() >= resource.getHutCost())) {
            messages.appendText("a hut is built, now minions will come." + "\n");
        }
        else if (resource.getHut() < 10 && (resource.getWood() < resource.getHutCost())) {
            messages.appendText("can't build a hut. not enough wood." + "\n");
        }
        else if (resource.getHut() == 10) {
            messages.appendText("no more room for huts." + "\n");
        }
        else {
            System.out.println("Unknown Error: Someone dun goofed.");
        }

        //Increment hut and decrement wood
        resource.incrementHut();
        
        
    }
}
