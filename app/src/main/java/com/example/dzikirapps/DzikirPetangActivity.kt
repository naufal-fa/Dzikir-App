package com.example.dzikirapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DzikirPetangActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_dzikir_petang)

        val cvDzikirPetang = findViewById<RecyclerView>(R.id.cv_dzikir_petang)
        cvDzikirPetang.layoutManager = LinearLayoutManager(this)
        cvDzikirPetang.adapter = DzikirDoaAdaptor(DataDzikirDoa.listDzikirPetang)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}