package br.com.dld.orgs.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.dld.orgs.R
import br.com.dld.orgs.dao.ProductDao
import br.com.dld.orgs.models.Product

class ListOfProductsAdapter(
    private val context: Context,
    products: List<Product>
) : RecyclerView.Adapter<ListOfProductsAdapter.ViewHolder>() {

    private val dataSet = products.toMutableList();

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(product: Product) {
            val name = itemView.findViewById<TextView>(R.id.activity_form_product_name)
            name.text = product.name

            val description = itemView.findViewById<TextView>(R.id.activity_form_product_description)
            description.text = product.description

            val price = itemView.findViewById<TextView>(R.id.activity_form_product_price)
            price.text = product.price.toPlainString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.product_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = dataSet[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int = dataSet.size

    fun update() {
        dataSet.clear();
        dataSet.addAll(ProductDao().findAll())
        notifyDataSetChanged()
    }
}
