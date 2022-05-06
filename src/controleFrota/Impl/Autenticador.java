package controleFrota.Impl;

import controleFrota.Autenticavel;

// TODO: Criar lista de autenticados e implementar o método autenticar.

public class Autenticador {
    public boolean autenticar(Autenticavel autenticavel) {
        String credenciais = autenticavel.obterCredenciais();
        
        System.out.println("Liberando acesso a empresa para: " + credenciais);

        return true;        
    }
}
