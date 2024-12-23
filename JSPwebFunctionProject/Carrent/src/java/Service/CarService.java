/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Models.Cars;
import java.sql.SQLException;
import java.util.List;

public class CarService {

   public CarService() {
   }

   public List<Cars> getCarById(String carId) {
      DBLiteControl db = new DBLiteControl();
      String query = "SELECT * FROM Cars WHERE carid = ?";
      List<Object> params = List.of(carId);

      return db.getRecords(query, params, rs -> {
         try {
            int id = rs.getInt("carid");
            String carid = rs.getString("carid");
            String pathImage = rs.getString("carName");
            String carName = rs.getString("carid");
            String carPrice = rs.getString("carPrice");
             String imageName = rs.getString("imageName");
            return new Cars(id, pathImage, carName, carPrice, imageName);
         } catch (SQLException e) {
            e.printStackTrace();
         }
         return null;
      });
   }

   public List<Cars> GetCarList() throws SQLException {

      DBLiteControl db = new DBLiteControl();
      String query = "SELECT  * FROM Cars ";
      List<Cars> cars = db.selectCommand(query, rs -> {
         try {
            int id = rs.getInt("carid");
            String pathImage = rs.getString("pathImage");
            String carname = rs.getString("carName");
            String carPrice = rs.getString("carPrice");
            String imageName = rs.getString("imageName");

            return new Cars(id, pathImage, carname, carPrice, imageName);
         } catch (SQLException e) {
            e.printStackTrace();
            return null;
         }
      });
      return cars;

   }
}
