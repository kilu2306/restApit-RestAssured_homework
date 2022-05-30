package com.restapiexample.dummy.employeeinfo;

import com.restapiexample.dummy.model.EmployeeUpDatePojo;
import com.restapiexample.dummy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class putTestForUpdateRecord extends TestBase {
    @Test
    public void updateRecord() {
        EmployeeUpDatePojo employeeUpDatePojo= new EmployeeUpDatePojo();
        employeeUpDatePojo.setId(21);
        employeeUpDatePojo.setEmployee_name("dhyani");
        employeeUpDatePojo.setEmployee_salary(50000);
        employeeUpDatePojo.setProfile_image("");
        employeeUpDatePojo.setEmployee_age(23);
        Response response = given()
                .header("Content-Type","application/json")
                .body(employeeUpDatePojo)
                .when()
                .put("/update/25");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}