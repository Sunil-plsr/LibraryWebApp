package business;

import java.io.Serializable;

//User Business Object Class
public class User implements Serializable {

 private static final long serialVersionUID = 1L;
 private String Name;
 private String Email;
 private String Type;
 private String Password;

 // Zero parameter constructor
 public User() {
     Name = null;
     Email = null;
     Type = null;
     Password = null;
     
 }

 public User(String name, String email, String type, String password, String confirmPassword) {
     Name = name;
     Email = email;
     Type = type;
     Password = password;
     
 }

 public String getName() {
     return Name;
 }

 public void setName(String name) {
     this.Name = name;
 }

 public String getType() {
     return Type;
 }

 public void setType(String type) {
     this.Type = type;
 }

 public String getPassword() {
     return Password;
 }

 public void setPassword(String Password) {
     this.Password = Password;
 }

 public String getEmail() {
     return Email;
 }

 public void setEmail(String email) {
     this.Email = email;
 }
}
