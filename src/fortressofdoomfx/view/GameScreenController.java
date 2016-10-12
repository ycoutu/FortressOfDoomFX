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
import javafx.scene.control.Tab;


/**
 * FXML Controller class
 *
 * @author Team Minion Patrol
 */
public class GameScreenController implements Initializable {

    @FXML private Tab forestTab;
    
    fortressofdoomfx.model.Resources resource = new fortressofdoomfx.model.Resources();
    /**
     * Initializes the controller class.
     */
    //fortressofdoomfx.model.Resources resource;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void gatherPowerClicked() {
        //Debug text
        System.out.println("Gather power button was clicked");
        
        //resource = MainGameModel.getResourceClass();
        
        //Increment the power by 2 per button press using Resources'
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
        resource.incrementWood();
    }
}
