/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package designmyexperience;

/**
 *
 * @author proza
 */
public class Booking {
    
    private int bookingId;
    private int userId;
    private int activityId;
    private BookingStatus status;
    private int day;
    private int month;
    private int year;

    public Booking(){}

    public Booking(int bookingId, int userId, int activityId, BookingStatus status, int day, int month, int year) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.activityId = activityId;
        this.status = status;
        this.day = day;
        this.month = month;
        this.year = year;
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

    

    public int getBookingId() {
        return bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public int getActivityId() {
        return activityId;
    }

    public BookingStatus getStatus() {
        return status;
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
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
    
    
}
