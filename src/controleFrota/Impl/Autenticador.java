package controleFrota.Impl;

import controleFrota.Autenticavel;

public class Autenticador {
    public boolean autenticar(Autenticavel autenticavel) {
        String credenciais = autenticavel.obterCredenciais();
        
        System.out.println("Liberando acesso a empresa para: " + credenciais);

        return true;        
    }
}
