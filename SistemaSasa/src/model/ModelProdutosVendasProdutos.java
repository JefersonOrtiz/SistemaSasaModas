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
public class ModelProdutosVendasProdutos {
    
    private ModelProdutos modelProdutos;
    private ModelVendaProdutos modelVendaProdutos;

    /**
     * @return the modelProdutos
     */
    public ModelProdutos getModelProdutos() {
        return modelProdutos;
    }

    /**
     * @param modelProdutos the modelProdutos to set
     */
    public void setModelProdutos(ModelProdutos modelProdutos) {
        this.modelProdutos = modelProdutos;
    }

    /**
     * @return the modelVendaProdutos
     */
    public ModelVendaProdutos getModelVendaProdutos() {
        return modelVendaProdutos;
    }

    /**
     * @param modelVendaProdutos the modelVendaProdutos to set
     */
    public void setModelVendaProdutos(ModelVendaProdutos modelVendaProdutos) {
        this.modelVendaProdutos = modelVendaProdutos;
    }
}
