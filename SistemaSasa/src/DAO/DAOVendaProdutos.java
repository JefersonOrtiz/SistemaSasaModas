package DAO;

import model.ModelVendaProdutos;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Jeferson
*/
public class DAOVendaProdutos extends ConexaoMySql {

    /**
    * grava VendaProdutos
    * @param pModelVendaProdutos
    * return int
    */
    public int salvarVendaProdutosDAO(ModelVendaProdutos pModelVendaProdutos){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO tbl_venda_produtos ("
                    + "fk_produto,"
                    + "fk_vendas,"
                    + "vlr_venda_prod,"
                    + "qtd_venda_prod"
                + ") VALUES ("
                    + "'" + pModelVendaProdutos.getProduto() + "',"
                    + "'" + pModelVendaProdutos.getVendas() + "',"
                    + "'" + pModelVendaProdutos.getVlrVendaProd() + "',"
                    + "'" + pModelVendaProdutos.getQtdVendaProd() + "'"
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
    * recupera VendaProdutos
    * @param pIdVendaProduto
    * return ModelVendaProdutos
    */
    public ModelVendaProdutos getVendaProdutosDAO(int pIdVendaProduto){
        ModelVendaProdutos modelVendaProdutos = new ModelVendaProdutos();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_id_venda_produto,"
                    + "fk_produto,"
                    + "fk_vendas,"
                    + "vlr_venda_prod,"
                    + "qtd_venda_prod"
                 + " FROM"
                     + " tbl_venda_produtos"
                 + " WHERE"
                     + " pk_id_venda_produto = '" + pIdVendaProduto + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVendaProdutos.setIdVendaProduto(this.getResultSet().getInt(1));
                modelVendaProdutos.setProduto(this.getResultSet().getInt(2));
                modelVendaProdutos.setVendas(this.getResultSet().getInt(3));
                modelVendaProdutos.setVlrVendaProd(this.getResultSet().getDouble(4));
                modelVendaProdutos.setQtdVendaProd(this.getResultSet().getInt(5));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelVendaProdutos;
    }

    /**
    * recupera uma lista de VendaProdutos
        * return ArrayList
    */
    public ArrayList<ModelVendaProdutos> getListaVendaProdutosDAO(){
        ArrayList<ModelVendaProdutos> listamodelVendaProdutos = new ArrayList();
        ModelVendaProdutos modelVendaProdutos = new ModelVendaProdutos();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_id_venda_produto,"
                    + "fk_produto,"
                    + "fk_vendas,"
                    + "vlr_venda_prod,"
                    + "qtd_venda_prod"
                 + " FROM"
                     + " tbl_venda_produtos"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVendaProdutos = new ModelVendaProdutos();
                modelVendaProdutos.setIdVendaProduto(this.getResultSet().getInt(1));
                modelVendaProdutos.setProduto(this.getResultSet().getInt(2));
                modelVendaProdutos.setVendas(this.getResultSet().getInt(3));
                modelVendaProdutos.setVlrVendaProd(this.getResultSet().getDouble(4));
                modelVendaProdutos.setQtdVendaProd(this.getResultSet().getInt(5));
                listamodelVendaProdutos.add(modelVendaProdutos);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelVendaProdutos;
    }

    /**
    * atualiza VendaProdutos
    * @param pModelVendaProdutos
    * return boolean
    */
    public boolean atualizarVendaProdutosDAO(ModelVendaProdutos pModelVendaProdutos){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE tbl_venda_produtos SET "
                    + "pk_id_venda_produto = '" + pModelVendaProdutos.getIdVendaProduto() + "',"
                    + "fk_produto = '" + pModelVendaProdutos.getProduto() + "',"
                    + "fk_vendas = '" + pModelVendaProdutos.getVendas() + "',"
                    + "vlr_venda_prod = '" + pModelVendaProdutos.getVlrVendaProd() + "',"
                    + "qtd_venda_prod = '" + pModelVendaProdutos.getQtdVendaProd() + "'"
                + " WHERE "
                    + "pk_id_venda_produto = '" + pModelVendaProdutos.getIdVendaProduto() + "'"
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
    * exclui VendaProdutos
    * @param pIdVendaProduto
    * return boolean
    */
    public boolean excluirVendaProdutosDAO(int pIdVendaProduto){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM tbl_venda_produtos "
                + " WHERE "
                    + "pk_id_venda_produto = '" + pIdVendaProduto + "'"
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