package me.dio.academia.digital.entity.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class RegistrationForm {

  @NotNull(message = "insira o id corretamente")
  @Positive(message = "O ID precisa ser um número positivo")
  private Long studentId;

}
