package br.com.uniftec.projetoecommerce.model;

import java.io.Serializable;

/**
 * Created by daniel on 26/10/17.
 */

public class Cartao implements Serializable {
    private Integer id;
    private String numero;
    private String expiracao;
    private String cvv;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getExpiracao() {
        return expiracao;
    }

    public void setExpiracao(String expiracao) {
        this.expiracao = expiracao;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
