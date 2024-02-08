package escola.com.pt.gerenciamento.Enum;

public enum Curso {
    ENGENHARIA("Engenharia Informática"),
    RG("Recursos Humanos"),
    DIREITO("Direito"),
    ARQ("Arquitetura");

    private String curso;

    private Curso(String curso) {
        this.curso = curso;
    }

}
