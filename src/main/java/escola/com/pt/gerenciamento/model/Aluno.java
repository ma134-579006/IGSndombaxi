package escola.com.pt.gerenciamento.model;

import escola.com.pt.gerenciamento.Enum.Curso;
import escola.com.pt.gerenciamento.Enum.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome")
    @Size(min = 5, max = 35, message = "O nome deve conter no mínimo 5 caracteres")
    @NotBlank(message = "O nome não pode ser vazio.")
    private String nome;

    @Column(name = "curso")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "O campo curso não pode ser nulo")
    private Curso curso;

    @Column(name = "matricula", length = 6)
    @NotNull(message = "Clique no botão gerar")
    @Size(min = 3, message = "Clique no botão gerar matricula")
    private String matricula;

    @Column(name = "turno")
    @NotBlank(message = "O campo turno não pode ser vazio")
    @Size(min = 4, message = "No minimo 4 caracteres")
    private String turno;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "O campo status não pode ser nulo.")
    private Status status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}