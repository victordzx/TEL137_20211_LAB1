package edu.pucp.gtics.lab1_gtics_20211.controller;

import edu.pucp.gtics.lab1_gtics_20211.entity.Distribuidoras;
import edu.pucp.gtics.lab1_gtics_20211.repository.DistribuidorasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/distribuidoras")
public class DistribuidorasController {

    @Autowired
    DistribuidorasRepository distribuidorasRepository;

    @GetMapping("/lista")
    public String listaDistribuidoras(Model model){
        List<Distribuidoras> distribuidorasList = distribuidorasRepository.findAll();
        model.addAttribute("distribuidorasList", distribuidorasList);
        return "distribuidoras/lista";
    }

    @GetMapping("/editar")
    public String editarDistribuidoras(@RequestParam("id") int id, Model model){
        Optional<Distribuidoras> optionalDistribuidoras = distribuidorasRepository.findById(id);
        if (optionalDistribuidoras.isPresent()) {
            Distribuidoras distribuidoras = optionalDistribuidoras.get();
            model.addAttribute("distribuidoras", distribuidoras);
            return "distribuidoras/editar";
        } else {
            return "redirect:/distribuidoras/lista";
        }
    }

    @GetMapping("/nuevo")
    public String nuevaDistribuidora(){
        return "distribuidoras/nuevo";
    }

    @PostMapping("/save")
    public String guardarDistribuidora(Distribuidoras distribuidoras){
        distribuidorasRepository.save(distribuidoras);
        return "redirect:/distribuidoras/lista";
    }

    @GetMapping("/borrar")
    public String borrarDistribuidora(@RequestParam("id") int id){
        Optional<Distribuidoras> optionalDistribuidoras = distribuidorasRepository.findById(id);
        if (optionalDistribuidoras.isPresent()) {
            distribuidorasRepository.deleteById(id);
        }
        return "redirect:/distribuidoras/lista";
    }

}
