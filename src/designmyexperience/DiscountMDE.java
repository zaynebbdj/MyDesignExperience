/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package designmyexperience;
import java.util.ArrayList;

/**
 *
 * @author proza
 */
public interface DiscountMDE {
    
   public void addDiscount(Discount d);
   
   public Discount getDiscount(int discountId);
   public ArrayList<Discount> getAllDiscount(int userId);
   
   public ArrayList<Discount> getAllDiscountActivity(int activityId);
}
