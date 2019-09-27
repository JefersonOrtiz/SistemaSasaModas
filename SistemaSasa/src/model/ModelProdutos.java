/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Jeferson
 */
public class ModelProdutos {
    
    private int idProduto;
    private String nomeProd;
    private Double valorProd;
    private int estoqProd;

    /**
     * @return the idProduto
     */
    public int getIdProduto() {
        return idProduto;
    }

    /**
     * @param idProduto the idProduto to set
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * @return the nomeProd
     */
    public String getNomeProd() {
        return nomeProd;
    }

    /**
     * @param nomeProd the nomeProd to set
     */
    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    /**
     * @return the valorProd
     */
    public Double getValorProd() {
        return valorProd;
    }

    /**
     * @param valorProd the valorProd to set
     */
    public void setValorProd(Double valorProd) {
        this.valorProd = valorProd;
    }

    /**
     * @return the estoqProd
     */
    public int getEstoqProd() {
        return estoqProd;
    }

    /**
     * @param estoqProd the estoqProd to set
     */
    public void setEstoqProd(int estoqProd) {
        this.estoqProd = estoqProd;
    }
}
