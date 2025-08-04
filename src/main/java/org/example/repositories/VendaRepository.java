package org.example.repositories;

import org.example.entities.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, Long> {
    List<Venda> findByClienteCliCpf(String cpf);
    Long countByVendaDataAfter(LocalDateTime data); // você já tem
}
