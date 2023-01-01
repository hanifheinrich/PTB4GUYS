package id.ac.unand.lunch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class EditLogbook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_logbook)
        getSupportActionBar()?.hide()
    }
}