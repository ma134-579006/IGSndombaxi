package escola.com.pt.gerenciamento.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import escola.com.pt.gerenciamento.model.Aluno;

public interface AlunoDao extends JpaRepository<Aluno, Integer> {
    @Query("select m from Aluno m where m.status='ATIVO'")
    public List<Aluno> findByStatusAtivos();

    @Query("select e from Aluno e where e.status='INATIVO'")
    public List<Aluno> findByStatusInativos();

    @Query("select a from Aluno a where a.status='TRANCADO'")
    public List<Aluno> findByStatusTrancado();

    @Query("select b from Aluno b where b.status='CANCELADO'")
    public List<Aluno> findByStatusCancelado();

    public List<Aluno> findByNomeContainingIgnoreCase(String nome);

}
