package com.restapiexample.dummy.employeeinfo;

import com.restapiexample.dummy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteRecord extends TestBase {
    @Test
    public void deleteRecord(){
        Response response = given()
                .when()
                .delete("/delete/2");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}
