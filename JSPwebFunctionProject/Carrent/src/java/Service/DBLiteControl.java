/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sqlite.JDBC;

public class DBLiteControl {

   private static final String DB_URL = "jdbc:sqlite:D:/databases/test.db";
   private static Connection _conn;

//   static {
//      try {
//         Class.forName("org.sqlite.JDBC");
//      } catch (ClassNotFoundException e) {
//         e.printStackTrace();
//      }
//   }
//   public Connection GetDbConn() {
//      return _conn;
//   }
   public Connection GetCon() {
      try {
         //Connection conn = DriverManager.getConnection(DB_URL);
         return DriverManager.getConnection(DB_URL);

      } catch (SQLException ex) {
         Logger.getLogger(DBLiteControl.class.getName()).log(Level.SEVERE, null, ex);
      }

      return null;
   }

   public DBLiteControl() {
      try {
         Class.forName("org.sqlite.JDBC");
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }

   }

   public void closeConnection() {
      if (_conn != null) {
         try {
            _conn.close();
            System.out.println("Connection closed successfully.");
         } catch (SQLException ex) {
            ex.printStackTrace();
         }
      }
   }

   public <T> List<T> getRecords(String query, List<Object> parameters, Function<ResultSet, T> mapper) {
      try ( Connection conn = GetCon()) {
         return Optional.ofNullable(conn)
                 .flatMap(connection -> {
                    try ( PreparedStatement stmt = connection.prepareStatement(query)) {
                       // Set parameters
                       for (int i = 0; i < parameters.size(); i++) {
                          stmt.setObject(i + 1, parameters.get(i));
                       }

                       try ( ResultSet rs = stmt.executeQuery()) {
                          List<T> results = new ArrayList<>();
                          while (rs.next()) {
                           
                             T record = mapper.apply(rs);
                             results.add(record);
                          }
                          return Optional.of(results);
                       } catch (SQLException e) {
                          e.printStackTrace();
                       }
                    } catch (SQLException e) {
                       e.printStackTrace();
                    }
                    return Optional.empty();
                 })
                 .orElse(new ArrayList<>());
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return new ArrayList<>();
   }

   public void InsertCommand(String query, List<Object> parameters) {

      try ( Connection db = DriverManager.getConnection(DB_URL);) {

         Optional.ofNullable(db).ifPresent(conn -> {
            try ( PreparedStatement stmt = conn.prepareStatement(query)) {

               for (int i = 0; i < parameters.size(); i++) {
                  var value = parameters.get(i);
                  System.out.println("value : " + value);
                  stmt.setObject(i + 1, value);
               }
               int affectedRows = stmt.executeUpdate();
               System.out.println("Rows affected: " + affectedRows);
               db.close();

            } catch (SQLException ex) {
               ex.printStackTrace();
            }
         });

      } catch (SQLException ex) {
         Logger.getLogger(DBLiteControl.class.getName()).log(Level.SEVERE, null, ex);
      }

   }

   public <T> List<T> selectCommand(String query, Function<ResultSet, T> mapper) throws SQLException {
      List<T> resultList = new ArrayList<>();
      try ( Connection conn = DriverManager.getConnection(DB_URL);) {
         Optional.ofNullable(conn).ifPresent(db -> {

            try ( PreparedStatement stmt = db.prepareStatement(query);  ResultSet rs = stmt.executeQuery()) {

               while (rs.next()) {
                  T obj = mapper.apply(rs);
                  resultList.add(obj);

               }
            } catch (SQLException ex) {
               ex.printStackTrace();
            }
         });

      }

      return resultList;

   }

}
