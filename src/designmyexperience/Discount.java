/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package designmyexperience;

/**
 *
 * @author proza
 */
public class Discount {
    private int discountId;
    private int userId;
    private int activityId;
    private int percent;
    private int startDay;
    private int startMonth;
    private int startYear;
    private int endDay;
    private int endMonth;
    private int endYear;

    public Discount(){}
    public Discount(int discountId, int userId, int activityId, int percent, int startDay, int startMonth, int startYear, int endDay, int endMonth, int endYear) {
        this.discountId = discountId;
        this.userId = userId;
        this.activityId = activityId;
        this.percent = percent;
        this.startDay = startDay;
        this.startMonth = startMonth;
        this.startYear = startYear;
        this.startDay = endDay;
        this.startMonth = endMonth;
        this.startYear = endYear;
    }

    public int getEndDay() {
        return endDay;
    }

    public int getEndMonth() {
        return endMonth;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndDay(int endDay) {
        this.endDay = endDay;
    }

    public void setEndMonth(int endMonth) {
        this.endMonth = endMonth;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }
    
    
    public int getUserId(){
        return this.userId;
    }
    public void setUserId(int userId){
        this.userId= userId;
    }

    public int getDiscountId() {
        return discountId;
    }

    public int getActivityId() {
        return activityId;
    }

    public int getPercent() {
        return percent;
    }

    public int getStartDay() {
        return startDay;
    }

    public int getStartMonth() {
        return startMonth;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setDiscountId(int discountId) {
        this.discountId = discountId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public void setStartDay(int startDay) {
        this.startDay = startDay;
    }

    public void setStartMonth(int startMonth) {
        this.startMonth = startMonth;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }
    
    
    
}
