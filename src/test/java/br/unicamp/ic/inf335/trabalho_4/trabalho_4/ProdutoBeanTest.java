package br.unicamp.ic.inf335.trabalho_4.trabalho_4;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ProdutoBeanTest {

    private ProdutoBean produtoBean = new ProdutoBean();

    @org.junit.jupiter.api.Test
    void getCodigo() {
        produtoBean.setCodigo("00000123");
        assertAll("getCodigo",
                () -> assertNotNull(produtoBean),
                () -> assertEquals("00000123", produtoBean.getCodigo())
        );
    }

    @org.junit.jupiter.api.Test
    void setCodigo() {
        produtoBean.setCodigo("00000123");
        assertAll("setCodigo",
                () -> assertNotNull(produtoBean),
                () -> assertEquals("00000123", produtoBean.getCodigo())
        );
    }

    @org.junit.jupiter.api.Test
    void getNome() {
        produtoBean.setNome("Marcelo Pereira");
        assertAll("getNome",
                () -> assertNotNull(produtoBean),
                () -> assertEquals("Marcelo Pereira", produtoBean.getNome())
        );
    }

    @org.junit.jupiter.api.Test
    void setNome() {
        produtoBean.setNome("Murilo Araujo");
        assertAll("setNome",
                () -> assertNotNull(produtoBean),
                () -> assertEquals("Murilo Araujo", produtoBean.getNome())
        );
    }

    @org.junit.jupiter.api.Test
    void getDescricao() {
        produtoBean.setDescricao("Desc1");
        assertAll("getDescricao",
                () -> assertNotNull(produtoBean),
                () -> assertEquals("Desc1", produtoBean.getDescricao())
        );
    }

    @org.junit.jupiter.api.Test
    void setDescricao() {
        produtoBean.setDescricao("Desc2");
        assertAll("setDescricao",
                () -> assertNotNull(produtoBean),
                () -> assertEquals("Desc2", produtoBean.getDescricao())
        );
    }

    @org.junit.jupiter.api.Test
    void getValor() {
        produtoBean.setValor(15.00);
        assertAll("getValor",
                () -> assertNotNull(produtoBean),
                () -> assertEquals(15.00, produtoBean.getValor())
        );
    }

    @org.junit.jupiter.api.Test
    void setValor() {
        produtoBean.setValor(5.00);
        assertAll("setValor",
                () -> assertNotNull(produtoBean),
                () -> assertEquals(5.00, produtoBean.getValor())
        );
    }

    @org.junit.jupiter.api.Test
    void getEstado() {
        produtoBean.setEstado("Disponivel");
        assertAll("getEstado",
                () -> assertNotNull(produtoBean),
                () -> assertEquals("Disponivel", produtoBean.getEstado())
        );
    }

    @org.junit.jupiter.api.Test
    void setEstado() {
        produtoBean.setEstado("Vendido");
        assertAll("setEstado",
                () -> assertNotNull(produtoBean),
                () -> assertEquals("Vendido", produtoBean.getEstado())
        );
    }

    @org.junit.jupiter.api.Test
    void getSerialversionuid() {
        assertAll("getSerial",
                () -> assertNotNull(produtoBean),
                () -> assertEquals(1L, ProdutoBean.getSerialversionuid())
        );
    }

    @org.junit.jupiter.api.Test
    void compareTo() {
        produtoBean.setValor(100.0);
        ProdutoBean produtoBean2 = new ProdutoBean();
        produtoBean2.setValor(200.00);
        ProdutoBean produtoBean3 = new ProdutoBean();
        produtoBean3.setValor(200.00);

        assertEquals(-1, produtoBean.compareTo(produtoBean2));
        assertEquals(1, produtoBean2.compareTo(produtoBean));
        assertEquals(0, produtoBean3.compareTo(produtoBean2));
    }
}