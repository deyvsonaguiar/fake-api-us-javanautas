package com.deyvsonaguiar.fakeapius.infrastructure.clients;

import com.deyvsonaguiar.fakeapius.apiv1.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "fake-api", url = "${fake-api.url:#{null}}")
public interface IFakeApiClient {

    @GetMapping("/products")
    List<ProductDTO> buscarListaProdutos();
}
