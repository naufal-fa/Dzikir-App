package com.example.dzikirapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dzikirapps.DzikirDoa
import com.example.dzikirapps.DzikirDoaAdaptor
import com.example.dzikirapps.R

class HarianDzikirDoaActivity : AppCompatActivity() {

    //data yg kosong di tampilakn terlebih dahulu
//    private val listHarianDzikir: ArrayList<DzikirDoa> = arrayListOf()

    //data yg diarsipkan telebih dahulu
    private lateinit var listHarianDzikir: ArrayList<DzikirDoa>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initData()
        initView()

    }

    private fun initView() {
        val rvHarianDzikirDoaActivity = findViewById<RecyclerView>(R.id.rv_harian_dzikir_doa)
        rvHarianDzikirDoaActivity.layoutManager = LinearLayoutManager(this)
        rvHarianDzikirDoaActivity.adapter = DzikirDoaAdaptor(listHarianDzikir)
    }

    private fun initData() {
        val descHarianDzikir = resources.getStringArray(R.array.arr_dzikir_doa_harian)
        val lafazHarianDzikir = resources.getStringArray(R.array.arr_lafaz_dzikir_doa_harian)
        val terjemahHarianDzikir = resources.getStringArray(R.array.arr_terjemah_dzikir_doa_harian)

        for (data in descHarianDzikir.indices) {
            val list = DzikirDoa(
                descHarianDzikir[data],
                lafazHarianDzikir[data],
                terjemahHarianDzikir[data]
            )
            listHarianDzikir.add(list)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}