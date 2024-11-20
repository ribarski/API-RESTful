# API-RESTful
API RESTful para processamento de requisições de um cliente HTTP

<br/>

link swagger: http://localhost:8080/swagger-ui/index.html#/

<h2>RECOMENDAÇÃO CONTROLLER</h2>

![Controller recomendação (120)](https://github.com/user-attachments/assets/4e2609fb-6d42-4d7e-94e4-79af46a6eabb)
## (GET) /recomendacoes/{id}
Retorna em um array com os seguintes dados das recomendações: id da recomendação, descrição da recomendação, tipo da recomendação e o id do atentimento realizado.
  
## (PUT) /recomendacoes/{id}
Atualiza os dados da recomendação com base no id da recomendação.

## (DELETE) /recomendacoes/{id}
Deleta os dados da recomendação com base no id da recomendação.

## (POST) /recomendacoes
Cria um array com os seguintes campos: id da recomendação, descrição da recomendação, tipo da recomendação e o id do atentimento realizado.

## (GET) /recomendacoes/atendimento/{atendimentoId}
Pode ser utilizado para mostrar as recomendações feitas, associadas ao id específico do atendimento, podendo listar várias recomendações realizadas em um atendimento.

<br/>

<h2>MEDICAMENTO CONTROLLER</h2>

![Controller medicamento(121)](https://github.com/user-attachments/assets/1d220bd3-b1ac-41de-aabc-ca20f576ad66)

## (GET) /medicamentos/{id}
Retorna em um array os dados com as seguintes informações do medicamento: id do medicamento, nome do medicamento, princípio ativo do medicamento, a dosagem do medicamento e a quantidade do medicamento em estoque.

## (PUT) /medicamentos/{id}
Atualiza os dados do medicamento com base no id da recomendação.

## (DELETE) /medicamentos/{id}
Deleta os dados do medicamento com base no id da recomendação.

## (GET) /medicamentos
Pode ser utilizado para mostrar todos os medicamentos do sistema.

## (POST) /medicamentos
Cria um array com os seguintes campos: id  do medicamento, nome do medicamento, principio ativo do medicamento, a dosagem do medicamento e a quantidade do medicamento em estoque.

<br/>

<h2>ATENDIMENTO CONTROLLER</h2>

![Controller atendimento(122)](https://github.com/user-attachments/assets/9a756914-1970-47c2-ae0a-c15dc65a742c)

## (GET) /atendimentos/{id}
Retorna em um array com os seguintes dados do atendimento: data do atendimento, médico responsável pelo atendimento, nome do paciente atendido, diagnóstico que o paciente recebeu do médico e observações.

## (PUT) /atendimentos/{id}
Atualiza os dados do atendimento com base no id do atendimento.

## (DELETE) /atendimentos/{id}
Deleta os dados do atendimento com base no id do atendimento.

## (GET) /atendimentos
Pode ser utilizado para mostrar todos os atendimentos do sistema.

## (POST) /atendimentos
Cria um array com os seguintes campos:data do atendimento, médico responsável pelo atendimento, nome do paciente atendido, diagnóstico que o paciente recebeu do médico e observações.

## (GET) /atendimentos/find
Pode ser utilizado para mostrar todos os atendimentos do sistema utilizando filtros de algum campo da tabela, permitindo buscas mais específicas.
