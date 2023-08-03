package com.MundoSenai.Presenca.Service;

public class CPFValidator {
    public class CpfValidador {

        public static boolean isValidCPF(String cpf) {
            // Remover caracteres não numéricos
            cpf = NumeroClear.cleanNumber(cpf);

            // Verificar se o CPF possui 11 dígitos
            if (cpf.length() != 11) {
                return false;
            }

            // Verificar se todos os dígitos são iguais (CPF inválido)
            boolean allDigitsEqual = true;
            for (int i = 1; i < 11; i++) {
                if (cpf.charAt(i) != cpf.charAt(0)) {
                    allDigitsEqual = false;
                    break;
                }
            }
            if (allDigitsEqual) {
                return false;
            }

            // Calcular o primeiro dígito verificador
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                int digit = Character.getNumericValue(cpf.charAt(i));
                sum += digit * (10 - i);
            }
            int firstVerifier = 11 - (sum % 11);
            if (firstVerifier >= 10) {
                firstVerifier = 0;
            }

            // Calcular o segundo dígito verificador
            sum = 0;
            for (int i = 0; i < 10; i++) {
                int digit = Character.getNumericValue(cpf.charAt(i));
                sum += digit * (11 - i);
            }
            int secondVerifier = 11 - (sum % 11);
            if (secondVerifier >= 10) {
                secondVerifier = 0;
            }

            // Verificar se os dígitos verificadores estão corretos
            return (firstVerifier == Character.getNumericValue(cpf.charAt(9)))
                    && (secondVerifier == Character.getNumericValue(cpf.charAt(10)));
        }

        }
    }


