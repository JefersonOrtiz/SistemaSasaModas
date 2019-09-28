package model;
/**
*
* @author Jeferson Ortiz
*/
public class ModelClientes {

    private int idCliente;
    private String nomeCliente;
    private String enderecoCliente;
    private String bairroCliente;
    private String cidadeCliente;
    private String ufCliente;
    private String cepCliente;
    private String telCliente;

    /**
    * Construtor
    */
    public ModelClientes(){}

    /**
    * seta o valor de idCliente
    * @param pIdCliente
    */
    public void setIdCliente(int pIdCliente){
        this.idCliente = pIdCliente;
    }
    /**
    * return pk_idCliente
    */
    public int getIdCliente(){
        return this.idCliente;
    }

    /**
    * seta o valor de nomeCliente
    * @param pNomeCliente
    */
    public void setNomeCliente(String pNomeCliente){
        this.nomeCliente = pNomeCliente;
    }
    /**
    * return nomeCliente
    */
    public String getNomeCliente(){
        return this.nomeCliente;
    }

    /**
    * seta o valor de enderecoCliente
    * @param pEnderecoCliente
    */
    public void setEnderecoCliente(String pEnderecoCliente){
        this.enderecoCliente = pEnderecoCliente;
    }
    /**
    * return enderecoCliente
    */
    public String getEnderecoCliente(){
        return this.enderecoCliente;
    }

    /**
    * seta o valor de bairroCliente
    * @param pBairroCliente
    */
    public void setBairroCliente(String pBairroCliente){
        this.bairroCliente = pBairroCliente;
    }
    /**
    * return bairroCliente
    */
    public String getBairroCliente(){
        return this.bairroCliente;
    }

    /**
    * seta o valor de cidadeCliente
    * @param pCidadeCliente
    */
    public void setCidadeCliente(String pCidadeCliente){
        this.cidadeCliente = pCidadeCliente;
    }
    /**
    * return cidadeCliente
    */
    public String getCidadeCliente(){
        return this.cidadeCliente;
    }

    /**
    * seta o valor de ufCliente
    * @param pUfCliente
    */
    public void setUfCliente(String pUfCliente){
        this.ufCliente = pUfCliente;
    }
    /**
    * return ufCliente
    */
    public String getUfCliente(){
        return this.ufCliente;
    }

    /**
    * seta o valor de cepCliente
    * @param pCepCliente
    */
    public void setCepCliente(String pCepCliente){
        this.cepCliente = pCepCliente;
    }
    /**
    * return cepCliente
    */
    public String getCepCliente(){
        return this.cepCliente;
    }

    /**
    * seta o valor de telCliente
    * @param pTelCliente
    */
    public void setTelCliente(String pTelCliente){
        this.telCliente = pTelCliente;
    }
    /**
    * return telCliente
    */
    public String getTelCliente(){
        return this.telCliente;
    }

    @Override
    public String toString(){
        return "ModelClientes {" + "::idCliente = " + this.idCliente + "::nomeCliente = " + this.nomeCliente + "::enderecoCliente = " + this.enderecoCliente + "::bairroCliente = " + this.bairroCliente + "::cidadeCliente = " + this.cidadeCliente + "::ufCliente = " + this.ufCliente + "::cepCliente = " + this.cepCliente + "::telCliente = " + this.telCliente +  "}";
    }
}