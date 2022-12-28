package id.ac.unand.lunch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var handler: Handler

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        //Intent ke Login Activity
        //val directbutton = findViewById<Button>(R.id.directbutton)

        //directbutton.setOnClickListener {
        //    Intent(this, LoginActivity::class.java).also {
        //        startActivity(it) }
        //}

      //Handler
      //Splashscreen to Login Activity
      handler = Handler()
      handler.postDelayed({
          val intent = Intent (this,LoginActivity::class.java)
          startActivity(intent)
          finish()
      }, 2000)
    }
}