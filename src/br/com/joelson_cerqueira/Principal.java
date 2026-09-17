package br.com.joelson_cerqueira;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class Principal {

    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        NumberFormat nf = NumberFormat.getNumberInstance(new Locale.Builder().setLanguage("pt").setRegion("BR").build());
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);

        // 3.1 – Inserir todos os funcionários
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Maria",   LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João",    LocalDate.of(1990, 12,  5), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio",    LocalDate.of(1961,  5,  2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel",  LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice",   LocalDate.of(1995,  1,  5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor",  LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur",  LocalDate.of(1993,  3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura",   LocalDate.of(1994,  7,  8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003,  5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena",  LocalDate.of(1996,  9,  2), new BigDecimal("2799.93"), "Gerente"));

        // 3.2 – Remover o funcionário "João"
        funcionarios.removeIf(f -> f.getNome().equals("João"));

        // 3.3 – Imprimir todos os funcionários
        System.out.println("============================================================");
        System.out.println(" 3.3 – LISTA DE FUNCIONÁRIOS");
        System.out.println("============================================================");
        for (Funcionario f : funcionarios) {
            System.out.printf("Nome: %-10s | Nascimento: %s | Salário: R$ %s | Função: %s%n",
                    f.getNome(),
                    f.getDataNascimento().format(formatter),
                    nf.format(f.getSalario()),
                    f.getFuncao());
        }

        // 3.4 – Aumento de 10% no salário
        for (Funcionario f : funcionarios) {
            BigDecimal novoSalario = f.getSalario().multiply(new BigDecimal("1.10"));
            f.setSalario(novoSalario);
        }

        // 3.5 – Agrupar funcionários por função em um Map
        Map<String, List<Funcionario>> porFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        // 3.6 – Imprimir funcionários agrupados por função
        System.out.println("\n============================================================");
        System.out.println(" 3.6 – FUNCIONÁRIOS AGRUPADOS POR FUNÇÃO (após aumento 10%)");
        System.out.println("============================================================");
        porFuncao.forEach((funcao, lista) -> {
            System.out.println("\n[ " + funcao + " ]");
            for (Funcionario f : lista) {
                System.out.printf("  Nome: %-10s | Nascimento: %s | Salário: R$ %s%n",
                        f.getNome(),
                        f.getDataNascimento().format(formatter),
                        nf.format(f.getSalario()));
            }
        });

        // 3.8 – Funcionários que fazem aniversário nos meses 10 e 12
        System.out.println("\n============================================================");
        System.out.println(" 3.8 – ANIVERSARIANTES DOS MESES 10 E 12");
        System.out.println("============================================================");
        funcionarios.stream()
                .filter(f -> f.getDataNascimento().getMonthValue() == 10
                          || f.getDataNascimento().getMonthValue() == 12)
                .forEach(f -> System.out.printf("Nome: %-10s | Nascimento: %s%n",
                        f.getNome(),
                        f.getDataNascimento().format(formatter)));

        // 3.9 – Funcionário com maior idade
        System.out.println("\n============================================================");
        System.out.println(" 3.9 – FUNCIONÁRIO COM MAIOR IDADE");
        System.out.println("============================================================");
        Funcionario maisVelho = funcionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .orElseThrow();
        int idade = Period.between(maisVelho.getDataNascimento(), LocalDate.now()).getYears();
        System.out.printf("Nome: %s | Idade: %d anos%n", maisVelho.getNome(), idade);

        // 3.10 – Lista de funcionários em ordem alfabética
        System.out.println("\n============================================================");
        System.out.println(" 3.10 – FUNCIONÁRIOS EM ORDEM ALFABÉTICA");
        System.out.println("============================================================");
        funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(f -> System.out.printf("Nome: %-10s | Nascimento: %s | Salário: R$ %s | Função: %s%n",
                        f.getNome(),
                        f.getDataNascimento().format(formatter),
                        nf.format(f.getSalario()),
                        f.getFuncao()));

        // 3.11 – Total dos salários
        System.out.println("\n============================================================");
        System.out.println(" 3.11 – TOTAL DOS SALÁRIOS");
        System.out.println("============================================================");
        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total: R$ " + nf.format(totalSalarios));

        // 3.12 – Quantos salários mínimos cada funcionário ganha
        System.out.println("\n============================================================");
        System.out.println(" 3.12 – SALÁRIOS MÍNIMOS POR FUNCIONÁRIO (SM = R$ 1.212,00)");
        System.out.println("============================================================");
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(f -> {
                    BigDecimal qtdSM = f.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
                    System.out.printf("Nome: %-10s | Salário: R$ %s | Qtd. Sal. Mínimos: %s%n",
                            f.getNome(),
                            nf.format(f.getSalario()),
                            nf.format(qtdSM));
                });
    }
}
