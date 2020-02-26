package br.ufmt.webii.dwebii.controller;

import br.ufmt.webii.dwebii.dao.ClienteDAO;
import br.ufmt.webii.dwebii.dao.EstadoDAO;
import br.ufmt.webii.dwebii.entidades.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    private ClienteDAO dao;
    
    @Autowired
    private EstadoDAO estDAO;
    
    @GetMapping
    public String index(Model model){
        model.addAttribute("cliente", new Cliente());
        model.addAttribute("lista", dao.findAll());
        model.addAttribute("estados", estDAO.findAll());
        return "cliente";
    }
    
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("cliente") Cliente novo){
        dao.save(novo);
        return "redirect:/cliente";
    }
    
    @GetMapping("/editar/{id}")
    public String editar(@ModelAttribute("id") int pk, Model model){
        Cliente edit = dao.findById(pk).get();
        model.addAttribute("cliente", edit);
        model.addAttribute("lista", dao.findAll());
        model.addAttribute("estados", estDAO);
        return "cliente";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@ModelAttribute("id") int pk){
        dao.deleteById(pk);
        return "redirect:/cliente";
    }
    
}
