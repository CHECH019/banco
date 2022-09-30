package com.patrones.banco.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.patrones.banco.iServicios.IClienteServicio;
import com.patrones.banco.iServicios.IPrestamoServicio;
import com.patrones.banco.modelo.Prestamo;

@Controller
public class PrestamoControlador {
    @Autowired
    private IPrestamoServicio servicio;

    @Autowired
    private IClienteServicio clienteServicio;

    @GetMapping("/prestamos")
    public String mostrar(Model model){
        model.addAttribute("prestamos", servicio.getList());
        return "/prestamos/prestamos";
    }

    @GetMapping("/prestamos/new")
    public String crear(Model model){
        model.addAttribute("prestamo", new Prestamo());
        return "/prestamos/new-prestamo";
    }

    @PostMapping("/prestamos/save")
    public String guardar(@ModelAttribute("prestamo") Prestamo prestamo){
        prestamo.setCliente(clienteServicio.getByDni(prestamo.getCliente().getDni()));
        servicio.save(prestamo); 
        return "redirect:/prestamos";
    }

    @GetMapping("/prestamos/edit/{id}")
    public String editar(@PathVariable long id, Model model){
        model.addAttribute("prestamo", servicio.getById(id));
        return "/prestamos/edit-prestamo";
    }

    @PostMapping("/prestamos/{id}")
    public String actualizar(@PathVariable long id, @ModelAttribute("prestamos") Prestamo prestamo){
        Prestamo p = servicio.getById(id);
        p.setValor(prestamo.getValor());
        p.setIntereses(prestamo.getIntereses());
        p.setCuotas(prestamo.getCuotas());
        p.setDescripcion(prestamo.getDescripcion());
        servicio.update(p);
        return "redirect:/prestamos";
    }

    @GetMapping("/prestamos/{id}")
    public String eliminar(@PathVariable long id){
        servicio.delete(id);
        return "redirect:/prestamos";
    }

}