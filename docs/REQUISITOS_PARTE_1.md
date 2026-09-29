# Checklist — Projeto Final Parte 1

## Menu inicial

- [x] Arquivo/classe do menu criado.
- [ ] Cadastrar Novo Usuário encaminhando para o fluxo de cadastro.
- [ ] Login de Usuário encaminhando para autenticação.
- [ ] Login Administrativo encaminhando para autenticação administrativa.

## Cadastro de usuário

- [x] Model `Usuario` criado.
- [x] `UsuarioDAO` criado.
- [x] `CadastroUsuarioService` criado.
- [x] `CadastroUsuarioView` criada.
- [ ] Validar nome.
- [ ] Validar sobrenome.
- [ ] Validar login.
- [ ] Validar senha.
- [ ] Validar confirmação da senha.
- [ ] Salvar usuário no banco de dados.

## Login

- [x] Estrutura de login de usuário criada.
- [x] Estrutura de login administrativo criada.
- [ ] Validar usuário/senha no banco.
- [ ] Validar administrador/senha no banco.
- [ ] Redirecionar usuário autenticado para `MenuClienteView`.
- [ ] Redirecionar administrador autenticado para `MenuAdminView`.

## Área administrativa

- [x] Opção Cadastrar novo filme prevista.
- [x] Opção Buscar filme prevista.
- [x] Opção Remover filme prevista.
- [x] Opção Atualizar filme prevista.
- [ ] Implementar CRUD administrativo em uma etapa futura, conforme permitido pelo enunciado.

## Área do cliente

- [x] Opção Buscar filme prevista.
- [x] Opção Adicionar ao carrinho / reserva prevista.
- [x] Opção Retirar do carrinho / remover reserva prevista.
- [x] Opção Confirmar compra / reserva prevista.
- [ ] Implementar a busca de filme nesta entrega.
- [ ] Busca por ID.
- [ ] Busca por título/nome.
- [ ] Mostrar exatamente `Produto Não Encontrado` quando não houver resultado.

## Arquitetura

- [x] Java orientado a objetos.
- [x] Pacote `model`.
- [x] Pacote `dao`.
- [x] Pacote `connection` com JDBC.
- [x] Pacote `service`.
- [x] Pacote `view`.
- [x] Scripts-base do banco.
- [ ] Adicionar/configurar o driver JDBC do SGBD escolhido.
