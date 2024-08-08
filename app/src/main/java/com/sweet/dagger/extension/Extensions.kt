package com.sweet.dagger.extension

fun String.split(): List<String> {
    return this.split("|")
}