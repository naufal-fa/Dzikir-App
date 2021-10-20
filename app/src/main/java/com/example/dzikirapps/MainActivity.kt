package com.example.dzikirapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var llSunnahQauLiyah: LinearLayout
    private lateinit var llDzikirSetiapSaat: LinearLayout
    private lateinit var llDzikirDoaHarian: LinearLayout
    private lateinit var llDzikirPagiPetang: LinearLayout
    private lateinit var vpArtikel: ViewPager2
    private lateinit var llSliderDots: LinearLayout

    private val listArtikel: ArrayList<Artikel> = arrayListOf()

    private lateinit var sliderDots: Array<ImageView?>

    private val slidingCallBack = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            for (dots in 0 until listArtikel.size) {
                sliderDots[dots]?.setImageDrawable(
                    ContextCompat.getDrawable(applicationContext, R.drawable.dot_inactive)
                )
            }
            sliderDots[position]?.setImageDrawable(
                ContextCompat.getDrawable(applicationContext, R.drawable.dot_active)
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        initView()
        setupViewPager()

    }

    private fun setupViewPager() {
        vpArtikel.adapter = ArtikelAdapter(listArtikel)
        vpArtikel.registerOnPageChangeCallback(slidingCallBack)

        sliderDots = arrayOfNulls(listArtikel.size)

        sliderDots[0]?.setImageDrawable(
            ContextCompat.getDrawable(applicationContext, R.drawable.dot_active)
        )

        for (i in 0 until listArtikel.size) {
            sliderDots[i] = ImageView(this)
            sliderDots[i]?.setImageDrawable(
                ContextCompat.getDrawable(applicationContext, R.drawable.dot_inactive)
            )

            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(8, 0, 8, 0)
            llSliderDots.addView(sliderDots[i], params)
        }
    }

    private fun initView() {
        llSunnahQauLiyah = findViewById(R.id.ll_sunnah_qauliyah)
        llSunnahQauLiyah.setOnClickListener(this)
        llDzikirSetiapSaat = findViewById(R.id.ll_dzikir_setiap_saat)
        llDzikirSetiapSaat.setOnClickListener(this)
        llDzikirDoaHarian = findViewById(R.id.ll_dzikir_doa_harian)
        llDzikirDoaHarian.setOnClickListener(this)
        llDzikirPagiPetang = findViewById(R.id.ll_dzikir_pagi_petang)
        llDzikirPagiPetang.setOnClickListener(this)

        vpArtikel = findViewById(R.id.vp_artikel)
        llSliderDots = findViewById(R.id.ll_slider_dots)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.ll_sunnah_qauliyah -> startActivity(
                Intent(
                    this,
                    QauliyahShalatActivity::class.java
                )
            )
            R.id.ll_dzikir_doa_harian -> startActivity(
                Intent(
                    this,
                    HarianDzikirDoaActivity::class.java
                )
            )
            R.id.ll_dzikir_setiap_saat -> startActivity(
                Intent(
                    this,
                    SetiapSaatDzikirActivity::class.java
                )
            )
            R.id.ll_dzikir_pagi_petang -> startActivity(
                Intent(
                    this,
                    PagiPetangDzikirActivity::class.java
                )
            )

        }
    }

    private fun initData() {
        val titleArtikel = resources.getStringArray(R.array.arr_title_artikel)
        val descArtikel = resources.getStringArray(R.array.arr_desc_artikel)
        val imgArtikel = resources.obtainTypedArray(R.array.arr_img_artikel)

        listArtikel.clear()
        for (data in titleArtikel.indices) {
            val artikel = Artikel(
                imgArtikel.getResourceId(data, 0),
                titleArtikel[data],
                descArtikel[data]
            )
            listArtikel.add(artikel)
        }
        imgArtikel.recycle()
    }
}