package com.parquesoftti.tc.service.impl;

import com.parquesoftti.tc.model.Transaction;
import com.parquesoftti.tc.repository.TransactionRepository;
import com.parquesoftti.tc.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    // Inyección del repositorio de transacciones
    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    // Obtener todas las transacciones
    @Override
    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

    // Obtener una transacción por su ID
    @Override
    public Optional<Transaction> getTransactionById(Long id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        if (!transaction.isPresent()) {
            System.out.println("Transaction with ID " + id + " not found.");
        }
        return transaction;
    }

    // Guardar una nueva transacción
    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    // Actualizar una transacción existente
    @Override
    public Transaction updateTransaction(Transaction transaction, Long id) {
        Optional<Transaction> existingTransaction = transactionRepository.findById(id);
        if (existingTransaction.isPresent()) {
            transaction.setId(id);
            return transactionRepository.save(transaction);
        } else {
            // Simplemente devuelve el objeto sin cambios si no se encuentra
            System.out.println("Transaction with ID " + id + " not found for update.");
            return null;
        }
    }

    // Eliminar una transacción por su ID
    @Override
    public void deleteTransaction(Long id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        if (transaction.isPresent()) {
            transactionRepository.deleteById(id);
        } else {
            // Imprime un mensaje si no se encuentra la transacción para eliminar
            System.out.println("Transaction with ID " + id + " not found for deletion.");
        }
    }

    // Obtener una transacción por su número de referencia
    @Override
    public Transaction getTransactionByReferenceNumber(String referenceNumber) {
        // Aquí se llama al método que ya has definido en el repositorio: findByReferenceNumber
        Transaction transaction = transactionRepository.findByReferenceNumber(referenceNumber);
        if (transaction == null) {
            System.out.println("Transaction with reference number " + referenceNumber + " not found.");
        }
        return transaction;
    }

}

