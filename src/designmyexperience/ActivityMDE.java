/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package designmyexperience;

import javax.swing.DefaultListModel;
import java.util.ArrayList;

/**
 *
 * @author proza
 */
public interface ActivityMDE {
    
    public void addActivity(Activity activity);
    
    public void updateActivity(Activity activity);
    
    public void deleteActivity(int activityId);
    
    public ArrayList<Activity> getAllActivity(int ownerId);
    
    public ArrayList<Activity> getAllActivityTheme(String theme);
    
    public ArrayList<Activity> getAllActivityTheme(int ownerId, String theme);
    
    public Activity getActivity(int activityId);
    
    // public List<Activity> getAllActivity();
}
