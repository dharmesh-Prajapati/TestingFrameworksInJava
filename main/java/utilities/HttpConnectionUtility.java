package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class HttpConnectionUtility {



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
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


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


	public static void getRequestHeader() throws IOException {

		URL url = new URL("http://dummy.restapiexample.com/api/v1/employees");
		HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
		httpCon.setRequestMethod("GET");
		httpCon.setReadTimeout(3000);

		int responseCode = httpCon.getResponseCode();

		System.out.println(responseCode);
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
