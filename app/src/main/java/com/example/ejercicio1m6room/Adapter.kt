package com.example.ejercicio1m6room


import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicio1m6room.databinding.ItemBinding


class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {

    var tareasC = mutableListOf<TareaC>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
       val c= tareasC.size
        Log.e("lol", "getItemCount:$c")
        return tareasC.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tareac = tareasC[position]
        holder.bind(tareac)
    }

    fun setData(tareasC: MutableList<TareaC>) {
        this.tareasC = tareasC.toMutableList()
    }

    inner class ViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(tareac: TareaC) {

        }


    }

}



