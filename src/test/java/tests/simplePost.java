package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;

import endpoints.Methods;
import endpoints.UserEndpoints;
import io.restassured.response.Response;
import utility.UserPojo;
import utility.pojo;

public class simplePost {

pojo payload;	
	
@BeforeClass
public void setupData() {
Faker f=new Faker();
String name=f.name().firstName();
String mail=f.internet().emailAddress();
payload=new pojo();
payload.setClientName(name);
payload.setClientEmail(mail);	
}
@Test	
public void postUser() {

Response r = 
Methods.CreateUser(payload);
r.then().log().all();
int sk = r.getStatusCode();
Assert.assertEquals(sk, 201);

}


}
