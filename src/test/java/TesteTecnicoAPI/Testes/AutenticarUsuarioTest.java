package TesteTecnicoAPI.Testes;

import TesteTecnicoAPI.Dados.MapDados;
import TesteTecnicoAPI.Utils.BaseURL;
import TesteTecnicoAPI.Utils.VerificadorEmail;
import org.apache.http.HttpStatus;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;


public class AutenticarUsuarioTest extends BaseURL{
    MapDados objeto = new MapDados();
    VerificadorEmail verificadorEmail = new VerificadorEmail();

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
                .body("firstName",notNullValue())
                .body("lastName",notNullValue())
                .body("gender",notNullValue())
                .body("image",notNullValue())
                .body("token", notNullValue())
        ;
    }
    @Test
    public void validarAutenticacaoUsuarioInvalido(){
        Map objAtenticacao = objeto.autenticarUsuarioInvalido();

        String msgErro =
        given()
                .spec(reqSpec)
                .body(objAtenticacao)
        .when()
                .post("/auth/login")
        .then()
                .spec(resSpec)
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .extract().path("message")
        ;

        assertThat(msgErro,  is("Invalid credentials"));
    }

    @Test
    public void validarAutenticacaoUsuarioSemDados(){
        Map objAtenticacao = objeto.estruturaAutenticacao();

        String msgErro =
                given()
                        .spec(reqSpec)
                        .body(objAtenticacao)
                .when()
                        .post("/auth/login")
                .then()
                        .spec(resSpec)
                        .statusCode(HttpStatus.SC_BAD_REQUEST)
                        .extract().path("message")
                ;

            assertThat(msgErro,  is("Invalid credentials"));
    }

    @Test
    public void validarEmailRetornado() {
        Map objAtenticacao = objeto.autenticarUsuario();

        String emailUsuario =
                given()
                        .spec(reqSpec)
                        .body(objAtenticacao)
                .when()
                        .post("/auth/login")
                .then()
                        .spec(resSpec)
                        .statusCode(HttpStatus.SC_OK)
                        .extract().path("email")
                ;
         assertThat(verificadorEmail.validarEmail(emailUsuario),  is(true));
    }
}
