package unitins.br;


import java.util.ArrayList;
import java.util.List;

/**
 * Implementação de Árvore Binária de Busca para o sistema eleitoral.
 * Organiza os dados por código de cidade para buscas rápidas.
 * 
 * DEVE implementar a interface ArvoreBinariaADT.
 */
public class ArvoreBinaria implements ArvoreBinariaADT<Integer> {
    private No<Integer> raiz;
    private int tamanho;          // Quantidade de nós (cidades distintas)
    private int totalRegistros;   // Quantidade total de registros

    /**
     * Construtor da árvore binária.
     */
    public ArvoreBinaria() {
        this.raiz = null;
        this.tamanho = 0;
        this.totalRegistros = 0;
    }

    @Override
    public void inserir(Integer chave, PerfilEleitor registro) {
        raiz = inserirRecursivo(raiz, chave, registro);
    }

    /**
     * Método recursivo para inserir um registro na árvore.
     */
    private No<Integer> inserirRecursivo(No<Integer> no, Integer chave, PerfilEleitor registro) {
        // Caso base: criar novo nó
        if (no == null) {
            No<Integer> novoNo = new No<>(chave, 100); // Capacidade inicial 100
            novoNo.adicionarRegistro(registro);
            tamanho++;
            totalRegistros++;
            return novoNo;
        }

        // Comparar chaves
        int comparacao = chave.compareTo(no.chave);

        if (comparacao == 0) {
            // Chave já existe: adicionar registro ao nó existente
            no.adicionarRegistro(registro);
            totalRegistros++;
        } else if (comparacao < 0) {
            // Inserir na subárvore esquerda
            no.esquerda = inserirRecursivo(no.esquerda, chave, registro);
        } else {
            // Inserir na subárvore direita
            no.direita = inserirRecursivo(no.direita, chave, registro);
        }

        return no;
    }

    @Override
    public PerfilEleitor[] buscar(Integer chave) {
        No<Integer> no = buscarNo(raiz, chave);
        if (no == null) {
            return new PerfilEleitor[0]; // Retorna array vazio se não encontrou
        }
        return no.getRegistros(); // Retorna cópia dos registros
    }

    /**
     * Método recursivo para buscar um nó pela chave.
     */
    private No<Integer> buscarNo(No<Integer> no, Integer chave) {
        if (no == null) {
            return null; // Não encontrado
        }

        int comparacao = chave.compareTo(no.chave);

        if (comparacao == 0) {
            return no; // Encontrou!
        } else if (comparacao < 0) {
            return buscarNo(no.esquerda, chave); // Buscar na esquerda
        } else {
            return buscarNo(no.direita, chave); // Buscar na direita
        }
    }

    @Override
    public boolean contem(Integer chave) {
        return buscarNo(raiz, chave) != null;
    }

    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public int totalRegistros() {
        return totalRegistros;
    }

    @Override
    public boolean estaVazia() {
        return raiz == null;
    }

    @Override
    public int altura() {
        return calcularAltura(raiz);
    }

    /**
     * Calcula a altura da árvore recursivamente.
     */
    private int calcularAltura(No<Integer> no) {
        if (no == null) {
            return 0;
        }
        int alturaEsquerda = calcularAltura(no.esquerda);
        int alturaDireita = calcularAltura(no.direita);
        return Math.max(alturaEsquerda, alturaDireita) + 1;
    }

    @Override
    public Integer[] emOrdem() {
        List<Integer> lista = new ArrayList<>();
        emOrdemRecursivo(raiz, lista);
        return lista.toArray(new Integer[0]);
    }

    /**
     * Percorre a árvore em ordem (esquerda -> raiz -> direita).
     */
    private void emOrdemRecursivo(No<Integer> no, List<Integer> lista) {
        if (no != null) {
            emOrdemRecursivo(no.esquerda, lista);
            lista.add(no.chave);
            emOrdemRecursivo(no.direita, lista);
        }
    }

    @Override
    public void limpar() {
        raiz = null;
        tamanho = 0;
        totalRegistros = 0;
    }
}