package id.ac.unand.lunch

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import id.ac.unand.lunch.response.LoginResponse
import id.ac.unand.lunch.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // inisialisasi view
        val decorView = window.decorView
        // Hide the status bar.
        decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        initAction()

        //Toast
        val lupaPassword = findViewById<TextView>(R.id.lupaPassword)

        lupaPassword.setOnClickListener{
            Toast.makeText(this,"Silahkan hubungi admin Jurusan",Toast.LENGTH_LONG).show()
        }
    }

    fun ke_home(view: View) {
        intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    fun initAction() {
        val btnLogin: Button = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener {
            Login()
        }
    }
    fun Login(){
        val usernameForm: EditText = findViewById(R.id.editUsername)
        val passwordForm: EditText = findViewById(R.id.editPassword)

        val username = usernameForm.text.toString().trim()
        val password = passwordForm.text.toString().trim()

        val retrofitClient = RetrofitClient.create()
        val callData = retrofitClient.login(username, password)
        callData.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(
                call: Call<LoginResponse>,
                response: Response<LoginResponse>
            ) {
                if(response.isSuccessful){
                    val token = response?.body()?.authorisation?.token
                    val sharedPref = getSharedPreferences("sharedPref", Context.MODE_PRIVATE) ?:return
                    with(sharedPref.edit()){
                        putString("TOKEN", token)
                        apply()
                    }
                    Log.d("Data",response.body().toString())
                    val name = response.body()?.user?.nama!!.toString()
                    Toast.makeText(applicationContext, "Selamat datang $name", Toast.LENGTH_SHORT).show()
                    ke_home(View(this@LoginActivity))
                }else{
                    Toast.makeText(applicationContext, "Masukkan Username dan password yang benar", Toast.LENGTH_SHORT).show()
                    Log.d("Data",response.body().toString())
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }
}
