package br.org.serratec.johnnyoriental.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.johnnyoriental.dto.PedidoDto;
import br.org.serratec.johnnyoriental.model.Pedido;
import br.org.serratec.johnnyoriental.repository.RestauranteRepositorio;


@Service
public class RestauranteService {
	
	@Autowired
	private RestauranteRepositorio restauranteRepositorio;

	public List<PedidoDto> obterPedidos() {
		return restauranteRepositorio.findAll().stream()
				.map(p -> new PedidoDto(p.getId(), p.getCliente(), p.getPedido(), p.getPrato(), p.getValorPedido())).toList();
	}
	
	public PedidoDto criarPedido(PedidoDto pedido) {
		Pedido pedidoEntity = restauranteRepositorio.save(pedido.toEntity());
		return pedidoEntity.toDto();	
	}
	
	public Optional<PedidoDto> atualizarPedido(Long id, PedidoDto pedido) {
		Pedido pedidoEntity = pedido.toEntity();
		if(restauranteRepositorio.existsById(id)) {
			pedidoEntity.setId(id);
			restauranteRepositorio.save(pedidoEntity);
			return Optional.of(pedidoEntity.toDto());
		}
		
		return Optional.empty();
	}
	
	public boolean excluirPedido(Long id) {
		if(!restauranteRepositorio.existsById(id)) {
			return false;
		}
		
		restauranteRepositorio.deleteById(id);
		return true;
	}
	
	public List<PedidoDto> obterPratos(String prato) {
		return restauranteRepositorio.findByPratoContainingIgnoreCase(prato).stream()
				.map(p -> new PedidoDto(p.getId(), p.getCliente(), 
				p.getPedido(), p.getPrato(), p.getValorPedido())).toList();
	}

	public List<PedidoDto> obterCliente(String cliente) {
		return restauranteRepositorio.findByClienteContainingIgnoreCase(cliente).stream()
				.map(c -> new PedidoDto(c.getId(), c.getCliente(), c.getPedido(),
						c.getPrato(), c.getValorPedido())).toList();
	}
	
	public List<PedidoDto> procurarValorPedidoMenor(Double valorPedido) {
		return restauranteRepositorio.findByValorPedidoLessThan(valorPedido).stream()
				.map(vm -> new PedidoDto(vm.getId(), vm.getCliente(), 
				vm.getPedido(), vm.getPrato(), vm.getValorPedido())).toList();
	}

	public Optional<PedidoDto> procurarPorId(Long id) {
		Optional<Pedido> pedido = restauranteRepositorio.findById(id);
		if(pedido.isEmpty()) {
			return Optional.empty();
		}
		
		return Optional.of(pedido.get().toDto());
	}

}
