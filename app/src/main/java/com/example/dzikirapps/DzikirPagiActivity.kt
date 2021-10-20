package com.example.dzikirapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DzikirPagiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_dzikir_pagi)

        val cvDzikirPagi = findViewById<RecyclerView>(R.id.cv_dzikir_pagi)
        cvDzikirPagi.layoutManager = LinearLayoutManager(this)
        cvDzikirPagi.adapter = DzikirDoaAdaptor(DataDzikirDoa.listDzikirPagi)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}