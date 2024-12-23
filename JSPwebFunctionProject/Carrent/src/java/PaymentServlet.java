
import Models.Booking;
import Models.Payment;
import Service.BookgingService;
import Service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/PaymentServlet"})
public class PaymentServlet extends HttpServlet {



   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {

      var bookingId = request.getParameter("bookingId");
      request.setAttribute("bookingId", bookingId);

      Payment payment = new Payment();
      var paymetdata = payment.GetPayment(bookingId);
      var bookinglist = paymetdata.getBookingList();
      var userlist = paymetdata.getUserList();
      var carList = paymetdata.getCarsList();

      userlist.forEach(user -> {
         request.setAttribute("name", user.getFullName());

      });

      bookinglist.forEach(booking -> {

         request.setAttribute("pickupaddress", booking.getPinkupAddress());
         request.setAttribute("dropoffDate", booking.getDropoffDate());
         request.setAttribute("pickupdate", booking.getPinkupDate());
         request.setAttribute("dropoffaddress", booking.getDropoffAddress());

      });

      carList.forEach(car -> {

         request.setAttribute("imagecar", car.getImageName());

      });
      request.getRequestDispatcher("/payment.jsp").forward(request, response);
   }

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      String bookingId = request.getParameter("bookingId");
      System.out.println("PaymentServlet.doPost() bookingId" + bookingId);
      String pickupaddress = request.getParameter("pickup_address");

      String pickupdate = request.getParameter("pickup_date");
      String dropoffadress = request.getParameter("dropoff_address");
      String dropoffdate = request.getParameter("dropoff_date");
      if (bookingId != null) {
         Payment payment = new Payment();
         var rowupdate = payment.UpdatePayment(
                 new Booking(
                         bookingId,
                         pickupaddress,
                         dropoffadress,
                         pickupdate,
                         dropoffdate
                 ));
         if(rowupdate > 0)
         {
             response.sendRedirect("/WebApplicationHW6/MainServlet");
         }
      }

      request.getRequestDispatcher("/payment.jsp").forward(request, response);
     
   }

   @Override
   public String getServletInfo() {
      return "Short description";
   }// </editor-fold>

}
