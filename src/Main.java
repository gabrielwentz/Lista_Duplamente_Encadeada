public class Main {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
        lista.adicionar(10);
        lista.adicionar(20);
        lista.adicionar(30);
        lista.adicionar(20);
        lista.adicionar(50);
        lista.adicionar(70);

        lista.listar();

        lista.remover(20);

        lista.listar();

        lista.removerTodos(20);

        lista.listar();

        lista.buscar(10);

        lista.buscar(40);

        System.out.println("O maior elemento da lista é: " + lista.maior());

        System.out.println("O menor elemento da lista é: " + lista.menor());

        System.out.println("A média dos elementos da lista é: " + lista.media());

        System.out.println("Quantidade: " + lista.quantidade());

    }
}
