package TesteTecnicoAPI.Dados;

import java.util.HashMap;
import java.util.Map;

public class MapDados {

    public Map estruturaAutenticacao(){
        Map<String,Object> login = new HashMap<String, Object>();
        login.put("username"," ");
        login.put("password", " ");

        return login;
    }
    public Map autenticarUsuario(){
        Map objLogin = estruturaAutenticacao();

        objLogin.put("username","kminchelle");
        objLogin.put("password", "0lelplR");

        return objLogin;
    }
}
