/**
 * 
 */
package com.cognizant.truyum.dao;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

/**
 * @Created By Saranya 760862
 *
 */
public class MenuItemDaoCollectionImpl implements MenuItemDao {

	static  List<MenuItem> menuItemList;
	public MenuItemDaoCollectionImpl()
	{
		if(menuItemList==null)
		{
			try
			{
				menuItemList=new ArrayList<MenuItem>();
				menuItemList.add(new MenuItem(0000001, "Sandwich", 99.00f, true, DateUtil.convertToDate("15/03/2017"), "Main Course",true));
				menuItemList.add(new MenuItem(0000002, "Burger", 129.00f, true, DateUtil.convertToDate("23/12/2017"), "Main Course",false));
				menuItemList.add(new MenuItem(0000003, "Pizza", 149.00f, true, DateUtil.convertToDate("21/08/2018"), "Main Course",false));
				menuItemList.add(new MenuItem(0000004, "French Fries", 57.00f, false, DateUtil.convertToDate("02/07/2017"), "Starters",true));
				menuItemList.add(new MenuItem(0000005, "Chocolate Brownie", 32.00f, true, DateUtil.convertToDate("02/11/2022"), "Dessert",true));
				menuItemList.add(new MenuItem(0000006, "Chocolate ", 32.00f, true, DateUtil.convertToDate("12/11/2019"), "Dessert",false));
			}
			catch(ParseException e)
			{
				System.out.println(e);
			}
			
		}
	}
	
	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		// TODO Auto-generated method stub
		return menuItemList;
		
	}
	
	@Override
	public List<MenuItem> getMenuItemlistCustomer() {
		// TODO Auto-generated method stub
		List<MenuItem> mlistcus=new ArrayList<MenuItem>();
		Date today=new Date();
		for(MenuItem menuitem:menuItemList)
		{
			if(menuitem.getDateOfLaunch().getTime()<=today.getTime() && menuitem.isActive())
			{
				mlistcus.add(menuitem);
			}
		}
		
	
		return mlistcus;
		
	}
	public void modifyMenuItem(MenuItem menuItem)
	{
		for(MenuItem menu_item_modify:menuItemList)
		{
			if(menuItem.getId()==menu_item_modify.getId())
			{
				menu_item_modify.setName(menuItem.getName());
				menu_item_modify.setCategory(menuItem.getCategory());
				menu_item_modify.setDateOfLaunch(menuItem.getDateOfLaunch());
				menu_item_modify.setPrice(menuItem.getPrice());
				
				
				
			}
		}
	}
	public MenuItem getMenuItem(long menuItemId)
	{
		for(MenuItem menu_item:menuItemList)
		{
			if(menuItemId==menu_item.getId())
			{
				return menu_item;
			}
		}
		
		return null;
		
	}
	
	
	
	
}

