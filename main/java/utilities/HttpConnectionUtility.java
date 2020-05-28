package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class HttpConnectionUtility {



	/*
	 * accepts url link as String.
	 * returns instance of HttpURLConnection with GET request method 
	 */
	private  HttpURLConnection getRequestHttpConnection(String restApiUrl) {
		try {

			URL url;
			HttpURLConnection httpCon;
			url = new URL(restApiUrl);
			httpCon = (HttpURLConnection) url.openConnection();
			httpCon.setRequestMethod("GET");
			httpCon.setReadTimeout(3000);

			return httpCon;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	/*
	 * accepts url link of rest api as String
	 * calls getRequestHttpConnection(String restApiUrl) to get instance of HttpURLConnection.
	 * on HttpURLConnection instance with response code 200 assigns response to stringBuffer and returns as String
	 *  else returns null
	 */
	public  String getHttpResponseinJson(String restApiUrl) throws Exception {
		String line = "";
		StringBuffer strBuffer = new StringBuffer();
		HttpURLConnection httpCon = getRequestHttpConnection(restApiUrl);
		int responseCode = httpCon.getResponseCode();
		System.out.println(responseCode);
		if(responseCode==HttpURLConnection.HTTP_OK) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));

			while((line=reader.readLine())!=null) {
				strBuffer.append(line);
			}	

			reader.close();
			httpCon.disconnect();
		}

		return strBuffer.toString();
	}


	/*
	 * accepts url link of rest api as String
	 * calls getRequestHttpConnection(String restApiUrl) to get instance of HttpURLConnection.
	 * on HttpURLConnection instance with response code 200 
	 * prints request header to the restapi link
	 */
	public void getRequestHeader(String restApiUrl) throws IOException {

		HttpURLConnection httpCon = getRequestHttpConnection(restApiUrl);

		Map<String, List<String>> map = httpCon.getHeaderFields();

		System.out.println("Printing Response Header...\n");

		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey()
			+ " ,Value : " + entry.getValue());
		}

		System.out.println("\nGet Response Header By Key ...\n");
		String server = httpCon.getHeaderField("Server");

		if (server == null) {
			System.out.println("Key 'Server' is not found!");
		} else {
			System.out.println("Server - " + server);
		}
		System.out.println("\n Done");
		httpCon.disconnect();

	}

}
