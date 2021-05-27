package br.com.mbragariano.gostudyapi.domains.presentation.models.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class CreateUserResponse {

  public String id;

  public String name;

  public String email;

  public String password;

  public String type;

}
