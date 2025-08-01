package org.example.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long compraId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne(optional = false)
    @JoinColumn(name = "venda_id")
    private Venda venda;

    @Column(nullable = false)
    private Integer compraQuantidade;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal compraPrecoVenda;

    public ItemVenda() {
    }

    public Long getCompraId() {
        return compraId;
    }

    public void setCompraId(Long compraId) {
        this.compraId = compraId;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Integer getCompraQuantidade() {
        return compraQuantidade;
    }

    public void setCompraQuantidade(Integer compraQuantidade) {
        this.compraQuantidade = compraQuantidade;
    }

    public BigDecimal getCompraPrecoVenda() {
        return compraPrecoVenda;
    }

    public void setCompraPrecoVenda(BigDecimal compraPrecoVenda) {
        this.compraPrecoVenda = compraPrecoVenda;
    }
}
