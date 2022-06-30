package com.finixstore.optimizingrv

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.finixstore.optimizingrv.databinding.ActivityMainBinding
import com.finixstore.optimizingrv.databinding.ItemListBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var rv: RecyclerView
    private lateinit var fruitAdapter: BaseRecyclerViewAdapter<String>
    private lateinit var binding: ActivityMainBinding
    private lateinit var itemBinding: ItemListBinding
    private val dummyData = listOf(
        "Apple",
        "Banana",
        "Cherry",
        "Guava",
        "Lemon", "Apple",
        "Banana",
        "Cherry",
        "Guava",
        "Lemon",
        "Mango"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        itemBinding = ItemListBinding.inflate(layoutInflater)

        fruitAdapter = BaseRecyclerViewAdapter(
            R.layout.item_list_2,
            false
        ) { position, data, view ->
            // init view on recycler view adapter
            val tvNumber = view.findViewById<AppCompatTextView>(R.id.tv_number)
            val tvFruit = view.findViewById<AppCompatTextView>(R.id.tv_fruit)


            // set data to view
            tvNumber.text = "Fruit #${position + 1}"
            tvFruit.text = data
        }
        rv = findViewById(R.id.rv)
        //binding.rv.apply {  }

        rv.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rv.adapter = fruitAdapter
        fruitAdapter.setItems(dummyData)
    }
}