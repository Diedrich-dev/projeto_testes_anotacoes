package controller;

import model.Pessoa;
import util.Input;

public class PessoaController {

    public void cadastrar(){
        Pessoa pessoa = new Pessoa();
    }

    public void setarDados(Pessoa p){
        System.out.println("informe seu nome:");
        p.setNome(Input.nextLine());
        System.out.println("informe seu cpf:");
        p.setCpf(Input.nextLine());
        System.out.println("informe seu e-mail:");
        p.setEmail(Input.nextLine());
        System.out.println("informe seu telefone:");
        p.setTelefone(Input.nextLine());
    }

}
