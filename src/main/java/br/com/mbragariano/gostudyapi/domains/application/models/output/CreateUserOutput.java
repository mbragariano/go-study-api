package br.com.mbragariano.gostudyapi.domains.application.models.output;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class CreateUserOutput {

  public String id;

  public String name;

  public String email;

  public String password;

  public String type;

}
