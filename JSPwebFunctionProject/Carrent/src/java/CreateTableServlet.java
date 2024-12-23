
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.sqlite.JDBC;

@WebServlet(urlPatterns = {"/CreateTableServlet"})
public class CreateTableServlet extends HttpServlet {

   private static final String DB_URL = "jdbc:sqlite:D:/databases/test.db";

   static {
      try {

         Class.forName("org.sqlite.JDBC");
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }
   }

   private void selectTest() throws SQLException {
      String query = "SELECT * from Users u ";
      try ( Connection conn = DriverManager.getConnection(DB_URL);) {
         try ( PreparedStatement stmt = conn.prepareStatement(query);  ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
               System.out.println(rs.getString("username"));
            }
         } catch (SQLException ex) {
            ex.printStackTrace();
         }
      }
   }

   private void createTable() throws SQLException {
      // สร้าง Connection ไปยัง SQLite Database
      try ( Connection conn = DriverManager.getConnection(DB_URL);) {
         Statement stmt = conn.createStatement();
         String sql = "select"
                 + "                    id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                 + "                    username TEXT NOT NULL UNIQUE,\n"
                 + "                    password TEXT NOT NULL,\n"
                 + "                    email TEXT\n"
                 + "                );";
         // Execute SQL
         stmt.execute(sql);
         System.out.println("Table Users created successfully.");
      }
   }

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      try {
         selectTest();
         response.getWriter().println("Table created successfully!");
      } catch (Exception e) {
         e.printStackTrace();
         response.getWriter().println("Failed to create table: " + e.getMessage());
      }
   }

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {

   }

   @Override
   public String getServletInfo() {
      return "Short description";
   }// </editor-fold>

}
