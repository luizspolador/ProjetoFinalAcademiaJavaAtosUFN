# Projeto Final 5ª Academia Java Atos-UFN
  Este repositório contém o projeto final desenvolvido durante a 5ª Academia Java da Atos-UFN. O objetivo do projeto é implementar um sistema de gestão de um banco de amostras em um laboratório de pesquisa científica da área médica. O sistema utiliza tecnologias de FrontEnd e BackEnd, além de um banco de dados.

## Tecnologias utilizadas
FrontEnd: HTML5, CSS3, Thymeleaf, Bootstrap v. 5.3.0
BackEnd: Java v. 17 (LTS) e Spring Boot v. 3.1.0
Dependências Spring Boot: Spring Boot Dev Tools, Lombok, Spring Web, Spring Data JPA, MySQL Driver, Spring Security 6, Thymeleaf.
Banco de Dados: MySQL
Softwares utilizados: IntelliJ Ultimate, XAMPP Control Panel, MySQL Workbench

### Contextualização
  Laboratórios de pesquisa científica da área médica de universidades trabalham com bancos de amostras biológicas. Esses bancos de amostras geralmente são organizados em planilhas Excel e são armazenados em serviços de armazenamento em nuvem, como Google Drive ou OneDrive, pelo docente responsável pelo laboratório.

  Com o intuito de melhorar a organização, controle e segurança na gestão do banco de amostras, este projeto final da 5ª Academia Java-UFN busca implementar essa melhoria. A busca por essa melhoria foi baseada na minha experiência como pesquisador científico durante 3 anos e 6 meses da minha primeira graduação, Biomedicina na Universidades Estadual de Londrina.

  O projeto, por enquanto, possui um nome genérico denominado "Cadastro de Projetos, Usuários e Amostras em um Laboratório de Pesquisa".

### Funcionalidades do sistema
Usuário sem permissão de acesso:
  O projeto possui uma tela inicial para login. Usuários que não possuem acesso autorizado podem preencher um formulário com dúvidas ou solicitações ao laboratório.

Usuário com permissão de acesso:
  Usuários com permissão de acesso conseguem efetuar o login e acessar a página inicial do laboratório. Nessa página, encontram-se informações sobre as linhas de pesquisa do laboratório. Em uma próxima atualização, essa tela inicial será adaptada para permitir que usuários sem permissão de login também possam visualizá-la.

  Uma navbar está disponível ao lado esquerdo para o cadastro de projetos, usuários e amostras. As três entidades possuem um relacionamento realizado pela JPA Hibernate. O foco principal do projeto é a página de Banco de Amostras, na qual é possível visualizar o usuário e o projeto atrelados à amostra cadastrada.

### Futuras melhorias
  Com a aquisição de novos conhecimentos e experiência durante minha trajetória como desenvolvedor, pretendo aperfeiçoar o projeto e torná-lo uma realidade em algum laboratório de pesquisa.
