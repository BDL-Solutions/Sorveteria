package br.com.DTO;

public class CartDTO {
    private int idCliente;
    private int idProduto;
    private int quantidade;
    private String valor;
    private String nomeProduto;

    // Construtores

    public CartDTO() {
    }

 //   public CartDTO(int idCliente, int idProduto, int quantidade, String valor, String nomeProduto) {
     //   this.idCliente = idCliente;
       // this.idProduto = idProduto;
      //  this.quantidade = quantidade;
      //  this.valor = valor;
      //  this.nomeProduto = nomeProduto;
  //  }

    // Getters e Setters

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int i) {
        this.idProduto = i;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
}
