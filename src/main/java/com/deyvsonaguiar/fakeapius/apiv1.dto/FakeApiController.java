package com.deyvsonaguiar.fakeapius.apiv1.dto;

import com.deyvsonaguiar.fakeapius.business.services.FakeApiService;
import com.deyvsonaguiar.fakeapius.business.services.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
@Tag(name = "fake-api")
public class FakeApiController {

    private final FakeApiService service;
    private final ProdutoService produtoService;


    @Operation(summary = "Busca e salvar produtos", method = "POST")
    @ApiResponses(value= {
        @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso!"),
        @ApiResponse(responseCode = "500", description = "Erro ao realizar busca e salvar de dados.")

    })
    @PostMapping("/api")
    public ResponseEntity<List<ProductDTO>> salvaProdutosApi() {
        return ResponseEntity.ok(service.buscaProdutos());
    }

    @Operation(summary = "Salvar novs produtos", method = "POST")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "Produto salvo com sucesso!"),
            @ApiResponse(responseCode = "500", description = "Erro ao salvar produtos.")

    })
    @PostMapping("/")
    public ResponseEntity<ProductDTO> salvaProdutos(@RequestBody ProductDTO dto) {
        return ResponseEntity.ok(produtoService.salvarProdutoDTO(dto));
    }


    @Operation(summary = "Atualização de produtos", method = "PUT")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso!"),
            @ApiResponse(responseCode = "500", description = "Erro ao atualizar produtos.")

    })
    @PutMapping("/")
    public ResponseEntity<ProductDTO> atualizarProdutos(@RequestParam ("id") String id, @RequestBody ProductDTO dto) {
        return ResponseEntity.ok(produtoService.atualizarProduto(id, dto));
    }

    @Operation(summary = "Excluir produto", method = "DELETE")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "Produto excluído com sucesso!"),
            @ApiResponse(responseCode = "500", description = "Erro ao excluir produtos.")

    })
    @DeleteMapping("/")
    public ResponseEntity<Void> excluirProduto(@RequestParam ("nome") String nome) {
        produtoService.deletaProduto(nome);
        return ResponseEntity.accepted().build();
    }

    @Operation(summary = "Buscar todos os produtos cadastrados", method = "GET")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso!"),
            @ApiResponse(responseCode = "500", description = "Erro ao atualizar produtos.")

    })
    @GetMapping("/")
    public ResponseEntity<List<ProductDTO>> buscarTodosProdutos() {
        return ResponseEntity.ok(produtoService.buscaTodosProdutos());
    }

    @Operation(summary = "Buscar todos os produtos por nome", method = "GET")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso!"),
            @ApiResponse(responseCode = "500", description = "Erro ao buscar produtos por nome.")

    })
    @GetMapping("/{nome}")
    public ResponseEntity<ProductDTO> buscaProdutosPorNome(@PathVariable ("nome") String nome) {
        return ResponseEntity.ok(produtoService.buscaProdutoPorNome(nome));
    }


}
