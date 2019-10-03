/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexoes.ConexaoMySql;
import java.util.ArrayList;
import model.ModelProdutos;
import model.ModelProdutosVendasProdutos;
import model.ModelVendaProdutos;

/**
 *
 * @author Jeferson
 */
public class DAOProdutosVendasProdutos extends ConexaoMySql {

    public ArrayList<ModelProdutosVendasProdutos> getListaProdutosVendasProdutosDAO(int pCodigoVenda) {

        ArrayList<ModelProdutosVendasProdutos> listaModelProdutosVendasProdutoses = new ArrayList<>();
        ModelProdutosVendasProdutos modelProdutosVendasProdutos = new ModelProdutosVendasProdutos();
        ModelProdutos modelProdutos = new ModelProdutos();
        ModelVendaProdutos modelVendaProdutos = new ModelVendaProdutos();

        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "tbl_produtos.pk_id_produto, "
                    + "tbl_produtos.estq_produto,"
                    + "tbl_produtos.nm_produto,"
                    + "tbl_produtos.vlr_produto,"
                    + "tbl_venda_produtos.fk_produto,"
                    + "tbl_venda_produtos.fk_vendas,"
                    + "tbl_venda_produtos.pk_id_venda_produto,"
                    + "tbl_venda_produtos.qtd_venda_prod,"
                    + "tbl_venda_produtos.vlr_venda_prod "
                    + "FROM tbl_venda_produtos INNER JOIN tbl_produtos "
                    + "ON tbl_produtos.pk_id_produto = tbl_venda_produtos.fk_produto "
                    + "WHERE tbl_venda_produtos.fk_vendas = '" + pCodigoVenda + "';");
            
            while (this.getResultSet().next()){
                modelProdutosVendasProdutos = new ModelProdutosVendasProdutos();
                modelProdutos = new ModelProdutos();
                modelVendaProdutos = new ModelVendaProdutos();
                // Produtos
                modelProdutos.setIdProduto(this.getResultSet().getInt(1));
                modelProdutos.setEstoqProd(this.getResultSet().getInt(2));
                modelProdutos.setNomeProd(this.getResultSet().getString(3));
                modelProdutos.setValorProd(this.getResultSet().getDouble(4));
                // Venda_produtos
                modelVendaProdutos.setProduto(this.getResultSet().getInt(5));
                modelVendaProdutos.setVendas(this.getResultSet().getInt(6));
                modelVendaProdutos.setIdVendaProduto(this.getResultSet().getInt(7));
                modelVendaProdutos.setQtdVendaProd(this.getResultSet().getInt(8));
                modelVendaProdutos.setVlrVendaProd(this.getResultSet().getDouble(9));
                
                modelProdutosVendasProdutos.setModelProdutos(modelProdutos);
                modelProdutosVendasProdutos.setModelVendaProdutos(modelVendaProdutos);
                
                listaModelProdutosVendasProdutoses.add(modelProdutosVendasProdutos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listaModelProdutosVendasProdutoses;
    }
}
