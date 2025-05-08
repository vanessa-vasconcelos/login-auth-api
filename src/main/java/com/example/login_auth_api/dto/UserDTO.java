package com.example.login_auth_api.dto;

public class UserDTO {
  String nome;
  String email;

  public UserDTO() {

  }

  public UserDTO(String nome, String email) {
    this.nome = nome;
    this.email = email;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

}
