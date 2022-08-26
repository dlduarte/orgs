package br.com.dld.orgs.dao

import br.com.dld.orgs.models.Product

class ProductDao {

    fun add(product: Product) {
        products.add(product)
    }

    fun findAll(): List<Product> {
        return products.toList()
    }

    companion object {
        private val products = mutableListOf<Product>()
    }
}