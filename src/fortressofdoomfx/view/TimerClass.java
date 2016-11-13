/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fortressofdoomfx.view;
import java.lang.Runnable.*;
import java.util.Optional;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;

/**
 *
 * @author Suzanne
 */
public class TimerClass implements Runnable {
    
    Timer timer = new Timer();
    Random randNum = new Random();
    Events event = new Events();
   
    @Override
    public void run()
    {  
      System.out.println("Periodic background task");
      timer.scheduleAtFixedRate(EventCheck(),10000, 10000);
      timer.scheduleAtFixedRate(MinionAccumulation(), 10000, 10000);
      timer.scheduleAtFixedRate(ResourceAccumulation(), 10000, 10000);
      //timer.sc
    }
    
    public TimerTask EventCheck()
    {
        TimerTask EventTask = new TimerTask(){
        @Override
        public void run()
        {
            
          
            System.out.println("Event happening");
            
           
            Platform.runLater(() -> {
               int eventProbability; 
                 eventProbability = randNum.nextInt(5);
                 System.out.println(eventProbability);
                 if(eventProbability == 1)
                 {
                            event.MerchantEvent();  
                 }
                 else if(eventProbability == 2)
                 {
                     event.EnemyEvent();
                 }
        });
           
            /* Alert encounter = new Alert(AlertType.CONFIRMATION);
           encounter.setTitle("You've encountered a travelling merchant!");
           encounter.setHeaderText("stuff");
           encounter.setContentText("A travelling merchant approaches, do you wish to purchase their goods?");
                   
           ButtonType btnWood = new ButtonType("Purchase Wood");
           ButtonType btnGoodbye = new ButtonType("Goodbye", ButtonData.CANCEL_CLOSE);
           
           encounter.getButtonTypes().setAll(btnWood, btnGoodbye);
           
           Optional<ButtonType> selection = encounter.showAndWait();
           if(selection.get() == btnWood)
           {
               System.out.println("Wood Purchased");}
           else{}*/
           
            
        } 
        };
        
        return EventTask;
    }
        public TimerTask ResourceAccumulation()
        {
            TimerTask ResourceAdd = new TimerTask(){
        @Override
        public void run()
        {
            event.ResourceEvent();
            
        }
        };
            
          
            
            
            return ResourceAdd;
        }
      public TimerTask MinionAccumulation()
        {
            TimerTask ResourceAdd = new TimerTask(){
        @Override
        public void run()
        {
            event.MinionEvent();
            
        }
        };
            
          
            
            
            return ResourceAdd;
        }   
    
}
