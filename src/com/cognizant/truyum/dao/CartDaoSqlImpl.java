/**
 * 
 */
package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
import com.mysql.jdbc.PreparedStatement;

/**
 * @Created By Saranya 760862
 *
 */
public class CartDaoSqlImpl implements CartDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cognizant.truyum.dao.CartDao#addCartItem(long, long)
	 */
	@Override
	public void addCartItem(long userId, long menuItemId) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionHandler.getConnection();
		java.sql.PreparedStatement preparedStatement = null;

		try {
			if (conn != null) {

				preparedStatement = conn
						.prepareStatement("insert into cart values(default,?,?)");
				preparedStatement.setLong(1, userId);
				preparedStatement.setLong(2, menuItemId);
				preparedStatement.executeUpdate();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cognizant.truyum.dao.CartDao#getAllCartItems(long)
	 */
	@Override
	public List<MenuItem> getAllCartItems(long userId)
			throws CartEmptyException {
		// TODO Auto-generated method stub
		java.sql.PreparedStatement preparedStatement;
		Connection connection = null;
		ResultSet resultSet;
		boolean activeFlag, freeDeliveryFlag;
		List<MenuItem> menuItemList = new ArrayList<MenuItem>();

		try {
			connection = ConnectionHandler.getConnection();
			if (connection != null) {
				Cart cart = new Cart(menuItemList, (double) 0);
				StringBuffer sqlBuffer = new StringBuffer();
				sqlBuffer
						.append("select menu_item.me_id, menu_item.me_name, menu_item.me_free_delivery, menu_item.me_price, menu_item.me_active, ")
						.append("menu_item.me_category, menu_item.me_date_of_launch from menu_item inner ")
						.append("join cart on ")
						.append("menu_item.me_id = cart.ct_pr_id ")
						.append("where cart.ct_us_id = ?;");
				preparedStatement = connection.prepareStatement(sqlBuffer
						.toString());
				preparedStatement.setLong(1, userId);
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					Long menuItemId = resultSet.getLong(1);
					String name = resultSet.getString(2);
					float price = resultSet.getFloat(4);
					String active = resultSet.getString(5);
					String freeDelivery = resultSet.getString(3);
					String category = resultSet.getString(6);
					Date dateOfLaunch = resultSet.getDate(7);
					if (freeDelivery != null && freeDelivery.equals("Yes"))
						freeDeliveryFlag = true;
					else
						freeDeliveryFlag = false;
					if (active != null && freeDelivery.equals("Yes"))
						activeFlag = true;
					else
						activeFlag = false;

					MenuItem menuItem = new MenuItem(menuItemId, name, price,
							activeFlag, dateOfLaunch, category,
							freeDeliveryFlag);
					menuItemList.add(menuItem);
				}
				cart.setMenuItemList(menuItemList);
				cart.setTotal(getTotalPrice(userId, connection));
			}

			if (menuItemList.size() == 0) {
				throw new CartEmptyException("Cart is empty");
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return menuItemList;
	}

	private double getTotalPrice(long userId, Connection conn) {
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		double total = 0;
		List<MenuItem> menuItemList = new ArrayList<MenuItem>();
		try {
			if (conn != null) {
				Cart cart = new Cart(menuItemList, 0);
				StringBuffer sqlBuffer = new StringBuffer();
				sqlBuffer
						.append("SELECT SUM(menu_item.me_price) FROM menu_item INNER JOIN cart ON menu_item.me_id = cart.ct_pr_id ")
						.append("WHERE cart.ct_us_id = ?");
				System.out.println("SqlString:" + sqlBuffer.toString());

				preparedStatement = (PreparedStatement) conn
						.prepareStatement(sqlBuffer.toString());
				preparedStatement.setLong(1, userId);
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					total = resultSet.getDouble(1);
				}
				System.out.println("Records fetched successfully");
			}
		} catch (SQLException sq) {
			sq.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return total;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cognizant.truyum.dao.CartDao#removeCartItem(long, long)
	 */
	@Override
	public void removeCartItem(long userId, long menuItemId) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement;
		try {
			connection = ConnectionHandler.getConnection();
			if (connection != null) {
				preparedStatement = (PreparedStatement) connection
						.prepareStatement("delete from cart where ct_us_id=? and  ct_pr_id=?");
				preparedStatement.setLong(1, userId);
				preparedStatement.setLong(2, menuItemId);
				preparedStatement.executeUpdate();
				System.out.println("Record deleted successfully");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
