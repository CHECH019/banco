package com.patrones.banco.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.patrones.banco.iServicios.IClienteServicio;
import com.patrones.banco.modelo.Cliente;

@Controller
public class ClienteControlador {
    @Autowired
    private IClienteServicio servicio;
    
    @GetMapping({"/clientes","/"})
    public String mostrar(Model model){
        model.addAttribute("clientes", servicio.getList());
        return "/clientes/clientes";
    }

    @GetMapping("/clientes/new")
    public String crear(Model model){
        model.addAttribute("cliente", new Cliente());
        return "/clientes/new-cliente";
    }

    @PostMapping("/clientes/save")
    public String guardar(@ModelAttribute("cliente") Cliente cliente){
        servicio.save(cliente); 
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/edit/{id}")
    public String editar(@PathVariable long id, Model model){
        model.addAttribute("cliente", servicio.getById(id));
        return "/clientes/edit-cliente";
    }

    @PostMapping("/clientes/{id}")
    public String actualizar(@PathVariable long id, @ModelAttribute("cliente") Cliente cliente){
        Cliente c = servicio.getById(id);
        c.setNombre(cliente.getNombre());
        c.setCorreo(cliente.getCorreo());
        c.setDni(cliente.getDni());
        c.setCel(cliente.getCel());
        

        servicio.update(c);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/{id}")
    public String eliminar(@PathVariable long id){
        servicio.delete(id);
        return "redirect:/clientes";
    }
}
