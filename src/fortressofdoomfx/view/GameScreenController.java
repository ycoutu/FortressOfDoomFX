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

/**
 * FXML Controller class
 *
 * @author Team Minion Patrol
 */
public class GameScreenController implements Initializable {

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
        System.out.println("Gather power button was clicked");
        //resource = MainGameModel.getResourceClass();
        resource.incrementPower();
    }
    
}
