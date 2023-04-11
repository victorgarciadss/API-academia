package me.dio.academia.digital.entity.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentForm {

  @NotEmpty(message = "insira o nome corretamente")
  @Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
  private String name;

  @NotEmpty(message = "insira o cpf corretamente")
  private String cpf;

  @NotEmpty(message = "insira o bairro corretamente")
  @Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
  private String neighborhood;

  @NotNull(message = "insira a data de nascimento corretamente")
  @Past(message = "Data '${validatedValue}'' é inválida.")
  private LocalDate bornDate;
}
