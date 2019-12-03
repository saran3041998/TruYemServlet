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
public interface CartDao {
	void addCartItem(long userId,long menuItemId);
	List<MenuItem> getAllCartItems(long userId) throws CartEmptyException;
	void removeCartItem(long userId,long menuItemId);

}
