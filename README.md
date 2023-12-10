# APISicredi
Teste API Produtos com testes automatizados.

Contem os testes:
- Consultar Usuarios ("/users"):
    * Validação de sucesso de chamada da requisição
    * Validação dos tipos e atributos retornados
    * Validação do tipo de imagem retornada
    * Validação de retorno valido para os atributos "name" e "password"
- Consultar Produto/id ("/products/id""): 
    * Validação de sucesso de chamada da requisição
    * Validação dos tipos e atributos retornados
    * Validação da consulta com produto inexistente
- Consultar Produtos ("/products"):
    * Validação de sucesso de chamada da requisição
    * Validação do tipo do atributo "image"
    * Validação de total retornado por pagina
- Consultar Produtos Autorizador ("/auth/products"):
    * Validação de sucesso de chamada da requisição
    * Validação dos tipos e atributos retornados
      - Atributo "rating" não esta com o tipo correto
    * Validar consulta sem informação de token
    * Validar consulta com token invalido
      - Campo "name" não retorna o texto correto
      - Campo "message" não retorna o texto correto
- Autenticar Usuario ("/auth/login"):
    * Validação dos tipos dos atributos retornados
    * Validar retorno com dados de usuario inexistente
    * Validar retorno com dados de usuario vazio
    * Validar email retornado
- Adicionar Produtos ("/products/add"):
    * Validação de sucesso de chamada da requisição
      - Não retorna o status code correto
    * Validação de envio de requisição com atributos vazios
      - Não retorna o status code correto
    * Validação dos valores envidos nos atributos da requisição
      - Não envia o atributo "discountPercentage"
    * Validação do corpo de envio da requisição
      - Não envia o atributo "discountPercentage"
    * Validar incremento de ID
      - Não incrementa ID de produto. Registrando dois produtos com o mesmo ID.

##  Tecnologias e Ferramentas
* Java 1.8.0
* Apache Maven 3.9.3
* Rest-Assured
* IntelliJ
* [Java Faker](https://github.com/DiUS/java-faker)

## Execução do projeto
```bash
Necessario para execução do projeto de teste
#Para executar os testes do projeto
#Relatorios gerados em: target/sufire-reports
    mvn test
    
#Para gerar relatório dos testes
#Arquivo .html gerado em: target/site
    mvn surefire-report:report-only
