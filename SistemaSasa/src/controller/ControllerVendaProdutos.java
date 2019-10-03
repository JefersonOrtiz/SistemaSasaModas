package controller;

import model.ModelVendaProdutos;
import DAO.DAOVendaProdutos;
import java.util.ArrayList;

/**
*
* @author Jeferson
*/
public class ControllerVendaProdutos {

    private DAOVendaProdutos daoVendaProdutos = new DAOVendaProdutos();

    /**
    * grava VendaProdutos
    * @param pModelVendaProdutos
    * return int
    */
    public int salvarVendaProdutosController(ModelVendaProdutos pModelVendaProdutos){
        return this.daoVendaProdutos.salvarVendaProdutosDAO(pModelVendaProdutos);
    }

    /**
    * recupera VendaProdutos
    * @param pIdVendaProduto
    * return ModelVendaProdutos
    */
    public ModelVendaProdutos getVendaProdutosController(int pIdVendaProduto){
        return this.daoVendaProdutos.getVendaProdutosDAO(pIdVendaProduto);
    }

    /**
    * recupera uma lista deVendaProdutos
    * @param pIdVendaProduto
    * return ArrayList
    */
    public ArrayList<ModelVendaProdutos> getListaVendaProdutosController(){
        return this.daoVendaProdutos.getListaVendaProdutosDAO();
    }

    /**
    * atualiza VendaProdutos
    * @param pModelVendaProdutos
    * return boolean
    */
    public boolean atualizarVendaProdutosController(ModelVendaProdutos pModelVendaProdutos){
        return this.daoVendaProdutos.atualizarVendaProdutosDAO(pModelVendaProdutos);
    }

    /**
    * exclui VendaProdutos
    * @param pIdVendaProduto
    * return boolean
    */
    public boolean excluirVendaProdutosController(int pIdVendaProduto){
        return this.daoVendaProdutos.excluirVendaProdutosDAO(pIdVendaProduto);
    }
    
    /**
     * Salva uma lista baixa no estoque
     * @param pListaModelVendaProdutoses
     * @return 
     */
    public boolean salvarVendaProdutosController(ArrayList<ModelVendaProdutos> pListaModelVendaProdutoses) {
        return this.daoVendaProdutos.salvarVendaProdutosDAO(pListaModelVendaProdutoses);
    }
}