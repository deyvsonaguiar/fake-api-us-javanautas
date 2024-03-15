package com.deyvsonaguiar.fakeapius.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name="ProdutoEntity")
@Table(name="produtos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdutoEntity {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "title", length = 800)
    private String nome;
    @Column(name = "price")
    private BigDecimal preco;
    @Column(name = "category", length = 800)
    private String categoria;
    @Column(name = "description", length = 800)
    private String descricao;
    @Column(name = "image", length = 800)
    private String imagem;
    @Column(name = "created_at")
    private LocalDateTime dataCriacao;
}
