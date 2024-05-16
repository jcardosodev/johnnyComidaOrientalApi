package br.org.serratec.johnnyoriental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.johnnyoriental.model.Pedido;

public interface RestauranteRepositorio extends JpaRepository<Pedido, Long> {

	List<Pedido> findByPratoContainingIgnoreCase(String prato);
	List<Pedido> findByClienteContainingIgnoreCase(String cliente);
	List<Pedido> findByValorPedidoLessThan(Double valorPedido);
	
}
