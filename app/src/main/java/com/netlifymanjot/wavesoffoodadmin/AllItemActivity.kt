package com.netlifymanjot.wavesoffoodadmin

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.netlifymanjot.wavesoffoodadmin.adapter.MenuItemAdapter
import com.netlifymanjot.wavesoffoodadmin.databinding.ActivityAllItemBinding
import com.netlifymanjot.wavesoffoodadmin.model.AllMenu
import kotlin.collections.ArrayList

class AllItemActivity : AppCompatActivity() {

    private lateinit var databaseReference: DatabaseReference
    private lateinit var database: FirebaseDatabase
    private var menuItems : ArrayList<AllMenu> = ArrayList()

    private val binding:ActivityAllItemBinding by lazy {
        ActivityAllItemBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        databaseReference = FirebaseDatabase.getInstance().reference
        retrieveMenuItem()

        binding.backButton.setOnClickListener{
            finish()
        }


    }

    private fun retrieveMenuItem() {
        database = FirebaseDatabase.getInstance()
        val foodRef: DatabaseReference = database.reference.child("menu")
       foodRef.addListenerForSingleValueEvent(object : ValueEventListener {
           override fun onDataChange(snapshot: DataSnapshot){
               menuItems.clear()

               for (foodSnapshot in snapshot.children){
                   val menuItem = foodSnapshot.getValue(AllMenu::class.java)
                   menuItem?.let {
                       menuItems.add(it)
                   }
               }
               setAdapter()
           }

           override fun onCancelled(error: DatabaseError) {
               Log.d("DatabaseError", "Error: ${error.message}")
           }


       }) 
    }
    private fun setAdapter() {
        val adapter = MenuItemAdapter(this@AllItemActivity,menuItems, databaseReference)
        binding.MenuRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.MenuRecyclerView.adapter = adapter
    }
}