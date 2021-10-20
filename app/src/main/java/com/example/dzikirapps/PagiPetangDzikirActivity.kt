package com.example.dzikirapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.cardview.widget.CardView

class PagiPetangDzikirActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var cvDzikirPagi: CardView
    private lateinit var cvDzikirPetang: CardView
    private lateinit var btnvDzikirPagi: ImageButton
    private lateinit var btnDzikirPetang: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_pagi_petang_dzikir)

        cvDzikirPagi = findViewById(R.id.cv_dzikir_pagi)
        cvDzikirPagi.setOnClickListener(this)
        cvDzikirPetang = findViewById(R.id.cv_dzikir_petang)
        cvDzikirPetang.setOnClickListener(this)
        cvDzikirPagi = findViewById(R.id.img_btn_dzikir_pagi)
        cvDzikirPagi.setOnClickListener(this)
        cvDzikirPetang = findViewById(R.id.img_btn_dzikir_petang)
        cvDzikirPetang.setOnClickListener(this)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.cv_dzikir_pagi -> startActivity(Intent(this, DzikirPagiActivity::class.java))
            R.id.img_btn_dzikir_pagi -> startActivity(Intent(this, DzikirPagiActivity::class.java))

            R.id.cv_dzikir_petang -> startActivity(Intent(this, DzikirPetangActivity::class.java))
            R.id.img_btn_dzikir_petang -> startActivity(Intent(this, DzikirPetangActivity::class.java))
        }
    }
}