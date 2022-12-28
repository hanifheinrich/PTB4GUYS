package id.ac.unand.lunch.models

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.lunch.R


class ViewHolder(inflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder(inflater.inflate(R.layout.list_kp, parent, false)) {
    private var namaInstansi:TextView? = null
    private var status:TextView? = null
    private var alasan:TextView? = null
    private var imageStatus: ImageView? = null

    init {
        imageStatus = itemView.findViewById(R.id.imageCheck)
        namaInstansi = itemView.findViewById(R.id.textInstansi)
        alasan = itemView.findViewById(R.id.textAlasan)
        status = itemView.findViewById(R.id.textStatus)
    }

    fun bind(data:pengajuanKP){
        imageStatus?.setImageResource(data.imageStatus)
        namaInstansi?.text=data.namaInstansi
        alasan?.text=data.alasan
        status?.text=data.status
    }
}