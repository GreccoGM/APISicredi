package TesteTecnicoAPI.Testes;

import TesteTecnicoAPI.Utils.BaseURL;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class tst extends BaseURL {
    @Test
    public void validarConsumoAPI(){
        given()
                .spec(reqSpec)
        .when()
                .get("test")
        .then()
                .spec(resSpec)
                .statusCode(HttpStatus.SC_OK)
        ;
    }
}