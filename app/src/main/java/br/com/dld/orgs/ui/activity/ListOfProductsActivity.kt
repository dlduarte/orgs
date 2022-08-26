package br.com.dld.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.dld.orgs.R
import br.com.dld.orgs.dao.ProductDao
import br.com.dld.orgs.ui.recyclerview.adapter.ListOfProductsAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListOfProductsActivity : AppCompatActivity(R.layout.activity_list_of_products) {

    private val adapter = ListOfProductsAdapter(this, ProductDao().findAll())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configRecycleView()
        presetFab()
    }

    override fun onResume() {
        super.onResume()
        adapter.update()
    }

    private fun configRecycleView() {
        val listOfProducts = findViewById<RecyclerView>(R.id.activity_list_of_products_collection)
        listOfProducts.adapter = adapter
    }

    private fun presetFab() {
        val fab = findViewById<FloatingActionButton>(R.id.activity_list_of_products_btn_new_product)
        fab.setOnClickListener { navigateToForm() }
    }

    private fun navigateToForm() {
        startActivity(Intent(this, FormProductActivity::class.java))
    }
}