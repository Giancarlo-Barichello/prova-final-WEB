package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(
            @RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("OLA %s!", name);
    }

    @GetMapping("/cpf")
    public String cpf(
            @RequestParam(value = "number", defaultValue = "123.456.789-10") String cpf) {
        return String.format("CPF: %s", cpf);
    }

    @GetMapping("/endereco")
    public String endereco(
            @RequestParam(value = "number", defaultValue = "João da Silva - Rua das Flores, 123") String endereco) {
        return String.format("Endereco: %s", endereco);
    }

    @GetMapping("/soma")
    public String soma(
            @RequestParam(value = "a") int a,
            @RequestParam(value = "b") int b) {

        int resultado = a + b;
        return "Resultado: " + resultado;
    }

    @GetMapping("/aluno")
    public String aluno() {
        return "Nome: João da Silva\nCurso: Sistemas de Informação";
    }

    @GetMapping("/professor")
    public String professor() {
        return "Professor: Ana Paula Canal\nDisciplina: Sistemas Operacionais";
    }

    // Exercício 3 - Calculadora, precisei da ajuda de I.A
    @GetMapping("/calculadora")
    public String calculadora(
            @RequestParam int a,
            @RequestParam int b,
            @RequestParam String operacao) {

        switch (operacao.toLowerCase()) {
            case "soma":
                return "Resultado: " + (a + b);

            case "subtracao":
                return "Resultado: " + (a - b);

            case "multiplicacao":
                return "Resultado: " + (a * b);

            case "divisao":
                if (b == 0) {
                    return "Não é possível dividir por zero";
                }
                return "Resultado: " + (a / b);

            default:
                return "Operação inválida";
        }
    }
}
