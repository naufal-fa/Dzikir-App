package com.example.dzikirapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class QauliyahShalatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qauliyah_shalat)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val rvQauliyahSholat = findViewById<RecyclerView>(R.id.rv_qauliyah_sholat)
        rvQauliyahSholat.layoutManager = LinearLayoutManager(this)
        rvQauliyahSholat.adapter = DzikirDoaAdaptor(DataDzikirDoa.listQauliyah)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}