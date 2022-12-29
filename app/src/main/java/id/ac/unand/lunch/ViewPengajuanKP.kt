package id.ac.unand.lunch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.lunch.models.ListAjuan

class ViewPengajuanKP : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pengajuan_kp)

        init()
    }

    private fun init () {
        recyclerView = findViewById(R.id.rv_view)

        var data = ArrayList<ListAjuan>()
        data.add(ListAjuan("Hanif Izza Pratama","20 November 2022", "LLDIKTI"))
        data.add(ListAjuan("Nada Safarina","25 November 2022", "PT Mutiara"))
        data.add(ListAjuan("Nathaniarahayu","26 November 2022", "PT Semen Padang"))
        data.add(ListAjuan("Annisa Faras","26 November 2022", "PLN Sawahan"))
        data.add(ListAjuan("Putri Wulan Dari","26 November 2022", "RS Semen Padang"))

    }

}