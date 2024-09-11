**1. Classe Veiculo**

-   [x] Criar a classe `Veiculo`
-   [x] **Atributos:**
    -   [x] `placa` (String)
    -   [x] `modelo` (String)
    -   [x] `problema` (String)
    -   [x] `valorDoServico` (double)
-   [x] **Métodos:**
    -   [x] Construtor vazio
    -   [x] Construtor com parâmetros (`placa`,  `modelo`,  `problema`,  `valorDoServico`)
    -   [x] Métodos `get` e `set` para todos os atributos
    -   [x] `toString()` para retornar uma representação em string do objeto

**2. Classe VetVeiculo**

-   [x] Criar a classe `VetVeiculo`
-   [x] **Atributos:**
    -   [x] `veiculos` (ArrayList de `Veiculo`)
-   [x] **Métodos:**
    -   [x] Construtor vazio
    -   [x] `getQuantidadeVeiculos()` (retorna o tamanho do ArrayList)
    -   [x] `getPos(int posicao)` (retorna o `Veiculo` na posição especificada ou `null` se inválida)
    -   [x] `pesquisarPorPlaca(String placa)` (retorna a posição do `Veiculo` ou -1 se não encontrado)
    -   [x] `inserirVeiculo(Veiculo veiculo)` (insere se não existir e retorna `true`, caso contrário `false`)
    -   [x] `removerVeiculo(Veiculo veiculo)` (remove se existir e retorna `true`, caso contrário `false`)

**3. Classe Oficina com método main**

-   [x] Criar a classe `Oficina`
-   [x] **Método main:**
    -   [x] Criar um objeto `VetVeiculo` para armazenar os veículos
    -   [x] Implementar um loop para exibir o menu e receber a opção do usuário
    -   [x] **Opções do menu:**
        -   [x] 1.  `adicionarVeiculo()`
        -   [x] 2.  `pesquisarVeiculo()`
        -   [x] 3.  `removerVeiculo()`
        -   [x] 4.  `listarVeiculos()`
        -   [x] 5. Sair do programa (encerra o loop)
    -   [x] Manter o método `main` o mais enxuto possível, delegando a lógica para os outros métodos

**Observações:**

-   [x] Implemente a lógica do menu usando um loop, de modo que o programa continue até que o usuário escolha sair.
-   [x] Cada opção do menu (exceto o SAIR) deve ser um método
-   [x] O método main deve ser o mais enxuto possível
