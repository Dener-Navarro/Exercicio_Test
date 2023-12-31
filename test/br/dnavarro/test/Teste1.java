package br.dnavarro.test;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class Teste1 {

    @Test
    public void testNomesAlunos() {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Maria", "F"));
        pessoas.add(new Pessoa("Jose", "M"));
        pessoas.add(new Pessoa("Rose", "F"));
        pessoas.add(new Pessoa("Pedro", "M"));
        pessoas.add(new Pessoa("Lucia", "F"));
        pessoas.add(new Pessoa("Roberto", "M"));

        List<Pessoa> mulheres = pessoas.stream()
                .filter(pessoa -> pessoa.getGenero().equals("F"))
                .collect(Collectors.toList());


        List<String> expectedFemaleNames = new ArrayList<>();
        expectedFemaleNames.add("Maria");
        expectedFemaleNames.add("Rose");
        expectedFemaleNames.add("Lucia");


        List<String> actualFemaleNames = mulheres.stream()
                .map(Pessoa::getNome)
                .collect(Collectors.toList());


        assertEquals(expectedFemaleNames, actualFemaleNames);
    }
}
