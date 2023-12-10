package TesteTecnicoAPI.Dados;

import TesteTecnicoAPI.Utils.BaseURL;
import org.apache.http.HttpStatus;

import java.util.List;
import java.util.Map;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class DadosRetornados extends BaseURL {
    MapDados objeto = new MapDados();

    public String capturarToken(){
        Map objAtenticacao = objeto.autenticarUsuario();

        String token =
                given()
                        .spec(reqSpec)
                        .body(objAtenticacao)
                .when()
                        .post("/auth/login")
                .then()
                        .spec(resSpec)
                        .statusCode(HttpStatus.SC_OK)
                        .body("token", notNullValue())
                        .extract().path("token")
                ;
        return token;
    }

    public String tokenInvalido() {
        return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MTUsInVzZXJuYW1lIjoia21pbmNoZWxsZSIsImVtYWlsIjoia21pbmNoZWxsZUBxcS5jb20iLCJmaXJzdE5hbWUiOiJKZWFubmUiLCJsYXN0TmFtZSI6IkhhbHZvcnNvbiIsImdlbmRlciI6ImZlbWFsZSIsImltYWdlIjoiaHR0cHM6Ly9yb2JvaGFzaC5vcmcvYXV0cXVpYXV0LnBuZyIsImlhdCI6MTcwMTk2MDU2OSwiZXhwIjoxNzAxOTY0MTY5fQ.NbHbNtaJ3rHuZvvy5alugkVPhAKOu2ubOgj4VZhipEY";
    }

    public int capturarIdProduto(){
        Random randomico = new Random();
        int idCapturado = 0;
        List<Integer> prodIds =
                given()
                        .spec(reqSpec)
                .when()
                        .get("/products")
                .then()
                        .spec(resSpec)
                        //.body("id", everyItem(notNullValue()))
                        .extract().path("products.id")
                ;

            int posicao = randomico.nextInt(prodIds.size());

            if(posicao > 0 ){
                idCapturado = prodIds.get(posicao);
                //System.out.println(idCapturado);
            }

        return idCapturado;
    }
}
