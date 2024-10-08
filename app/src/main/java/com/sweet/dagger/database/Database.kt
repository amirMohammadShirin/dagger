package com.sweet.dagger.database

import com.sweet.dagger.model.Account
import java.math.BigDecimal
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Database @Inject constructor() {

    private val accounts: MutableMap<String, Account> = mutableMapOf()

    init {
        accounts["guest"] = Account("guest", BigDecimal.ZERO)
    }

    fun getAccount(id: String): Account? = accounts[id]

    fun upsertAccount(account: Account) {
        accounts[account.id] = account
    }

}