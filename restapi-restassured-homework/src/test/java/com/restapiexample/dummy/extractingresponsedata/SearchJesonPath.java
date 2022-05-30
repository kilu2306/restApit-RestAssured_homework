package com.restapiexample.dummy.extractingresponsedata;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class SearchJesonPath {
    static ValidatableResponse response;
    @BeforeClass
    public static void  inIt(){
        RestAssured.baseURI="https://dummy.restapiexample.com";
        RestAssured.basePath="/api/v1";
       response = given().log().all()
                .when()
                .get("/employees")
                .then().statusCode(200);




    }
    @Test
    //1]to verify total records are 24"
    public void verifyTotalRecord(){
        int numOfRecord = response.extract().path("data.size()");
        System.out.println("number of recrod is := "+ numOfRecord);
    }
    //2]to verify data[23].id = 24"
    @Test
    public void getId(){
        int id = response.extract().path("data[23].id");
        System.out.println("number of id : = "+ id);
    }
    //3] to verify data[23].employee_name = “Doris Wilder”
    @Test
    public void getEmployeeName(){
        String name = response.extract().path("data[23].employee_name");
        System.out.println("data[23] has employee name : = " +name);
    }
    //4] message = “Successfully! All records has beenfetched
    @Test
    public void getMessage (){
        String text = response.extract().path("message");
        System.out.println("message is : "+ text);

    }
    //5] to verify status = success"
    @Test
    public void statusText(){
        String text = response.extract().path("status");
        System.out.println("status is : "+ text);
    }
    //6] to verify id = 3 has employee_salary = 86000"
    @Test
    public void employeeSalary(){
        int salary = response.extract().path("data.find{it.id==3}.employee_salary");
        System.out.println("status is : "+ salary);
    }
    //7] to verify id = 6 has employee_age = 61"
    @Test
    public void employeeAge(){
        int age = response.extract().path("data.find{it.id==6}.employee_age");
        System.out.println("status is : "+ age);
    }
    //8] to verify  id = 11 has employee_name = Jena Gaines"
    @Test
    public void employeeName(){
        String  name= response.extract().path("data.find{it.id==11}.employee_name");
        System.out.println("status is : "+ name);
    }

}
