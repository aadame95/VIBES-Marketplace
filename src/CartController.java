package Vibes_Marketplace;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CartController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ShoppingCart cart = (ShoppingCart)
		// request.getSession().getAttribute("cart");
		List<Items> cart = new ArrayList<Items>();
		int id = Integer.parseInt(request.getParameter("id"));
		Items item = new Items();
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
				item = new Items( rs.getInt( "id" ), rs.getString( "name" ), 
            			rs.getString( "details" ), rs.getInt("quantity"), rs.getDouble("price") );
				cart.add(item);
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
		request.setAttribute("cart", cart);
		request.getRequestDispatcher("/WEB-INF/ShoppingCart.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}