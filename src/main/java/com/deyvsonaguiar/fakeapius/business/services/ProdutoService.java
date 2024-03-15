package com.deyvsonaguiar.fakeapius.business.services;

import com.deyvsonaguiar.fakeapius.infrastructure.entities.ProdutoEntity;
import com.deyvsonaguiar.fakeapius.infrastructure.repositories.IProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final IProdutoRepository repository;

    public ProdutoEntity salvarProduto(ProdutoEntity entity) {
        try{
            return repository.save(entity);
        } catch( Exception e) {
            throw new RuntimeException("Erro ao salvar produto." + e);
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
            throw new RuntimeException(format("Erro ao buscar produtos por nome." + nome), e);
        }
    }
}
