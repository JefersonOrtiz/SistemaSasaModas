/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexoes.ConexaoMySql;
import java.util.ArrayList;
import model.ModelClientes;
import model.ModelVendas;
import model.ModelVendasCliente;

/**
 *
 * @author Jeferson
 */
public class DAOVendasCliente extends ConexaoMySql {

    public ArrayList<ModelVendasCliente> getListaVendasClienteDAO() {

        ArrayList<ModelVendasCliente> listaModelVendasClientes = new ArrayList();
        ModelVendas modelVendas = new ModelVendas();
        ModelClientes modelClientes = new ModelClientes();
        ModelVendasCliente modelVendasCliente = new ModelVendasCliente();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "tbl_vendas.pk_id_venda,"
                    + "tbl_vendas.fk_cliente,"
                    + "tbl_vendas.data_venda,"
                    + "tbl_vendas.vlr_liq_venda,"
                    + "tbl_vendas.vlr_brt_venda,"
                    + "tbl_vendas.desc_venda,"
                    + "tbl_clientes.pk_id_cliente,"
                    + "tbl_clientes.nome_cliente,"
                    + "tbl_clientes.endereco_cliente,"
                    + "tbl_clientes.bairro_cliente,"
                    + "tbl_clientes.cidade_cliente,"
                    + "tbl_clientes.uf_cliente,"
                    + "tbl_clientes.cep_cliente,"
                    + "tbl_clientes.tel_cliente"
                    + " FROM "
                        + " tbl_vendas INNER JOIN tbl_clientes "
                            + " ON tbl_clientes.pk_id_cliente = tbl_vendas.fk_cliente; "
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelVendas = new ModelVendas();
                modelClientes = new ModelClientes();
                modelVendasCliente = new ModelVendasCliente();
                // Venda
                modelVendas.setIdVenda(this.getResultSet().getInt(1));
                modelVendas.setCliente(this.getResultSet().getInt(2));
                modelVendas.setDataVenda(this.getResultSet().getDate(3));
                modelVendas.setVlrLiqVenda(this.getResultSet().getDouble(4));
                modelVendas.setVlrBrtVenda(this.getResultSet().getDouble(5));
                modelVendas.setDescVenda(this.getResultSet().getDouble(6));
                // Cliente
                modelClientes.setIdCliente(this.getResultSet().getInt(7));
                modelClientes.setNomeCliente(this.getResultSet().getString(8));
                modelClientes.setEnderecoCliente(this.getResultSet().getString(9));
                modelClientes.setBairroCliente(this.getResultSet().getString(10));
                modelClientes.setCidadeCliente(this.getResultSet().getString(11));
                modelClientes.setUfCliente(this.getResultSet().getString(12));
                modelClientes.setCepCliente(this.getResultSet().getString(13));
                modelClientes.setTelCliente(this.getResultSet().getString(14));
                
                modelVendasCliente.setModelVendas(modelVendas);
                modelVendasCliente.setModelClientes(modelClientes);
                
                listaModelVendasClientes.add(modelVendasCliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaModelVendasClientes;
    }
}
