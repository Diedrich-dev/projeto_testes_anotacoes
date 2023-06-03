package controller;

import model.Cargo;
import util.Input;

import java.time.Duration;
import java.time.LocalTime;

public class CargoController {

    public void cadastrar(){
        Cargo cargo = new Cargo();
    }

    public void setarDados(Cargo c){
        System.out.println("informe a descricao do cargo:");
        c.setDescricao(Input.nextLine());
        System.out.println("informe a carga horario mensal:");
        double cargaHoraria = Input.nextDouble();
        Duration duracao = Duration.ofHours((long) cargaHoraria);
        c.setCargaHorariaMensal(LocalTime.MIDNIGHT.plus(duracao));
    }
}
