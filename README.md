# LiterAlura - Catálogo de Livros

Projeto desenvolvido para criar um catálogo de livros utilizando **Java**, **Spring Boot**, e **MySQL** para a persistência dos dados. Este sistema é capaz de realizar operações CRUD (Criar, Ler, Atualizar e Deletar) de maneira integrada, utilizando um banco de dados relacional.

## Descrição

O projeto **LiterAlura** foi idealizado como um sistema de gerenciamento de livros. A aplicação permite:
- Cadastro de novos livros no catálogo
- Listagem dos livros registrados
- Atualização de informações sobre os livros
- Exclusão de livros do catálogo

### Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.3.5**
- **MySQL 8.0.33**
- **JPA (Java Persistence API)**
- **Jakarta Validation API** para validação de dados
- **JUnit 5** e **Mockito** para testes unitários

### Desafios e Dificuldades

Durante o desenvolvimento deste projeto, enfrentei diversas dificuldades, especialmente porque as tecnologias utilizadas eram novas para mim. Além disso, meu notebook, por ser um modelo mais antigo, apresentou limitações técnicas que dificultaram a execução de alguns testes. Em alguns casos, a aplicação não conseguiu rodar como esperado devido a restrições de desempenho e memória da máquina.

Apesar das dificuldades, consegui desenvolver grande parte do projeto e aprendi bastante sobre cada uma das tecnologias envolvidas. No entanto, alguns testes e funcionalidades podem não ter sido verificados de maneira ideal, devido a limitações de hardware.

### Estrutura do Projeto

O projeto foi estruturado da seguinte maneira:

- **Camada de Controle**: Contém os controladores responsáveis por receber as requisições HTTP e direcioná-las para os serviços adequados.
- **Camada de Serviço**: Contém a lógica de negócio, processando as informações antes de enviá-las para a camada de persistência.
- **Camada de Persistência**: Utiliza Spring Data JPA para gerenciar as operações de CRUD com o banco de dados MySQL.
- **Banco de Dados**: Configurado para armazenar informações dos livros. Utilizei o **MySQL** para persistir os dados de maneira relacional.

### Instalação e Configuração

1. **Pré-requisitos**: Certifique-se de ter **Java 21**, **Maven**, e um servidor **MySQL** instalados.
2. **Clone o repositório**:
    ```bash
    git clone https://github.com/fred-creator-creat/literalura.git
    cd literalura
    ```
3. **Configure o banco de dados**:
   - Crie um banco de dados MySQL chamado `literalura`.
   - Configure as credenciais de acesso ao banco de dados no arquivo `application.properties` em `src/main/resources/`.

4. **Instale as dependências e compile o projeto**:
    ```bash
    mvn clean install
    ```

5. **Execute a aplicação**:
    ```bash
    mvn spring-boot:run
    ```

### Testes

Os testes foram configurados utilizando **JUnit 5** e **Mockito**. No entanto, devido a limitações de hardware no meu notebook, alguns testes não puderam ser executados de maneira eficiente, e a cobertura de testes pode estar incompleta.

### Conclusão

Este projeto foi um grande aprendizado, pois exigiu o uso de ferramentas e frameworks que eu ainda não dominava. Apesar dos desafios, principalmente devido às limitações do meu notebook, consegui desenvolver a aplicação e integrar as tecnologias propostas. Pretendo, no futuro, melhorar a cobertura de testes e otimizar algumas funcionalidades quando tiver acesso a um ambiente de desenvolvimento mais robusto.

---

**Nota**: Caso tenha dúvidas ou encontre algum problema, sinta-se à vontade para entrar em contato.

---

### Créditos

Agradecimentos a Alura pelo suporte e orientação contínua durante o desenvolvimento deste projeto.

---
