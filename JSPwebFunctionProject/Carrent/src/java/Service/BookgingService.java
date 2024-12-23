package Service;

import Models.Booking;
import Models.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookgingService {

   public List<Booking> getBookingById(String bookId) {
      DBLiteControl db = new DBLiteControl();
      String query = "SELECT * FROM Booking WHERE bookingid = ?";
      List<Object> params = List.of(bookId);

      return db.getRecords(query, params, rs -> {
         try {
            int id = rs.getInt("bookingid");
            String pickUpAddress = rs.getString("pickUpAddress");
            String pickUpDate = rs.getString("pickUpDate");
            String dropoffAddress = rs.getString("DropoffAddress");
            String dropoffDate = rs.getString("DropoffDate");
            String idcard = rs.getString("idcard");

            return new Booking(pickUpAddress, pickUpDate, dropoffAddress, dropoffDate);
         } catch (SQLException e) {
            e.printStackTrace();
         }
         return null;
      });
   }

 
}
