/**
 * 
 */
package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

/**
 * @Created By Saranya 760862
 *
 */
public class MenuItemDaoCollectionImplTest {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws ParseException {
		
		//testGetMenuItemListAdmin();
		//testGetMenuItemListCustomer();
		testModifyMenuItem();
		

	}
	public static void testGetMenuItemListAdmin()
	{
		MenuItemDaoCollectionImpl menu=new MenuItemDaoCollectionImpl();
		System.out.println("MENU ITEM LIST : "+menu.getMenuItemListAdmin());
		List<MenuItem> menuitem=menu.getMenuItemListAdmin();
		for(MenuItem menu_item : menuitem)
		{
			System.out.println(menu_item.toString());
		}
	}
	public static void testGetMenuItemListCustomer()
	{
		MenuItemDaoCollectionImpl menu=new MenuItemDaoCollectionImpl();
		System.out.println("CUSTOMER MENU ITEM LIST : "+menu.getMenuItemlistCustomer());
		List<MenuItem> menuitem=menu.getMenuItemlistCustomer();
		for(MenuItem menu_item : menuitem)
		{
			System.out.println(menu_item.toString());
		}
	}
	public static void testModifyMenuItem() throws ParseException
	{
		MenuItemDaoCollectionImpl menuitemcollectionimpl=new MenuItemDaoCollectionImpl();
		MenuItem menuItem=new MenuItem(000002,"Cake",180.00f,true,DateUtil.convertToDate("20/11/2012"),"Main Course",false);
		MenuItemDao menuitemdao=menuitemcollectionimpl;
		menuitemdao.modifyMenuItem(menuItem);
		System.out.println("Modify Menu Item : "+menuitemdao.getMenuItem(000002));
		
		
		
		
		
	}
	public void testGetMenuItem()
	{
		
	}

}
