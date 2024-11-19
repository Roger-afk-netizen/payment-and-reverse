package com.parquesoftti.tc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sessions")
public class SimulationRestController {


    @PostMapping
    public ResponseEntity<String> payment() {
        // Lógica para procesar el pago (se puede implementar más adelante)
        return ResponseEntity.ok("Pago procesado exitosamente.");
    }


    @PutMapping
    public ResponseEntity<String> reversePayment() {
        // Lógica para revertir el pago (se puede implementar más adelante)
        return ResponseEntity.ok("Pago revertido exitosamente.");
    }
}
