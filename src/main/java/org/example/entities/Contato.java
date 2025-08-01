package org.example.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.entities.Cliente;
import org.example.entities.Fornecedor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Contato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CON_ID")
    private Long conId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "CON_CLI_ID")
    private Cliente conCliente;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "CON_FOR_ID")
    private Fornecedor conFornecedor;

    @NotBlank(message = "celular é obrigatório")
    @Size(max = 17, message = "celular deve ter no máximo 14 caracteres")
    @Column(name = "CON_CELULAR", length = 17)
    private String conCelular;

    @NotBlank(message = "telefone comercial é obrigatório")
    @Size(max = 17, message = "telefone comercial deve ter no máximo 14 caracteres")
    @Column(name = "CON_TELEFONE_COMERCIAL", length = 17)
    private String conTelefoneComercial;

    @NotBlank(message = "email é obrigatório")
    @Email(message = "email inválido")
    @Size(max = 100, message = "email deve ter no máximo 100 caracteres")
    @Column(name = "CON_EMAIL", length = 100)
    private String conEmail;

    // Construtor vazio obrigatório
    public Contato() {
    }

    // Construtor com parâmetros para facilitar a criação do objeto
    public Contato(Long conId, Cliente conCliente, Fornecedor conFornecedor,
                   String conCelular, String conTelefoneComercial, String conEmail) {
        this.conId = conId;
        this.conCliente = conCliente;
        this.conFornecedor = conFornecedor;
        this.conCelular = conCelular;
        this.conTelefoneComercial = conTelefoneComercial;
        this.conEmail = conEmail;
    }

    // Getters e Setters
    public Long getConId() {
        return conId;
    }

    public void setConId(Long conId) {
        this.conId = conId;
    }

    public Cliente getConCliente() {
        return conCliente;
    }

    public void setConCliente(Cliente conCliente) {
        this.conCliente = conCliente;
    }

    public Fornecedor getConFornecedor() {
        return conFornecedor;
    }

    public void setConFornecedor(Fornecedor conFornecedor) {
        this.conFornecedor = conFornecedor;
    }

    public String getConCelular() {
        return conCelular;
    }

    public void setConCelular(String conCelular) {
        this.conCelular = conCelular;
    }

    public String getConTelefoneComercial() {
        return conTelefoneComercial;
    }

    public void setConTelefoneComercial(String conTelefoneComercial) {
        this.conTelefoneComercial = conTelefoneComercial;
    }

    public String getConEmail() {
        return conEmail;
    }

    public void setConEmail(String conEmail) {
        this.conEmail = conEmail;
    }
}
