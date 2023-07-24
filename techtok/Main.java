package techtok;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Produto produto1 = new Produto(1, "Smartphone", "Um smartphone avançado", 1500.00, 10);
        Produto produto2 = new Produto(2, "Notebook", "Um notebook potente", 3000.00, 5);
        Produto produto3 = new Produto(3, "Fone de Ouvido", "Um fone de ouvido de alta qualidade", 100.00, 20);

        LojaVirtual lojaVirtual = new LojaVirtual();
        lojaVirtual.adicionarProduto(produto1);
        lojaVirtual.adicionarProduto(produto2);
        lojaVirtual.adicionarProduto(produto3);

        CarrinhoCompras carrinho = new CarrinhoCompras();

        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 5) {
            System.out.println("=== TechTok - Loja Virtual ===");
            System.out.println("1. Adicionar produto ao carrinho");
            System.out.println("2. Remover produto do carrinho");
            System.out.println("3. Exibir produtos no carrinho");
            System.out.println("4. Calcular valor total da compra");
            System.out.println("5. Sair");
            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    System.out.println("=== Produtos Disponíveis ===");
                    lojaVirtual.listarProdutos();
                    System.out.print("Digite o ID do produto a ser adicionado: ");
                    int idProduto = scanner.nextInt();
                    System.out.print("Digite a quantidade desejada: ");
                    int quantidade = scanner.nextInt();
                    Produto produtoSelecionado = null;
                    for (Produto produto : lojaVirtual.getProdutos()) {
                        if (produto.getId() == idProduto) {
                            produtoSelecionado = produto;
                            break;
                        }
                    }
                    if (produtoSelecionado != null) {
                        if (produtoSelecionado.getQuantidadeEmEstoque() >= quantidade) {
                            ItemCarrinho item = new ItemCarrinho(produtoSelecionado, quantidade);
                            carrinho.adicionarItem(item);
                            produtoSelecionado.setQuantidadeEmEstoque(produtoSelecionado.getQuantidadeEmEstoque() - quantidade);
                            System.out.println("Produto adicionado ao carrinho!");
                        } else {
                            System.out.println("Quantidade em estoque insuficiente!");
                        }
                    } else {
                        System.out.println("Produto não encontrado!");
                    }
                }
                case 2 -> {
                    System.out.println("=== Produtos no Carrinho ===");
                    carrinho.exibirItens();
                    System.out.print("Digite o ID do produto a ser removido: ");
                    int idProduto = scanner.nextInt();
                    ItemCarrinho itemRemover = null;
                    for (ItemCarrinho item : carrinho.getItens()) {
                        if (item.getProduto().getId() == idProduto) {
                            itemRemover = item;
                            break;
                        }
                    }
                    if (itemRemover != null) {
                        carrinho.removerItem(itemRemover);
                        itemRemover.getProduto().setQuantidadeEmEstoque(itemRemover.getProduto().getQuantidadeEmEstoque() + itemRemover.getQuantidade());
                        System.out.println("Produto removido do carrinho!");
                    } else {
                        System.out.println("Produto não encontrado no carrinho!");
                    }
                }
                case 3 -> {
                    System.out.println("=== Produtos no Carrinho ===");
                    carrinho.exibirItens();
                }
                case 4 -> {
                    double valorTotal = carrinho.calcularValorTotal();
                    System.out.println("Valor total da compra: R$" + valorTotal);
                }
                case 5 -> System.out.println("Obrigado por utilizar a loja virtual TechTok. Volte sempre!");
                default -> System.out.println("Opção inválida. Digite novamente.");
            }
        }

        scanner.close();
    }
}

