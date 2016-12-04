package Vibes_Marketplace;
 
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/remove")
public class remove extends HttpServlet {
    private static final long serialVersionUID = 1L;
        
     
    public remove() {
        super();
    }
 
     
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
         
        Connection c = null;
        try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu54";
            String username = "cs3220stu54";
            String password = "#D.8SnJ6";
 
            String sql = "Delete From Items Where id = ?";
            c = DriverManager.getConnection( url, username, password );
             
            PreparedStatement pstmt = c.prepareStatement( sql );
            pstmt.setString( 1, id);
            pstmt.executeUpdate();
       
        }
        catch( SQLException e )
        {
            throw new ServletException( e );
        }
        finally
        {
            try
            {
                if( c != null ) c.close();
            }
            catch( SQLException e )
            {
                throw new ServletException( e );
            }
        }
        response.sendRedirect("inventory");
    }
 
     
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
 
}