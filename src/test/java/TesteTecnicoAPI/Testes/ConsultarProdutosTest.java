package TesteTecnicoAPI.Testes;

import TesteTecnicoAPI.Utils.BaseURL;
import org.apache.http.HttpStatus;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.isA;

public class ConsultarProdutosTest extends BaseURL {

    @Test
    public void validarRetornoConsultarProdutos() {
        given()
                .spec(reqSpec)
        .when()
                .get("/products")
        .then()
                .spec(resSpec)
                .body(not(empty()))
                .body("products", isA(List.class))
                .statusCode(HttpStatus.SC_OK)
        ;
    }
    @Test
    public void validarTipoRetornoImgs() {
        given()
                .spec(reqSpec)
        .when()
                .get("/products")
        .then()
                .spec(resSpec)
                .statusCode(HttpStatus.SC_OK)
                .body("products.images", everyItem(isA(List.class)))
        ;
    }

    @Test
    public void validarTotalPaginacao() {
        int limitePag = 30;

        given()
                .spec(reqSpec)
        .when()
                .get("/products")
        .then()
                .spec(resSpec)
                .statusCode(HttpStatus.SC_OK)
                .body("products.size()",is(limitePag))
        ;
    }
}
