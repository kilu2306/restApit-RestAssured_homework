package com.restapiexample.dummy.employeeinfo;

import com.restapiexample.dummy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetEmployeeList extends TestBase {
    @Test
    public void getEmployeeList() {
        Response response = given().log().all()
                .when()
                .get("/employees");
        response.then().statusCode(200);
        response.prettyPrint();


    }
}
