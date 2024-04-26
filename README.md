# <center>TESTE-API<br>
API para genrenciar pessoas e seus respectivos endereços (CRUD) que faz parte do Teste -API<br>
O projeto foi elaborado com as seguintes tecnologias:
# Tecnologias
>>
>>* Spring Boot
>>* Spring MVC
>>* Spring Data JPA
>>* SpringDoc Seagger2
>>* MySQL
>>
## Práticas adotadas
>>* SOLID, DRY, YAGNI, KISS
>>* API REST
>>* Consultas com Spring Data JPA
>>* Injeção de Dependências
>>* Geração automática do Swagger2

## Como Executar
>* Clonar Repositório GIT
>* Construir o Projeto
>* Montar a Base de Dados
>> 
>>>* Criar esquema "teste_api"
>> 
>>>* CREATE TABLE `pessoa` (
     `id` bigint NOT NULL AUTO_INCREMENT,
     `nome` varchar(50) NOT NULL,
     `nascimento` date NOT NULL,
     PRIMARY KEY (`id`)
     ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
>> 
>>>* CREATE TABLE `endereco` (
     `id` bigint NOT NULL AUTO_INCREMENT,
     `logradouro` varchar(50) NOT NULL,
     `cep` int NOT NULL,
     `cidade` varchar(45) NOT NULL,
     `estado` varchar(45) NOT NULL,
     `principal` bit(1) NOT NULL,
     `id_pessoa` bigint DEFAULT NULL,
     PRIMARY KEY (`id`),
     KEY `FK36sv4vy3hi3flqeiswatu14sl` (`id_pessoa`),
     CONSTRAINT `FK36sv4vy3hi3flqeiswatu14sl` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoa` (`id`)
     ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

>> /mvnw clean package 
>>* Executar a aplicação:
>>>* $ java -jartarget/Teste-de-API-0.0.1-SNAPSHOT.jar 
>>
>> A API poderá ser acessada em localhost:8080
>> O Swagger poderá ser visualizado em http://localhost:8080/swagger-ui/index.html
> 
># API Endpoints 
> Para fazer as requisições HTTP abaixo, foi utilizado o próprio Swaggeer
> #### Criar Pessoa
>>http://localhost:8080/swagger-ui/index.html#/pessoa-controller/create
>>> {<br>"nome": "string",<br>"nascimento": "2024-04-26T16:06:57.725Z"<br>}
> #### Listar Pessoas
>>http://localhost:8080/swagger-ui/index.html#/pessoa-controller/listpessoa
>>> [<br>
>>> {<br>
>>>    "id": 0,<br>
>>> "nome": "string",<br>
>>> "nascimento": "2024-04-26T16:10:58.381Z"<br>
>>> }<br>
>>> ] 
> #### Alterar Pessoas
>> http://localhost:8080/swagger-ui/index.html#/pessoa-controller/update
>>>  {<br>
>>>  "id": 0,<br>
>>>  "nome": "string",<br>
>>>  "nascimento": "2024-04-26T16:15:31.435Z"<br>
>>>  }<br>
> #### Deletar Pessoas
>>http://localhost:8080/swagger-ui/index.html#/pessoa-controller/delete/pessoa/{id}
> #### Criar Endereço
>> http://localhost:8080/swagger-ui/index.html#/endereco-controller/create_1
>>> {<br>
>>> "idPessoa": 0,<br>
>>> "logradouro": "string",<br>
>>> "cep": 0,<br>
>>> "cidade": "string",<br>
>>> "estado": "string",<br>
>>> "principal": true<br>
>>> }<br>
> #### Listar Endereço
>> http://localhost:8080/swagger-ui/index.html#/endereco-controller/list/endereco/{id}
>#### Alterar Endereço 
>>> {<br>
>>> "id": 0,<br>
>>> "idPessoa": 0,<br>
>>> "logradouro": "string",<br>
>>> "cep": 0,<br>
>>> "cidade": "string",<br>
>>> "estado": "string",<br>
>>> "principal": true<br>
>>> } <br>
> #### Deletar Endereço
>> http://localhost:8080/swagger-ui/index.html#/endereco-controller/delete_1/endereco/{id} 