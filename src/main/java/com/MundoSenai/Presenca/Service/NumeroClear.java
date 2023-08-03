package com.MundoSenai.Presenca.Service;

public class NumeroClear {
    public static String cleanNumber(String num) {
        // Remove caracteres, apenas os dígitos serão mantidos
        return num.replaceAll("[^0-9]", "");
    }
}
