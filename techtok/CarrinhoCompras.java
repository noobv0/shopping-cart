package techtok;
import java.util.List;
import java.util.ArrayList;
class CarrinhoCompras {
    private List<ItemCarrinho> itens;

    public CarrinhoCompras() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemCarrinho item) {
        itens.add(item);
    }

    public void removerItem(ItemCarrinho item) {
        itens.remove(item);
    }

    public double calcularValorTotal() {
        double valorTotal = 0;
        for (ItemCarrinho item : itens) {
            Produto produto = item.getProduto();
            int quantidade = item.getQuantidade();
            valorTotal += produto.getPreco() * quantidade;
        }
        return valorTotal;
    }

    public void exibirItens() {
        for (ItemCarrinho item : itens) {
            Produto produto = item.getProduto();
            int quantidade = item.getQuantidade();
            System.out.println("Produto: " + produto.getNome() + " - Quantidade: " + quantidade);
        }
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }
}