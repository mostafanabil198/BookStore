/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

/**
 *
 * @author tarek
 */
public class User {
    public User(String userName,String email,String firstName,String secondName,String password,int manager, String phone,String address ){
       this. userName=userName;
       this.email=email;
       this. firstName=firstName;
       this.secondName=secondName;
       this.password=password;
       this.manager=manager;
       this.address=address;
       this.phone=phone;
    }
    
    public User(String userName,String email,String firstName,String secondName){
       this. userName=userName;
       this.email=email;
       this. firstName=firstName;
       this.secondName=secondName;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public int getManager() {
        return manager;
    }
    private String userName,email,firstName,secondName,password,address,phone;
    private int manager;
    
    
    
}
