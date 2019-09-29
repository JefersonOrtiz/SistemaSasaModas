package model;

import java.sql.Date;

/**
*
* @author Jeferson
*/
public class ModelVendas {

    private int idVenda;
    private int cliente;
    private Date dataVenda;
    private double vlrLiqVenda;
    private double vlrBrtVenda;
    private double descVenda;

    /**
    * Construtor
    */
    public ModelVendas(){}

    /**
    * seta o valor de idVenda
    * @param pIdVenda
    */
    public void setIdVenda(int pIdVenda){
        this.idVenda = pIdVenda;
    }
    /**
    * return pk_idVenda
    */
    public int getIdVenda(){
        return this.idVenda;
    }

    /**
    * seta o valor de cliente
    * @param pCliente
    */
    public void setCliente(int pCliente){
        this.cliente = pCliente;
    }
    /**
    * return fk_cliente
    */
    public int getCliente(){
        return this.cliente;
    }

    /**
    * seta o valor de dataVenda
    * @param pDataVenda
    */
    public void setDataVenda(Date pDataVenda){
        this.dataVenda = pDataVenda;
    }
    /**
    * return dataVenda
    */
    public Date getDataVenda(){
        return this.dataVenda;
    }

    /**
    * seta o valor de vlrLiqVenda
    * @param pVlrLiqVenda
    */
    public void setVlrLiqVenda(double pVlrLiqVenda){
        this.vlrLiqVenda = pVlrLiqVenda;
    }
    /**
    * return vlrLiqVenda
    */
    public double getVlrLiqVenda(){
        return this.vlrLiqVenda;
    }

    /**
    * seta o valor de vlrBrtVenda
    * @param pVlrBrtVenda
    */
    public void setVlrBrtVenda(double pVlrBrtVenda){
        this.vlrBrtVenda = pVlrBrtVenda;
    }
    /**
    * return vlrBrtVenda
    */
    public double getVlrBrtVenda(){
        return this.vlrBrtVenda;
    }

    /**
    * seta o valor de descVenda
    * @param pDescVenda
    */
    public void setDescVenda(double pDescVenda){
        this.descVenda = pDescVenda;
    }
    /**
    * return descVenda
    */
    public double getDescVenda(){
        return this.descVenda;
    }

    @Override
    public String toString(){
        return "ModelVendas {" + "::idVenda = " + this.idVenda + "::cliente = " + this.cliente + "::dataVenda = " + this.dataVenda + "::vlrLiqVenda = " + this.vlrLiqVenda + "::vlrBrtVenda = " + this.vlrBrtVenda + "::descVenda = " + this.descVenda +  "}";
    }
}