/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import Models.Users;
import Service.DBLiteControl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Thanawin
 */
@WebServlet(urlPatterns = {"/ResgisterServlet"})
public class ResgisterServlet extends HttpServlet {

   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {

      response.setContentType("text/html;charset=UTF-8");
      try ( PrintWriter out = response.getWriter()) {
         /* TODO output your page here. You may use following sample code. */
         out.println("<!DOCTYPE html>");
         out.println("<html>");
         out.println("<head>");
         out.println("<title>Servlet ResgisterServlet</title>");
         out.println("</head>");
         out.println("<body>");
         out.println("<h1>Servlet ResgisterServlet at " + request.getContextPath() + "</h1>");
         out.println("</body>");
         out.println("</html>");
      }
   }

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      processRequest(request, response);
   }

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {

      HttpSession seesion = request.getSession();
      Random rand = new Random();
      int rand_int1 = rand.nextInt(1000);
      DBLiteControl db = new DBLiteControl();

      var idcard = request.getParameter("idcard");
      var username = request.getParameter("username");
      String password = request.getParameter("passwrod");
      String firstName = request.getParameter("firstname");
      String lastName = request.getParameter("lasttname");
      String fullname = String.join(firstName, "  ", lastName);

      String query = "INSERT INTO Users (userid,username, password, idCard, fullName) VALUES(?,?,?,?,?)";
      List<Object> params = List.of(rand_int1, username, password, idcard, fullname);
      db.InsertCommand(query, params);

      HashSet<Users> hashSet = new HashSet<>();
      Users user = new Users(rand_int1, username, password, idcard, fullname);
      hashSet.add(user);

      db.closeConnection();
      seesion.setAttribute("userInfo", hashSet);

      // Response for the Modal Popup
      response.setContentType("text/html");
      response.setCharacterEncoding("UTF-8");
      response.getWriter().write("<html><head>");
      response.getWriter().write("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>");
      response.getWriter().write("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>");
      response.getWriter().write("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js'></script>");
      response.getWriter().write("</head><body>");

      // HTML for Modal Popup
      response.getWriter().write(
              "<div class='modal' id='myModal' tabindex='-1' role='dialog'>"
              + "  <div class='modal-dialog' role='document'>"
              + "    <div class='modal-content'>"
              + "      <div class='modal-header'>"
              + "        <h5 class='modal-title'>Success</h5>"
              + "        <button type='button' class='close' data-dismiss='modal' aria-label='Close'>"
              + "          <span aria-hidden='true'>&times;</span>"
              + "        </button>"
              + "      </div>"
              + "      <div class='modal-body'>"
              + "        <p>User has been successfully registered!</p>"
              + "      </div>"
              + "      <div class='modal-footer'>"
              + "        <button type='button' class='btn btn-primary' id='redirectButton'>OK</button>"
              + "      </div>"
              + "    </div>"
              + "  </div>"
              + "</div>");

      // JavaScript to Show Modal and Redirect
      response.getWriter().write(
              "<script type='text/javascript'>"
              + "  $(document).ready(function() {"
              + "    $('#myModal').modal('show');"
              + // Show the modal
              "    $('#redirectButton').click(function() {"
              + "      window.location.href = '/WebApplicationHW6/MainServlet';"
              + // Redirect on button click
              "    });"
              + "  });"
              + "</script>");

      response.getWriter().write("</body></html>");

   }

   @Override
   public String getServletInfo() {
      return "Short description";
   }// </editor-fold>

}
