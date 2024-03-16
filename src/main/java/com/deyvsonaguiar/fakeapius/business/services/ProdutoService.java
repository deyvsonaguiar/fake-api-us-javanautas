package com.deyvsonaguiar.fakeapius.business.services;

import com.deyvsonaguiar.fakeapius.apiv1.dto.ProductDTO;
import com.deyvsonaguiar.fakeapius.business.services.converter.ProdutoConverter;
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
    private final ProdutoConverter converter;

    public ProdutoEntity salvarProduto(ProdutoEntity entity) {
        try{
            return repository.save(entity);
        } catch( Exception e) {
            throw new RuntimeException("Erro ao salvar produto." + e);
        }
    }

    public ProductDTO buscaProdutoPorNome(String nome) {
        try{
            return converter.toDTO(repository.findByNome(nome));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar produtos por nome." + e);
        }
    }

    public List<ProductDTO> buscaTodosProdutos() {
        try{
            return converter.toListDTO(repository.findAll());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar todos os produtos." + e);
        }
    }

    public void deletaProduto(String nome) {
        try{
            repository.deleteByNome(nome);
        } catch (Exception e) {
            throw new RuntimeException("Erro deletar produto por nome." + e);
        }
    }

    public ProductDTO atualizarProduto(String id, ProductDTO dto) {
        try{
            ProdutoEntity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Id inexistente."));
            salvarProduto(converter.toEntityUpdate(entity, id, dto));
            return converter.toDTO(repository.findByNome(entity.getNome()));

        } catch (Exception e) {
            throw new RuntimeException("Erro atualizar o produtoe." + e);
        }
    }

    public boolean existsPorNome(String nome) {
        try{
            return repository.existsByNome(nome);
        } catch(Exception e) {
            throw new RuntimeException(format("Erro ao buscar produtos por nome." + nome), e);
        }
    }

    public ProductDTO salvarProdutoDTO(ProductDTO dto) {
        try{
            ProdutoEntity entity = converter.toEntity(dto);
            return converter.toDTO(repository.save(entity));
        } catch( Exception e) {
            throw new RuntimeException("Erro ao salvar produto." + e);
        }
    }
}
