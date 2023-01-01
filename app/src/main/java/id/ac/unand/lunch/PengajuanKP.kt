package id.ac.unand.lunch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PengajuanKP : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengajuan_kp)
        getSupportActionBar()?.hide()

        val SubmitAjukanKP = findViewById<Button>(R.id.SubmitAjukanKP)

        SubmitAjukanKP.setOnClickListener {
            Intent(this, DonePengajuanKP::class.java).also {
                startActivity(it)
            }
        }
    }
}