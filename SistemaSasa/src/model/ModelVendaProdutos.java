package model;
/**
*
* @author Jeferson
*/
public class ModelVendaProdutos {

    private int idVendaProduto;
    private int produto;
    private int vendas;
    private double vlrVendaProd;
    private int qtdVendaProd;

    /**
    * Construtor
    */
    public ModelVendaProdutos(){}

    /**
    * seta o valor de idVendaProduto
    * @param pIdVendaProduto
    */
    public void setIdVendaProduto(int pIdVendaProduto){
        this.idVendaProduto = pIdVendaProduto;
    }
    /**
    * return pk_idVendaProduto
    */
    public int getIdVendaProduto(){
        return this.idVendaProduto;
    }

    /**
    * seta o valor de produto
    * @param pProduto
    */
    public void setProduto(int pProduto){
        this.produto = pProduto;
    }
    /**
    * return fk_produto
    */
    public int getProduto(){
        return this.produto;
    }

    /**
    * seta o valor de vendas
    * @param pVendas
    */
    public void setVendas(int pVendas){
        this.vendas = pVendas;
    }
    /**
    * return fk_vendas
    */
    public int getVendas(){
        return this.vendas;
    }

    /**
    * seta o valor de vlrVendaProd
    * @param pVlrVendaProd
    */
    public void setVlrVendaProd(double pVlrVendaProd){
        this.vlrVendaProd = pVlrVendaProd;
    }
    /**
    * return vlrVendaProd
    */
    public double getVlrVendaProd(){
        return this.vlrVendaProd;
    }

    /**
    * seta o valor de qtdVendaProd
    * @param pQtdVendaProd
    */
    public void setQtdVendaProd(int pQtdVendaProd){
        this.qtdVendaProd = pQtdVendaProd;
    }
    /**
    * return qtdVendaProd
    */
    public int getQtdVendaProd(){
        return this.qtdVendaProd;
    }

    @Override
    public String toString(){
        return "ModelVendaProdutos {" + "::idVendaProduto = " + this.idVendaProduto + "::produto = " + this.produto + "::vendas = " + this.vendas + "::vlrVendaProd = " + this.vlrVendaProd + "::qtdVendaProd = " + this.qtdVendaProd +  "}";
    }
}