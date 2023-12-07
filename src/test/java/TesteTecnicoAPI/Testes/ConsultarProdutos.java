package TesteTecnicoAPI.Testes;

import TesteTecnicoAPI.Utils.Autenticacao;
import TesteTecnicoAPI.Utils.BaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ConsultarProdutos extends BaseURL {
    Autenticacao auth = new Autenticacao();

    @Test
    public void validarSucessoConsultaProdutos() {
        given()
                .spec(reqSpec)
                .header("Authorization", "Bearer " + auth.capturarToken())
        .when()
                .get("/auth/products")
        .then()
                .spec(resSpec)
                .statusCode(HttpStatus.SC_OK)
                .body(not(empty()))
        ;
    }

    @Test
    public void validarExibicaoCamposConsultaProdutos() {
        given()
                .spec(reqSpec)
                .header("Authorization", "Bearer " + auth.capturarToken())
        .when()
                .get("/auth/products")
        .then()
                .spec(resSpec)
                .statusCode(HttpStatus.SC_OK)
                .body(not(empty()))
                .body("products", isA(List.class))
                .body("products.id", everyItem(isA(Integer.class)))
                .body("products.title", everyItem(isA(String.class)))
                .body("products.description", everyItem(isA(String.class)))
                .body("products.price", everyItem(isA(Integer.class)))
                .body("products.discountPercentage", everyItem(isA(Float.class)))
                .body("products.rating", everyItem(isA(Float.class))) //erro
                .body("products.stock", everyItem(isA(Integer.class)))
                .body("products.brand", everyItem(isA(String.class)))
                .body("products.category", everyItem(isA(String.class)))
                .body("products.thumbnail", everyItem(isA(String.class)))
                .body("products.images", isA(List.class))
        ;
    }

    @Test
    public void validarConsultaProdutosSemToken() {
        String msgErro =
                given()
                    .spec(reqSpec)
                .when()
                    .get("/auth/products")
                .then()
                    .spec(resSpec)
                    .statusCode(HttpStatus.SC_FORBIDDEN)
                    .extract().path("message")
        ;

        assertThat(msgErro,  is("Authentication Problem"));
    }

    @Test
    public void validarConsultaProdutosTokenInvalido() {
        ValidatableResponse retorno =
                given()
                        .spec(reqSpec)
                        .header("Authorization", "Bearer " + auth.tokenInvalido())
                .when()
                        .get("/auth/products")
                .then()
                        .spec(resSpec)
                        .statusCode(HttpStatus.SC_UNAUTHORIZED)
                ;
        JsonPath jsonCaminho = retorno.extract().jsonPath();
        String erro = jsonCaminho.getString("name");
        String msg = jsonCaminho.getString("message");

        assertThat(erro,  is("JsonWebTokenError")); //erro
        assertThat(msg,  is("Invalid/Expired Token!")); //erro
    }
}
