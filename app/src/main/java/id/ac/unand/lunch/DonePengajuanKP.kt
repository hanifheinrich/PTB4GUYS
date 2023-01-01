package id.ac.unand.lunch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DonePengajuanKP : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_done_pengajuan_kp)
        getSupportActionBar()?.hide()

        val ViewKP = findViewById<Button>(R.id.viewKP)

        ViewKP.setOnClickListener {
            Intent(this, ViewPengajuanKP::class.java).also {
                startActivity(it)
            }
        }
    }
}