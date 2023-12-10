package TesteTecnicoAPI.Dados;
import TesteTecnicoAPI.Utils.GeradorDados;

import java.util.HashMap;
import java.util.Map;


public class MapDados  extends GeradorDados{

    public Map estruturaAutenticacao(){
        Map<String,Object> login = new HashMap<String, Object>();
        login.put("username"," ");
        login.put("password", " ");

        return login;
    }

    public Map estruturaAdcProduto(){
        Map<String,Object> prod = new HashMap<String, Object>();
        prod.put("title"," ");
        prod.put("description", " ");
        prod.put("price", " ");
        prod.put("discountPercentage", " ");
        prod.put("rating", " ");
        prod.put("stock", " ");
        prod.put("brand", " ");
        prod.put("category", " ");
        prod.put("thumbnail", " ");


        return prod;
    }

    public Map autenticarUsuario(){
        Map objLogin = estruturaAutenticacao();

        objLogin.put("username","kminchelle");
        objLogin.put("password", "0lelplR");

        return objLogin;
    }

    public Map produto(){
        Map objProduto = estruturaAdcProduto();

        objProduto.put("title", getTituloFaker());
        objProduto.put("description",getDescFaker());
        objProduto.put("price", getPrecoFaker());
        objProduto.put("discountPercentage",getDescontoFaker());
        objProduto.put("rating", getAvaliacaoFaker());
        objProduto.put("stock", getEstoqFaker());
        objProduto.put("brand", getMarcaFaker());
        objProduto.put("category", getCategoriaFaker());
        objProduto.put("thumbnail", getImgFaker());

        return objProduto;
    }

    public Map objetosProduto(){
        Map objProd1 = produto();
        Map objProd2 = produto();

        Map<String, Object> objetos = new HashMap<>();
        objetos.put("produto1", objProd1);
        objetos.put("produto2", objProd2);

        return objetos;
    }
}
