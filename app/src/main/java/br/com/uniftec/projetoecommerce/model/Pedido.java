package br.com.uniftec.projetoecommerce.model;

import org.json.JSONArray;

import java.math.BigDecimal;

/**
 * Created by willi on 09/11/2017.
 */

public class Pedido {
    private Integer id;
    private Integer idUsuario;
    private JSONArray Produtos;
    private BigDecimal total;
    private String data;
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public JSONArray getProdutos() {
        return Produtos;
    }

    public void setProdutos(JSONArray produtos) {
        Produtos = produtos;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
