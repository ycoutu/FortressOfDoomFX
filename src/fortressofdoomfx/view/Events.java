/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fortressofdoomfx.view;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import fortressofdoomfx.view.GameScreenController;
import javafx.fxml.FXMLLoader;

/**
 *
 * @author Suzanne
 */
public class Events {

    FXMLLoader loader = new FXMLLoader();
    GameScreenController controller = loader.getController();
    
    fortressofdoomfx.model.Resources resource = new fortressofdoomfx.model.Resources();
    Events()
    {}
    
    
    public void MerchantEvent()
    {
        
        //Alternative to use of 'Alert' popup type
        //Dialog d = new Dialog();
        //DialogPane dp = new DialogPane();
        //dp.setContentText("Test");
       // d.  
        /*
        
        dp.getButtonTypes().setAll(btnWood, btnScales, btnGoodbye);
            d.setDialogPane(dp);
            d.showAndWait();*/
         Alert encounter = new Alert(Alert.AlertType.NONE);
           encounter.setTitle("You've encountered a travelling merchant!");
           encounter.setHeaderText("Event");
           encounter.setContentText("A travelling merchant approaches, do you wish to purchase their goods?");
                   
           ButtonType btnWood = new ButtonType("Purchase Wood", ButtonBar.ButtonData.OTHER);
           ButtonType btnScales = new ButtonType("Purchase Scales", ButtonBar.ButtonData.OTHER);
           ButtonType btnGoodbye = new ButtonType("Goodbye", ButtonBar.ButtonData.CANCEL_CLOSE);
           
           encounter.getButtonTypes().setAll(btnWood,btnScales, btnGoodbye);
         
        
                boolean inEncounter = true;

                while(inEncounter)
                {
                    Optional<ButtonType> selection = encounter.showAndWait();
                    if(selection.get() == btnWood)
                    {
                        System.out.println("Wood Purchased");

                    }
                    else if(selection.get() == btnScales)
                    {
                        System.out.println("Scales Purchased");
                    }
                    else
                    {
                        inEncounter = false;
                        encounter.close();
                        
                    }
                }
    }
    public void EnemyEvent()
    {
     Alert EnemyEncounter = new Alert(Alert.AlertType.NONE);
           EnemyEncounter.setTitle("A Hero Approaches");
           EnemyEncounter.setHeaderText("Hero Event");
           EnemyEncounter.setContentText("A do-gooder approaches your domain. What will you do?");
                   
           ButtonType btnChallenge = new ButtonType("Challenge", ButtonBar.ButtonData.OTHER);
           ButtonType btnHide = new ButtonType("Hide yourself with power", ButtonBar.ButtonData.OTHER);
           ButtonType btnIgnore = new ButtonType("Ignore", ButtonBar.ButtonData.CANCEL_CLOSE);
           
           EnemyEncounter.getButtonTypes().setAll(btnChallenge,btnHide, btnIgnore);
           
           Optional<ButtonType> selection = EnemyEncounter.showAndWait();
                    if(selection.get() == btnChallenge)
                    {
                        System.out.println("You challenge him, you win and theres probably a consequence that i need to add");

                    }
                    else if(selection.get() == btnHide)
                    {
                        System.out.println("wow hiding so wimp");
                    }
                    else
                    {
                        
                        System.out.println("The hero walked on by");
                        //inEncounter = false;
                        EnemyEncounter.close();
                        
                    }
           
    }
    public void MinionEvent()
    {
      resource.incrementMinion();
      
      
    }
    public void ResourceEvent()
    {
      resource.incrementWoodOverTime();
      //controller.updateWoodLabel();
    
    }
}
