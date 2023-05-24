package com.example.lab6_sol.controller;

import com.example.lab6_sol.entity.Usuario;
import com.example.lab6_sol.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/lista")
    public String listaUsuarios(Model model){
        List<Usuario> estudiantes = usuarioRepository.findByRolid(5);
        model.addAttribute("estudiantes", estudiantes);
        return "lista_usuarios";
    }
    @GetMapping("/new")
    public String nuevoEstudianteFrm (@ModelAttribute("usuario") Usuario usuario){

        return "newFrmEstudiante";
    }
    @GetMapping("/edit")
    public String editarTransportista(@ModelAttribute("usuario") Usuario usuario ,Model model, @RequestParam("id") int id) {

        Optional<Usuario> optUsuario = usuarioRepository.findById(id);

        if (optUsuario.isPresent()) {
            usuario = optUsuario.get();
            model.addAttribute("usuario", usuario);
            return "product/newFrm";
        } else {
            return "redirect:/product";
        }
    }
    @PostMapping ("/save")
    public String saveEstudiante (@ModelAttribute("usuario") @Valid Usuario usuario,Model model, BindingResult bindingResult, RedirectAttributes attr){

        if(bindingResult.hasErrors()){

            model.addAttribute("listaSupplier", usuarioRepository.findByRolid(5));
            return "redirect:/estudiente/lista";
        }else {
            attr.addFlashAttribute("msg", "Producto"+(usuario.getId()==0? "Creado" : "actualizado") + "existosametne" );
            usuarioRepository.save(usuario);
            return "redirect:/estudiente/lista";
        }

    }
}






