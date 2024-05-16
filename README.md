# Johnny Restaurante Cozinha Oriental

### Objetivo

Desenvolver uma API RESTful utilizando Spring e Java para gerenciar
informações de um restaurante oriental. A API deve permitir a manipulação de
dados relacionados a pratos, pedidos e clientes.

### Intruções para executar a aplicação

- Crie um banco de dados no PgAdmin (postgres) com o nome: johnnyoriental
- Inicialize a aplicação como um Maven Project na IDE
- Para adicionar pedidos, consultar, deletar e alterar use o Postman
- O formato JSON terá como base o exemplo abaixo (o id será gerado automaticamente):

```
{
    "cliente": "Jonathan",
    "pedido": "Mesa 05",
    "prato": "California Roll",
    "valorPedido": 200
}
```

### Estrutura da API

A aplicação foi criada passando como entidade o pedido, cliente, prato e valor de cada pedido. As consultas mais específicas devem ser utilizadas com: /restaurante, /restaurante/cliente, /restaurante/prato e etc...

### Demais usos

Alguns exemplos de utilização da API seria em aplicativos de entrega de alimentos, websites de restaurante e encomendas de comida oriental.  