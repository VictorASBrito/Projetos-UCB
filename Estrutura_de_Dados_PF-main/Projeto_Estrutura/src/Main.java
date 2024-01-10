import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FabricanteDAO fabricanteDAO = new FabricanteDAO();
        SneakerDAO sneakerDAO = new SneakerDAO();

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    adicionarFabricantes(scanner, fabricanteDAO);
                    break;
                case 2:
                    adicionarSneakers(scanner, fabricanteDAO, sneakerDAO);
                    break;
                case 3:
                    listarMarcas(fabricanteDAO);
                    break;
                case 4:
                    listarProdutos(sneakerDAO);
                    break;
                case 5:
                    listarProdutosPorEstado(scanner, sneakerDAO);
                    break;
                case 6:
                    listarProdutosPorMarca(scanner, sneakerDAO);
                    break;
                case 7:
                    apresentarEstadoProdutoMaisCaro(sneakerDAO);
                    break;
                case 8:
                    apresentarFabricantesProdutoMaisBarato(sneakerDAO);
                    break;
                case 9:
                    listarProdutosPorValorCrescente(sneakerDAO);
                    break;
                case 10:
                    listarProdutosPorLucroCrescente(sneakerDAO);
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu() {

        System.out.println("\n|----------------------------------------------------------------|");
        System.out.println("|          MENU INICIAL - [SNEAKERS]                             |");
        System.out.println("|----------------------------------------------------------------|");
        System.out.println("|  01   |    Cadastrar Fabricante                                |");
        System.out.println("|----------------------------------------------------------------|");
        System.out.println("|  02   |    Cadastrar Produto                                   |");
        System.out.println("|----------------------------------------------------------------|");
        System.out.println("|  03   |    Listar marcas                                       |");
        System.out.println("|----------------------------------------------------------------|");
        System.out.println("|  04   |    Listar produtos                                     |");
        System.out.println("|----------------------------------------------------------------|");
        System.out.println("|  05   |    Listar produtos por estado                          |");
        System.out.println("|----------------------------------------------------------------|");
        System.out.println("|  06   |    Listar produtos por marca                           |");
        System.out.println("|----------------------------------------------------------------|");
        System.out.println("|  07   |    Apresentar estado com o produto mais caro           |");
        System.out.println("|----------------------------------------------------------------|");
        System.out.println("|  08   |    Apresentar fabricantes com o produto mais barato    |");
        System.out.println("|----------------------------------------------------------------|");
        System.out.println("|  09   |    Listar produtos em ordem crescente de valor         |");
        System.out.println("|----------------------------------------------------------------|");
        System.out.println("|  10   |    Listar produtos em ordem crescente de valor do lucro|");
        System.out.println("|----------------------------------------------------------------|");
        System.out.println("|  00   |    Sair do programa                                    |");
        System.out.println("|----------------------------------------------------------------|\n");
        System.out.print("Escolha uma opção: ");
    }

    private static void adicionarFabricantes(Scanner scanner, FabricanteDAO fabricanteDAO) {
        int quantidadeFabricantes = obterQuantidade(scanner, "Quantidade de fabricantes: ");

        for (int i = 0; i < quantidadeFabricantes; i++) {
            System.out.println("Fabricante " + (i + 1));
            Fabricante fabricante = criarFabricante(scanner);
            fabricanteDAO.adicionarFabricante(fabricante);
        }
    }

    private static Fabricante criarFabricante(Scanner scanner) {

        scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Site: ");
        String site = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("UF: ");
        String uf = scanner.nextLine();

        return new Fabricante(nome, site, telefone, uf);
    }

    private static void adicionarSneakers(Scanner scanner, FabricanteDAO fabricanteDAO, SneakerDAO sneakerDAO) {
        int quantidadeSneakers = obterQuantidade(scanner, "Quantidade de sneakers: ");

        for (int i = 0; i < quantidadeSneakers; i++) {
            System.out.println("Sneaker " + (i + 1));
            Sneaker sneaker = criarSneaker(scanner, fabricanteDAO);
            sneakerDAO.adicionarSneaker(sneaker);
        }
    }

    private static Sneaker criarSneaker(Scanner scanner, FabricanteDAO fabricanteDAO) {

        scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Peso: ");
        double peso = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Valor de compra: ");
        double valorCompra = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Valor de venda: ");
        double valorVenda = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Selecione a fabricante:");
        List<Fabricante> fabricantes = fabricanteDAO.getFabricantes();
        for (int i = 0; i < fabricantes.size(); i++) {
            System.out.println((i + 1) + ". " + fabricantes.get(i).getNome());
        }
        int opcaoFabricante = scanner.nextInt();
        scanner.nextLine();

        Fabricante fabricante = fabricantes.get(opcaoFabricante - 1);

        return new Sneaker(nome, descricao, peso, valorCompra, valorVenda, fabricante);
    }

    private static int obterQuantidade(Scanner scanner, String mensagem) {
        System.out.print(mensagem);
        return scanner.nextInt();
    }

    private static void listarMarcas(FabricanteDAO fabricanteDAO) {
        System.out.println("\nMarcas disponíveis:");
        List<Fabricante> fabricantes = fabricanteDAO.getFabricantes();
        for (Fabricante fabricante : fabricantes) {
            System.out.println(fabricante.getNome());
        }
        System.out.println();
    }

    private static void listarProdutos(SneakerDAO sneakerDAO) {
        System.out.println("\nProdutos disponíveis:");
        List<Sneaker> sneakers = sneakerDAO.getSneakers();
        for (Sneaker sneaker : sneakers) {
            System.out.println("Nome: " + sneaker.getNome());
            System.out.println("Descrição: " + sneaker.getDescricao());
            System.out.println("Peso: " + sneaker.getPeso());
            System.out.println("Valor de compra: " + sneaker.getValorCompra());
            System.out.println("Valor de venda: " + sneaker.getValorVenda());
            System.out.println("Fabricante: " + sneaker.getFabricante().getNome());
            System.out.println();
        }
    }

    private static void listarProdutosPorEstado(Scanner scanner, SneakerDAO sneakerDAO) {
        System.out.print("Informe o estado: ");
        String estado = scanner.nextLine();

        System.out.println("\nProdutos do estado '" + estado + "':");
        List<Sneaker> sneakers = sneakerDAO.getSneakers();
        for (Sneaker sneaker : sneakers) {
            if (sneaker.getFabricante().getUf().equalsIgnoreCase(estado)) {
                System.out.println("Nome: " + sneaker.getNome());
                System.out.println("Descrição: " + sneaker.getDescricao());
                System.out.println("Peso: " + sneaker.getPeso());
                System.out.println("Valor de compra: " + sneaker.getValorCompra());
                System.out.println("Valor de venda: " + sneaker.getValorVenda());
                System.out.println("Fabricante: " + sneaker.getFabricante().getNome());
                System.out.println();
            }
        }
    }

    private static void listarProdutosPorMarca(Scanner scanner, SneakerDAO sneakerDAO) {
        System.out.print("Informe a marca: ");
        String marca = scanner.nextLine();

        System.out.println("\nProdutos da marca '" + marca + "':");
        List<Sneaker> sneakers = sneakerDAO.getSneakers();
        for (Sneaker sneaker : sneakers) {
            if (sneaker.getFabricante().getNome().equalsIgnoreCase(marca)) {
                System.out.println("Nome: " + sneaker.getNome());
                System.out.println("Descrição: " + sneaker.getDescricao());
                System.out.println("Peso: " + sneaker.getPeso());
                System.out.println("Valor de compra: " + sneaker.getValorCompra());
                System.out.println("Valor de venda: " + sneaker.getValorVenda());
                System.out.println("Fabricante: " + sneaker.getFabricante().getNome());
                System.out.println();
            }
        }
    }

    private static void apresentarEstadoProdutoMaisCaro(SneakerDAO sneakerDAO) {
        List<Sneaker> sneakers = sneakerDAO.getSneakers();
        double maiorValor = 0;
        String estado = "";

        for (Sneaker sneaker : sneakers) {
            if (sneaker.getValorVenda() > maiorValor) {
                maiorValor = sneaker.getValorVenda();
                estado = sneaker.getFabricante().getUf();
            }
        }

        System.out.println("\nEstado com o produto mais caro: " + estado);
        System.out.println();
    }

    private static void apresentarFabricantesProdutoMaisBarato(SneakerDAO sneakerDAO) {
        List<Sneaker> sneakers = sneakerDAO.getSneakers();
        double menorValor = Double.MAX_VALUE;
        List<Fabricante> fabricantes = new ArrayList<>();

        for (Sneaker sneaker : sneakers) {
            if (sneaker.getValorVenda() < menorValor) {
                menorValor = sneaker.getValorVenda();
                fabricantes.clear();
                fabricantes.add(sneaker.getFabricante());
            } else if (sneaker.getValorVenda() == menorValor) {
                fabricantes.add(sneaker.getFabricante());
            }
        }

        System.out.println("\nFabricantes com o produto mais barato:");
        for (Fabricante fabricante : fabricantes) {
            System.out.println("Nome: " + fabricante.getNome());
            System.out.println("Site: " + fabricante.getSite());
            System.out.println("Telefone: " + fabricante.getTelefone());
            System.out.println("UF: " + fabricante.getUf());
            System.out.println();
        }
    }

    private static void listarProdutosPorValorCrescente(SneakerDAO sneakerDAO) {
        List<Sneaker> sneakers = sneakerDAO.getSneakers();
        sneakers.sort((s1, s2) -> Double.compare(s1.getValorVenda(), s2.getValorVenda()));

        System.out.println("\nProdutos em ordem crescente de valor:");
        for (Sneaker sneaker : sneakers) {
            System.out.println("Nome: " + sneaker.getNome());
            System.out.println("Descrição: " + sneaker.getDescricao());
            System.out.println("Peso: " + sneaker.getPeso());
            System.out.println("Valor de compra: " + sneaker.getValorCompra());
            System.out.println("Valor de venda: " + sneaker.getValorVenda());
            System.out.println("Fabricante: " + sneaker.getFabricante().getNome());
            System.out.println();
        }
    }

    private static void listarProdutosPorLucroCrescente(SneakerDAO sneakerDAO) {
        List<Sneaker> sneakers = sneakerDAO.getSneakers();
        sneakers.sort((s1, s2) -> Double.compare(s1.getValorLucro(), s2.getValorLucro()));

        System.out.println("\nProdutos em ordem crescente de valor do lucro:");
        for (Sneaker sneaker : sneakers) {
            System.out.println("Nome: " + sneaker.getNome());
            System.out.println("Descrição: " + sneaker.getDescricao());
            System.out.println("Peso: " + sneaker.getPeso());
            System.out.println("Valor de compra: " + sneaker.getValorCompra());
            System.out.println("Valor de venda: " + sneaker.getValorVenda());
            System.out.println("Valor do lucro: " + sneaker.getValorLucro());
            System.out.println("Fabricante: " + sneaker.getFabricante().getNome());
            System.out.println();
        }
    }
}
