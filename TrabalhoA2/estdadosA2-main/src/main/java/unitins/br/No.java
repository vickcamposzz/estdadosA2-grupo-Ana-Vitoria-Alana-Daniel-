package unitins.br;


/**
 * Classe que representa um nó da árvore binária.
 * Cada nó armazena uma chave (código da cidade) e todos os registros dessa cidade.
 */
public class No<T extends Comparable<T>> {
    T chave;                    // Código da cidade (ex: 1200401)
    PerfilEleitor[] registros;  // Array com TODOS os registros desta cidade
    int qtdRegistros;           // Quantidade de registros no array
    int capacidade;             // Capacidade atual do array
    No<T> esquerda;            // Filho esquerdo
    No<T> direita;             // Filho direito

    /**
     * Construtor do nó.
     * @param chave Código da cidade
     * @param capacidadeInicial Capacidade inicial do array de registros
     */
    public No(T chave, int capacidadeInicial) {
        this.chave = chave;
        this.capacidade = capacidadeInicial;
        this.registros = new PerfilEleitor[capacidade];
        this.qtdRegistros = 0;
        this.esquerda = null;
        this.direita = null;
    }

    /**
     * Adiciona um registro ao nó.
     * Expande o array se necessário.
     * @param registro Registro a ser adicionado
     */
    public void adicionarRegistro(PerfilEleitor registro) {
        // Se o array está cheio, expandir
        if (qtdRegistros >= capacidade) {
            int novaCapacidade = capacidade * 2;
            PerfilEleitor[] novoArray = new PerfilEleitor[novaCapacidade];
            System.arraycopy(registros, 0, novoArray, 0, qtdRegistros);
            registros = novoArray;
            capacidade = novaCapacidade;
        }
        // Adicionar registro
        registros[qtdRegistros++] = registro;
    }

    /**
     * Retorna uma cópia dos registros com tamanho exato.
     * @return Array com os registros (sem espaços vazios)
     */
    public PerfilEleitor[] getRegistros() {
        PerfilEleitor[] resultado = new PerfilEleitor[qtdRegistros];
        System.arraycopy(registros, 0, resultado, 0, qtdRegistros);
        return resultado;
    }
}
