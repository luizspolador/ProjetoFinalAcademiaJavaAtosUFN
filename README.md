
<h1 align="center"> Projeto Final 5ª Academia Java Atos-UFN </h1>

<h2 align="center">Sistema de cadastro de projetos, usuários e amostras de um laboratório de pesquisa</h2>

## Tecnologias utilizadas
- **FrontEnd:** HTML5, CSS3, Thymeleaf, Bootstrap v. 5.3.0
- **BackEnd:** Java v. 17 (LTS) e Spring Boot v. 3.1.0
  - **Dependências Spring Boot:** Spring Boot Dev Tools, Lombok, Spring Web, Spring Data JPA, MySQL Driver, Spring Security 6, Thymeleaf.
- **Banco de Dados:** MySQL
- **Softwares utilizados:** IntelliJ Ultimate, XAMPP Control Panel, MySQL Workbench

### Contextualização
  Laboratórios de pesquisa científica da área médica de universidades trabalham com bancos de amostras biológicas. Normalmente, esses bancos de amostras geralmente são organizados em planilhas Excel e são armazenados em serviços de armazenamento em nuvem, como Google Drive ou OneDrive, pelo docente responsável do laboratório ou alunos de pós graduação.

  O projeto final da 5ª Academia Java-UFN busca implementar melhoras na organização, controle e segurança na gestão do banco de amostras. A busca por essa melhoria foi baseada na minha experiência como pesquisador científico durante 3 anos e 6 meses da minha primeira graduação,  Biomedicina, na Universidades Estadual de Londrina.

  O projeto, por enquanto, possui um nome genérico denominado "Cadastro de Projetos, Usuários e Amostras em um Laboratório de Pesquisa".

### Funcionalidades do sistema
- Usuário sem permissão de acesso: <br>
  O projeto possui uma tela inicial para login. Usuários que não possuem acesso autorizado podem preencher um formulário com dúvidas ou solicitações ao laboratório. O formulário preenchido é recebido por um e-mail cadastrado no backend.

- Usuário com permissão de acesso:<br>
    Usuários com permissão de acesso conseguem efetuar o login e acessar a página inicial do laboratório. Nessa página, encontram-se informações sobre as linhas de pesquisa do laboratório. Em uma próxima atualização, essa tela inicial será adaptada para permitir que usuários sem permissão de login também possam visualizá-la. <br>

  Uma navbar está disponível ao lado esquerdo para o cadastro e listagem de projetos, usuários e amostras. As três entidades possuem relacionamentos realizado pela JPA Hibernate. O foco principal do projeto é a página de Banco de Amostras, o qual é possível visualizar o usuário e o projeto atrelados à amostra cadastrada.

### Futuras melhorias
  Com a aquisição de novos conhecimentos e experiência durante minha trajetória como desenvolvedor, pretendo aperfeiçoa-lo e tornar realidade em algum laboratório de pesquisa.
  Além diso, em uma futura atualização, buscarei por trabalhar com Desenvolvimento Orientado a Testes para tornar o código mais limpo, flexível e funcional.
