/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package designmyexperience;

/**
 *
 * @author proza
 */
public class User {
    private int userId;
    private UserType userType;
    private String username;
    private String password;
    private String name;
    private String firstname;
    private String email ;
    private String phoneNumber;
    private String imagePath;

    public User(){}

    public User(int userId, UserType userType, String username, String password, String name, String firstname, String email, String phoneNumber, String imagePath) {
        this.userId = userId;
        this.userType = userType;
        this.username = username;
        this.password = password;
        this.name = name;
        this.firstname = firstname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.imagePath = imagePath;
    }
    
    public User(int userId, UserType userType) {
        this.userId = userId;
        this.userType = userType;
    }
    
    public void setImagePath(String imagePath){
        this.imagePath = imagePath;
    }
    public String getImagePath(){
        return this.imagePath;
    }
    public UserType getUserType(){
        return this.userType;
    }
    
    public String getUserTypeStr(){
        return this.userType.name().toLowerCase();
    }
    public int getUserId(){
        return this.userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", userType=" + userType + ", username=" + username + ", password=" + password + ", name=" + name + ", firstname=" + firstname + ", email=" + email + ", phoneNumber=" + phoneNumber + '}';
    }
    
    
}
