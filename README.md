# tc1-api-phto

API desenvolvida para cadastro de Eletrodomésticos, Pessoas e Endereços.

## Workflow

![](fluxo_api_tc1-phto.png)

## Como rodar esta aplicação springboot

1° - No terminal, rode os seguintes comandos (de preferência na mesma ordem):

```
docker network create redelocal --driver=bridge  

docker run --name tc1_phto_mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -e MYSQL_PASSWORD=admin -e MYSQL_USER=admin -e MYSQL_DATABASE=db_tc1 --network redelocal -p 3306:3306 -d mysql
```

2° - Insira essas variáveis de ambiente na aplicação, basta copiar e colar:

```
SPRING_DATA_SOURCE_URL=jdbc:mysql://localhost:3306/db_tc1
SPRING_DATA_SOURCE_USERNAME=admin
SPRING_DATA_SOURCE_PASSWORD=admin
SERVER_PORT=8080
```

> **_NOTA:_**  Ao startar a aplicação, para acessar a api basta acessar a seguinte url a depender da porta escolhida
> na variável SERVER_PORT. Ex: http://localhost:8080/swagger-ui.html#/

## Squad
Grupo 21

## Repositório

- [tc1-api-phto](https://github.com/paulohto/tc1-phto)

## Commits Guideline

Nós possuimos regras e padrões sobre como as nossas mensagens de commit devem ser formatadas. Isso nós oferece uma
melhor experiência na hora de acompaharmos o history do projeto.

Utilizamos o padrão de [conventional commits](https://www.conventionalcommits.org/), logo todos os commits neste
repositório deverão seguir essa convenção.

### Formato do Commit

Cada mensagem de commit pode conter um **header**, um **body** e um **footer**. O header possui um formato especial
que pode conter um **type**, uma **task** (task ou história do jira) e um **subject**.

```
<type>(<task>): <subject>
<body>
<footer>
```

O **type** e o **subject** são obrigatórios.

Exemplo:

`docs: change README about CICD`

### Tipos de Commits

| Tipo    | Função                                                                      |
| ------- | --------------------------------------------------------------------------- |
| _feat_  | Uma nova implementação / feature                                            |
| _build_ | Modificações que afetam as ferramentas de build                             |
| _ci_    | Modificações nos arquivos e nos scripts de configuração de CI               |
| _docs_  | Modificações em documentações e afins                                       |
| _fix_   | Correção de um bug                                                          |
| _perf_  | Modificações de código para otimizar performance                            |
| _impr_  | Modificações que não necessariamente é um fix ou nova feature               |
| _style_ | Mudanças que não modifiquem lógica (white-space, formatting, prettier, etc) |
| _test_  | Testes que foram adicionados ou corrigidos                                  |
| _chore_ | Uma modificação geral que não se enquandra em nenhum outro padrão           |