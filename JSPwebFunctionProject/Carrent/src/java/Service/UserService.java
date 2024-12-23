
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Models.Cars;
import Models.Users;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserService {

   public List<Users> getUserById(String idCardValue) {
      DBLiteControl db = new DBLiteControl();
      String query = "SELECT * FROM Users WHERE idCard = ?";
      List<Object> params = List.of(idCardValue);

      return db.getRecords(query, params, rs -> {
         try {
            int id = rs.getInt("userid");
            String username = rs.getString("username");
            String password = rs.getString("password");
            String idCard = rs.getString("idCard");
            String fullName = rs.getString("fullName");

            return new Users(id, username, password, idCard, fullName);
         } catch (SQLException e) {
            e.printStackTrace();
         }
         return null;
      });
   }

   public Users login(String usernameValue, String password) throws SQLException {
      DBLiteControl db = new DBLiteControl();
      String query = "SELECT * FROM Users WHERE username = ? AND password = ?";

      try ( Connection conn = db.GetCon()) {

         return Optional.ofNullable(conn)
                 .flatMap(connection -> {
                    try ( PreparedStatement stmt = connection.prepareStatement(query)) {
                       stmt.setString(1, usernameValue);
                       stmt.setString(2, password);

                       try ( ResultSet rs = stmt.executeQuery()) {

                          return Optional.ofNullable(rs)
                                  .filter(resultSet -> {
                                     try {
                                        return resultSet.next();
                                     } catch (SQLException e) {
                                        e.printStackTrace();
                                        return false;
                                     }
                                  })
                                  .map(resultSet -> {
                                     try {
                                        int id = resultSet.getInt("userid");
                                        String userName = resultSet.getString("username");
                                        String passWord = resultSet.getString("password");
                                        String idCard = resultSet.getString("idCard");
                                        String fullName = resultSet.getString("fullName");

                                        return new Users(id, userName, passWord, idCard, fullName);
                                     } catch (SQLException e) {
                                        e.printStackTrace();
                                     }
                                     return null;
                                  });
                       } catch (SQLException e) {
                          e.printStackTrace();
                       }
                    } catch (SQLException e) {
                       e.printStackTrace();
                    }
                    return Optional.empty();
                 })
                 .orElse(new Users());
      } catch (SQLException ex) {
         Logger.getLogger(DBLiteControl.class.getName()).log(Level.SEVERE, null, ex);
      }

      return new Users();
   }

}
