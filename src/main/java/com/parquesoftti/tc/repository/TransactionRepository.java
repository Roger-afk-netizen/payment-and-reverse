package com.parquesoftti.tc.repository;

import com.parquesoftti.tc.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // Método para buscar una transacción por su número de referencia
    Transaction findByReferenceNumber(String referenceNumber);
}
