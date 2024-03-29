package com.MundoSenai.Presenca.Service;

import com.MundoSenai.Presenca.Model.m_Pessoa;
import com.MundoSenai.Presenca.Repostory.R_Pessoa;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class s_Pessoa {
    private static R_Pessoa r_Pessoa;

    public s_Pessoa(R_Pessoa r_Pessoa){
        this.r_Pessoa = r_Pessoa;
    }

    public static m_Pessoa getPessoaLogin(String usuario, String senha){
        return r_Pessoa.findByUsuarioESenha(Long.valueOf(usuario),senha);
    }

    public static void cadastrarPessoa(String nome, String email, String cpf, String telefone, String datanasc, String senha, String conf_senha){
    if(senha.equals(conf_senha)) {
        return "A senha e a confimarção de senha deve ser igual";
    }else if(!CPFValidator.valiadorCPF(cpf)) {
        return "cpf invalido";
    }else if(nome == null || nome.trim() == "" ) {
        return "Deve ser informado o nome";
    }else if ((email == null || email.trim() == "") && (NumeroClear.cleanNumber(telefone) == null
              || NumeroClear.cleanNumber(telefone).trim() == "")) {
        return "e-mail ou telefone precisa ser informado";
    }else{
        m_Pessoa M_Pessoa = new m_Pessoa();
        M_Pessoa.setNome(nome);
        M_Pessoa.setCpf(Long.valueOf(cpf));
        M_Pessoa.setTelefone(Long.valueOf(telefone));
        M_Pessoa.setEmail(email);
        M_Pessoa.setData_nasc(LocalDate.parse(datanasc));
        M_Pessoa.setSenha(senha);
        r_Pessoa.save(M_Pessoa);
    }
     return "Cadastro efetuado com sucesso";
    }
}
