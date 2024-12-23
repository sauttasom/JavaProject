/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Service.BookgingService;
import Service.CarService;
import Service.DBLiteControl;
import Service.UserService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Payment {

   private List<Booking> _bookingList;
   private List<Users> _userList;
   private List<Cars> _carsList;

   public List<Booking> getBookingList() {
      return _bookingList;
   }

   public List<Users> getUserList() {
      return _userList;
   }

   public List<Cars> getCarsList() {
      return _carsList;
   }

   public Payment(List<Booking> bookingList, List<Users> userList, List<Cars> carsList) {
      this._bookingList = bookingList;
      this._userList = userList;
      this._carsList = carsList;
   }

//   public int UpdatePayment(Booking booking) {
//      DBLiteControl db = new DBLiteControl();
//
//      String updateQuery = "UPDATE Booking ";
//      String value = " SET pickUpAddress=?, pickUpDate=?, DropoffAddress=?, DropoffDate=?, status=?";
//      String whereCluase = "where bookingid=?";
//
//      updateQuery += value + whereCluase;
//
//      final List<Object> params = List.of(
//              booking.getPinkupAddress(),
//              booking.getPinkupDate(),
//              booking.getDropoffAddress(),
//              booking.getDropoffDate(), "Success");
//
//      db.InsertCommand(updateQuery, params);
//
//      return 1;
//   }
   public int UpdatePayment(Booking booking) {
      DBLiteControl db = new DBLiteControl();

      String updateQuery = "UPDATE Booking ";
      String value = " SET pickUpAddress=?, pickUpDate=?, DropoffAddress=?, DropoffDate=?, status=?";
      String whereCluase = "where bookingid=?";

      updateQuery += value + whereCluase;

      final List<Object> params = List.of(
              booking.getPinkupAddress(),
              booking.getPinkupDate(),
              booking.getDropoffAddress(),
              booking.getDropoffDate(),
              "Success",
              booking.getBookingid());

      try ( Connection conn = db.GetCon()) {
         if (conn != null) {
            try ( PreparedStatement stmt = conn.prepareStatement(updateQuery)) {
               for (int i = 0; i < params.size(); i++) {
                  stmt.setObject(i + 1, params.get(i));
               }

               int rowsAffected = stmt.executeUpdate();
               if (rowsAffected > 0) {

                  System.out.println("Successfully updated " + rowsAffected + " row(s).");
               } else {
                  System.out.println("Update failed.");
               }
               return rowsAffected;
            } catch (SQLException e) {
               e.printStackTrace();
            }

         } else {
            System.out.println("Connection is null.");
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return 0;
   }

   public Payment GetPayment(String bookingid) {
      DBLiteControl db = new DBLiteControl();
      String queryGetBooking = "SELECT * FROM Booking WHERE bookingid = ?";
      List<Object> params = List.of(bookingid);

      var bookingDb = db.getRecords(queryGetBooking, params, rs -> {
         try {
            String pickUpAddress = rs.getString("pickUpAddress");
            return new Booking(
                    rs.getString("idcard"),
                    rs.getString("carid"),
                    rs.getString("pickUpAddress"),
                    rs.getString("pickUpDate"),
                    rs.getString("DropoffAddress"),
                    rs.getString("DropoffDate"));

         } catch (SQLException e) {
            e.printStackTrace();
         }
         return null;
      });

      if (bookingDb != null && !bookingDb.isEmpty()) {
         UserService userservice = new UserService();
         CarService carservice = new CarService();

         List<Users> allUsers = bookingDb.stream()
                 .map(booking -> userservice.getUserById(booking.getIdcard()))
                 .filter(Objects::nonNull)
                 .flatMap(List::stream)
                 .collect(Collectors.toList());

         List<Cars> allCars = bookingDb.stream()
                 .map(booking -> carservice.getCarById(booking.getCarId()))
                 .filter(Objects::nonNull)
                 .flatMap(List::stream)
                 .collect(Collectors.toList());

         return new Payment(bookingDb, allUsers, allCars);
      }
      return new Payment();
   }

   public Payment() {
   }
;

}
