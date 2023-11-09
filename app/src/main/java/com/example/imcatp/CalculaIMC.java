package com.example.imcatp;

public class CalculaIMC {
    private final double altura;
    private final double peso;

    public CalculaIMC(double altura, double peso) {
        this.altura = altura;
        this.peso = peso;
    }

    public double getIMC() {
        double alturaQuadrado = this.altura * this.altura;
        return this.peso / alturaQuadrado;
    }

    public String getClassificacao() {
        double imc = getIMC();
        if (imc < 16) return "Magreza grave";
        else if (imc >= 16 && imc <= 16.9) return "Magreza moderada";
        else if (imc >= 17 && imc <= 18.5) return "Magreza leve";
        else if (imc >= 18.6 && imc <= 24.9) return "Normal";
        else if (imc >= 25 && imc <= 29.9) return "Sobrepeso";
        else if (imc >= 30 && imc <= 34.9) return "Obesidade grau I";
        else if (imc >= 35 && imc <= 39.9) return "Obesidade grau II ou severa";
        else return "Obesidade grau III ou mórbida";
    }

}
