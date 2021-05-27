package br.com.mbragariano.gostudyapi.domains.application.models.input;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class CreateUserInput {

  public String name;

  public String email;

  public String password;

  public String type;

}
