package tests;

import org.testng.annotations.Test;

import endpoints.Methods;
import io.restassured.response.Response;
import utility.DataProvide;
import utility.pojo;

public class DDrTest {
	
pojo payload=new pojo();

	
//@Test(dataProvider="userNames",dataProviderClass=DataProvide.class)
//public void getUser(String username) {
//Response re= Methods.getUser(username);
//re.then().log().all();

//@Test(priority=1,dataProvider="CreateUserAuth",dataProviderClass=DataProvide.class)
public void createUserAuthTest(String name,String mail) {
int bookID=3;
payload.setClientName(name);
payload.setClientEmail(mail);
Response r =Methods.CreateUserAuth(payload);
String token = r.jsonPath().get("accessToken").toString();
payload.setBookID(bookID);
payload.setClientName(name);
Response r1=Methods.SubmitTheOrder(bookID, name, token);
r1.then().log().all();
int StatusCode=r1.getStatusCode();
System.out.print("STATUSNI KOD JE "+StatusCode);

}













}
