package com.netlifymanjot.wavesoffoodadmin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.netlifymanjot.wavesoffoodadmin.adapter.DeliveryAdapter
import com.netlifymanjot.wavesoffoodadmin.databinding.ActivityOutForDeliveryBinding

class OutForDeliveryActivity : AppCompatActivity() {
    private val binding: ActivityOutForDeliveryBinding by lazy{
        ActivityOutForDeliveryBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val customerName = arrayListOf(
            "Manjot Singh",
            "Jot",
            "Mike Johnson",
        )
        val moneyStatus = arrayListOf(
            "received",
            "notReceived",
            "Pending",
        )
        val adapter = DeliveryAdapter(customerName, moneyStatus)
        binding.deliveryRecyclerVeiw.adapter = adapter
        binding.deliveryRecyclerVeiw.layoutManager = LinearLayoutManager(this)
    }
}