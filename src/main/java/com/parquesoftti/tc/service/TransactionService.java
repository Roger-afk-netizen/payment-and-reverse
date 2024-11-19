package com.parquesoftti.tc.service;

import com.parquesoftti.tc.model.Transaction;
import java.util.List;
import java.util.Optional;

public interface TransactionService {

    // Obtener todas las transacciones
    public List<Transaction> getTransactions();

    // Obtener una transacción por su ID
    public Optional<Transaction> getTransactionById(Long id);

    // Guardar una nueva transacción
    public Transaction saveTransaction(Transaction transaction);

    // Actualizar una transacción existente
    public Transaction updateTransaction(Transaction transaction, Long id);

    // Eliminar una transacción por su ID
    public void deleteTransaction(Long id);

    // Obtener una transacción por su número de referencia
    public Transaction getTransactionByReferenceNumber(String referenceNumber);
}

