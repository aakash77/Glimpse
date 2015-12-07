package com.group4.glimpse.util;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Hash Password before saving in database using Bcrypt
 * @author Group 4
 *
 */
public class PasswordHash {

	// Define the BCrypt workload to use when generating password hashes. 10-31 is a valid value.
	private static final int WORKLOAD = 12;

	/**
	 * This method can be used to generate a string representing an account password
	 * suitable for storing in a database.
	 * @param password_plaintext
	 * @return String - a string of length 60 that is the bcrypt hashed password in crypt(3) format.
	 */
	public static String hashPassword(String password_plaintext) {
		String salt = BCrypt.gensalt(WORKLOAD);
		String hashed_password = BCrypt.hashpw(password_plaintext, salt);

		return(hashed_password);
	}

	/**
	 * This method can be used to verify a computed hash from a plaintext 
	 * with that of a stored hash from a database. The password hash from the database
	 * must be passed as the second variable.
	 * @param password_plaintext
	 * @param stored_hash
	 * @return true if the password matches the password of the stored hash, false otherwise
	 */
	public static boolean checkPassword(String password_plaintext, String stored_hash) {
		boolean password_verified = false;

		if(null == stored_hash)
			throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");

		password_verified = BCrypt.checkpw(password_plaintext, stored_hash);

		return(password_verified);
	}
}
