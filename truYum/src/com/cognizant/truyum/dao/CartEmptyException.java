/**
 * 
 */
package com.cognizant.truyum.dao;

/**
 * @Created By Saranya 760862
 *
 */
public class CartEmptyException extends Exception {

	
		// TODO Auto-generated method stub
		private String message;
		
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
		public CartEmptyException(String message)
		{
			super (message);
			this.message=message;
		}

	

}
