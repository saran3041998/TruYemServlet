package com.cognizant.truyum.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.model.MenuItem;

/**
 * Servlet implementation class ShowMenuItemListAdminServlet
 */
@WebServlet("/ShowMenuItemListAdminServlet")
public class ShowMenuItemListAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowMenuItemListAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MenuItemDaoCollectionImpl menuitemdaocollectionimpl=new MenuItemDaoCollectionImpl();
		MenuItemDao menuItemDao=menuitemdaocollectionimpl;
		menuItemDao.getMenuItemListAdmin();	
		List<MenuItem> menuitem=menuItemDao.getMenuItemListAdmin();
		System.out.println("MenuItem.."+menuitem);
		
		request.setAttribute("adminmenuitem",menuitem);
		request.getRequestDispatcher("menu-item-list-admin.jsp").forward(request, response);
		
	}

	

}
