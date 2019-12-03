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
public interface MenuItemDao {
	List<MenuItem> getMenuItemListAdmin();
	List<MenuItem> getMenuItemlistCustomer();
	void modifyMenuItem(MenuItem menuItem);
	MenuItem getMenuItem(long menuIten);

}
