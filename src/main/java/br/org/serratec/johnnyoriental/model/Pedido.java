package br.org.serratec.johnnyoriental.model;

import br.org.serratec.johnnyoriental.dto.PedidoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String pedido;
	private String cliente;
	private String prato;
	private double valorPedido;
	
	public Pedido() {}
	
	
	
	public Pedido(Long id, String pedido, String cliente, String prato, double valorPedido) {
		super();
		this.id = id;
		this.pedido = pedido;
		this.cliente = cliente;
		this.prato = prato;
		this.valorPedido = valorPedido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPedido() {
		return pedido;
	}

	public void setPedido(String pedido) {
		this.pedido = pedido;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getPrato() {
		return prato;
	}

	public void setPrato(String prato) {
		this.prato = prato;
	}

	public double getValorPedido() {
		return valorPedido;
	}

	public void setValorPedido(double valorPedido) {
		this.valorPedido = valorPedido;
	}
	
	public PedidoDto toDto() {
		return new PedidoDto(this.id, this.pedido, this.cliente, this.prato, this.valorPedido);
	}

}
