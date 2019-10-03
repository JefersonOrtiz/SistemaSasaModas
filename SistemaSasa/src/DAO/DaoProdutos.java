/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexoes.ConexaoMySql;
import java.util.ArrayList;
import model.ModelProdutos;

/**
 *
 * @author Aula
 */
public class DaoProdutos extends ConexaoMySql {

    /**
     * Cadastrar um produto no banco
     *
     * @param pModelProdutos
     * @return
     */
    public int salvarProdutosDAO(ModelProdutos pModelProdutos) {
        try {
            this.conectar();
            return this.insertSQL("INSERT INTO tbl_produtos ("
                    + "nm_produto,"
                    + "vlr_produto,"
                    + "estq_produto"
                    + ") VALUES ("
                    + "'" + pModelProdutos.getNomeProd()+ "',"
                    + "'" + pModelProdutos.getValorProd()+ "',"
                    + "'" + pModelProdutos.getEstoqProd()+ "'"
                    + ");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * Excluir um produto do banco
     *
     * @param pIdProduto
     * @return boolean
     */
    public boolean excluirProdutoDAO(int pIdProduto) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM tbl_produtos WHERE pk_id_produto = '" + pIdProduto + "'"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * Alterar dados do produtos
     *
     * @param pModelProdutos
     * @return boolean
     */
    public boolean alterarProdutoDAO(ModelProdutos pModelProdutos) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE tbl_produtos SET "
                    + "nm_produto = '" + pModelProdutos.getNomeProd()+ "',"
                    + "vlr_produto = '" + pModelProdutos.getValorProd()+ "',"
                    + "estq_produto = '" + pModelProdutos.getEstoqProd()+ "'"
                    + " WHERE pk_id_produto = '" + pModelProdutos.getIdProduto() + "'"
            );

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }

    }

    /**
     * retornar um produto pelo codigo
     *
     * @param pIdProduto
     * @return modelproduto
     */
    public ModelProdutos retornarProdutoDAO(int pIdProduto) {
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "pk_id_produto, "
                    + "nm_produto,"
                    + "vlr_produto,"
                    + "estq_produto "
                    + "FROM tbl_produtos WHERE pk_id_produto = '" + pIdProduto + "';");
            while (this.getResultSet().next()) {
                modelProdutos.setIdProduto(this.getResultSet().getInt(1));
                modelProdutos.setNomeProd(this.getResultSet().getString(2));
                modelProdutos.setValorProd(this.getResultSet().getDouble(3));
                modelProdutos.setEstoqProd(this.getResultSet().getInt(4));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelProdutos;
    }

    /**
     * retornar um produto pelo nome
     *
     * @param pNomeProd
     * @return modelproduto
     */
    public ModelProdutos retornarProdutoDAO(String pNomeProd) {
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "pk_id_produto, "
                    + "nm_produto,"
                    + "vlr_produto,"
                    + "estq_produto "
                    + "FROM tbl_produtos WHERE nm_produto = '" + pNomeProd + "';");
            while (this.getResultSet().next()) {
                modelProdutos.setIdProduto(this.getResultSet().getInt(1));
                modelProdutos.setNomeProd(this.getResultSet().getString(2));
                modelProdutos.setValorProd(this.getResultSet().getDouble(3));
                modelProdutos.setEstoqProd(this.getResultSet().getInt(4));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelProdutos;
    }

    /**
     * Retornar uma lista completa de produtos
     *
     * @return listaModelProdutos
     */
    public ArrayList<ModelProdutos> retornarListaProdutosDAO() {
        ArrayList<ModelProdutos> listaModelProdutos = new ArrayList<>();
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "pk_id_produto, "
                    + "nm_produto,"
                    + "vlr_produto,"
                    + "estq_produto "
                    + "FROM tbl_produtos;");

            while (this.getResultSet().next()) {
                modelProdutos = new ModelProdutos();
                modelProdutos.setIdProduto(this.getResultSet().getInt(1));
                modelProdutos.setNomeProd(this.getResultSet().getString(2));
                modelProdutos.setValorProd(this.getResultSet().getDouble(3));
                modelProdutos.setEstoqProd(this.getResultSet().getInt(4));
                listaModelProdutos.add(modelProdutos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaModelProdutos;
    }

    /**
     * Alterar estoque de produtos no banco
     * @param pListaModelProdutoses
     * @return 
     */
    public boolean alterarEstoqueProdutosDAO(ArrayList<ModelProdutos> pListaModelProdutoses) {
        try {
            this.conectar();
            for (int i = 0; i < pListaModelProdutoses.size(); i++) {
                this.executarUpdateDeleteSQL(
                        "UPDATE tbl_produtos SET "
                        + "estq_produto = '" + pListaModelProdutoses.get(i).getEstoqProd()+ "'"
                        + " WHERE pk_id_produto = '" + pListaModelProdutoses.get(i).getIdProduto() + "'"
                );
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

}

