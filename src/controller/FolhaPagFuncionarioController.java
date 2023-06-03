package controller;

import model.FolhaPagFuncionario;
import util.Input;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FolhaPagFuncionarioController {

    public void cadastrar(){
        FolhaPagFuncionario folhaPagFuncionario = new FolhaPagFuncionario();
    }

    public void setarDados(FolhaPagFuncionario f){
        System.out.println("informe seu ano de referencia:");
        f.setAnoReferencia(Input.nextInt());
        System.out.println("informe seu mes de referencia:");
        f.setMesReferencia(Input.nextInt());
        System.out.println("informe a data de pagamento:");
        String dataPagamento = Input.nextLine();
        f.setDataPagamento(LocalDate.parse(dataPagamento, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("informe as horas trabalhadas:");
        double horasTrabalhadas = Input.nextDouble();
        Duration duracao = Duration.ofHours((long) horasTrabalhadas);
        f.setHorasTrabalhadas(LocalTime.MIDNIGHT.plus(duracao));
        System.out.println("informe a quantidade de faltas sem justificativa:");
        f.setFaltasSemJustificativa(Input.nextInt());
        System.out.println("informe o salario base:");
        f.setSalarioBase(Input.nextDouble());
        System.out.println("informe as horas extras:");
        f.setValorHorasExtras(Input.nextDouble());
        System.out.println("informe o total de proventos");
        f.setTotalProventos(Input.nextDouble());
        System.out.println("informe o valor do vale transporte:");
        f.setValorValeTransporte(Input.nextDouble());
        System.out.println("informe o valor do vale alimentacao:");
        f.setDescontoValeAlimentacao(Input.nextDouble());
        System.out.println("informe o desconto do INSS:");
        f.setDescontoINSS(Input.nextDouble());
        System.out.println("informe o desconto do IR:");
        f.setDescontoIR(Input.nextDouble());
        System.out.println("informe o desconto do vale transporte:");
        f.setDescontoValeTransporte(Input.nextDouble());
        System.out.println("informe o desconto do vale alimentacao:");
        f.setDescontoValeAlimentacao(Input.nextDouble());
        System.out.println("informe o valor do FGTS:");
        f.setValorFGTS(Input.nextDouble());
        System.out.println("informe o total de descontos:");
        f.setTotalDescontos(Input.nextDouble());
        System.out.println("informe o salario liquido:");
        f.setSalarioLiquido(Input.nextDouble());

    }

}
