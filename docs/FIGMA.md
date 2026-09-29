# Referência do protótipo no Figma

Arquivo utilizado como referência:

`Protótipo_Sistema_Cinema`

## Telas identificadas

- `Validacao_Login`
- `Novo_Cadastro`
- `Inicio`
- `Escolheu_Filme`
- `Escolha_Sessao`
- `Escolha_Assento`
- `Escolha_Ingresso`
- `Detalhes_Pedido`
- `Pagar_Compra`
- `Confirmacao_Compra`
- `Esqueceu-Senha`

## O que entra na Parte 1

Para a entrega atual, a estrutura Java está focada em:

1. cadastro de usuário;
2. login do cliente;
3. login administrativo;
4. área do cliente;
5. área administrativa;
6. busca de filme por ID ou título.

As telas de sessão, assento, ingresso, pedido e pagamento ficam como referência
para as próximas partes do sistema e ainda não foram implementadas em Java.

## Diferenças importantes entre Figma e enunciado

### Cadastro

O enunciado exige no mínimo:

- nome;
- sobrenome;
- login;
- senha;
- confirmação de senha.

O Figma mostra também:

- e-mail;
- CPF;
- endereço;
- caixa postal.

Por isso o modelo `Usuario` já possui campos extras, mas eles ainda não são
obrigatórios no código.

### Login

O enunciado fala em `login + senha`.

No Figma, a tela `Validacao_Login` mostra o campo:

`E-mail, Telefone ou CPF`

Antes de finalizar a autenticação, o grupo deve definir se seguirá literalmente
o enunciado com um campo `login` ou se também permitirá autenticação pelos dados
do protótipo.
