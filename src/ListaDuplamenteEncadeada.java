public class ListaDuplamenteEncadeada {
    private No cabeca;
    private No cauda;

    public ListaDuplamenteEncadeada() {
        this.cabeca = null;
        this.cauda = null;
    }

    public void adicionar(Integer elemento) {
        No novoNo = new No(elemento);
        if (cabeca == null) {
            cabeca = cauda = novoNo;
        } else {
            cauda.setProximo(novoNo);
            novoNo.setAnterior(cauda);
            cauda = novoNo;
        }
    }
        
    public void adicionarInicio(Integer elemento) {
    No novoNo = new No(elemento);
    if (cabeca == null) {
        cabeca = cauda = novoNo;
    } else {
        novoNo.setProximo(cabeca);
        cabeca.setAnterior(novoNo);
        cabeca = novoNo;
    }
}

    public void adicionarFim(Integer elemento) {
    No novoNo = new No(elemento);
    if (cabeca == null) {
        cabeca = cauda = novoNo;
    } else {
        cauda.setProximo(novoNo);
        novoNo.setAnterior(cauda);
        cauda = novoNo;
    }
}

    public boolean removerInicio() {
    if (cabeca == null) {
        return false; // Lista vazia, não há o que remover
    }
    if (cabeca == cauda) {
        // Se há apenas um elemento na lista
        cabeca = cauda = null;
        return true;
    }
    cabeca = cabeca.getProximo();
    cabeca.setAnterior(null);
    return true;
}

    public boolean removerFim() {
    if (cabeca == null) {
        return false; // Lista vazia, não há o que remover
    }
    if (cabeca == cauda) {
        // Se há apenas um elemento na lista
        cabeca = cauda = null;
        return true;
    }
    cauda = cauda.getAnterior();
    cauda.setProximo(null);
    return true;
}
    
    public boolean remover(Integer elemento) {
        No atual = cabeca;
        while (atual != null) {
            if (atual.getElemento().equals(elemento)) {
                if (atual.getAnterior() != null) {
                    atual.getAnterior().setProximo(atual.getProximo());
                } else {
                    cabeca = atual.getProximo();
                }
                if (atual.getProximo() != null) {
                    atual.getProximo().setAnterior(atual.getAnterior());
                } else {
                    cauda = atual.getAnterior();
                }
                return true;
            }
            atual = atual.getProximo();
        }
        return false;
    }

    public void removerTodos(Integer elemento) {
        No atual = cabeca;
        while (atual != null) {
            No proximo = atual.getProximo();
            if (atual.getElemento().equals(elemento)) {
                if (atual.getAnterior() != null) {
                    atual.getAnterior().setProximo(atual.getProximo());
                } else {
                    cabeca = atual.getProximo();
                }
                if (atual.getProximo() != null) {
                    atual.getProximo().setAnterior(atual.getAnterior());
                } else {
                    cauda = atual.getAnterior();
                }
            }
            atual = proximo;
        }
    }

    public void listar() {
        No atual = cabeca;
        while (atual != null) {
            System.out.print(atual.getElemento() + " ");
            atual = atual.getProximo();
        }
        System.out.println();
    }

    public void buscar(Integer elemento) {
        No atual = cabeca;
        while (atual != null) {
            if (atual.getElemento().equals(elemento)) {
                System.out.println("O elemento " + elemento + " está presente na lista.");
                return;
            }
            atual = atual.getProximo();
        }
        System.out.println("O elemento " + elemento + " não está presente na lista.");
    }

    public Integer maior() {
        if (cabeca == null) {
            throw new RuntimeException("A lista está vazia.");
        }

        No atual = cabeca;
        Integer max = atual.getElemento();
        while (atual != null) {
            max = Math.max(max, atual.getElemento());
            atual = atual.getProximo();
        }
        return max;
    }

    public Integer menor() {
        if (cabeca == null) {
            throw new RuntimeException("A lista está vazia.");
        }

        No atual = cabeca;
        Integer min = atual.getElemento();
        while (atual != null) {
            min = Math.min(min, atual.getElemento());
            atual = atual.getProximo();
        }
        return min;
    }

    public double media() {
        if (cabeca == null) {
            throw new RuntimeException("A lista está vazia.");
        }

        No atual = cabeca;
        int soma = 0;
        int contagem = 0;
        while (atual != null) {
            soma += atual.getElemento();
            contagem++;
            atual = atual.getProximo();
        }
        return (double) soma / contagem;
    }

    public int quantidade() {
        No atual = cabeca;
        int contagem = 0;
        while (atual != null) {
            contagem++;
            atual = atual.getProximo();
        }
        return contagem;
    }
}
