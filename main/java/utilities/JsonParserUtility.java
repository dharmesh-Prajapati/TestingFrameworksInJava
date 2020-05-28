package utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonParserUtility {


	/*
	 * with repository org.json.simple
	 * accepts json in string and key to iterate and return value in String
	 */
	public  String getJsonStringValue(String jsonInString, String key) throws Exception {

		JSONParser jsonparser = new JSONParser();
		JSONObject jsonObj = (JSONObject)jsonparser.parse(jsonInString);

		String value = jsonObj.get(key).toString();
		System.out.println(value);
		return value;
	}

	public  void getJsonStringtArray(String jsonInString, String key) throws Exception {
		//List<String> jsonArrayList = new ArrayList<String>();
		JSONParser jsonparser = new JSONParser();
		JSONObject jsonObj = (JSONObject)jsonparser.parse(jsonInString);
		JSONArray jsonArray = (JSONArray) jsonObj.get(key);

		System.out.println("-----------------------------");
		System.out.println(jsonArray.size());
		System.out.println("-----------------------------");

		@SuppressWarnings("unchecked")
		Iterator<Object> iterator = jsonArray.iterator();
		while(iterator.hasNext()){
			JSONObject jsonObject = (JSONObject) iterator.next();
			for(Object arrkey : jsonObject.keySet()){
				if(jsonObject.get(arrkey)!=null) {
					System.out.println(arrkey + ":" + jsonObject.get(arrkey).toString());
				}else {
					System.out.println(arrkey + ":" + "none");
				}
			}
		}
	}
	
	/*
	 * json as string and key to iterate over jsonArray
	 * returns List of Map of JSONARRAY.
	 */
	public   List<Map<String, String>> getJsonListOfMap(String jsonInString, String key) throws Exception {
		List<Map<String, String>> jsonArrayList = new ArrayList<Map<String, String>>();
		JSONParser jsonparser = new JSONParser();
		JSONObject jsonObj = (JSONObject)jsonparser.parse(jsonInString);
		JSONArray jsonArray = (JSONArray) jsonObj.get(key);

		@SuppressWarnings("unchecked")
		Iterator<Object> iterator = jsonArray.iterator();
		while(iterator.hasNext()){
			JSONObject jsonObject = (JSONObject) iterator.next();
			Map<String, String> mapData = new HashMap<String,String>();
			for(Object arrkey : jsonObject.keySet()){
				
				if(jsonObject.get(arrkey)!=null) {
					mapData.put(arrkey.toString(), jsonObject.get(arrkey).toString());
					//System.out.println(arrkey + ":" + jsonObject.get(arrkey).toString());
				}else {
					//System.out.println(arrkey + ":" + "none");
					mapData.put(arrkey.toString(), "none");
				}
			}
			jsonArrayList.add(mapData);
		}
		
		return jsonArrayList;
	}
}
