package escola.com.pt.gerenciamento.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import escola.com.pt.gerenciamento.model.ModelUsuario;

public interface UsuarioDao extends JpaRepository<ModelUsuario, Long> {

    @Query("select i from ModelUsuario i where i.email= :email ")
    public ModelUsuario findByEmail(String email);

    @Query("select m from ModelUsuario m where m.user= :user and m.senha=:senha ")
    public ModelUsuario buscarLogin(String user, String senha);

}