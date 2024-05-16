package br.org.serratec.johnnyoriental.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.johnnyoriental.dto.PedidoDto;
import br.org.serratec.johnnyoriental.service.RestauranteService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/restaurante")
public class JohnnyRestauranteController {
	
	@Autowired
	private RestauranteService servico;
	
	@GetMapping
	public ResponseEntity<List<PedidoDto>> listar() {
		return ResponseEntity.ok(servico.obterPedidos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PedidoDto> buscarPorId(@PathVariable Long id) {
		Optional<PedidoDto> pedido = servico.procurarPorId(id);
		if(pedido.isPresent()) {
			return ResponseEntity.ok(pedido.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/prato")
	public ResponseEntity<List<PedidoDto>> obterPrato(@RequestBody String prato) {
		return ResponseEntity.ok(servico.obterPratos(prato));
	}
	
	@GetMapping("/cliente")
	public ResponseEntity<List<PedidoDto>> obterCliente(@RequestBody String cliente) {
		return ResponseEntity.ok(servico.obterCliente(cliente));
	}
	
	@GetMapping("valorpedido/menor")
	public ResponseEntity<List<PedidoDto>> obterValorPedidoMenor(@RequestBody String valorPedido) {
		return ResponseEntity.ok(servico.procurarValorPedidoMenor(Double.valueOf(valorPedido)));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PedidoDto fazerPedido (@Valid @RequestBody PedidoDto pedido) {
		return servico.criarPedido(pedido);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PedidoDto> modificarPedidoId(@PathVariable Long id, @RequestBody PedidoDto pedidoAlterado) {
		Optional<PedidoDto> pedido = servico.atualizarPedido(id, pedidoAlterado);
		if(pedido.isPresent()) {
			return ResponseEntity.ok(pedido.get());
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarPedido(@PathVariable Long id) {
		if(!servico.excluirPedido(id)) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.noContent().build();
	}
	
}
