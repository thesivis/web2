package br.ufmt.web.curso;

public class Cliente {
  private int id;
  private String nome;

  public int getId(){
    return id;
  }
  public void setId(int id){
    this.id = id;
  }
  public String getNome(){
    if(nome == null){
      nome = "";
    }
    return nome;
  }
  public void setNome(String nome){
    this.nome = nome;
  }
}
