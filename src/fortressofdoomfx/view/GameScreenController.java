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
import java.time.Duration;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
    
    @FXML private Label ruinPowerLabel;
    @FXML private Label forestPowerLabel;
    @FXML private Label ruinWoodLabel;
    @FXML private Label forestWoodLabel;
    @FXML private Label forestCartLabel;
    @FXML private Label forestTrapLabel;
    @FXML private Label forestHutLabel;
    
    //@FXML private Timer timerfx;
    //private Timer timer = new Timer();
   

    //fortressofdoomfx.model.Resources resource = new fortressofdoomfx.model.Resources();
    fortressofdoomfx.view.TimerClass tm = new fortressofdoomfx.view.TimerClass();

    /*public GameScreenController() {
        this.resource = new fortressofdoomfx.model.Resources();
        
    }*/
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Append this message on game startup
        messages.appendText("old bones shiver in the dark." + "\n" + 
                "the shadows coalesce." + "\n" + "they form a being." +
                "\n" + "you." + "\n" + "\n");
        
        //Set initial label text
        ruinPowerLabel.setText("");
        forestPowerLabel.setText("");
        ruinWoodLabel.setText("");
        forestWoodLabel.setText("");
        forestCartLabel.setText("");
        forestTrapLabel.setText("");
        forestHutLabel.setText("");

       tm.run();
      
    }
    public void buttonCooldown(Button button, int duration)
    {
        //Disable Button
        button.setDisable(true);
        
        //Create task
        TimerTask tButtonTask = new TimerTask()
        {
            @Override
            public void run()
            {
                //Enable Button
                button.setDisable(false);
                //System.out.println("Inside of TimerTask");
            }
        };
        //Set timer
        //Timer timer = new Timer();
        //Set timer schedule run tTask after duration=time
        tm.timer.schedule(tButtonTask, duration);
    }
    public void EventCheck()
    {/*long seconds = 5;
       // Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.ofSeconds(5), new EventHandler<ActionEvent>() {

    @Override
    public void handle(ActionEvent event) {
        System.out.println("this is called every 5 seconds on UI thread");
    }
}));
fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
fiveSecondsWonder.play(); */
    
    }
    
    
    
    public void gatherPowerClicked() {
        //Debug text
        System.out.println("Gather power button was clicked" + "\n");
        
        //Append this message to the textarea when the button is clicked
        messages.appendText("your power is growing..." + "\n" + "\n");
                
        //resource = MainGameModel.getResourceClass();
        
        //Increment the power up by 2 per button press using Resources'
        //incrementPower() method
        tm.event.resource.incrementPower();
        
        //Labels
        ruinPowerLabel.setText(Integer.toString(tm.event.resource.getPower()));
        forestPowerLabel.setText(Integer.toString(tm.event.resource.getPower()));
        
        //Unhide and enable the Dark Forest tab
        if(tm.event.resource.getPower() > 6) {
            //btnGatherStone.setVisible(true);
            forestTab.setDisable(false);
            forestTab.setStyle("visibility: visible;");
            //tm.run();
        }
        
        //this.buttonCooldown(gatherPowerButton,1000);
            
        
    }
    
    public void gatherWoodClicked() {
        //Increment wood up by 10 per button press using Resources'
        //incrementWood() method
        tm.event.resource.incrementWood();
       
        //Append this message to the textarea when the button is clicked
        messages.appendText("not very glamorous, but wood is useful." + "\n");
        
        //Labels
        ruinWoodLabel.setText(Integer.toString(tm.event.resource.getWood()));
        forestWoodLabel.setText(Integer.toString(tm.event.resource.getWood()));
        
        //Unhide build hut button
        if (tm.event.resource.getWood() >= 10) {
            buildLabel.setStyle("visibility: visible;");
            buildTrapButton.setDisable(false);
            buildTrapButton.setStyle("visibility: visible;");
        }
        if (tm.event.resource.getWood() >= 30 && tm.event.resource.getCart() == false) {
            buildCartButton.setDisable(false);
            buildCartButton.setStyle("visibility: visible;");
        }
        if (tm.event.resource.getWood() >= 100) {
            buildHutButton.setDisable(false);
            buildHutButton.setStyle("visibility: visible;");
        } 
        this.buttonCooldown(gatherWoodButton, 1000);
    }
    
     public void cartClicked() {
        if (tm.event.resource.getCart() == false) {
            tm.event.resource.incrementCart();
            messages.appendText("the rickety cart will carry more wood from the forest."
        + "\n");
            
            //Label
            forestCartLabel.setText(Integer.toString(1));
            ruinWoodLabel.setText(Integer.toString(tm.event.resource.getWood()));
            forestWoodLabel.setText(Integer.toString(tm.event.resource.getWood()));
        }
        else {
            System.out.println("heyo, you already have a cart!");
        }
        
        buildCartButton.setDisable(true);
    }
     
     public void buildTrapClicked() {

        if (tm.event.resource.getTrap() < 10 && (tm.event.resource.getWood() >= tm.event.resource.getTrapCost())) {
            tm.event.resource.incrementTrap();
            messages.appendText("more traps to catch more creatures." + "\n");
             
            //Label
            forestTrapLabel.setText(Integer.toString(tm.event.resource.getTrap()));
            ruinWoodLabel.setText(Integer.toString(tm.event.resource.getWood()));
            forestWoodLabel.setText(Integer.toString(tm.event.resource.getWood()));
             
            if (tm.event.resource.getTrap() == 10) {
                buildTrapButton.setDisable(true);
            }
        }
        else if (tm.event.resource.getTrap() < 10 && (tm.event.resource.getWood() < tm.event.resource.getTrapCost())) {
            messages.appendText("can't build a trap. not enough wood." + "\n");
        }
        else {
            System.out.println("Something is broken.");
        }
    }

    public void buildHutClicked() {
        

        //Append this message to the textarea when the button is clicked
        if (tm.event.resource.getHut() < 10 && (tm.event.resource.getWood() >= tm.event.resource.getHutCost())) {
            tm.event.resource.incrementHut();
            messages.appendText("a hut is built, now minions will come." + "\n");
            
            //Label
            forestHutLabel.setText(Integer.toString(tm.event.resource.getHut()));
            ruinWoodLabel.setText(Integer.toString(tm.event.resource.getWood()));
            forestWoodLabel.setText(Integer.toString(tm.event.resource.getWood()));
            
            if (tm.event.resource.getHut() == 10) {
                buildHutButton.setDisable(true);
            }
        }
        else if (tm.event.resource.getHut() < 10 && (tm.event.resource.getWood() < tm.event.resource.getHutCost())) {
            messages.appendText("can't build a hut. not enough wood." + "\n");
        }
        else {
            System.out.println("Unknown Error: Someone dun goofed.");
        }        
    }
    
    public void updateWoodLabel() {
        ruinWoodLabel.setText(Integer.toString(tm.event.resource.getWood()));
        forestWoodLabel.setText(Integer.toString(tm.event.resource.getWood()));
    }
    
}
