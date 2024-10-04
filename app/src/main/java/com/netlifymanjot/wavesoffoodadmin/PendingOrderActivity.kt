package com.netlifymanjot.wavesoffoodadmin

import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.netlifymanjot.wavesoffoodadmin.adapter.DeliveryAdapter
import com.netlifymanjot.wavesoffoodadmin.adapter.PendingOrderAdapter
import com.netlifymanjot.wavesoffoodadmin.databinding.ActivityPendingOrderBinding
import com.netlifymanjot.wavesoffoodadmin.databinding.PendingOrdersItemBinding

class PendingOrderActivity : AppCompatActivity() {
    private lateinit var binding:ActivityPendingOrderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPendingOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.backButton.setOnClickListener {
            finish()
        }
        val orderedCustomerName = arrayListOf(
            "Manjot Singh",
            "Jot",
            "Mike Johnson",
        )
        val orderedQuantity = arrayListOf(
            "8",
            "6",
            "4",
        )
        val orderedFoodImage= arrayListOf(R.drawable.menu1, R.drawable.menu2, R.drawable.menu3)
        val adapter = PendingOrderAdapter(orderedCustomerName, orderedQuantity, orderedFoodImage, this)
        binding.pendingOrderRecyclerView.adapter = adapter
        binding.pendingOrderRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}