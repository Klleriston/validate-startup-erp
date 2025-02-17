# Validate Startup ERP

## Descrição do Projeto
O Validate Startup ERP é uma plataforma desenvolvida com Spring Boot e MongoDB para facilitar a criação colaborativa de startups. A aplicação permite que empreendedores, colaboradores e investidores compartilhem ideias inovadoras, interajam por meio de comentários e votos, e enviem solicitações de colaboração. A plataforma oferece operações CRUD para gerenciar usuários, ideias, comentários, votos e colaborações.

## Arquitetura Utilizada
O projeto segue uma arquitetura modular organizada em camadas:

```
src/
 └── main/
      └── java/
           └── com/
                └── seuProjeto/
                     ├── domain/                
                     │    ├── model/            
                     │    │    ├── User.java
                     │    │    ├── Idea.java
                     │    │    ├── Comment.java
                     │    │    ├── Vote.java
                     │    │    └── Collaboration.java
                     │    └── repository/       
                     │         ├── UserRepository.java
                     │         ├── IdeaRepository.java
                     │         ├── CommentRepository.java
                     │         ├── VoteRepository.java
                     │         └── CollaborationRepository.java
                     │
                     ├── application/           
                     │    ├── dto/              
                     │    │    ├── UserDTO.java
                     │    │    ├── IdeaDTO.java
                     │    │    ├── CommentDTO.java
                     │    │    ├── VoteDTO.java
                     │    │    └── CollaborationDTO.java
                     │    └── usecase/          
                     │         ├── CreateUserUseCase.java
                     │         ├── CreateIdeaUseCase.java
                     │         ├── CreateCommentUseCase.java
                     │         ├── CreateVoteUseCase.java
                     │         └── CreateCollaborationUseCase.java
                     │
                     ├── infrastructure/        
                     │    └── repository/       
                     │         ├── UserRepositoryImpl.java
                     │         ├── IdeaRepositoryImpl.java
                     │         ├── CommentRepositoryImpl.java
                     │         ├── VoteRepositoryImpl.java
                     │         └── CollaborationRepositoryImpl.java
                     │
                     └── adapters/              
                          ├── controller/       
                          │    ├── UserController.java
                          │    ├── IdeaController.java
                          │    ├── CommentController.java
                          │    ├── VoteController.java
                          │    └── CollaborationController.java
                          └── mapper/           
                               ├── UserMapper.java
                               ├── IdeaMapper.java
                               ├── CommentMapper.java
                               ├── VoteMapper.java
                               └── CollaborationMapper.java
```

## Funcionalidades Principais
O Validate Startup ERP é organizado em cinco collections principais:

1. **Users**: Cadastro de usuários com informações pessoais e papéis (empreendedor, colaborador ou investidor).
2. **Ideas**: Registro de ideias de startups postadas pelos usuários.
3. **Comments**: Comentários e feedbacks sobre as ideias.
4. **Votes**: Sistema de votação (upvote/downvote).
5. **Collaborations**: Solicitações de colaboração para o desenvolvimento das ideias.

## Requisitos Funcionais
### Cadastro e Gerenciamento de Usuários
- Cadastro de novos usuários com nome, e-mail e papel.
- Atualização e exclusão dos dados do usuário.

### Gerenciamento de Ideias
- CRUD de ideias de startup vinculadas ao autor.
- Cada ideia contém título, descrição, categoria, status e data de criação.

### Sistema de Comentários
- Permitir que os usuários comentem nas ideias.
- Cada comentário é vinculado ao autor e à ideia.

### Sistema de Votos
- Permitir upvotes e downvotes.
- Cada usuário pode votar apenas uma vez por ideia.

### Solicitações de Colaboração
- Envio de solicitações para colaborar.
- Cada solicitação contém mensagem e status (pendente, aceito, recusado).

## Diagrama Simplificado das Relações
```
Users (1) --- (N) Ideas
Users (1) --- (N) Comments
Users (1) --- (N) Votes
Users (1) --- (N) Collaborations

Ideas (1) --- (N) Comments
Ideas (1) --- (N) Votes
Ideas (1) --- (N) Collaborations
```
