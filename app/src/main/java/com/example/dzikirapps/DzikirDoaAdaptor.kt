package com.example.dzikirapps

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView

class DzikirDoaAdaptor(val listDzikirDoa: ArrayList<DzikirDoa>) :
    RecyclerView.Adapter<DzikirDoaAdaptor.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvDesc = view.findViewById<TextView>(R.id.tv_desc)
        val tvLafaz = view.findViewById<TextView>(R.id.tv_lafaz)
        val tvTerjemah: TextView = view.findViewById(R.id.tv_terjemah)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = MyViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.row_item_dzikir_doa, parent, false)
    )

    override fun onBindViewHolder(holder: DzikirDoaAdaptor.MyViewHolder, position: Int) {
        holder.tvDesc.text = listDzikirDoa[position].desc
        holder.tvLafaz.text = listDzikirDoa[position].lafaz
        holder.tvTerjemah.text = listDzikirDoa[position].terjemah
    }

    override fun getItemCount() = listDzikirDoa.size

}