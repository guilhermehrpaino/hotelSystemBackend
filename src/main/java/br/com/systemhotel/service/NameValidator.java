package br.com.systemhotel.service;

public class NameValidator {
    public static boolean isValid(String name) {
        if (name == null || name.isBlank()) { // validamos se a linha esta vazia
            return false;
        }
        if (name.length() < 3) { // valida se o nome esta "completo"
            return false;
        }
            return name.matches("[A-Za-zÀ-ÿ ]+"); // regex para ver se a linha contem apenas letras
    }
}
