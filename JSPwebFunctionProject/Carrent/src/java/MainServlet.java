
import Models.Booking;
import Models.Cars;
import Service.DBLiteControl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");
      try ( PrintWriter out = response.getWriter()) {
         /* TODO output your page here. You may use following sample code. */
         out.println("<!DOCTYPE html>");
         out.println("<html>");
         out.println("<head>");
         out.println("<title>Servlet MainServlet</title>");
         out.println("</head>");
         out.println("<body>");
         out.println("<h1>Servlet MainServlet at " + request.getContextPath() + "</h1>");
         out.println("</body>");
         out.println("</html>");
      }
   }

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {

      request.setAttribute("contentPage", "/view/booking.jsp");
      request.getRequestDispatcher("main.jsp").forward(request, response);
   }

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {

      HttpSession seesion = request.getSession();

      String pickupaddress = request.getParameter("pickUp_address");
      String pickupdate = request.getParameter("pickup_date");
      String dropoffadress = request.getParameter("dropoff_address");
      String dropoffdate = request.getParameter("dropoff_date");
 

      Booking booking = new Booking(pickupaddress,dropoffadress, pickupdate, dropoffdate);
      seesion.setAttribute("bookingInfo", booking);

    
      response.sendRedirect("/WebApplicationHW6/PageSerlver?page=cars.jsp");

   }

   @Override
   public String getServletInfo() {
      return "Short description";
   }// </editor-fold>

}
