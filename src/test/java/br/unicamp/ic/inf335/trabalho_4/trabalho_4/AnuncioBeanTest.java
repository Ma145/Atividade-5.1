package br.unicamp.ic.inf335.trabalho_4.trabalho_4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

class AnuncioBeanTest {

    AnuncioBean anuncioBean = new AnuncioBean();

    @Test
    void getProduto() {
        ProdutoBean p1 = new ProdutoBean();
        p1.setEstado("Disponivel");
        p1.setCodigo("000");
        p1.setValor(100.0);
        p1.setDescricao("Desc1");
        anuncioBean.setProduto(p1);

        assertAll("getProduto",
                () -> assertNotNull(anuncioBean),
                () -> assertEquals(p1, anuncioBean.getProduto())
        );
    }

    @Test
    void setProduto() {
        ProdutoBean p2 = new ProdutoBean();
        p2.setEstado("Vendido");
        p2.setCodigo("999");
        p2.setValor(500.0);
        p2.setDescricao("Desc2");
        anuncioBean.setProduto(p2);

        assertAll("getProduto",
                () -> assertNotNull(anuncioBean),
                () -> assertEquals(p2, anuncioBean.getProduto())
        );
    }

    @Test
    void getFotosUrl() throws MalformedURLException {
        ArrayList<URL> fotosUrl = new ArrayList<URL>();
        fotosUrl.add(new URL("https://vestibular1.com.br/wp-content/uploads/2016/01/unicampuniversidadeestadualdecampinas.png/"));
        fotosUrl.add(new URL("https://www.idis.org.br/wp-content/uploads/2021/03/Unicamp_ArthurCastro.png"));
        anuncioBean.setFotosUrl(fotosUrl);
        assertAll("getFotosUrl",
                () -> assertNotNull(anuncioBean),
                () -> assertEquals(fotosUrl, anuncioBean.getFotosUrl()),
                () -> assertEquals(fotosUrl.get(0), anuncioBean.getFotosUrl().get(0)),
                () -> assertEquals(fotosUrl.get(1), anuncioBean.getFotosUrl().get(1)),
                () -> assertEquals(2, anuncioBean.getFotosUrl().size()),
                () -> assertThrows(MalformedURLException.class, () -> {new URL("URL INVALIDA");})
        );
    }

    @Test
    void setFotosUrl() throws MalformedURLException {
        ArrayList<URL> fotosUrl = new ArrayList<URL>();
        fotosUrl.add(new URL("https://vestibular1.com.br/wp-content/uploads/2016/01/unicampuniversidadeestadualdecampinas.png/"));
        fotosUrl.add(new URL("https://www.idis.org.br/wp-content/uploads/2021/03/Unicamp_ArthurCastro.png"));
        anuncioBean.setFotosUrl(fotosUrl);
        assertAll("getFotosUrl",
                () -> assertNotNull(anuncioBean),
                () -> assertEquals(fotosUrl, anuncioBean.getFotosUrl()),
                () -> assertEquals(fotosUrl.get(0), anuncioBean.getFotosUrl().get(0)),
                () -> assertEquals(fotosUrl.get(1), anuncioBean.getFotosUrl().get(1)),
                () -> assertEquals(2, anuncioBean.getFotosUrl().size()),
                () -> assertThrows(MalformedURLException.class, () -> {new URL("URL INVALIDA");})
        );
    }

    @Test
    void getDesconto() {
        anuncioBean.setDesconto(5.8);
        assertAll("getDesconto",
                () -> assertNotNull(anuncioBean),
                () -> assertEquals(5.8, anuncioBean.getDesconto())
        );
    }

    @Test
    void setDesconto() {
        anuncioBean.setDesconto(5.8);
        assertAll("getDesconto",
                () -> assertNotNull(anuncioBean),
                () -> assertEquals(5.8, anuncioBean.getDesconto())
        );
    }

    @Test
    void getSerialversionuid() {
        assertAll("getSerial",
                () -> assertNotNull(anuncioBean),
                () -> assertEquals(1L, AnuncioBean.getSerialversionuid())
        );
    }

    @Test
    void getValor() {
        ProdutoBean p3 = new ProdutoBean();
        p3.setEstado("Reservado");
        p3.setCodigo("199");
        p3.setValor(1000.0);
        p3.setDescricao("Desc3");
        anuncioBean.setProduto(p3);
        anuncioBean.setDesconto(0.1);

        assertAll("getValor",
                () -> assertNotNull(anuncioBean),
                () -> assertEquals(900, anuncioBean.getValor())
        );
    }
}