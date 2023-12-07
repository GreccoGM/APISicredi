package TesteTecnicoAPI.Testes;

import TesteTecnicoAPI.Dados.MapDados;
import TesteTecnicoAPI.Utils.BaseURL;
import org.apache.http.HttpStatus;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;


public class AutenticarUsuario extends BaseURL{
    MapDados objeto = new MapDados();

    @Test
    public void validarSucessoAutenticacao(){
        Map objAtenticacao = objeto.autenticarUsuario();

        given()
                .spec(reqSpec)
                .body(objAtenticacao)
        .when()
                .post("/auth/login")
        .then()
                .spec(resSpec)
                .statusCode(HttpStatus.SC_OK)
                .body("id",notNullValue())
                .body("username",notNullValue())
                .body("password",notNullValue())
                .body("firstName",notNullValue())
                .body("lastName",notNullValue())
                .body("gender",notNullValue())
                .body("image",notNullValue())
                .body("token", notNullValue())
        ;
    }

}
