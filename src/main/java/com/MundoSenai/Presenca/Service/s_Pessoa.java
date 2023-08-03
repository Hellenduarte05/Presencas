package com.MundoSenai.Presenca.Service;

import com.MundoSenai.Presenca.Model.m_Pessoa;
import com.MundoSenai.Presenca.Repostory.R_Pessoa;
import org.springframework.stereotype.Service;

@Service
public class s_Pessoa {
    private static R_Pessoa r_Pessoa;

    public s_Pessoa(R_Pessoa r_Pessoa){
        this.r_Pessoa = r_Pessoa;
    }

    public static m_Pessoa getPessoaLogin(String usuario, String senha){
        return r_Pessoa.findByUsuarioESenha(Long.valueOf(usuario),senha);
    }
}
