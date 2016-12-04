package Vibes_Marketplace;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class itemDetails
 */
@WebServlet("/Details")
public class itemDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public itemDetails() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Items detailItem = null;
		Connection d = null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu54";
			String username = "cs3220stu54";
			String password = "#D.8SnJ6";

			d = DriverManager.getConnection(url, username, password);
			
			String sql = "select * from Items where id = ?";
			
			PreparedStatement pstmt = d.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				detailItem = new Items( rs.getInt( "id" ), rs.getString( "name" ), 
            			rs.getString( "details" ), rs.getInt("quantity"), rs.getDouble("price") );
			}	
		} catch (SQLException e) {
			throw new ServletException(e);
		} finally {
			try {
				if (d != null)
					d.close();
			} catch (SQLException e) {
				throw new ServletException(e);
			}
		}
		request.setAttribute("detail", detailItem);
		request.getRequestDispatcher("/Detail.jsp" ).forward(request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
