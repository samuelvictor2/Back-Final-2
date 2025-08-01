package org.example.resources;

import org.example.dto.VendaDTO;
import org.example.entities.Venda;
import org.example.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/vendas")
public class VendaResource {

    @Autowired
    private VendaService vendaService;

    @PostMapping
    public ResponseEntity<VendaDTO> insert(@Valid @RequestBody VendaDTO dto) {
        Venda novaVenda = vendaService.insert(dto);
        VendaDTO responseDto = vendaService.toDTO(novaVenda);
        return ResponseEntity.created(URI.create("/vendas/" + novaVenda.getVendaId())).body(responseDto);
    }
}