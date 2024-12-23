/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Random;

public class Users {

   private int userid;
   private String username;
   private String password;
   private String idCard;
   private String fullName;

   public int getUserid() {
      return userid;
   }

   public String getUsername() {
      return username;
   }

   public String getPassword() {
      return password;
   }

   public String getIdCard() {
      return idCard;
   }

   public String getFullName() {
      return fullName;
   }

   public Users() {
   }

   public Users(int userid ,  String username, String password, String idCard, String fullName) {
   
    
      this.userid = userid;
      this.username = username;
      this.password = password;
      this.idCard = idCard;
      this.fullName = fullName;
   }

   public void setUserid(int userid) {
      this.userid = userid;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public void setIdCard(String idCard) {
      this.idCard = idCard;
   }

   public void setFullName(String fullName) {
      this.fullName = fullName;
   }

}
