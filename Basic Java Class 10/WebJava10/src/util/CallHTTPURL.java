package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class CallHTTPURL {
	public static void main(String[] args) throws Exception {
		invokeSoapService("https://postman-echo.com/post", "POST", "<xml><body>SAOP request</body></xml>");
		System.out.println("\n\n\n\n>>>>>> Start new");
		invokeSoapService("https://www.google.com", "GET", null);
	}

	public static void invokeSoapService(final String url, final String httpMethod, final String requestXML)
			throws IOException {
		URL myUrl = new URL(url);

		HttpURLConnection conn = (HttpsURLConnection) myUrl.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod(httpMethod);

		OutputStreamWriter out = null;
		if ("POST".equals(httpMethod) && requestXML != null) {
			out = new OutputStreamWriter(conn.getOutputStream());
			out.append(requestXML);
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

		String inputLine;

		System.out.println("Response Code: " + conn.getResponseCode());
		System.out.print("Response Text: ");

		while ((inputLine = br.readLine()) != null) {
			System.out.println(inputLine);
		}

		if (out != null) {
			out.flush();
			out.close();
		}

		br.close();
	}
}
