package org.example.services;

import org.example.dto.CompraDTO;
import org.example.dto.VendaDTO;
import org.example.entities.*;
import org.example.repositories.*;
import org.example.services.exeptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepo;

    @Autowired
    private ProdutoRepository produtoRepo;

    @Autowired
    private ClienteRepository clienteRepo;

    @Autowired
    private FormaPagamentoRepository formaPagamentoRepo;

    public Venda insert(VendaDTO dto) {
        Cliente cliente = clienteRepo.findById(dto.getCliId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));

        FormaPagamento formaPagamento = formaPagamentoRepo.findById(dto.getFpgId())
                .orElseThrow(() -> new ResourceNotFoundException("Forma de pagamento não encontrada"));

        Venda venda = new Venda();
        venda.setCliente(cliente);
        venda.setFormaPagamento(formaPagamento);
        venda.setVendaData(LocalDateTime.now());
        venda.setVendaCodigo(generateCodigoUnico());

        List<ItemVenda> compras = new ArrayList<>();
        BigDecimal total = BigDecimal.ZERO;

        for (CompraDTO item : dto.getCompras()) {
            Produto produto = produtoRepo.findById(item.getProId())
                    .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));

            BigDecimal subtotal = item.getCompraPrecoVenda()
                    .multiply(BigDecimal.valueOf(item.getCompraQuantidade()));
            total = total.add(subtotal);

            ItemVenda compra = new ItemVenda(); // ✅ Nome correto da entidade
            compra.setProduto(produto);
            compra.setCompraQuantidade(item.getCompraQuantidade());
            compra.setCompraPrecoVenda(item.getCompraPrecoVenda());
            compra.setVenda(venda);

            compras.add(compra);
        }

        venda.setItens(compras);
        venda.setVendaValorTotal(total);


        return vendaRepo.save(venda);
    }

    public VendaDTO toDTO(Venda venda) {
        // Aqui você pode montar a conversão de entidade para DTO, se quiser posso te ajudar com isso
        return new VendaDTO(); // Placeholder
    }

    private String generateCodigoUnico() {
        // Gera código no formato VXXXXX
        return "V" + (int)(Math.random() * 90000 + 10000);
    }
}