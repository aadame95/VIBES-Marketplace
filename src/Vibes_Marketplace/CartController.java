package Vibes_Marketplace;

import java.io.IOException;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		List<Items> cart = new ArrayList<Items>();
		cart = testCart();
		double sum = 0;
		for(Items item : cart){
			sum+=item.price;
		}
		request.setAttribute("cart", cart);
		request.setAttribute("totalPrice", sum);
		request.getRequestDispatcher( "/WEB-INF/ShoppingCart.jsp" ).forward(request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	public List testCart(){
		List<Items> cart = new ArrayList<Items>();
		cart.add(new Items(3, "T-Shirt", "Blue", 2, 10));
		return cart;
	}

}
