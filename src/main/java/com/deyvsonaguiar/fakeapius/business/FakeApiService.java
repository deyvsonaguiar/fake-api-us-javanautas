package com.deyvsonaguiar.fakeapius.business;

import com.deyvsonaguiar.fakeapius.apiv1.dto.ProductDTO;
import com.deyvsonaguiar.fakeapius.infrastructure.IFakeApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FakeApiService {

    private final IFakeApiClient client;

    public List<ProductDTO> buscaProdutos() {
        return client.buscarListaProdutos();
    }

}
