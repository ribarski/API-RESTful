# API-RESTful
API RESTful para processamento de requisições de um cliente HTTP

Desenvolvimento de um sistema focado em Saúde e Bem Estar, o qual possue 3 entidades, sendo elas: paciente, atendimento e medicação. Todas as entidades podem realizar 4 operações distintas (POST, DELETE, GET e PUT) e possuem suas próprias rotas. O projeto visa como objeto proporcionar ao paciente e ao médico um sistema eficaz, capaz de melhorar a eficiência dos atendimentos e melhorar o controle dos medicamentos que poderão ser recomendados durante os atendimentos realizados.

___

<br/>

<h2>INSTRUÇÕES PARA EXECUÇÃO DO PROJETO </h2>
Porta padrão 8080

___

<br/>

link swagger:
Local: http://localhost:8080/swagger-ui/index.html#/

Web: https://api-restful-ppr5.onrender.com/swagger-ui/index.html#


<h2>RECOMENDAÇÃO CONTROLLER</h2>

![Controller recomendação (120)](https://github.com/user-attachments/assets/4e2609fb-6d42-4d7e-94e4-79af46a6eabb)
## (GET) /recomendacoes/{id}
Status: 200 OK

Retorna em um array com os seguintes dados das recomendações: id da recomendação, descrição da recomendação, tipo da recomendação e o id do atentimento realizado.
  
## (PUT) /recomendacoes/{id}
Status: 201 CREATED

Atualiza os dados da recomendação com base no id da recomendação.

## (DELETE) /recomendacoes/{id}
Status: 204 DELETE

Deleta os dados da recomendação com base no id da recomendação.

## (POST) /recomendacoes
Status: 201 CREATED

Cria um array com os seguintes campos: id da recomendação, descrição da recomendação, tipo da recomendação e o id do atentimento realizado.

{

  "atendimentoId": 1,
  
  "medicamentoId": 1,
  
  "observacao": "tomar de 8 em 8 horas"
  
}

## (GET) /recomendacoes/atendimento/{atendimentoId}
Pode ser utilizado para mostrar as recomendações feitas, associadas ao id específico do atendimento, podendo listar várias recomendações realizadas em um atendimento.

<br/>

<h2>MEDICAMENTO CONTROLLER</h2>

![Controller medicamento(121)](https://github.com/user-attachments/assets/1d220bd3-b1ac-41de-aabc-ca20f576ad66)

## (GET) /medicamentos/{id}
Status: 200 OK

Retorna em um array os dados com as seguintes informações do medicamento: id do medicamento, nome do medicamento, princípio ativo do medicamento, a dosagem do medicamento e a quantidade do medicamento em estoque.

## (PUT) /medicamentos/{id}
Status: 201 CREATED

Atualiza os dados do medicamento com base no id da recomendação.

## (DELETE) /medicamentos/{id}
Status: 204 DELETE

Deleta os dados do medicamento com base no id da recomendação.

## (GET) /medicamentos
Status: 200 OK

Pode ser utilizado para mostrar todos os medicamentos do sistema.

## (POST) /medicamentos
Status: 201 CREATED

Cria um array com os seguintes campos: id  do medicamento, nome do medicamento, principio ativo do medicamento, a dosagem do medicamento e a quantidade do medicamento em estoque.

{

  "nome": "paracetamol",
  
  "principioAtivo": "paracetamol",
  
  "dosagem": "1cmprimido",
  
  "estoque": 10
  
}

<br/>

<h2>ATENDIMENTO CONTROLLER</h2>

![Controller atendimento(122)](https://github.com/user-attachments/assets/9a756914-1970-47c2-ae0a-c15dc65a742c)

## (GET) /atendimentos/{id}
Status: 200 OK

Retorna em um array com os seguintes dados do atendimento: data do atendimento, médico responsável pelo atendimento, nome do paciente atendido, diagnóstico que o paciente recebeu do médico e observações.

## (PUT) /atendimentos/{id}
Status: 201 CREATED

Atualiza os dados do atendimento com base no id do atendimento.

## (DELETE) /atendimentos/{id}
Status: 204 DELETE

Deleta os dados do atendimento com base no id do atendimento.

## (GET) /atendimentos
Status: 200 OK

Pode ser utilizado para mostrar todos os atendimentos do sistema.

## (POST) /atendimentos
Status: 201 CREATED

Cria um array com os seguintes campos:data do atendimento, médico responsável pelo atendimento, nome do paciente atendido, diagnóstico que o paciente recebeu do médico e observações.

{

  "data": "2024-11-26",
  
  "medico": "dt backend",
  
  "paciente": "aluno ferido",
  
  "diagnostico": "nota ruim",
  
  "observacoes": "precisa estudar"
  
}

## (GET) /atendimentos/find
Pode ser utilizado para mostrar todos os atendimentos do sistema utilizando filtros de algum campo da tabela, permitindo buscas mais específicas.
