package org.example.services;

import org.example.entities.Produto;
import org.example.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    // Criar Produto
    public Produto createProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    // Buscar todos os produtos
    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    // Buscar Produto por ID
    public Produto getProdutoById(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.orElse(null);
    }

    // Atualizar Produto
    public Produto updateProduto(Long id, Produto produto) {
        Optional<Produto> existingProduto = produtoRepository.findById(id);
        if (existingProduto.isPresent()) {
            Produto updatedProduto = existingProduto.get();
            updatedProduto.setProNome(produto.getProNome());
            updatedProduto.setProDescricao(produto.getProDescricao());
            updatedProduto.setProPrecoCusto(produto.getProPrecoCusto());
            updatedProduto.setProPrecoVenda(produto.getProPrecoVenda());
            updatedProduto.setProQuantidadeEstoque(produto.getProQuantidadeEstoque());
            updatedProduto.setProCategoria(produto.getProCategoria());
            updatedProduto.setProCodigoDeBarras(produto.getProCodigoDeBarras());
            updatedProduto.setProMarca(produto.getProMarca());
            updatedProduto.setProUnidadeMedida(produto.getProUnidadeMedida());
            updatedProduto.setProAtivo(produto.getProAtivo());
            updatedProduto.setProDataCadastro(produto.getProDataCadastro()); // Opcional: Pode deixar sem alteração
            updatedProduto.setProDataAtualizacao(produto.getProDataAtualizacao()); // Atualiza a data
            return produtoRepository.save(updatedProduto);
        }
        return null;
    }

    // Deletar Produto
    public boolean deleteProduto(Long id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
