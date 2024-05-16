package br.org.serratec.johnnyoriental.dto;

import br.org.serratec.johnnyoriental.model.Pedido;
import jakarta.validation.constraints.NotBlank;

public record PedidoDto(
		Long id,
		@NotBlank(message = "Esse cliente não consta no banco de dados.")
		String cliente,
		@NotBlank(message = "Esse pedido não existe!")
		String pedido,
		@NotBlank(message = "Prato não encontrado")
		String prato,
		Double valorPedido) {

	public Pedido toEntity() {
		return new Pedido (this.id, this.cliente, this.pedido, this.prato, this.valorPedido);
	}
	
}
