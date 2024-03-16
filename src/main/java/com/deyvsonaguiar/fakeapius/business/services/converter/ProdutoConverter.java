package com.deyvsonaguiar.fakeapius.business.services.converter;

import com.deyvsonaguiar.fakeapius.apiv1.dto.ProductDTO;
import com.deyvsonaguiar.fakeapius.infrastructure.entities.ProdutoEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
public class ProdutoConverter {

    public ProdutoEntity toEntity(ProductDTO dto) {
        return ProdutoEntity.builder()
                .id(String.valueOf(UUID.randomUUID()))
                .nome(dto.getNome())
                .preco(dto.getPreco())
                .categoria(dto.getCategoria())
                .descricao(dto.getDescricao())
                .imagem(dto.getImagem())
                .dataCriacao(dto.getDataCriacao())
                .dataAtualizacao(LocalDateTime.now())
                .build();
    }

    public ProductDTO toDTO(ProdutoEntity entity) {
        return ProductDTO.builder()
                .entityId(String.valueOf(entity.getId()))
                .nome(entity.getNome())
                .preco(entity.getPreco())
                .categoria(entity.getCategoria())
                .descricao(entity.getDescricao())
                .imagem(entity.getImagem())
                .dataCriacao(entity.getDataCriacao())
                .dataAtualizacao(LocalDateTime.now())
                .build();
    }

    public List<ProductDTO> toListDTO(List<ProdutoEntity> listEntity) {
        return listEntity.stream().map(this::toDTO).toList();
    }

    public ProdutoEntity toEntityUpdate(ProdutoEntity entity, String id, ProductDTO dto) {
        return ProdutoEntity.builder()
                .id(id)
                .nome(dto.getNome() != null ? dto.getNome() : entity.getNome())
                .preco(dto.getPreco() != null ? dto.getPreco() : entity.getPreco())
                .categoria(dto.getCategoria() != null ? dto.getCategoria() : entity.getCategoria())
                .descricao(dto.getDescricao() != null ? dto.getDescricao() : entity.getDescricao())
                .imagem(dto.getImagem() != null ? dto.getImagem() : entity.getImagem())
                .dataCriacao(entity.getDataCriacao())
                .dataAtualizacao(LocalDateTime.now())
                .build();
    }
}
