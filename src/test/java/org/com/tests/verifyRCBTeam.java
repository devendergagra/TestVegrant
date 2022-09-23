package org.com.tests;

import java.util.HashMap;
import java.util.Map;

import org.com.actions.AssertActions;
import org.com.payload.RCBTeamPayload;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Reporter;
import org.testng.annotations.Test;



public class verifyRCBTeam {
	
	@Test
	public void validateRCBTeam() {	
		//Local variable initialization
		int foreignPlayerCount = 0;
		int wicketKeeperCount = 0;
		
		//map declare to print the player country with count, If do not want to print country name we can avoid hashmap
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		//Retrieving json data from declared variable
		JSONObject object = new  JSONObject(RCBTeamPayload.data_Json);
		//fetching json array from json object
		JSONArray array = object.getJSONArray("player");  
		//Iterating array to get the particular json from jsonarray
		for(int i = 0; i < array.length(); i++) {
			//fetching one-by-one json object from json array
			JSONObject arrayObject = array.getJSONObject(i);  
			//condition to check foreigner players
			if(!"India".equals(arrayObject.getString("country"))) {
				//counting the player
				foreignPlayerCount++;
				//adding to map count and contry name
				map.put(foreignPlayerCount, arrayObject.getString("country"));
			} 
			
			////condition to check Wicket-keeper
			if("Wicket-keeper".equals(arrayObject.getString("role"))) {
				//counting the Wicket-keeper
				wicketKeeperCount++;
			}
		}  
				
		//At-least one wicket-keeper
		AssertActions.verifyPostiveCondition(wicketKeeperCount > 0, "there is more than or less than one wicket-keeper in RCB team i.e "+ wicketKeeperCount);
		Reporter.log("there should be at-least one wicket-keeper in RCB team actual:"+ wicketKeeperCount);
		
		//Team has only 4 foreigner player if > 4 || < 4 condition will fail
		AssertActions.verifyJsonResponse(foreignPlayerCount, 4, "there is more than or less than four foreign players are in RCB team i.e "+ foreignPlayerCount);
		Reporter.log("four foreign players should be in RCB team actual: "+ foreignPlayerCount +" expected: "+4);
		
		//printing the country name 
		for(Map.Entry<Integer, String> m : map.entrySet()) {
			System.out.println(m.getKey() +" country is "+ m.getValue());
		}
	}
}
