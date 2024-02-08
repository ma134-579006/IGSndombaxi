package escola.com.pt.gerenciamento.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id; // Correção na importação
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class ModelUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Email
    private String email;
    @Size(min = 3, max = 20, message = "Usuario deve conter entre 3 a 20 caracteres")
    private String user;
    private String senha;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
