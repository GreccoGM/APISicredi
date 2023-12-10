package TesteTecnicoAPI.Testes;

import TesteTecnicoAPI.Utils.BaseURL;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class ConsultarUsuariosTest extends BaseURL {
    @Test
    public void validarSucessoConsultarUsuarios() {
        given()
                .spec(reqSpec)
        .when()
                .get("/users")
        .then()
                .spec(resSpec)
                .statusCode(HttpStatus.SC_OK)
                .body(not(empty()))
        ;
    }

    @Test
    public void validarRetornosCampos() {
        //melhorar para pegar todos os retornos
        given()
                .spec(reqSpec)
        .when()
                .get("/users")
        .then()
                .spec(resSpec)
                .statusCode(HttpStatus.SC_OK)

                .body(not(empty()))
                .body("users[0].id",isA(Integer.class))
                .body("users[0].firstName", isA(String.class))
                .body("users[0].lastName", isA(String.class))
                .body("users[0].maidenName", isA(String.class))
                .body("users[0].age",isA(Integer.class))
                .body("users[0].gender", isA(String.class))
                .body("users[0].email", isA(String.class))
                .body("users[0].phone", isA(String.class))
                .body("users[0].username", isA(String.class))
                .body("users[0].password", isA(String.class))
                .body("users[0].birthDate", isA(String.class))
                .body("users[0].image", isA(String.class))
                .body("users[0].bloodGroup", isA(String.class))
                .body("users[0].height", isA(Integer.class))
                .body("users[0].weight", isA(Float.class))
                .body("users[0].eyeColor", isA(String.class))
                .body("users[0].hair", notNullValue())
                    .body("users[0].hair.color", isA(String.class))
                    .body("users[0].hair.type", isA(String.class))
                .body("users[0].domain", isA(String.class))
                .body("users[0].ip", isA(String.class))
                .body("users[0].address", notNullValue())
                    .body("users[0].address.address", isA(String.class))
                    .body("users[0].address.city", isA(String.class))
                    .body("users[0].address.coordinates", notNullValue())
                        .body("users[0].address.coordinates.lat", isA(Float.class))
                        .body("users[0].address.coordinates.lng", isA(Float.class))
                    .body("users[0].address.postalCode", isA(String.class))
                    .body("users[0].address.state", isA(String.class))
                .body("users[0].macAddress", isA(String.class))
                .body("users[0].university", isA(String.class))
                .body("users[0].bank", notNullValue())
                    .body("users[0].bank.cardExpire", isA(String.class))
                    .body("users[0].bank.cardNumber", isA(String.class))
                    .body("users[0].bank.cardType", isA(String.class))
                    .body("users[0].bank.currency", isA(String.class))
                    .body("users[0].bank.iban", isA(String.class))
                .body("users[0].company", notNullValue())
                    .body("users[0].company.address", notNullValue())
                        .body("users[0].company.address.address", isA(String.class))
                        .body("users[0].company.address.city", isA(String.class))
                        .body("users[0].company.address.coordinates",notNullValue())
                            .body("users[0].company.address.coordinates.lat",isA(Float.class))
                            .body("users[0].company.address.coordinates.lng",isA(Float.class))
                    .body("users[0].company.department", isA(String.class))
                    .body("users[0].company.name", isA(String.class))
                    .body("users[0].company.title", isA(String.class))
                .body("users[0].ein", isA(String.class))
                .body("users[0].ssn", isA(String.class))
                .body("users[0].userAgent", isA(String.class))
        ;
    }

    @Test
    public void validarTipoImagem() {
        given()
                .spec(reqSpec)
        .when()
                .get("/users")
        .then()
                .spec(resSpec)
                .statusCode(HttpStatus.SC_OK)
                .body(not(empty()))
                .body("users.image", everyItem(containsString(".png")))
        ;
    }

    @Test
    public void validarRetornoValidoNomeSenha() {
        given()
                .spec(reqSpec)
        .when()
                .get("/users")
        .then()
                .spec(resSpec)
                .statusCode(HttpStatus.SC_OK)
                .body("users.name",everyItem(not(empty())))
                //.body("users.name",everyItem(notNullValue()))
                .body("users.password",everyItem(not(empty())))
                .body("users.password", everyItem(notNullValue()))
        ;
    }

}
