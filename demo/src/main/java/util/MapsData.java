package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MapsData {

	public static void main(String[] args) {
		 try {

	            URL url = new URL("https://maps.googleapis.com/maps/api/place/textsearch/json?query=restaurants+in+hyderabad&key=AIzaSyAIXOVEcrFF2yOwYxAB6ua5h11wBZftPCw");
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            conn.setRequestMethod("GET");
	            conn.setRequestProperty("Accept", "application/json");
	            if (conn.getResponseCode() != 200) {
	                throw new RuntimeException("Failed : HTTP Error code : "
	                        + conn.getResponseCode());
	            }
	            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	            String output;
	            while ((output = br.readLine()) != null) {
	                System.out.println(output);
	            }
	            conn.disconnect();

	        } catch (Exception e) {
	            System.out.println("Exception in NetClientGet:- " + e);
	        }
	}

}
