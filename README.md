# 🏭 Iniflex - Teste Prático Java

Projeto desenvolvido como parte do processo seletivo para a vaga de **Desenvolvedor Júnior** na **Iniflex**.

---

## 📋 Sobre o Projeto

O sistema gerencia uma lista de funcionários de uma indústria, realizando diversas operações como cadastro, remoção, agrupamento, ordenação e cálculos salariais — tudo utilizando recursos modernos do Java.

---

## 🗂️ Estrutura das Classes

```
src/
└── br/com/joelson_cerqueira/
    ├── Pessoa.java        → Classe base com nome e data de nascimento
    ├── Funcionario.java   → Estende Pessoa, adiciona salário e função
    └── Principal.java     → Classe principal com todas as operações
```

---

## ⚙️ Funcionalidades Implementadas

| # | Descrição |
|---|-----------|
| 3.1 | Inserção de todos os funcionários conforme tabela fornecida |
| 3.2 | Remoção do funcionário **João** da lista |
| 3.3 | Listagem com data no formato `dd/MM/yyyy` e salário formatado (R$ 1.000,00) |
| 3.4 | Aumento de **10%** no salário de todos os funcionários |
| 3.5 | Agrupamento dos funcionários por função em um `Map` |
| 3.6 | Impressão dos funcionários agrupados por função |
| 3.8 | Listagem dos aniversariantes dos meses **10** e **12** |
| 3.9 | Exibição do funcionário com **maior idade** |
| 3.10 | Listagem em **ordem alfabética** |
| 3.11 | Cálculo e exibição do **total de salários** |
| 3.12 | Quantidade de **salários mínimos** que cada funcionário recebe (SM = R$ 1.212,00) |

---

## 🚀 Como Executar

### Pré-requisitos
- Java 17+ instalado
- Eclipse IDE (ou qualquer IDE Java)

### Passos
1. Clone o repositório:
   ```bash
   git clone https://github.com/Joelson0935/Iniflex_Joelson_Cerqueira.git
   ```
2. Importe o projeto no Eclipse:
   `File → Import → Existing Projects into Workspace`
3. Abra a classe `Principal.java` e execute com **Ctrl + F11**

---

## 🛠️ Tecnologias Utilizadas

- **Java 21**
- `java.time.LocalDate` — manipulação de datas
- `java.math.BigDecimal` — precisão em cálculos monetários
- `java.util.stream` — operações funcionais sobre coleções
- `java.text.NumberFormat` — formatação de valores em Real (BRL)

---

## 👤 Autor

**Joelson Cerqueira**  
[![GitHub](https://img.shields.io/badge/GitHub-Joelson0935-181717?style=flat&logo=github)](https://github.com/Joelson0935)
