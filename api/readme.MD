# Me leva ai

API para um aplicativo de corridas
## Funcionalidades

- Incluir motorista: `POST /motoristas`
- Sacar saldo motorista: `PUT /motoristas/{id}/sacar`
- Iniciar corrida: `PUT /motoristas/{idMotorista}/iniciar-corrida/{idCorrida}`
- Avaliar passageiro: `PUT /motoristas/avaliar-passageiro`
- Finalizar corrida: `PUT /motoristas/{idMotorista}/finalizar-corrida/{idCorrida}`
- Adicionar veiculo : `POST /veiculos`
- Listar passageiros : `GET /passageiros`
- Detalhar passageiro : `GET /passageiros/{id}`
- Listar passageiros disponiveis : `GET /passageiros/habilitados`
- Solicitar corrida : `POST /passageiros/{id}/solicitar-corrida`
- Incluir passageiro: `POST /passageiros`
- Depositar credito passageiro : `PUT /passageiros/{id}/depositar-creditos`
- Avaliar motorista : `PUT /passageiros/avaliar-motorista`
- Obter corrida : `GET /corridas/{id}`
- Listar motorista : `GET /motoristas`
- Obter motorista: `GET /motoristas/{id}`


## Dados

### Schema

```
    Arquivo em /data/base.sql
```

### Inserts
```
    Arquivo em /data/insert.sql
```

