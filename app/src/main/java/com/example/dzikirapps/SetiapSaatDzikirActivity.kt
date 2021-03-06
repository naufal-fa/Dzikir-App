package com.example.dzikirapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SetiapSaatDzikirActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setiap_saat_dzikir)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val rvDzikir = findViewById<RecyclerView>(R.id.rv_setiap_saat_dzikir)
        rvDzikir.layoutManager = LinearLayoutManager(this)
        rvDzikir.adapter = DzikirDoaAdaptor(DataDzikirDoa.listQauliyah)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}