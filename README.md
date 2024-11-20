# API-RESTful
API RESTful para processamento de requisições de um cliente HTTP

<br/>

link swagger: http://localhost:8080/swagger-ui/index.html#/

<h2>RECOMENDAÇÃO CONTROLLER</h2>

![Controller recomendação (120)](https://github.com/user-attachments/assets/4e2609fb-6d42-4d7e-94e4-79af46a6eabb)
## (GET) /recomendacoes/{id}
Retorna em um array os dados com as recomendações: id da recomendação, descrição da recomendação, tipo da recomendação e o id do atentimento realizado.
  
## (PUT) /recomendacoes/{id}
Atualiza os dados da recomendação com base no id da recomendação.

## (DELETE) /recomendacoes/{id}
Deleta os dados da recomendação com base no id da recomendação.

## (POST) /recomendacoes
Cria um array com os seguintes campos: id da recomendação, descrição da recomendação, tipo da recomendação e o id do atentimento realizado.

## (GET) /recomendacoes/atendimento/{atendimentoId}
Pode ser utilizado para mostrar as recomendações feitaa, associadas ao id específico do atendimento, listando várias recomendações realizadas em um atendimento.

<br/>

<h2>MEDICAMENTO CONTROLLER</h2>

![Controller medicamento(121)](https://github.com/user-attachments/assets/1d220bd3-b1ac-41de-aabc-ca20f576ad66)

## (GET) /medicamentos/{id}
descrição

## (PUT) /medicamentos/{id}
descrição

## (DELETE) /medicamentos/{id}
descrição

## (GET) /medicamentos
descrição

## (POST) /medicamentos
descrição

<br/>

<h2>ATENDIMENTO CONTROLLER</h2>

![Controller atendimento(122)](https://github.com/user-attachments/assets/9a756914-1970-47c2-ae0a-c15dc65a742c)

## (GET) /atendimentos/{id}
descrição

## (PUT) /atendimentos/{id}
descrição

## (DELETE) /atendimentos/{id}
descrição

## (GET) /atendimentos
descrição

## (POST) /atendimentos
descrição

## (GET) /atendimentos/find
descrição
