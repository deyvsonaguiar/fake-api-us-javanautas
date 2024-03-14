package com.deyvsonaguiar.fakeapius.business.services;

import com.deyvsonaguiar.fakeapius.infrastructure.entities.ProdutoEntity;
import com.deyvsonaguiar.fakeapius.infrastructure.repositories.IProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final IProdutoRepository repository;

    public ProdutoEntity salvarProduto(ProdutoEntity entity) {
        try{
            return repository.save(entity);
        } catch( Exception e) {
            throw new RuntimeException("Erro ao salvar produto.");
        }
    }

    public List<ProdutoEntity> buscarTodosProdutos() {
        try{
            return repository.findAll();
        } catch(Exception e) {
            throw new RuntimeException("Erro ao buscar produtos." + e);
        }
    }

    public boolean existsPorNome(String nome) {
        try{
            return repository.existsByNome(nome);
        } catch(Exception e) {
            throw new RuntimeException(String.format("Erro ao buscar produtos por nome." + nome) + e);
        }
    }
}
