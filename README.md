# literatura
Biblioteca Virtual - Literatura
Este projeto é uma aplicação em Java que simula uma biblioteca virtual. O objetivo é permitir que os usuários pesquisem e visualizem informações sobre livros e autores, além de explorar dados históricos e estatísticos. Aqui estão as funcionalidades principais:

Funcionalidades
1. Pesquisar por Título
O usuário pode buscar um livro específico pelo título. Caso o livro esteja registrado, serão exibidas as seguintes informações:

Título do livro
Nome do autor
Idioma
Número de downloads
Se o livro não for encontrado, uma mensagem de erro será exibida.

2. Mostrar Livros Adicionados
Exibe a lista de todos os livros registrados na aplicação. Cada livro será mostrado com:

Título
Nome do autor
Idioma
Caso não haja livros registrados, será exibida uma mensagem indicando que a lista está vazia.

3. Mostrar Autores Adicionados
Exibe a lista de todos os autores cadastrados na aplicação, junto com suas informações. Para cada autor, serão mostrados:

Nome
Ano de nascimento
Ano de falecimento (se aplicável)
Lista de livros registrados na aplicação
Se não houver autores registrados, será exibida uma mensagem de erro.

4. Encontrar Autor Vivo em um Período Específico
O usuário pode fornecer um ano específico, e a aplicação verificará se algum dos autores registrados estava vivo nesse período. Caso encontre, será exibido o nome do autor.
Se nenhum autor estiver vivo no ano solicitado, será exibida uma mensagem de erro.

5. Mostrar Livro por Idioma
Permite ao usuário buscar livros registrados em um idioma específico. Os idiomas disponíveis são:

Português (pt)
Inglês (en)
Espanhol (es)
Francês (fr)
Se houver livros no idioma solicitado, será exibida uma lista com o título, autor e idioma. Caso contrário, uma mensagem informará que não há livros no idioma solicitado.
