package com.deyvsonaguiar.fakeapius.business.services;

import com.deyvsonaguiar.fakeapius.apiv1.dto.ProductDTO;
import com.deyvsonaguiar.fakeapius.business.services.converter.ProdutoConverter;
import com.deyvsonaguiar.fakeapius.infrastructure.clients.IFakeApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FakeApiService {

    private final IFakeApiClient client;
    private final ProdutoService service;
    private final ProdutoConverter converter;

    public List<ProductDTO> buscaProdutos() {
        try {
            List<ProductDTO> dto = client.buscarListaProdutos();
            dto.forEach(produto -> {
                Boolean ifExists = service.existsPorNome(produto.getNome());
                if(ifExists.equals(false)) {
                    service.salvarProduto(converter.toEntity(produto));
                }
            });
            return converter.toListDTO(service.buscarTodosProdutos());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao cadastrar produto." + e);
        }
    }

}
