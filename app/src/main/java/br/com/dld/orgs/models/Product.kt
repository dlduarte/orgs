package br.com.dld.orgs.models

import java.math.BigDecimal

data class Product(
    val name: String,
    val description: String,
    val price: BigDecimal
)
