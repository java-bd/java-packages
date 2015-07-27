import java.net.URLConnection;
import java.net.HttpURLConnection;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map.Entry;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class HttpURLConnectionCoreTest{
	
	public static void main(String args[]) throws Exception{
		
		// format = https://www.google.com.bd/?#q=query
		/*
		
		String url = "http://www.google.com";
		String charset = "UTF-8";  
		URLConnection connection = new URL(url).openConnection();
		connection.setDoOutput(true);
		connection.setRequestProperty("Accept-Charset",charset);
		connection.setRequestProperty("Content-Length", Integer.toString(1024));
		
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);
		
		System.out.println(connection.toString());
		
		InputStream response = connection.getInputStream();
		
		HttpURLConnection httpconnection = (HttpURLConnection) new URL(url).openConnection();
		httpconnection.setRequestMethod("POST");
		
		int status = httpconnection.getResponseCode();
		System.out.println(status);
		*/
		// format = https://www.google.com.bd/?#q=query
		
		
			String url = "https://www.google.com/";
			String query = "android";
			URLConnection connection = new URL(url + "?#q=" + query).openConnection();
			// for chrome 41
			// http://www.useragentstring.com/pages/Chrome/
			connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36");
			connection.setRequestProperty("Accept-Charset", "UTF-8");
			InputStream response = connection.getInputStream();
			
			String contentType = connection.getHeaderField("Content-Type");
			String charset = null;
			 
			for (String param : contentType.replace(" ", "").split(";")) {
				if (param.startsWith("charset=")) {
					charset = param.split("=", 2)[1];
					break; 
				} 
			} 
			
			if (charset != null) {
				try (BufferedReader reader = new BufferedReader(new InputStreamReader(response, charset))) {
					for (String line; (line = reader.readLine()) != null;) {
						System.out.println(line);
					} 
				} 
			} 
			
			
			
			/*
			
			String contentType = connection.getHeaderField("Server");
			System.out.println(contentType);
			
			for(Entry<String, List<String> > header : connection.getHeaderFields().entrySet()){
				System.out.println(header.getKey() + "=" + header.getValue());
			}
			*/
		
			
 
		
	}
	
}