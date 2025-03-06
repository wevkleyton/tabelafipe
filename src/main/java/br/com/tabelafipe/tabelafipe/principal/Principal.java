package br.com.tabelafipe.tabelafipe.principal;

import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);

    public void exibeMenu(){
        var menu = """
                *** OPÇÔES ***
                -> Carro
                -> Moto
                -> Caminhão
                -> Digite uma das opções para consulta:
                """ ;

        System.out.println(menu);
        var opcao = leitura.nextLine();



    }
}
