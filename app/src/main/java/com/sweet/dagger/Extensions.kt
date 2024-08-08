package com.sweet.dagger

fun String.split(): List<String> {
    return this.split("//s+")
}