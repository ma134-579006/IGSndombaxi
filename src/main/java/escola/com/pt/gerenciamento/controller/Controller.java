/*
 * package escola.com.pt.gerenciamento.controller;
 * 
 * import java.security.NoSuchAlgorithmException;
 * 
 * import javax.validation.Valid;
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.stereotype.Controller;
 * import org.springframework.validation.BindingResult;
 * import org.springframework.web.bind.annotation.GetMapping;
 * import org.springframework.web.bind.annotation.PostMapping;
 * import org.springframework.web.servlet.ModelAndView;
 * 
 * import escola.com.pt.gerenciamento.dao.UsuarioDao;
 * import escola.com.pt.gerenciamento.model.Aluno;
 * import escola.com.pt.gerenciamento.model.ModelUsuario;
 * import escola.com.pt.gerenciamento.service.ServiceExc;
 * import escola.com.pt.gerenciamento.service.ServiceUsuario;
 * import escola.com.pt.gerenciamento.util.Util;
 * import jakarta.servlet.http.HttpSession;
 * 
 * @Controller
 * public class ControllerUsuario {
 * 
 * @SuppressWarnings("unused")
 * 
 * @Autowired
 * private UsuarioDao usuarioRepositorio;
 * 
 * @Autowired
 * private ServiceUsuario serviceUsuario;
 * 
 * @GetMapping("/")
 * public ModelAndView login() {
 * ModelAndView mv = new ModelAndView();
 * mv.setViewName("Login/login");
 * return mv;
 * }
 * 
 * @GetMapping("/index")
 * public ModelAndView index() {
 * ModelAndView mv = new ModelAndView();
 * mv.setViewName("home/index");
 * mv.addObject("aluno", new Aluno());
 * 
 * return mv;
 * 
 * }
 * 
 * @GetMapping("/cadastro")
 * public ModelAndView cadastrar() {
 * ModelAndView mv = new ModelAndView();
 * mv.addObject("usuario", new ModelUsuario());
 * mv.setViewName("Login/cadastro");
 * return mv;
 * }
 * 
 * @PostMapping("salvarUsuario")
 * public ModelAndView cadastrar(ModelUsuario usuario) throws Exception {
 * ModelAndView mv = new ModelAndView();
 * serviceUsuario.salvarUsuario(usuario);
 * mv.setViewName("redirect:/");
 * return mv;
 * 
 * }
 * 
 * 
 * @PostMapping("/login")
 * public ModelAndView login(@Valid ModelUsuario usuario, BindingResult br,
 * HttpSession session)
 * throws NoSuchAlgorithmException, ServiceExc {
 * ModelAndView mv = new ModelAndView();
 * mv.addObject("usuario", new ModelUsuario());
 * if (br.hasErrors()) {
 * mv.setViewName("Login/cadastro");
 * }
 * ModelUsuario userLogin = serviceUsuario.loginUser(usuario.getUser(),
 * Util.md5(usuario.getSenha()));
 * if (userLogin == null) {
 * mv.addObject("msg", "Usuario não encontrado");
 * } else {
 * session.setAttribute("usuarioLogado", userLogin);
 * return new ModelAndView("redirect:/index"); // Redirecionar para /index
 * }
 * return mv;
 * }
 * }
 */