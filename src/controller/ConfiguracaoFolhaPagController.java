package controller;

import model.ConfiguracaoFolhaPag;
import util.Input;

public class ConfiguracaoFolhaPagController {

    public void cadastrar(){
        ConfiguracaoFolhaPag configuracaoFolhaPag = new ConfiguracaoFolhaPag();
    }

    public void setarDados(ConfiguracaoFolhaPag c){
        System.out.println("informe o ano vigencia:");
        c.setAnoVigencia(Input.nextInt());
//        System.out.println("informe se esta ativo: true ou false");
//        c.setAtivo(Input.nextBoolean());
        System.out.println("informe o valor dia do vale alimentacao:");
        c.setValorDiaValeAlimentacao(Input.nextDouble());
        System.out.println("informe o valor dia do vale transporte:");
        c.setValorDiaValeTransporte(Input.nextDouble());
        System.out.println("informe o percentual de desconto do vale transporte:");
        c.setPercentualDescontoValeTransporte(Input.nextDouble());
        System.out.println("informe o percentual de desconto do vale alimentacao:");
        c.setPercentualDescontoValeAlimentacao(Input.nextDouble());

    }
}
