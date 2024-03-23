package endpoints;
import static io.restassured.RestAssured.*;
import api.Routes;
import io.restassured.response.Response;
import utility.pojo;

public class Methods {
	
pojo load=new pojo();	
	
public static Response CreateUser(pojo load) {
	
Response r= given().contentType("application/json"). 	
body(load).when().post(Routes.authBooks);
return r;
}

public static Response getUser(String username) {
	
Response r=given().pathParam("username",username).
when().get(Routes.getURL);
return r;	
}


}
