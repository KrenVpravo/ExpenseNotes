package com.krenvpravo.expensenotes.repository

import com.krenvpravo.expensenotes.models.Currency
import com.krenvpravo.expensenotes.models.Transaction
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import java.util.*

/**
 * @author Dmitry Borodin on 2017-01-17.
 */
class TransactionRepositoryTest {

    @Before
    fun setUp() {

    }

    @After
    fun tearDown(){
        TransactionRepository.cleanTransactions()
    }

    @Test
    fun testRepositoryEmpty() {
        assertTrue(TransactionRepository.getTransactions().isEmpty())
    }

    @Test
    fun testRepositoryAdd() {
        assertTrue(TransactionRepository.getTransactions().isEmpty())
        val transaction = getTestTransaction()
        TransactionRepository.saveTransaction(transaction)

        assertTrue(TransactionRepository.getTransactions().size == 1)
        assertEquals(transaction, TransactionRepository.getTransactions().get(0))
    }

    @Test
    fun testRepositoryClean() {
        val transaction = getTestTransaction()
        TransactionRepository.saveTransaction(transaction)
        TransactionRepository.cleanTransactions()
        assertTrue(TransactionRepository.getTransactions().isEmpty())
    }

    private fun getTestTransaction(): Transaction {
        return Transaction(
                amoutnWithCents = 10L,
                currency = Currency(1, "maney", "fullnameMoney"),
                description = "description", addingDate = Date())
    }

}