package techtok;
import java.util.ArrayList;
import java.util.List;
class LojaVirtual {
    private List<Produto> produtos;

    public LojaVirtual() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    public void listarProdutos() {
        for (Produto produto : produtos) {
            System.out.println("ID: " + produto.getId() +
                    " - Nome: " + produto.getNome() +
                    " - Preço: " + produto.getPreco() +
                    " - Quantidade em Estoque: " + produto.getQuantidadeEmEstoque());
        }
    }

    public Produto buscarProdutoPorId(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
