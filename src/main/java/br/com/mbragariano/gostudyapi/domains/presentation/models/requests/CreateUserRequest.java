package br.com.mbragariano.gostudyapi.domains.presentation.models.requests;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateUserRequest {

  public String name;

  public String email;

  public String password;

  public String type;

}
