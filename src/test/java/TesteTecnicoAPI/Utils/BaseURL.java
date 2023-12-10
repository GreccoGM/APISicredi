package TesteTecnicoAPI.Utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;
public class BaseURL {
    public static RequestSpecification reqSpec;
    public static ResponseSpecification resSpec;

    @BeforeClass
    public static void config(){

        RestAssured.baseURI = "https://dummyjson.com";

        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        reqBuilder.setContentType(ContentType.JSON);
        reqBuilder.log(LogDetail.URI);
        reqBuilder.log(LogDetail.BODY);
        reqBuilder.log(LogDetail.HEADERS);
        reqSpec = reqBuilder.build();

        ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
        resBuilder.log(LogDetail.BODY);
        //resBuilder.log(LogDetail.STATUS);
        resSpec = resBuilder.build();
    }

}