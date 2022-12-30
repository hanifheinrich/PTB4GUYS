package id.ac.unand.lunch.models

import android.icu.text.CaseMap
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.lunch.R

class ViewHolder1(inflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder(inflater.inflate(
    R.layout.list_pengajuankp, parent, false)){

    private var Tittle : TextView? = null
    private var TittleSub : TextView? = null
    private var TittleSub1 : TextView? = null

    init {
        Tittle = itemView.findViewById(R.id.tittle)
        TittleSub = itemView.findViewById(R.id.tittle_sub)
        TittleSub1 = itemView.findViewById(R.id.tittle_sub1)

    }

        fun bind (data:ListAjuan){
            Tittle?.text=data.Tittle
            TittleSub?.text=data.TittleSub
            TittleSub1?.text=data.TittleSub1
        }

}