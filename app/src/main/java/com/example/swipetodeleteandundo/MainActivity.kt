package com.example.swipetodeleteandundo

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.swipetodeleteandundo.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter:Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val dataSource = ArrayList<String>()

        for(n in 1..100)
            dataSource.add("String № $n")

        adapter = Adapter(this,dataSource)
        binding.recyclerView.adapter = adapter

        val itemTouchHelper = ItemTouchHelper(SwipeToDeleteCallback(adapter,getDrawable(R.drawable.ic_baseline_delete_sweep_24)!!,ColorDrawable(Color.RED)))
        itemTouchHelper.attachToRecyclerView(binding.recyclerView)

    }
}