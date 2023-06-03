package controller;

import model.Funcionario;
import util.Input;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.zip.DataFormatException;

public class FuncionarioController {

    public void cadatrar(){
        Funcionario funcionario = new Funcionario();
    }

    public void setarDados(Funcionario f){
        System.out.println("informe seu ctps:");
        f.setCtps(Input.nextLine());
        System.out.println("informe sua data de admissão: (00/00/0000)");
        String dataAdmissao = Input.nextLine();
        f.setDataAdmissao(LocalDate.parse(dataAdmissao, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("informe sua data de demissão: (00/00/0000)");
        String dataDemissao = Input.nextLine();
        f.setDataAdmissao(LocalDate.parse(dataDemissao, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("informe seu salario:");
        f.setSalario(Input.nextDouble());

    }
}
