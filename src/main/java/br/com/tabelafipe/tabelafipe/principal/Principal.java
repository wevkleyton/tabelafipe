package br.com.tabelafipe.tabelafipe.principal;

import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);

<<<<<<< HEAD

    public void exibeMenu(){
        System.out.println("Digite o tipo do Veiculo");
        System.out.println("Caminhão, Carro ou Moto!");
=======
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


>>>>>>> 23f3993c6e1a5e91060204e634732bd1e42c2ce8

    }
}
