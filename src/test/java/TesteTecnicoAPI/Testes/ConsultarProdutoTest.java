package TesteTecnicoAPI.Testes;

import TesteTecnicoAPI.Dados.DadosRetornados;
import TesteTecnicoAPI.Utils.BaseURL;
import TesteTecnicoAPI.Utils.GeradorDados;
import org.apache.http.HttpStatus;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ConsultarProdutoTest extends BaseURL {
    DadosRetornados dadosRetorno = new DadosRetornados();
    GeradorDados dadosGerados = new GeradorDados();
    @Test
    public void validarSucessoRetornoProduto() {
        given()
                .spec(reqSpec)
                .when()
                .get("/products/" + dadosRetorno.capturarIdProduto())
                .then()
                .spec(resSpec)
                .statusCode(HttpStatus.SC_OK)
                .body(not(empty()))
        ;
    }
    @Test
    public void validarRetornosProduto() {
        given()
                .spec(reqSpec)
        .when()
                .get("/products/" + dadosRetorno.capturarIdProduto())
        .then()
                .spec(resSpec)
                .statusCode(HttpStatus.SC_OK)
                .body("id",(not(empty())))
                .body("title",isA(String.class))
                .body("description",isA(String.class))
                .body("price",isA(Integer.class))
                .body("discountPercentage",isA(Float.class))
                .body("rating",isA(Float.class))
                .body("stock",isA(Integer.class))
                .body("brand",isA(String.class))
                .body("category",isA(String.class))
                .body("thumbnail",isA(String.class))
                .body("images",isA(List.class))
                    .body("images", everyItem(isA(String.class)))
        ;
    }
    @Test
    public void validarRetornoProdutoInexistente() {
        int produtoInvalido = dadosGerados.getProdutoInexistente();
        given()
                .spec(reqSpec)
        .when()
                .get("/products/" + produtoInvalido)
        .then()
                .spec(resSpec)
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .body(not(empty()))
                .body("message", is("Product with id '" + produtoInvalido + "' not found"));
        ;
    }

}
