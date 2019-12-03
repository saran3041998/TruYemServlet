/**
 * 
 */
package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

/**
 * @Created By Saranya 760862
 *
 */
public class MenuItemDaoSqlImpl implements MenuItemDao {

	public List<MenuItem> getMenuItemListAdmin() {
		// TODO Auto-generated method stub
		ConnectionHandler ch = new ConnectionHandler();
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		List<MenuItem> menuItemList = new ArrayList<MenuItem>();
		ResultSet resultSet;
		boolean activeFlag, freeDeliveryFlag;
		try {
			conn = ch.getConnection();
			if (conn != null) {
				preparedStatement = conn
						.prepareStatement("select me_id,me_name,me_active,me_date_of_launch,me_price,me_category,me_free_delivery from menu_item");
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {

					int id = resultSet.getInt("me_id");
					String name = resultSet.getString("me_name");
					Date dateOfLaunch = resultSet.getDate("me_date_of_launch");
					String active = resultSet.getString("me_active");
					float price = resultSet.getFloat("me_price");
					String category = resultSet.getString("me_category");
					String freeDelivery = resultSet
							.getString("me_free_delivery");
					if (freeDelivery != null && freeDelivery.equals("Yes")) {
						freeDeliveryFlag = true;
					} else {
						freeDeliveryFlag = false;
					}
					if (active != null && active.equals("Yes")) {
						activeFlag = true;
					} else {
						activeFlag = false;
					}
					MenuItem menuItem = new MenuItem(id, name, price,
							activeFlag, dateOfLaunch, category,
							freeDeliveryFlag);
					/*
					 * emp1.setEmployee_id(empid); emp1.setName(name);
					 * emp1.setDate_of_birth(date); emp1.setSalary(sal);
					 */
					System.out.println(menuItem);
					menuItemList.add(menuItem);
				}
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

		return menuItemList;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cognizant.truyum.dao.MenuItemDao#getMenuItemlistCustomer()
	 */
	@Override
	public List<MenuItem> getMenuItemlistCustomer() {
		// TODO Auto-generated method stub
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		List<MenuItem> menuItemList = new ArrayList<MenuItem>();
		if (connection != null) {
			try {
				preparedStatement = connection
						.prepareStatement("select * from menu_item where me_active='Yes' and me_date_of_launch <= now()");
				resultSet = preparedStatement.executeQuery();
				boolean activeFlag, freeDeliveryFlag;
				Date date_of_launch;
				while (resultSet.next()) {
					int menuItemId = resultSet.getInt(1);
					String name = resultSet.getString(2);
					float price = resultSet.getFloat(3);
					String active = resultSet.getString(4);
					date_of_launch = resultSet.getDate(5);
					String category = resultSet.getString(6);
					String freeDelivery = resultSet.getString(7);
					if (active != null && active.equals("Yes"))
						activeFlag = true;
					else
						activeFlag = false;
					if (freeDelivery != null && freeDelivery.equals("Yes"))
						freeDeliveryFlag = true;
					else
						freeDeliveryFlag = false;
					MenuItem menuItem = new MenuItem(menuItemId, name, price,
							activeFlag, date_of_launch, category,
							freeDeliveryFlag);
					menuItemList.add(menuItem);
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
		return menuItemList;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cognizant.truyum.dao.MenuItemDao#modifyMenuItem(com.cognizant.truyum
	 * .model.MenuItem)
	 */
	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionHandler.getConnection();
		String sql = "update menu_item set me_name = ?,me_price =?,me_active= ?,me_date_of_launch= ?,me_category =?,me_free_delivery=? where me_id =?";
		try {
			if (connection != null) {
				PreparedStatement preparestatement = connection
						.prepareStatement(sql);
				preparestatement.setString(1, menuItem.getName());
				preparestatement.setFloat(2, menuItem.getPrice());
				if (menuItem.isActive()) {
					preparestatement.setString(3, "Yes");
				} else {
					preparestatement.setString(3, "No");
				}

				preparestatement.setDate(4, new java.sql.Date(menuItem
						.getDateOfLaunch().getTime()));
				preparestatement.setString(5, menuItem.getCategory());
				if (menuItem.getFreedelivery()) {
					preparestatement.setString(6, "Yes");
				} else {
					preparestatement.setString(6, "No");

				}
				preparestatement.setLong(7, menuItem.getId());
				preparestatement.executeUpdate();
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}

		finally {
			try {
				connection.close();
			} catch (Exception e)

			{
				e.printStackTrace();
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cognizant.truyum.dao.MenuItemDao#getMenuItem(long)
	 */
	@Override
	public MenuItem getMenuItem(long menuIten) {
		// TODO Auto-generated method stub
		ConnectionHandler ch = new ConnectionHandler();
		Connection connection = ch.getConnection();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		MenuItem menuItem = null;
		if (connection != null) {
			try {
				preparedStatement = connection
						.prepareStatement("select * from menu_item where me_id=?");
				preparedStatement.setLong(1, menuIten);

				resultSet = preparedStatement.executeQuery();
				boolean activeFlag, freeDeliveryFlag;
				Date date_of_launch;
				while (resultSet.next()) {
					String name = resultSet.getString(2);
					float price = resultSet.getFloat(3);
					String active = resultSet.getString(4);
					date_of_launch = resultSet.getDate(5);
					String category = resultSet.getString(6);
					String freeDelivery = resultSet.getString(7);
					if (active != null && active.equals("Yes"))
						activeFlag = true;
					else
						activeFlag = false;
					if (freeDelivery != null && freeDelivery.equals("Yes"))
						freeDeliveryFlag = true;
					else
						freeDeliveryFlag = false;
					menuItem = new MenuItem(menuIten, name, price, activeFlag,
							date_of_launch, category, freeDeliveryFlag);
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
		return menuItem;

	}

}
