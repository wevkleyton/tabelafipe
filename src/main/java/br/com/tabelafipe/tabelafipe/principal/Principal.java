package br.com.tabelafipe.tabelafipe.principal;

import br.com.tabelafipe.tabelafipe.model.Dados;
import br.com.tabelafipe.tabelafipe.model.Modelos;
import br.com.tabelafipe.tabelafipe.model.Veiculo;
import br.com.tabelafipe.tabelafipe.services.ConsumoAPI;
import br.com.tabelafipe.tabelafipe.services.ConverteDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";
    private ConsumoAPI consumo = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();

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
        String endereco ;
        if (opcao.toLowerCase().contains("carr")){
            endereco = URL_BASE + "carros/marcas";
        }else if (opcao.toLowerCase().contains("mot")){
            endereco = URL_BASE + "motos/marcas";
        }else{
            endereco = URL_BASE + "caminhoes/marcas";
        }

        var json = consumo.obterDados(endereco);
        System.out.println(json);
        var marcas = conversor.obterLista(json, Dados.class);
        marcas.stream().sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.println("Informe o codigo da marca para consulta: ");
        var codigoMarca =leitura.nextLine();
        endereco = endereco + "/" + codigoMarca + "/modelos";
        json = consumo.obterDados(endereco);
        var modeloLista = conversor.obterDados(json, Modelos.class);
        System.out.println("/nModelos dessa masca: ");
        modeloLista.modelos().stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.println("/nDigite o trecho do nome do carro a ser buscado");
        var nomeveiculo = leitura.nextLine();
        List<Dados> modelosFiltrados = modeloLista.modelos().stream()
                .filter(m -> m.nome().toLowerCase().contains(nomeveiculo.toLowerCase()))
                        .collect(Collectors.toList());
        System.out.println("/nModelos Filtrados");
        modelosFiltrados.forEach(System.out::println);
        System.out.println("Digite por favor o codigo do modelo para buscar os valores de avaliacao");
        var codigoModelo = leitura.nextLine();
        endereco = endereco + "/" + codigoModelo + "/anos";
        json = consumo.obterDados(endereco);
        List<Dados> anos = conversor.obterLista(json, Dados.class);
        List<Veiculo> veiculos = new ArrayList<>();

        for (int i = 0; i < anos.size(); i++){
            var enderecoAnos = endereco + "/" + anos.get(i).codigo();
            json = consumo.obterDados(enderecoAnos);
            Veiculo veiculo = conversor.obterDados(json, Veiculo.class);
            veiculos.add(veiculo);

        }
        System.out.println("Todos os veiculos fintrados vom avaliacao por ano");
        veiculos.forEach(System.out::println);


    }
}
