# Trabalho A2 - Estrutura de Dados - UNITINS

## 👥 Grupo - Integrantes:
- **Ana Vitoria**
- **Ana Caroline** 
- **Daniel Holanda**

## 📋 Descrição
Implementação de árvore binária para sistema de consulta de dados eleitorais do TSE.

## 🚀 Funcionalidades
- ✅ Carregamento de dados do TSE
- ✅ Árvore binária por código de cidade
- ✅ Buscas otimizadas O(log n)
- ✅ Consultas por perfil demográfico
- ✅ Comparação de desempenho array vs árvore

## 🚀 Como Executar o Projeto

### **Pré-requisitos**
- Java JDK 17 ou superior
- Terminal/Command Prompt

### **Execução com Java Direto (Método Recomendado)**

```bash
# 1. Navegue até a pasta do projeto
cd C:\MeusProjetos\TrabalhoA2\estdadosA2-main

# 2. Compile o código
javac -d target/classes -cp "src/main/java" src/main/java/unitins/br/*.java

# 3. Execute o programa
java -cp "target/classes" unitins.br.App  

## 🛠 Tecnologias
- Java
- Maven
- Árvore Binária de Busca

## 📊 Resultados
- Tempo de construção da árvore: ~50ms
- Busca por cidade: O(log n) vs O(n) do array
- Melhoria significativa em grandes volumes de dados
