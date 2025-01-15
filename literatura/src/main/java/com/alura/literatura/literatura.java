import java.util.*;

public class literatura {

    // Lista de livros e autores
    private static final List<Livro> livros = new ArrayList<>();
    private static final List<Autor> autores = new ArrayList<>();

    public static void main(String[] args) {
        // Adicionando 3 livros manualmente
        adicionarLivrosIniciais();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=== Biblioteca Virtual ===");
            System.out.println("1. Pesquisar por Título");
            System.out.println("2. Mostrar Livros Adicionados");
            System.out.println("3. Mostrar Autores Adicionados");
            System.out.println("4. Encontrar Autor Vivo em um Período");
            System.out.println("5. Mostrar Livro por Idioma");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o título do livro: ");
                    String titulo = scanner.nextLine();
                    buscarPorTitulo(titulo);
                    break;
                case 2:
                    mostrarLivrosAdicionados();
                    break;
                case 3:
                    mostrarAutoresAdicionados();
                    break;
                case 4:
                    System.out.print("Digite o ano para buscar um autor vivo: ");
                    int ano = scanner.nextInt();
                    encontrarAutorPorAno(ano);
                    break;
                case 5:
                    System.out.print("Digite o idioma (pt, en, es, fr): ");
                    String idioma = scanner.nextLine();
                    mostrarLivroPorIdioma(idioma);
                    break;
                case 6:
                    System.out.println("Encerrando o programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void adicionarLivrosIniciais() {
        // Adicionando livros e associando autores
        Livro livro1 = new Livro("Dom Casmurro", "Machado de Assis", "pt", 1899, 500);
        Livro livro2 = new Livro("Pride and Prejudice", "Jane Austen", "en", 1813, 1000);
        Livro livro3 = new Livro("Cien años de soledad", "Gabriel García Márquez", "es", 1967, 800);

        livros.add(livro1);
        livros.add(livro2);
        livros.add(livro3);

        // Associando livros aos autores
        Autor autor1 = new Autor("Machado de Assis", 1839, 1908);
        autor1.adicionarLivro(livro1);

        Autor autor2 = new Autor("Jane Austen", 1775, 1817);
        autor2.adicionarLivro(livro2);

        Autor autor3 = new Autor("Gabriel García Márquez", 1927, 2014);
        autor3.adicionarLivro(livro3);

        autores.add(autor1);
        autores.add(autor2);
        autores.add(autor3);
    }

    private static void buscarPorTitulo(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("Título: " + livro.getTitulo());
                System.out.println("Autor: " + livro.getAutor());
                System.out.println("Idioma: " + livro.getIdioma());
                System.out.println("Downloads: " + livro.getDownloads());
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }

    private static void mostrarLivrosAdicionados() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro foi adicionado.");
        } else {
            for (Livro livro : livros) {
                System.out.println("Título: " + livro.getTitulo() + " | Autor: " + livro.getAutor() + " | Idioma: " + livro.getIdioma());
            }
        }
    }

    private static void mostrarAutoresAdicionados() {
        if (autores.isEmpty()) {
            System.out.println("Nenhum autor foi adicionado.");
        } else {
            for (Autor autor : autores) {
                System.out.println("Nome: " + autor.getNome() + " | Nascimento: " + autor.getAnoNascimento() + " | Falecimento: " + autor.getAnoFalecimento());
                System.out.println("Livros registrados: " + autor.getLivros());
                System.out.println("------");
            }
        }
    }

    private static void encontrarAutorPorAno(int ano) {
        for (Autor autor : autores) {
            if (autor.getAnoNascimento() <= ano && autor.getAnoFalecimento() >= ano) {
                System.out.println("Autor vivo em " + ano + ": " + autor.getNome());
                return;
            }
        }
        System.out.println("Nenhum autor vivo foi encontrado no ano " + ano + ".");
    }

    private static void mostrarLivroPorIdioma(String idioma) {
        for (Livro livro : livros) {
            if (livro.getIdioma().equalsIgnoreCase(idioma)) {
                System.out.println("Título: " + livro.getTitulo() + " | Autor: " + livro.getAutor() + " | Idioma: " + livro.getIdioma());
                return;
            }
        }
        System.out.println("Nenhum livro encontrado no idioma: " + idioma + ".");
    }
}

// Classe Livro
class Livro {
    private final String titulo;
    private final String autor;
    private final String idioma;
    private final int ano;
    private final int downloads;

    public Livro(String titulo, String autor, String idioma, int ano, int downloads) {
        this.titulo = titulo;
        this.autor = autor;
        this.idioma = idioma;
        this.ano = ano;
        this.downloads = downloads;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public int getDownloads() {
        return downloads;
    }
}

// Classe Autor
class Autor {
    private final String nome;
    private final int anoNascimento;
    private final int anoFalecimento;
    private final List<String> livros = new ArrayList<>();

    public Autor(String nome, int anoNascimento, int anoFalecimento) {
        this.nome = nome;
        this.anoNascimento = anoNascimento;
        this.anoFalecimento = anoFalecimento;
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro.getTitulo());
    }

    public String getNome() {
        return nome;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public int getAnoFalecimento() {
        return anoFalecimento;
    }

    public List<String> getLivros() {
        return livros;
    }
}
