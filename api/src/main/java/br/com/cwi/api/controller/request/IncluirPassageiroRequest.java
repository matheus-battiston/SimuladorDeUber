package br.com.cwi.api.controller.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class IncluirPassageiroRequest {

    @NotBlank(message = "Nome é um campo obrigatório")
    private String nome;

    @NotNull(message = "Data de nascimento é um campo obrigatório")
    private LocalDate dataNascimento;


    @NotBlank(message = "Cpf é um campo obrigatório")
    @CPF(message = "CPF invalido")
    private String cpf;

}
