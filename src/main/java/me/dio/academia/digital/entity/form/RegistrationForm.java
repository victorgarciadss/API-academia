package me.dio.academia.digital.entity.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationForm {

  @NotNull(message = "insira o id corretamente")
  @Positive(message = "O ID precisa ser um número positivo")
  private Long studentId;

}
