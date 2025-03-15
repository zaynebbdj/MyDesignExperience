/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package designmyexperience;

/**
 *
 * @author proza
 */
public class Activity {
    
    private int activityId;
    private String name;
    private String description;
    private ActivityTheme theme;
    private int ownerId;
    private int day;
    private int month;
    private int year;
    private double fee;
    private String address;
    private int maxParticipant;
    private int duration;
    private String imagePath;
    
    public Activity(){}

    
    public Activity(int activityId, String name, String description, ActivityTheme theme, int ownerId, int day, int month, int year, double fee, String address, int maxParticipant, int duration, String imagePath) {
        this.activityId = activityId;
        this.name = name;
        this.description = description;
        this.theme = theme;
        this.ownerId = ownerId;
        this.day = day;
        this.month = month;
        this.year = year;
        this.fee = fee;
        this.address = address;
        this.maxParticipant = maxParticipant;
        this.duration = duration;
        this.imagePath = imagePath;
    }
    public void setImagePath(String imagePath) {
            this.imagePath = imagePath;
    }

    public String getImagePath(){
        return this.imagePath;
    }
    public String getDescription(){
        return this.description;
    }

    public int getActivityId() {
        return activityId;
    }

    public String getName() {
        return name;
    }

    public ActivityTheme getTheme() {
        return theme;
    }
    
    public String getThemeStr(){
        return this.theme.name();
    }

    public int getOwnerId() {
        return ownerId;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public double getFee() {
        return fee;
    }

    public String getAddress() {
        return address;
    }

    public int getMaxParticipant() {
        return maxParticipant;
    }

    public int getDuration() {
        return duration;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setDescription(String desc){  
        this.description = desc;
    }

    public void setTheme(ActivityTheme theme) {
        this.theme = theme;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMaxParticipant(int maxParticipant) {
        this.maxParticipant = maxParticipant;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Activity{" + "activityId=" + activityId + ", name=" + name + ", description=" + description + ", theme=" + theme + ", ownerId=" + ownerId + ", day=" + day + ", month=" + month + ", year=" + year + ", fee=" + fee + ", address=" + address + ", maxParticipant=" + maxParticipant + ", duration=" + duration + '}';
    }
    
    
    
}
