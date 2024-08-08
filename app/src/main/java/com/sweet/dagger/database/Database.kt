package com.sweet.dagger.database

import com.sweet.dagger.model.Account
import javax.inject.Inject

class Database @Inject constructor() {

    private val accounts: MutableMap<String, Account> = mutableMapOf()

    fun getAccount(id: String): Account? = accounts[id]



}