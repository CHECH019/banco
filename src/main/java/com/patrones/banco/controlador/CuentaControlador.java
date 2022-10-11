package com.patrones.banco.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.patrones.banco.dto.CuentaDTO;
import com.patrones.banco.iServicios.IClienteServicio;
import com.patrones.banco.iServicios.ICuentaServicio;

@Controller
public class CuentaControlador {
    @Autowired
    private ICuentaServicio servicio;

    @Autowired
    private IClienteServicio clienteServicio;

    @GetMapping("/cuentas")
    public String mostrar(Model model){
        model.addAttribute("cuentas", servicio.getList());
        return "/cuentas/cuentas";
    }

    @GetMapping("/cuentas/new")
    public String crear(Model model){
        model.addAttribute("cuenta", new CuentaDTO());
        return "/cuentas/new-cuenta";
    }

    @PostMapping("/cuentas/save")
    public String guardar(@ModelAttribute("cuenta") CuentaDTO cuenta){
        cuenta.setCliente(clienteServicio.getByDni(cuenta.getCliente().getDni()));
        servicio.save(cuenta); 
        return "redirect:/cuentas";
    }

    @GetMapping("/cuentas/edit/{id}")
    public String editar(@PathVariable long id, Model model){
        model.addAttribute("cuenta", servicio.getById(id));
        return "/cuentas/edit-cuenta";
    }

    @PostMapping("/cuentas/{id}")
    public String actualizar(@PathVariable long id, @ModelAttribute("cuentas") CuentaDTO cuenta){
        CuentaDTO c = servicio.getById(id);
        c.setClave(cuenta.getClave());
        c.setSaldo(cuenta.getSaldo());
        servicio.update(c);
        return "redirect:/cuentas";
    }

    @GetMapping("/cuentas/{id}")
    public String eliminar(@PathVariable long id){
        servicio.delete(id);
        return "redirect:/cuentas";
    }
}