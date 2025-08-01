package org.example.dto;

import org.example.entities.ItemVenda;
import org.example.entities.Venda;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VendaDTO {

    private Long vendaId;

    @NotBlank
    private String vendaCodigo;

    private LocalDateTime vendaData;

    @NotNull
    private Long cliId;

    @NotNull
    private Long fpgId;

    @NotNull @Digits(integer = 10, fraction = 2)
    private BigDecimal vendaValorTotal;

    @NotEmpty
    private List<CompraDTO> compras;

    public VendaDTO() {
    }

    public Long getVendaId() {
        return vendaId;
    }

    public void setVendaId(Long vendaId) {
        this.vendaId = vendaId;
    }

    public String getVendaCodigo() {
        return vendaCodigo;
    }

    public void setVendaCodigo(String vendaCodigo) {
        this.vendaCodigo = vendaCodigo;
    }

    public LocalDateTime getVendaData() {
        return vendaData;
    }

    public void setVendaData(LocalDateTime vendaData) {
        this.vendaData = vendaData;
    }

    public Long getCliId() {
        return cliId;
    }

    public void setCliId(Long cliId) {
        this.cliId = cliId;
    }

    public Long getFpgId() {
        return fpgId;
    }

    public void setFpgId(Long fpgId) {
        this.fpgId = fpgId;
    }

    public BigDecimal getVendaValorTotal() {
        return vendaValorTotal;
    }

    public void setVendaValorTotal(BigDecimal vendaValorTotal) {
        this.vendaValorTotal = vendaValorTotal;
    }

    public List<CompraDTO> getCompras() {
        return compras;
    }

    public void setCompras(List<CompraDTO> compras) {
        this.compras = compras;
    }

    public static VendaDTO fromEntity(Venda venda) {
        VendaDTO dto = new VendaDTO();
        dto.setVendaId(venda.getVendaId());
        dto.setVendaCodigo(venda.getVendaCodigo());
        dto.setVendaData(venda.getVendaData());
        dto.setCliId(venda.getCliente().getCliId());  // Corrigido
        dto.setFpgId(venda.getFormaPagamento().getFpgId());  // Corrigido
        dto.setVendaValorTotal(venda.getVendaValorTotal());

        List<CompraDTO> comprasDto = new ArrayList<>();
        for (ItemVenda item : venda.getItens()) {
            CompraDTO compraDto = new CompraDTO();
            compraDto.setProId(item.getProduto().getProId());
            compraDto.setCompraQuantidade(item.getCompraQuantidade());
            compraDto.setCompraPrecoVenda(item.getCompraPrecoVenda());
            comprasDto.add(compraDto);
        }
        dto.setCompras(comprasDto);

        return dto;
    }
}