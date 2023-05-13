package br.unicamp.ic.inf335.trabalho_4.trabalho_4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

class AnuncianteBeanTest {

    AnuncianteBean anuncianteBean = new AnuncianteBean();

    @Test
    void getNome() {
        anuncianteBean.setNome("Marcelo Silva");
        assertAll("getNome",
                () -> assertNotNull(anuncianteBean),
                () -> assertEquals("Marcelo Silva", anuncianteBean.getNome())
        );
    }

    @Test
    void setNome() {
        anuncianteBean.setNome("Murilo Araujo");
        assertAll("setNome",
                () -> assertNotNull(anuncianteBean),
                () -> assertEquals("Murilo Araujo", anuncianteBean.getNome())
        );
    }

    @Test
    void getCPF() {
        anuncianteBean.setCPF("9999999999");
        assertAll("getCPF",
                () -> assertNotNull(anuncianteBean),
                () -> assertEquals("9999999999", anuncianteBean.getCPF())
        );
    }

    @Test
    void setCPF() {
        anuncianteBean.setCPF("1111111111");
        assertAll("setCPF",
                () -> assertNotNull(anuncianteBean),
                () -> assertEquals("1111111111", anuncianteBean.getCPF())
        );
    }

    @Test
    void getAnuncios() throws MalformedURLException {
        ProdutoBean produtoBeanTesteget = new ProdutoBean("001", "Geladeira", "Grande", 5035.20, "Vendido");
        ArrayList<URL> fotosUrlTesteget = new ArrayList<URL>();
        fotosUrlTesteget.add(new URL("https://www.consul.com.br/geladeira-consul-facilite-frost-free-300-litros-branca-crb36ab/p"));
        AnuncioBean anuncioBeanTeste = new AnuncioBean(produtoBeanTesteget, fotosUrlTesteget, 0.5);
        anuncioBeanTeste.setProduto(produtoBeanTesteget);
        ArrayList<AnuncioBean> anunciosBeansget = new ArrayList<AnuncioBean>();
        anunciosBeansget.add(anuncioBeanTeste);
        anuncianteBean.setAnuncios(anunciosBeansget);

        assertAll("getAnuncios",
                () -> assertNotNull(anuncianteBean),
                () -> assertEquals(1, anuncianteBean.getAnuncios().size()),
                () -> assertEquals(anunciosBeansget, anuncianteBean.getAnuncios())
        );
    }

    @Test
    void setAnuncios() throws MalformedURLException{
        ProdutoBean produtoBeanTesteset = new ProdutoBean("001", "Geladeira", "Grande", 5035.20, "Vendido");
        ArrayList<URL> fotosUrlTesteset = new ArrayList<URL>();
        fotosUrlTesteset.add(new URL("https://www.consul.com.br/geladeira-consul-facilite-frost-free-300-litros-branca-crb36ab/p"));
        AnuncioBean anuncioBeanTeste = new AnuncioBean(produtoBeanTesteset, fotosUrlTesteset, 0.5);
        anuncioBeanTeste.setProduto(produtoBeanTesteset);
        ArrayList<AnuncioBean> anunciosBeansset = new ArrayList<AnuncioBean>();
        anunciosBeansset.add(anuncioBeanTeste);
        anuncianteBean.setAnuncios(anunciosBeansset);

        assertAll("getAnuncios",
                () -> assertNotNull(anuncianteBean),
                () -> assertEquals(1, anuncianteBean.getAnuncios().size()),
                () -> assertEquals(anunciosBeansset, anuncianteBean.getAnuncios())
        );
    }

    @Test
    void addAnuncio() throws MalformedURLException {
        ProdutoBean produtoBean1 = new ProdutoBean("001", "Geladeira", "Grande", 5000.00, "Vendido");
        ProdutoBean produtoBean2 = new ProdutoBean("002", "Microondas", "Pequeno", 1500.00, "Estoque");
        ProdutoBean produtoBean3 = new ProdutoBean("003", "Celular", "Médio", 2000.00, "Vendido");

        ArrayList<URL> fotosUrlProdutoBean1 = new ArrayList<URL>();
        fotosUrlProdutoBean1.add(new URL("https://www.consul.com.br/geladeira-consul-facilite-frost-free-300-litros-branca-crb36ab/p"));
        ArrayList<URL> fotosUrlProdutoBean2 = new ArrayList<URL>();
        fotosUrlProdutoBean2.add(new URL("http://receitasdeminuto.com/dicas-de-microondas-para-comprar/"));
        ArrayList<URL> fotosUrlProdutoBean3 = new ArrayList<URL>();
        fotosUrlProdutoBean3.add(new URL("https://www.techtudo.com.br/listas/2021/07/celular-simples-para-whatsapp.ghtml"));

        AnuncioBean anuncioBean1 = new AnuncioBean(produtoBean1, fotosUrlProdutoBean1, 0.1);
        AnuncioBean anuncioBean2 = new AnuncioBean(produtoBean2, fotosUrlProdutoBean2, 0.1);
        AnuncioBean anuncioBean3 = new AnuncioBean(produtoBean3, fotosUrlProdutoBean3, 0.1);

        anuncianteBean.addAnuncio(anuncioBean1);
        anuncianteBean.addAnuncio(anuncioBean2);
        anuncianteBean.addAnuncio(anuncioBean3);

        assertAll("addAnuncio",
                () -> assertNotNull(anuncianteBean),
                () -> assertEquals(anuncioBean1, anuncianteBean.getAnuncios().get(0)),
                () -> assertEquals(anuncioBean2, anuncianteBean.getAnuncios().get(1)),
                () -> assertEquals(anuncioBean3, anuncianteBean.getAnuncios().get(2)),
                () -> assertEquals(3, anuncianteBean.getAnuncios().size())
        );
    }

    @Test
    void removeAnuncio() throws MalformedURLException {
        addAnuncio();

        assertAll("removeAnuncioBefore",
                () -> assertNotNull(anuncianteBean),
                () -> assertEquals(3, anuncianteBean.getAnuncios().size())
        );

        anuncianteBean.removeAnuncio(0);

        assertAll("removeAnuncioAfter",
                () -> assertNotNull(anuncianteBean),
                () -> assertEquals(2, anuncianteBean.getAnuncios().size())
        );
    }

    @Test
    void valorMedioAnuncios() throws MalformedURLException {
        addAnuncio();

        assertAll("valorMedioAnuncios",
                () -> assertNotNull(anuncianteBean),
                () -> assertEquals(2550, anuncianteBean.valorMedioAnuncios())
        );
    }
}