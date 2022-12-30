package id.ac.unand.lunch.models

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyAdapter1(private val data: ArrayList<ListAjuan>): RecyclerView.Adapter<ViewHolder1>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder1 {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder1 (inflater, parent)
    }

    override fun onBindViewHolder(holder: ViewHolder1, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}