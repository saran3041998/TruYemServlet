/**
 * 
 */
package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

/**
 * @Created By Saranya 760862
 *
 */
public class MenuItemDaoSqlImplTest {
	public static void main(String args[]) {
		MenuItemDaoSqlImpl menuitemdaosqlimpl = new MenuItemDaoSqlImpl();
		List<MenuItem> menuItemList = menuitemdaosqlimpl.getMenuItemListAdmin();
		for (MenuItem menuItem : menuItemList) {
			System.out.println("MenuItem:" + menuItem);
		}
	}

}
