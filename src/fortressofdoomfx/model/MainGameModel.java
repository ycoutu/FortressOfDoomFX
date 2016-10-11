/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fortressofdoomfx.model;

/**
 *
 * @author Team Minion Patrol
 */
public class MainGameModel {
    
    fortressofdoomfx.model.Resources resource;
    
    public MainGameModel() {
        resource = new fortressofdoomfx.model.Resources();
    }
    
    public fortressofdoomfx.model.Resources getResourceClass() {
        return resource;
    }
}
