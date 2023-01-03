package id.ac.unand.lunch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class InputDataSeminar1Activity : AppCompatActivity() {

    private lateinit var btnIntent : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_data_seminar1)

        btnIntent = findViewById(R.id.ButtonNext)

        btnIntent.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.ButtonNext ->{
                val intentBiasa = Intent(this@InputDataSeminar1Activity, InputDataSeminar2Activity::class.java)
                startActivity(intentBiasa)
            }
        }
    }
}