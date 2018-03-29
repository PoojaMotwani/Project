import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
 
public class ServletProgram extends HttpServlet{

   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
      static final String DB_URL="jdbc:mysql://localhost/TEST";
      static final String USER = "root";
      static final String PASS = "password";
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
    
      try {
         Class.forName("com.mysql.jdbc.Driver");

         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

         Statement stmt = conn.createStatement();
         String sql,sql1,sqlfirst,sqlsecond,sqlthird,sqlfourth;
         sqlfirst="insert into Employees values(101,20,'Pooja','Motwani');";
         stmt.executeUpdate(sqlfirst);
         sqlsecond="insert into Employees values(102,21,'Anuja','Nanal');";
         stmt.executeUpdate(sqlsecond);
         sqlthird="insert into Employees values(103,22,'Pratibha','Mishra');";
         stmt.executeUpdate(sqlthird);
         sqlfourth="insert into Employees values(104,22,'Mrunal','Marne');";
         stmt.executeUpdate(sqlfourth);
         
         out.println("Insertion done successfully ");
         
         sql1 = "select id,first,last,age from Employees";
         ResultSet rs = stmt.executeQuery(sql1);

         while(rs.next()){
            int id  = rs.getInt("id");
            int age = rs.getInt("age");
            String first = rs.getString("first");
            String last = rs.getString("last");
            
            out.println("ID: " + id + "<br>");
            out.println(", Age: " + age + "<br>");
            out.println(", First: " + first + "<br>");
            out.println(", Last: " + last + "<br>");
         }
         rs.close();
         stmt.close();
         conn.close();
      } catch(SQLException se) {
         se.printStackTrace();
      } 
      } 
   }


