package TesteTecnicoAPI.Testes;

import TesteTecnicoAPI.Dados.MapDados;
import TesteTecnicoAPI.Utils.BaseURL;
import org.apache.http.HttpStatus;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class AdicionarProdutosTest extends BaseURL {
    MapDados objeto = new MapDados();

    @Test
    public void validarCodigoSucessoInserirProduto() {
        Map objProduto = objeto.produto();

        given()
                .spec(reqSpec)
                .body(objProduto)
        .when()
                .post("/products/add")
        .then()
                .spec(resSpec)
                .statusCode(HttpStatus.SC_CREATED) //erro status
        ;
    }

    @Test
    public void validarInserirProdutoVazio() {
        Map objProdVazio = objeto.estruturaAdcProduto();

        given()
                .spec(reqSpec)
                .body(objProdVazio)
        .when()
                .post("/products/add")
        .then()
                .spec(resSpec)
                .statusCode(HttpStatus.SC_BAD_REQUEST) // erro status
        ;
    }

    @Test
    public void validarEnvioValoresProduto() {
        Map objProd = objeto.produto();

        given()
                .spec(reqSpec)
                .body(objProd)
                .when()
                .post("/products/add")
                .then()
                .spec(resSpec)
                .body("title", is(objProd.get("title")))
                .body("description", is(objProd.get("description")))
                .body("price", is(objProd.get("price")))
                .body("discountPercentage", is(objProd.get("discountPercentage"))) //erro por nao enviar o valor
                .body("stock", is(objProd.get("stock")))
                .body("brand", is(objProd.get("brand")))
                .body("category", is(objProd.get("category")))
                .body("thumbnail", is(objProd.get("thumbnail")))
        ;
    }
    @Test
    public void validarEnvioAtributosProduto() {
        Map objProd = objeto.produto();

        given()
                .spec(reqSpec)
                .body(objProd)
        .when()
                .post("/products/add")
        .then()
                .spec(resSpec)
                .body("id",is(notNullValue()))
                .body("title",is(notNullValue()))
                .body("description",is(notNullValue()))
                .body("price",is(notNullValue()))
                .body("stock",is(notNullValue()))
                .body("brand",is(notNullValue()))
                .body("category",is(notNullValue()))
                .body("thumbnail",is(notNullValue()))
                .body("discountPercentage",is(notNullValue())) // nao envia
        ;
    }

    @Test
    public void validarEnvioMaisObj() {
        Map objetos = objeto.objetosProduto();

        given()
                .spec(reqSpec)
                .body(objetos)
        .when()
                .post("/products/add")
        .then()
                .spec(resSpec)
                .body(isA(List.class))
                .statusCode(HttpStatus.SC_CREATED)
        ;
    }

    //validar incremento do id
    //extrair do total
}
