package TesteTecnicoAPI.Utils;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class GeradorDados {
    Faker faker = new Faker(new Locale("pt-BR"));
    Random randomico = new Random();

    public String getTituloFaker(){
        String tituloFaker = faker.commerce().productName();

        return tituloFaker;
    }

    public String getDescFaker(){
        String descFaker = faker.commerce().material();

        return descFaker;
    }

    public int getPrecoFaker(){
        int precoFaker = faker.number().numberBetween(20,500);

        return precoFaker;
    }

    public float getDescontoFaker(){
        float descontoFaker =faker.number().numberBetween(0,75);

        return descontoFaker;
    }

    public float getAvaliacaoFaker(){
        float precoFaker =faker.number().numberBetween(0,5);

        return precoFaker;
    }

    public int getEstoqFaker(){
        int estoqueFaker = faker.number().numberBetween(0,400);

        return estoqueFaker;
    }

    public String getMarcaFaker(){
        String marcaFaker;
        String marcas[] = {"Motorola","Nokia",
                "Samsung",
                "Golden",
                "Sony", "Philco",
                "Nestle", "Purina"};

        int posicao = randomico.nextInt(marcas.length);

        marcaFaker = marcas[posicao];
        return marcaFaker;
    }

    public String getCategoriaFaker(){
        String categoriaFaker;
        String categorias[] = {"Serviços Digitais",
                "Perfumaria e Cosméticos",
                "Alimentos e Bebidas",
                "Casa e Decoração",
                "Saúde e bem-estar",
                "Produtos para pets"};

        int posicao = randomico.nextInt(categorias.length);

        categoriaFaker = categorias[posicao];
        return categoriaFaker;
    }

    public String getImgFaker(){
        String imgFaker = faker.internet().image();

        return imgFaker;
    }

    public int getProdutoInexistente(){
        int[] idInexistente = {1000,1001,1002,1003,1004,1005};
        int idInvalido;
        int posicao = randomico.nextInt(idInexistente.length);

        idInvalido = idInexistente[posicao];
        return idInvalido;
    }

}
