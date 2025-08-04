package org.example.entities;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRO_ID")
    private Long proId;

    @NotBlank
    @Size(max = 100)
    @Column(name = "PRO_NOME")
    private String proNome;

    @Size(max = 255)
    @Column(name = "PRO_DESCRICAO")
    private String proDescricao;

    @NotNull
    @DecimalMin("0.00")
    @Digits(integer = 8, fraction = 2)
    @Column(name = "PRO_PRECO_CUSTO", precision = 10, scale = 2)
    private BigDecimal proPrecoCusto;

    @NotNull
    @DecimalMin("0.00")
    @Digits(integer = 8, fraction = 2)
    @Column(name = "PRO_PRECO_VENDA", precision = 10, scale = 2)
    private BigDecimal proPrecoVenda;

    @NotNull
    @Min(0)
    @Column(name = "PRO_QUANTIDADE_ESTOQUE")
    private Integer proQuantidadeEstoque;

    @NotBlank
    @Size(max = 50)
    @Column(name = "PRO_CATEGORIA")
    private String proCategoria;

    @NotBlank
    @Size(max = 20)
    @Column(name = "PRO_CODIGO_DE_BARRAS")
    private String proCodigoDeBarras;

    @NotBlank
    @Size(max = 50)
    @Column(name = "PRO_MARCA")
    private String proMarca;

    @NotBlank
    @Size(max = 10)
    @Column(name = "PRO_UNIDADE_MEDIDA")
    private String proUnidadeMedida;

    @NotNull
    @Column(name = "PRO_ATIVO")
    private Boolean proAtivo;

    @NotNull
    @Column(name = "PRO_DATA_CADASTRO")
    private LocalDateTime proDataCadastro;

    @NotNull
    @Column(name = "PRO_DATA_ATUALIZACAO")
    private LocalDateTime proDataAtualizacao;

    public Produto() {}

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public String getProNome() {
        return proNome;
    }

    public void setProNome(String proNome) {
        this.proNome = proNome;
    }

    public String getProDescricao() {
        return proDescricao;
    }

    public void setProDescricao(String proDescricao) {
        this.proDescricao = proDescricao;
    }

    public BigDecimal getProPrecoCusto() {
        return proPrecoCusto;
    }

    public void setProPrecoCusto(BigDecimal proPrecoCusto) {
        this.proPrecoCusto = proPrecoCusto;
    }

    public BigDecimal getProPrecoVenda() {
        return proPrecoVenda;
    }

    public void setProPrecoVenda(BigDecimal proPrecoVenda) {
        this.proPrecoVenda = proPrecoVenda;
    }

    public Integer getProQuantidadeEstoque() {
        return proQuantidadeEstoque;
    }

    public void setProQuantidadeEstoque(Integer proQuantidadeEstoque) {
        this.proQuantidadeEstoque = proQuantidadeEstoque;
    }

    public String getProCategoria() {
        return proCategoria;
    }

    public void setProCategoria(String proCategoria) {
        this.proCategoria = proCategoria;
    }

    public String getProCodigoDeBarras() {
        return proCodigoDeBarras;
    }

    public void setProCodigoDeBarras(String proCodigoDeBarras) {
        this.proCodigoDeBarras = proCodigoDeBarras;
    }

    public String getProMarca() {
        return proMarca;
    }

    public void setProMarca(String proMarca) {
        this.proMarca = proMarca;
    }

    public String getProUnidadeMedida() {
        return proUnidadeMedida;
    }

    public void setProUnidadeMedida(String proUnidadeMedida) {
        this.proUnidadeMedida = proUnidadeMedida;
    }

    public Boolean getProAtivo() {
        return proAtivo;
    }

    public void setProAtivo(Boolean proAtivo) {
        this.proAtivo = proAtivo;
    }

    public LocalDateTime getProDataCadastro() {
        return proDataCadastro;
    }

    public void setProDataCadastro(LocalDateTime proDataCadastro) {
        this.proDataCadastro = proDataCadastro;
    }

    public LocalDateTime getProDataAtualizacao() {
        return proDataAtualizacao;
    }

    public void setProDataAtualizacao(LocalDateTime proDataAtualizacao) {
        this.proDataAtualizacao = proDataAtualizacao;
    }
}
