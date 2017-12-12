package br.com.uniftec.projetoecommerce.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.json.JSONArray;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.uniftec.projetoecommerce.model.Produto;

/**
 * Created by willi on 09/11/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PedidoResponse {


    public PedidoResponse(List<Produto> produtos) {
        listProdutos = new ArrayList<>();
    }

    private Integer id;
    private Integer idUsuario;
    private List<Produto> listProdutos;
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

    public List<Produto> getListProdutos() {
        return listProdutos;
    }

    public void setListProdutos(List<Produto> listProdutos) {
        this.listProdutos = listProdutos;
    }

}
