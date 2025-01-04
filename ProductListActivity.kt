package com.example.epsiapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.epsiapp.adapters.ProductAdapter
import com.example.epsiapp.models.Product
import com.example.epsiapp.network.RetrofitClient
import com.example.epsiapp.network.ProductService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var productList: ArrayList<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        recyclerView = findViewById(R.id.recycler_view_products)
        recyclerView.layoutManager = LinearLayoutManager(this)

        productList = ArrayList()

        val categoryUrl = intent.getStringExtra("CATEGORY_URL") ?: return
        val productService = RetrofitClient.getProductService()

        productService.getProducts(categoryUrl).enqueue(object : Callback<ProductResponse> {
            override fun onResponse(call: Call<ProductResponse>, response: Response<ProductResponse>) {
                if (response.isSuccessful) {
                    productList.addAll(response.body()?.record ?: emptyList())
                    val adapter = ProductAdapter(productList)
                    recyclerView.adapter = adapter
                }
            }

            holder.itemView.setOnClickListener {
                val intent = Intent(it.context, ProductListActivity::class.java)
                intent.putExtra("CATEGORY_URL", category.products_url)
                it.context.startActivity(intent)
            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                // Handle failure
            }
        })
    }
}
