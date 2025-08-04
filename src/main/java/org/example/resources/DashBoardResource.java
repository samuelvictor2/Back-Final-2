package org.example.resources;

import org.example.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/dashboard")
public class DashBoardResource {

    @Autowired
    private VendaService vendaService;

    @GetMapping("/lucro-total")
    public ResponseEntity<BigDecimal> getLucroTotal() {
        return ResponseEntity.ok(vendaService.calcularLucroTotal());
    }

    @GetMapping("/vendas-semana")
    public ResponseEntity<Long> getVendasSemana() {
        return ResponseEntity.ok(vendaService.contarVendasNaSemana());
    }
}
