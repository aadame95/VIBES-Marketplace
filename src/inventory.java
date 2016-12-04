package Vibes_Marketplace;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/inventory")
public class inventory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public inventory() {
        super();
    }

    public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );

        try
        {
            Class.forName( "com.mysql.jdbc.Driver" );
        }
        catch( ClassNotFoundException e )
        {
            throw new ServletException( e );
        }
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   List<Items> Item = new ArrayList<Items>();

	        Connection d = null;
	     
	        try
	        {
	            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu54";
	            String username = "cs3220stu54";
	            String password = "#D.8SnJ6";

	            d = DriverManager.getConnection( url, username, password );
	            
	            Statement stmt = d.createStatement();
	            ResultSet rs = stmt.executeQuery( "select * from Items" );

	            while( rs.next() )
	            {
	            	
	            	Items item = new Items( rs.getInt( "id" ), rs.getString( "name" ), 
	            			rs.getString( "details" ), rs.getInt("quantity"), rs.getDouble("price") );
	                Item.add( item );
	            }
	            	                
	        }
	        catch( SQLException e )
	        {
	            throw new ServletException( e );
	        }
	        finally
	        {
	            try
	            {
	                if( d != null ) d.close();
	            }
	            catch( SQLException e )
	            {
	                throw new ServletException( e );
	            }
	        }
	        
	        
	        request.setAttribute( "Item", Item );
	        request.getRequestDispatcher( "/inventory.jsp" ).forward(request, response );

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get the user input
        String name = request.getParameter( "name" );
        String details = request.getParameter( "details" );
        String quantity = request.getParameter( "quantity" );
        String price = request.getParameter( "price" );
        
        Connection c = null;
        try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu54";
            String username = "cs3220stu54";
            String password = "#D.8SnJ6";

            String sql = "insert into Items (name, details, quantity, price) values (?, ?, ?, ?)";
            c = DriverManager.getConnection( url, username, password );
            
            PreparedStatement pstmt = c.prepareStatement( sql );
            pstmt.setString( 1, name);
            pstmt.setString( 2, details);
            pstmt.setString( 3, quantity);
            pstmt.setString( 4, price);
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
         
        doGet(request, response);
	}

}
