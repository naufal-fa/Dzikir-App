package com.example.dzikirapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailArtikelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Artikel Islami"
        setContentView(R.layout.activity_detail_artikel)

        val dataTitle = intent.getStringExtra("title")
        val dataDesc = intent.getStringExtra("desc")
        val dataImage = intent.getIntExtra("image", 0)

        val tvTitle = findViewById<TextView>(R.id.tv_title_detail)
        tvTitle.text = dataTitle
        val tvDesc = findViewById<TextView>(R.id.tv_desc_detail_artikel)
        tvDesc.text
        val imgArtikel = findViewById<ImageView>(R.id.img_detail_artikel)
        imgArtikel.setImageResource(dataImage)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}