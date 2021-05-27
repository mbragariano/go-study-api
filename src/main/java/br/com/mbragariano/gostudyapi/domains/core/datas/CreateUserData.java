package br.com.mbragariano.gostudyapi.domains.core.datas;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class CreateUserData {

  public String id;

	public String name;

	public String email;

	public String password;

	public String type;

}
