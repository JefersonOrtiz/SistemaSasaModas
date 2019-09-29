package DAO;

import model.ModelVendas;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Jeferson
*/
public class DAOVendas extends ConexaoMySql {

    /**
    * grava Vendas
    * @param pModelVendas
    * return int
    */
    public int salvarVendasDAO(ModelVendas pModelVendas){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO tbl_vendas ("
                    + "fk_cliente,"
                    + "data_venda,"
                    + "vlr_liq_venda,"
                    + "vlr_brt_venda,"
                    + "desc_venda"
                + ") VALUES ("
                    + "'" + pModelVendas.getCliente() + "',"
                    + "'" + pModelVendas.getDataVenda() + "',"
                    + "'" + pModelVendas.getVlrLiqVenda() + "',"
                    + "'" + pModelVendas.getVlrBrtVenda() + "',"
                    + "'" + pModelVendas.getDescVenda() + "'"
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
    * recupera Vendas
    * @param pIdVenda
    * return ModelVendas
    */
    public ModelVendas getVendasDAO(int pIdVenda){
        ModelVendas modelVendas = new ModelVendas();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_id_venda,"
                    + "fk_cliente,"
                    + "data_venda,"
                    + "vlr_liq_venda,"
                    + "vlr_brt_venda,"
                    + "desc_venda"
                 + " FROM"
                     + " tbl_vendas"
                 + " WHERE"
                     + " pk_id_venda = '" + pIdVenda + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVendas.setIdVenda(this.getResultSet().getInt(1));
                modelVendas.setCliente(this.getResultSet().getInt(2));
                modelVendas.setDataVenda(this.getResultSet().getDate(3));
                modelVendas.setVlrLiqVenda(this.getResultSet().getDouble(4));
                modelVendas.setVlrBrtVenda(this.getResultSet().getDouble(5));
                modelVendas.setDescVenda(this.getResultSet().getDouble(6));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelVendas;
    }

    /**
    * recupera uma lista de Vendas
        * return ArrayList
    */
    public ArrayList<ModelVendas> getListaVendasDAO(){
        ArrayList<ModelVendas> listamodelVendas = new ArrayList();
        ModelVendas modelVendas = new ModelVendas();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_id_venda,"
                    + "fk_cliente,"
                    + "data_venda,"
                    + "vlr_liq_venda,"
                    + "vlr_brt_venda,"
                    + "desc_venda"
                 + " FROM"
                     + " tbl_vendas"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVendas = new ModelVendas();
                modelVendas.setIdVenda(this.getResultSet().getInt(1));
                modelVendas.setCliente(this.getResultSet().getInt(2));
                modelVendas.setDataVenda(this.getResultSet().getDate(3));
                modelVendas.setVlrLiqVenda(this.getResultSet().getDouble(4));
                modelVendas.setVlrBrtVenda(this.getResultSet().getDouble(5));
                modelVendas.setDescVenda(this.getResultSet().getDouble(6));
                listamodelVendas.add(modelVendas);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelVendas;
    }

    /**
    * atualiza Vendas
    * @param pModelVendas
    * return boolean
    */
    public boolean atualizarVendasDAO(ModelVendas pModelVendas){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE tbl_vendas SET "
                    + "pk_id_venda = '" + pModelVendas.getIdVenda() + "',"
                    + "fk_cliente = '" + pModelVendas.getCliente() + "',"
                    + "data_venda = '" + pModelVendas.getDataVenda() + "',"
                    + "vlr_liq_venda = '" + pModelVendas.getVlrLiqVenda() + "',"
                    + "vlr_brt_venda = '" + pModelVendas.getVlrBrtVenda() + "',"
                    + "desc_venda = '" + pModelVendas.getDescVenda() + "'"
                + " WHERE "
                    + "pk_id_venda = '" + pModelVendas.getIdVenda() + "'"
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
    * exclui Vendas
    * @param pIdVenda
    * return boolean
    */
    public boolean excluirVendasDAO(int pIdVenda){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM tbl_vendas "
                + " WHERE "
                    + "pk_id_venda = '" + pIdVenda + "'"
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