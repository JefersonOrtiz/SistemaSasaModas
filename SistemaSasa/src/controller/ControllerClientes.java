package controller;

import model.ModelClientes;
import DAO.DAOClientes;
import java.util.ArrayList;

/**
*
* @author Jeferson Ortiz
*/
public class ControllerClientes {

    private DAOClientes daoClientes = new DAOClientes();

    /**
    * grava Clientes
    * @param pModelClientes
    * return int
    */
    public int salvarClientesController(ModelClientes pModelClientes){
        return this.daoClientes.salvarClientesDAO(pModelClientes);
    }

    /**
    * recupera Clientes
    * @param pIdCliente
    * return ModelClientes
    */
    public ModelClientes getClientesController(int pIdCliente){
        return this.daoClientes.getClientesDAO(pIdCliente);
    }
    /**
    * recupera Clientes
    * @param pNomeCliente
    * return ModelClientes
    */
    public ModelClientes getClientesController(String pNomeCliente){
        return this.daoClientes.getClientesDAO(pNomeCliente);
    }
    /**
    * recupera uma lista deClientes
    * @param pIdCliente
    * return ArrayList
    */
    public ArrayList<ModelClientes> getListaClientesController(){
        return this.daoClientes.getListaClientesDAO();
    }

    /**
    * atualiza Clientes
    * @param pModelClientes
    * return boolean
    */
    public boolean atualizarClientesController(ModelClientes pModelClientes){
        return this.daoClientes.atualizarClientesDAO(pModelClientes);
    }

    /**
    * exclui Clientes
    * @param pIdCliente
    * return boolean
    */
    public boolean excluirClientesController(int pIdCliente){
        return this.daoClientes.excluirClientesDAO(pIdCliente);
    }
}