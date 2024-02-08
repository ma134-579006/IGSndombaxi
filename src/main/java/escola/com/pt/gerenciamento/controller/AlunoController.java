package escola.com.pt.gerenciamento.controller;

import escola.com.pt.gerenciamento.dao.AlunoDao;
import escola.com.pt.gerenciamento.model.Aluno;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlunoController {
    @Autowired
    private AlunoDao alunorepositorio;

    @GetMapping("/inserirAlunos")
    public ModelAndView insertAlunos(Aluno aluno) {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("estudante/formAluno");
        mv.addObject("aluno", new Aluno());
        return mv;
    }

    @SuppressWarnings("null")
    @PostMapping("InsertAlunos")
    public ModelAndView inserirAluno(@Valid Aluno aluno, BindingResult br) {
        ModelAndView mv = new ModelAndView();
        if (br.hasErrors()) {
            mv.setViewName("estudante/formAluno");
            mv.addObject("aluno");
        } else {

            mv.setViewName("redirect:/alunos-adcionados");
            alunorepositorio.save(aluno);
        }
        return mv;

    }

    @GetMapping("alunos-adcionados")
    public ModelAndView listagemAlunos() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("estudante/listAlunos");
        mv.addObject("alunosList", alunorepositorio.findAll());
        return mv;
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Integer id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("estudante/alterar");
        @SuppressWarnings({ "null", "deprecation" })
        Aluno aluno = alunorepositorio.getOne(id);
        mv.addObject("aluno", aluno);
        return mv;

    }

    @SuppressWarnings("null")
    @PostMapping("/alterar")
    public ModelAndView alterar(Aluno aluno) {
        ModelAndView mv = new ModelAndView();
        alunorepositorio.save(aluno);
        mv.setViewName("redirect:/alunos-adcionados");
        return mv;
    }

    @SuppressWarnings("null")
    @GetMapping("/excluir/{id}")
    public String excluirAluno(@PathVariable("id") Integer id) {
        alunorepositorio.deleteById(id);
        return "redirect:/alunos-adcionados";
    }

    @GetMapping("filtro-alunos")
    public ModelAndView filtroAlunos() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("estudante/filtroAlunos");
        return mv;
    }

    @GetMapping("alunos-ativos")
    public ModelAndView listaAtivos() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("estudante/alunos-ativos");
        mv.addObject("alunosAtivos", alunorepositorio.findByStatusAtivos());
        return mv;
    }

    @GetMapping("alunos-inativos")
    public ModelAndView listaInativos() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("estudante/alunos-inativos");
        mv.addObject("alunosInativos", alunorepositorio.findByStatusInativos());
        return mv;
    }

    @GetMapping("alunos-trancados")
    public ModelAndView listaTrancados() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("estudante/alunos-trancados");
        mv.addObject("alunosTrancados", alunorepositorio.findByStatusTrancado());
        return mv;
    }

    @GetMapping("alunos-cancelados")
    public ModelAndView listaCancelados() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("estudante/alunos-trancados");
        mv.addObject("alunosCancelados", alunorepositorio.findByStatusCancelado());
        return mv;
    }

    /* teste */
    @PostMapping("pesquisar-aluno")
    public ModelAndView pesquisarAluno(@RequestParam(required = false) String nome) {
        ModelAndView mv = new ModelAndView();
        List<Aluno> listaAlunos;
        if (nome == null || nome.trim().isEmpty()) {
            listaAlunos = alunorepositorio.findAll();
        } else {
            listaAlunos = alunorepositorio.findByNomeContainingIgnoreCase(nome);
        }
        mv.addObject("ListaDeAlunos", listaAlunos);
        mv.setViewName("estudante/pesquisa-resultado");
        return mv;

    }

    @PostMapping("pesquisar-estudante")
    public ModelAndView pesquisarEstudante(@RequestParam(required = false) String ndombaxi) {
        ModelAndView mv = new ModelAndView();
        List<Aluno> listaEstudantes;
        if (ndombaxi == null || ndombaxi.trim().isEmpty()) {
            listaEstudantes = alunorepositorio.findAll();
        } else {
            listaEstudantes = alunorepositorio.findByNomeContainingIgnoreCase(ndombaxi);
        }
        mv.addObject("ListaDeEstudantes", listaEstudantes);
        mv.setViewName("estudante/pesquisa-resultado2");
        return mv;

    }

}
