package com.patrones.banco.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.patrones.banco.dto.TarjetaDTO;
import com.patrones.banco.iServicios.IClienteServicio;
import com.patrones.banco.iServicios.ITarjetaServicio;

@Controller
public class TarjetaControlador {
    @Autowired
    private ITarjetaServicio servicio;

    @Autowired
    private IClienteServicio clienteServicio;

    @GetMapping("/tarjetas")
    public String mostrar(Model model){
        model.addAttribute("tarjetas", servicio.getList());
        return "/tarjetas/tarjetas";
    }

    @GetMapping("/tarjetas/new")
    public String crear(Model model){
        model.addAttribute("tarjeta", new TarjetaDTO());
        return "/tarjetas/new-tarjeta";
    }

    @PostMapping("/tarjetas/save")
    public String guardar(@ModelAttribute("tarjeta") TarjetaDTO tarjeta){
        tarjeta.setCliente(clienteServicio.getByDni(tarjeta.getCliente().getDni()));
        servicio.save(tarjeta); 
        return "redirect:/tarjetas";
    }

    @GetMapping("/tarjetas/edit/{id}")
    public String editar(@PathVariable long id, Model model){
        model.addAttribute("tarjeta", servicio.getById(id));
        return "/tarjetas/edit-tarjeta";
    }

    @PostMapping("/tarjetas/{id}")
    public String actualizar(@PathVariable long id, @ModelAttribute("tarjetas") TarjetaDTO tarjeta){
        TarjetaDTO t = servicio.getById(id);
        t.setVencimiento(tarjeta.getVencimiento());
        t.setNumeroTarjeta(tarjeta.getNumeroTarjeta());
        t.setCvv(tarjeta.getCvv());
        servicio.update(t);
        return "redirect:/tarjetas";
    }

    @GetMapping("/tarjetas/{id}")
    public String eliminar(@PathVariable long id){
        servicio.delete(id);
        return "redirect:/tarjetas";
    }
}
