package br.com.dld.orgs.ui.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import br.com.dld.orgs.R
import br.com.dld.orgs.dao.ProductDao
import br.com.dld.orgs.models.Product
import java.math.BigDecimal

class FormProductActivity : AppCompatActivity(R.layout.activity_form_product) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presetSaveButton()
    }

    private fun presetSaveButton() {
        val button = findViewById<Button>(R.id.activity_form_product_btn_save)
        button.setOnClickListener {
            val product = createProduct()
            val dao = ProductDao()
            dao.add(product)
            finish()
        }
    }

    private fun createProduct(): Product {
        val fieldName = findViewById<EditText>(R.id.activity_form_product_name)
        val fieldDescription = findViewById<EditText>(R.id.activity_form_product_description)
        val fieldPrice = findViewById<EditText>(R.id.activity_form_product_price)

        val price =
            if (fieldPrice.text.toString().isBlank()) BigDecimal.ZERO
            else BigDecimal(fieldPrice.text.toString())

        return Product(
            fieldName.text.toString(),
            fieldDescription.text.toString(),
            price
        )
    }
}