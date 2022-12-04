package com.patrones.banco.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.patrones.banco.dto.ClienteDTO;
import com.patrones.banco.iServicios.IClienteServicio;

@Controller
public class ClienteControlador {
    @Autowired
    private IClienteServicio servicio;
    
    
    public String mostrar(Model model){
        model.addAttribute("clientes", servicio.getAll());
        return "/clientes/clientes";
    }

    @GetMapping({"/clientes","/"})
    public String showClients(@RequestParam Map<String,Object> params, Model model){
        int page = params.get("page") != null ? (Integer.valueOf(params.get("page").toString()) -1) : 0;
        PageRequest pageRequest = PageRequest.of(page, 200);
        Page<ClienteDTO> pageClientes= servicio.getAllPageable(pageRequest);
        int totalPages = pageClientes.getTotalPages();
        if(totalPages > 0){
            List<Integer> pages = 
                IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pages", pages);
        }
        model.addAttribute("clientes", pageClientes.getContent());
        return "/clientes/clientes";
    }

    @GetMapping("clientes/buscar")
    public String getByNameAndLastName(@RequestParam Map<String,String> params, Model model){
        List<ClienteDTO> result;
        String name = params.get("name");
        String lastName = params.get("lastName");
        String id = params.get("id");
        if(id != null){
            result = new ArrayList<ClienteDTO>();
            result.add(servicio.getById(Long.parseLong(id)));
        }else {
            result = servicio.getByNameAndLastName(name, lastName);
        }

        model.addAttribute("clientes", result);
        model.addAttribute("pages", 0);
        return "/clientes/clientes";
    }


    @GetMapping("/clientes/new")
    public String crear(Model model){
        model.addAttribute("cliente", new ClienteDTO());
        return "/clientes/new-cliente";
    }


    @PostMapping("/clientes/save")
    public String guardar(@ModelAttribute("cliente") ClienteDTO cliente){
        servicio.save(cliente); 
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/edit/{id}")
    public String editar(@PathVariable long id, Model model){
        model.addAttribute("cliente", servicio.getById(id));
        return "/clientes/edit-cliente";
    }

    @PostMapping("/clientes/{id}")
    public String actualizar(@PathVariable long id, @ModelAttribute("cliente") ClienteDTO cliente){
        ClienteDTO c = servicio.getById(id);
        c.setNombre(cliente.getNombre());
        c.setCorreo(cliente.getCorreo());
        
        servicio.update(c);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/{id}")
    public String eliminar(@PathVariable long id){
        servicio.delete(id);
        return "redirect:/clientes";
    }
}
