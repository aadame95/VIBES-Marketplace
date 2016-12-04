package Vibes_Marketplace;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

@WebServlet("/Checkout")
public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Checkout() {
		super();

	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ShoppingCart cart = (ShoppingCart)
		// request.getSession().getAttribute("cart");
		List<Items> cart = new ArrayList<Items>();
		String errorMsg = (String) request.getAttribute("errorMsg");
		errorMsg = (errorMsg == null) ? "" : errorMsg;

		request.setAttribute("errorMsg", errorMsg);
		cart = testCart();
		request.setAttribute("cart", cart);
		request.getRequestDispatcher("/WEB-INF/Checkout.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String first = (String) request.getParameter("FirstName");
		System.out.println(first);
		String last = (String) request.getParameter("LastName");
		String email = (String) request.getParameter("Email");
		System.out.println(validation(first, last, email));
		if (!validation(first, last, email)) {
			request.setAttribute("errorMsg", "Error! Please complete the fields above.");
			doGet(request, response);
			return;
		}
		List<Items> cart = new ArrayList<Items>();
		cart = testCart();
		for (Items item : cart) {
			int id = item.id;
			int quant = item.quantity;
			java.sql.Connection c = null;
			try {
				String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu54";
				String username = "cs3220stu54";
				String password = "#D.8SnJ6";

				String sql = "UPDATE Items SET quantity=quantity-? WHERE id=?";
				c = DriverManager.getConnection(url, username, password);

				PreparedStatement pstmt = c.prepareStatement(sql);
				pstmt.setInt(1, quant);
				pstmt.setInt(2, id);

				pstmt.executeUpdate();

			} catch (SQLException e) {
				throw new ServletException(e);
			} finally {
				try {
					if (c != null)
						c.close();
				} catch (SQLException e) {
					throw new ServletException(e);
				}
			}
		}
		response.sendRedirect("inventory");
	}

	public List testCart() {
		List<Items> cart = new ArrayList<Items>();
		cart.add(new Items(1, "Book", "A Story", 1, 2.1));

		return cart;
	}

	public boolean validation(String first, String last, String email) {
		first = (first == null) ? "" : first;
		last = (last == null) ? "" : last;
		email = (email == null) ? "" : email;
		if (first.equals("") || last.equals("") || email.equals("")) {
			return false;
		} else
			return true;
	}

}