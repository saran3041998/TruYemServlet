package com.cognizant.truyum.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartDaoCollectionImpl;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

/**
 * Servlet implementation class RemoveCartServlet
 */
@WebServlet("/RemoveCartServlet")
public class RemoveCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        long userId=1;
		
		String menuItemId=request.getParameter("menuItemId");
		int menuitemid=Integer.parseInt(menuItemId);
		CartDaoCollectionImpl cartDaoCollectionImpl = new CartDaoCollectionImpl();
        CartDao cartDao = cartDaoCollectionImpl;
        MenuItemDaoCollectionImpl menu=new MenuItemDaoCollectionImpl();
        MenuItemDao menuItemDao=menu;
        cartDao.removeCartItem(1,menuitemid);
        
		try {
			List<MenuItem> menuItemList = cartDao.getAllCartItems(userId);
			 request.setAttribute("removeCartStatus",true);
		        //request.setAttribute("removeMenuItemList", menuItemList);
		        request.setAttribute("customerMenuItemList", menuItemList);
		        request.getRequestDispatcher("cart.jsp").forward(request,response);
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			request.getRequestDispatcher("cart-empty.jsp").forward(request,response);
			
		}
       
       
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
