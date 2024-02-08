package escola.com.pt.gerenciamento.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import escola.com.pt.gerenciamento.dao.UsuarioDao;
import escola.com.pt.gerenciamento.model.ModelUsuario;
import escola.com.pt.gerenciamento.util.Util;

@Service
public class ServiceUsuario {
    @Autowired
    private UsuarioDao repositorioUsuario;

    public void salvarUsuario(ModelUsuario user) throws Exception {

        try {
            if (repositorioUsuario.findByEmail(user.getEmail()) != null) {
                throw new EmailExgistExceptio("já existe um Email Cadastrado para: " + user.getEmail());

            }

            user.setSenha(Util.md5(user.getSenha()));
        } catch (NoSuchAlgorithmException e) {
            throw new CriptoExistException("Erro na criptografia da senha");

        }
        repositorioUsuario.save(user);
    }

    public ModelUsuario loginUser(String user, String senha) throws ServiceExc {
        ModelUsuario userLogin = repositorioUsuario.buscarLogin(user, senha);
        return userLogin;

    }
}
