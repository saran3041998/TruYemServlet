/**
 * 
 */
package com.cognizant.truyum.model;

import java.util.Date;

/**
 * @Created By Saranya 760862
 *
 */
public class MenuItem {

	/**
	 * @param args
	 */
	private long id;
	private String name;
	private float price;
	private boolean active;
	private Date dateOfLaunch;
	private String category;
	private Boolean freedelivery;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return the dateOfLaunch
	 */
	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	/**
	 * @param dateOfLaunch
	 *            the dateOfLaunch to set
	 */
	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the freedelivery
	 */
	public Boolean getFreedelivery() {
		return freedelivery;
	}

	/**
	 * @param freedelivery
	 *            the freedelivery to set
	 */
	public void setFreedelivery(Boolean freedelivery) {
		this.freedelivery = freedelivery;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result
				+ ((dateOfLaunch == null) ? 0 : dateOfLaunch.hashCode());
		result = prime * result
				+ ((freedelivery == null) ? 0 : freedelivery.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuItem other = (MenuItem) obj;
		if (active != other.active)
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (dateOfLaunch == null) {
			if (other.dateOfLaunch != null)
				return false;
		} else if (!dateOfLaunch.equals(other.dateOfLaunch))
			return false;
		if (freedelivery == null) {
			if (other.freedelivery != null)
				return false;
		} else if (!freedelivery.equals(other.freedelivery))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MenuItem [id=" + id + ", name=" + name + ", price=" + price
				+ ", active=" + active + ", dateOfLaunch=" + dateOfLaunch
				+ ", category=" + category + ", freedelivery=" + freedelivery
				+ "]";
	}

	/**
	 * @param id
	 * @param name
	 * @param price
	 * @param active
	 * @param dateOfLaunch
	 * @param category
	 * @param freedelivery
	 */
	public MenuItem(long id, String name, float price, boolean active,
			Date dateOfLaunch, String category, Boolean freedelivery) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.category = category;
		this.freedelivery = freedelivery;
	}

	/**
	 * 
	 */

	public MenuItem() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param dateOfLaunch1
	 */
	public void setDateOfLaunch1(Date dateOfLaunch1) {
		// TODO Auto-generated method stub

	}

}
