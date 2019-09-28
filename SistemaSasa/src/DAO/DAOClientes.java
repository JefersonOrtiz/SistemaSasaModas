package DAO;

import model.ModelClientes;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Jeferson Ortiz
*/
public class DAOClientes extends ConexaoMySql {

    /**
    * grava Clientes
    * @param pModelClientes
    * return int
    */
    public int salvarClientesDAO(ModelClientes pModelClientes){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO tbl_clientes ("
                    + "nome_cliente,"
                    + "endereco_cliente,"
                    + "bairro_cliente,"
                    + "cidade_cliente,"
                    + "uf_cliente,"
                    + "cep_cliente,"
                    + "tel_cliente"
                + ") VALUES ("
                    + "'" + pModelClientes.getNomeCliente() + "',"
                    + "'" + pModelClientes.getEnderecoCliente() + "',"
                    + "'" + pModelClientes.getBairroCliente() + "',"
                    + "'" + pModelClientes.getCidadeCliente() + "',"
                    + "'" + pModelClientes.getUfCliente() + "',"
                    + "'" + pModelClientes.getCepCliente() + "',"
                    + "'" + pModelClientes.getTelCliente() + "'"
                + ");"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * recupera Clientes
    * @param pIdCliente
    * return ModelClientes
    */
    public ModelClientes getClientesDAO(int pIdCliente){
        ModelClientes modelClientes = new ModelClientes();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_id_cliente,"
                    + "nome_cliente,"
                    + "endereco_cliente,"
                    + "bairro_cliente,"
                    + "cidade_cliente,"
                    + "uf_cliente,"
                    + "cep_cliente,"
                    + "tel_cliente"
                 + " FROM"
                     + " tbl_clientes"
                 + " WHERE"
                     + " pk_id_cliente = '" + pIdCliente + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelClientes.setIdCliente(this.getResultSet().getInt(1));
                modelClientes.setNomeCliente(this.getResultSet().getString(2));
                modelClientes.setEnderecoCliente(this.getResultSet().getString(3));
                modelClientes.setBairroCliente(this.getResultSet().getString(4));
                modelClientes.setCidadeCliente(this.getResultSet().getString(5));
                modelClientes.setUfCliente(this.getResultSet().getString(6));
                modelClientes.setCepCliente(this.getResultSet().getString(7));
                modelClientes.setTelCliente(this.getResultSet().getString(8));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelClientes;
    }

    /**
    * recupera uma lista de Clientes
        * return ArrayList
    */
    public ArrayList<ModelClientes> getListaClientesDAO(){
        ArrayList<ModelClientes> listamodelClientes = new ArrayList();
        ModelClientes modelClientes = new ModelClientes();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_id_cliente,"
                    + "nome_cliente,"
                    + "endereco_cliente,"
                    + "bairro_cliente,"
                    + "cidade_cliente,"
                    + "uf_cliente,"
                    + "cep_cliente,"
                    + "tel_cliente"
                 + " FROM"
                     + " tbl_clientes"
                + ";"
            );

            while(this.getResultSet().next()){
                modelClientes = new ModelClientes();
                modelClientes.setIdCliente(this.getResultSet().getInt(1));
                modelClientes.setNomeCliente(this.getResultSet().getString(2));
                modelClientes.setEnderecoCliente(this.getResultSet().getString(3));
                modelClientes.setBairroCliente(this.getResultSet().getString(4));
                modelClientes.setCidadeCliente(this.getResultSet().getString(5));
                modelClientes.setUfCliente(this.getResultSet().getString(6));
                modelClientes.setCepCliente(this.getResultSet().getString(7));
                modelClientes.setTelCliente(this.getResultSet().getString(8));
                listamodelClientes.add(modelClientes);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelClientes;
    }

    /**
    * atualiza Clientes
    * @param pModelClientes
    * return boolean
    */
    public boolean atualizarClientesDAO(ModelClientes pModelClientes){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE tbl_clientes SET "
                    + "pk_id_cliente = '" + pModelClientes.getIdCliente() + "',"
                    + "nome_cliente = '" + pModelClientes.getNomeCliente() + "',"
                    + "endereco_cliente = '" + pModelClientes.getEnderecoCliente() + "',"
                    + "bairro_cliente = '" + pModelClientes.getBairroCliente() + "',"
                    + "cidade_cliente = '" + pModelClientes.getCidadeCliente() + "',"
                    + "uf_cliente = '" + pModelClientes.getUfCliente() + "',"
                    + "cep_cliente = '" + pModelClientes.getCepCliente() + "',"
                    + "tel_cliente = '" + pModelClientes.getTelCliente() + "'"
                + " WHERE "
                    + "pk_id_cliente = '" + pModelClientes.getIdCliente() + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * exclui Clientes
    * @param pIdCliente
    * return boolean
    */
    public boolean excluirClientesDAO(int pIdCliente){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM tbl_clientes "
                + " WHERE "
                    + "pk_id_cliente = '" + pIdCliente + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }
}