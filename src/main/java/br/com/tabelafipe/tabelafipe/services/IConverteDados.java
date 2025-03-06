package br.com.tabelafipe.tabelafipe.services;

public interface IConverteDados {
    <T> T obterDados (String json, Class<T> classe);
}
