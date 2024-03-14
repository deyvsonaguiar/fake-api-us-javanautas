package com.deyvsonaguiar.fakeapius.infrastructure.repositories;

import com.deyvsonaguiar.fakeapius.infrastructure.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProdutoRepository extends JpaRepository<ProdutoEntity, String> {

    Boolean existsByNome(String nome);
}
