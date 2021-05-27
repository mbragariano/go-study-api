package br.com.mbragariano.gostudyapi.domains.persistence.schemas;

import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@NoArgsConstructor
@Table(name = UserSchema.NAME)
@Entity(name = UserSchema.NAME)
public class UserSchema {

  public static final String NAME = "usuario";

  @Id
  @Type(type = "pg-uuid")
  public UUID id;

  @Column(name = "nome", nullable = false)
  public String name;

  @Column(unique = true, nullable = false)
  public String email;

  @Column(name = "senha", nullable = false)
  public String password;

  @Column(name = "tipo", nullable = false)
  public String type;

  @Builder
  public UserSchema(
    UUID id,
    String name,
    String email,
    String password,
    String type
  ) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
    this.type = type;
  }

}
