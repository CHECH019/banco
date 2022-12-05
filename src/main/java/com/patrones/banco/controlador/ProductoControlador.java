package com.patrones.banco.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.patrones.banco.dto.ClienteDTO;
import com.patrones.banco.iServicios.IClienteServicio;
import com.patrones.banco.iServicios.IProductoServicio;

@Controller
public class ProductoControlador {

    @Autowired
    private IProductoServicio servicio;

    @Autowired
    private IClienteServicio clienteServicio;

    @GetMapping("/productos")
    public String show(Model model){
        model.addAttribute("productos", servicio.getAll());
        return "productos/productos";
    }

    @GetMapping("/productos/{id}")
    public String showClientProducts(@PathVariable Long id, Model model){
        model.addAttribute("productos", servicio.findProductsByClientId(id));
        model.addAttribute("cliente",clienteServicio.getById(id));
        return "productos/productos";
    }
    
    @GetMapping("/producto-nuevo/{id}")
    public String newCLientProduct(@PathVariable Long id, Model model){
        model.addAttribute("productos", servicio.getAll());
        model.addAttribute("cliente", clienteServicio.getById(id));
        return "productos/new-producto";
    }

    @PostMapping("save_product")
    public String saveClientProduct(@RequestParam("product_id") Integer product_id, @RequestParam("client_id") Long client_id){
        System.out.println(client_id+" "+product_id);
        servicio.saveClienteProducto(client_id, product_id);
        return "redirect:/productos/"+client_id;
    }

    @GetMapping("productos/buscar")
    public String getByNameAndLastName(@RequestParam Map<String,String> params, Model model){
        List<ClienteDTO> result;
        String name = params.get("name");
        String lastName = params.get("lastName");
        String id = params.get("id");
        if(id != null && !id.isEmpty()){
            result = new ArrayList<ClienteDTO>();
            result.add(clienteServicio.getById(Long.parseLong(id)));
        }else {
            result = clienteServicio.getByNameAndLastName(name, lastName);
        }

        model.addAttribute("productos", servicio.findProductsByClientId(result.get(0).getId()));
        model.addAttribute("cliente", result.get(0));
        return "productos/productos";
    }
}
