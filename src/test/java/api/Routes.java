package api;

public class Routes {
	
public static String baseURL = "https://petstore.swagger.io/v2";
public static String postURL = baseURL+"/user";
public static String getURL = baseURL+"/user/{username}";
public static String updateURL = baseURL+"/user/{username}";
public static String deleteURL = baseURL+"/user/{username}";	

public static String baseURL2 = "https://bookstore.toolsqa.com";
public static String postURL2= baseURL2+"/Account/v1/User";

public static String booksBaseURL = "https://simple-books-api.glitch.me";
public static String authBooks=booksBaseURL+"/api-clients/";
public static String SubmitURL=booksBaseURL+"/orders/";

}
