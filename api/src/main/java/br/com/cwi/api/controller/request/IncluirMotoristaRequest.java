package br.com.cwi.api.controller.request;

import br.com.cwi.api.domain.Categoria;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter @Setter
public class IncluirMotoristaRequest {
    @NotBlank (message = "Nome deve estar preenchido")
    @Size(min = 3, max = 50, message = "Nome deve ter no minimo 3 caracteres e no maximo 50")
    private String nome;

    @NotNull(message = "Data de nascimento deve estar preenchido")
    private LocalDate dataNascimento;

    @CPF(message = " CPF invalido")
    @NotBlank(message = "CPF deve estar preenchido")
    private String cpf;

    @NotBlank(message = "Numero da habilitação deve estar preenchido")
    private String habilitacaoNumero;

    @NotNull(message = "Categoria deve estar preenchido")
    private Categoria habilitacaoCategoria;

    @NotNull(message = "Vencimento da habilitaçao deve estar preenchido")
    private LocalDate habilitacaoDataVencimento;

}
