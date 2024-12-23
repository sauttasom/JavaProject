/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import Models.Booking;
import Models.Cars;
import Models.Users;
import Service.CarService;
import Service.DBLiteControl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = {"/CarsServlet"})
public class CarsServlet extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
//      CarService cars = new CarService();
//      try {
//         var cardata = cars.GetCarList();
//         cardata.forEach(item ->{System.out.println(item.getCarname());});
//         
////         request.setAttribute("cardataList", cardata);
////         request.getRequestDispatcher("/view/cars.jsp").forward(request, response);
//      } catch (SQLException ex) {
//         Logger.getLogger(CarsServlet.class.getName()).log(Level.SEVERE, null, ex);
//      }

      request.setAttribute("contentPage", "/view/cars.jsp");
      request.getRequestDispatcher("/page.jsp").forward(request, response);
   }

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      var carsid = request.getParameter("carid");

      HttpSession seesion = request.getSession();
      DBLiteControl db = new DBLiteControl();
      var user = (Users) seesion.getAttribute("userInfo");

      if (user == null) {
         response.sendRedirect("/WebApplicationHW6/PageSerlver?page=login.jsp");
      } else {
         Random rand = new Random();
         int rand_int1 = rand.nextInt(1000);
         var booking = (Booking) seesion.getAttribute("bookingInfo");

         String queryfiled = "INSERT INTO Booking (bookingid, pickUpAddress, pickUpDate, DropoffAddress, DropoffDate, idcard, carid, status)";
         String value = "VALUES(?, ?, ?,?, ?,?, ?, ?);";
         String query = queryfiled + value;
         List<Object> parameter = List.of(
                 rand_int1,
                 booking.getPinkupAddress(),
                 booking.getPinkupDate(),
                 booking.getDropoffAddress(),
                 booking.getDropoffDate(),
                 user.getIdCard(),
                 carsid, "Pending");

         db.InsertCommand(query, parameter);
       
         response.sendRedirect("/WebApplicationHW6/PaymentServlet?bookingId="+rand_int1);
      }

   }

   @Override
   public String getServletInfo() {
      return "Short description";
   }

}
