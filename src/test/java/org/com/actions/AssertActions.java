package org.com.actions;

import org.testng.Assert;

public class AssertActions {
	
	
	/*******
	 * verifyPostiveCondition() - This method will validate positive boolean value i.e true
	 * @param actual - returned boolean value
	 * @param message - will print message if condition fail
	 */
	public static void verifyPostiveCondition(boolean actual, String message) {
		Assert.assertTrue(actual, message);
	}
	
	
	/********
	 * verifyNegativeCondition() - This method will validate negative boolean value i.e false
	 * @param actual - returned boolean value
	 * @param message - will print message if condition fail
	 */
	public static void verifyNegativeCondition(boolean actual, String message) {
		Assert.assertFalse(actual, message);
	}
	
	
	/********
	 * verifyJsonResponse() - This method will validate actual and expected value
	 * @param actual - response returned value
	 * @param expected - test data value
	 * @param message - will print message if condition fail
	 */
	public static void verifyJsonResponse(Object actual, Object expected, String message) {
		Assert.assertEquals(actual, expected, message);
	}
	
}
