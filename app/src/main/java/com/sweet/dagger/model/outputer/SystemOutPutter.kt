package com.sweet.dagger.model.outputer

import com.sweet.dagger.model.OutPutter

class SystemOutPutter : OutPutter {
    override fun print(output: String) {
        println("ATM Response : $output")
    }
}