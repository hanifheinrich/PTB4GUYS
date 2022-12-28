package id.ac.unand.lunch

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.lunch.models.MyAdapter
import id.ac.unand.lunch.models.pengajuanKP
import id.ac.unand.lunch.response.LogoutResponse
import id.ac.unand.lunch.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@Suppress("DEPRECATION")
class HomeActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()

        val btnLogout: ImageView = findViewById(R.id.btnLogout)

        val sharedPref =
            applicationContext.getSharedPreferences("sharedPref", Context.MODE_PRIVATE) ?: return
        val token = sharedPref.getString("TOKEN", "")
        if (token != null) {
            Log.d("TOKEN : ", token)

        }

        btnLogout.setOnClickListener {
            val retrofitClient = RetrofitClient.create()
            val callData = retrofitClient.logout("Bearer $token")
            callData.enqueue(object : Callback<LogoutResponse> {
                override fun onResponse(
                    call: Call<LogoutResponse>,
                    response: Response<LogoutResponse>
                ) {
                    Log.d("LOGOUTTT : ", response.body().toString())
                    with(sharedPref.edit()) {
                        clear()
                        apply()
                    }
                    intent = Intent(this@HomeActivity, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                override fun onFailure(call: Call<LogoutResponse>, t: Throwable) {
                    Toast.makeText(this@HomeActivity, "Gagal", Toast.LENGTH_SHORT).show()
                }
            })
        }

        //ambil data dari LoginActivity
        val message = intent.getStringExtra("EXTRA_MESSAGE")

        val username = findViewById<TextView>(R.id.username).apply {
            text = message
        }

        init()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun init(){
        recyclerView = findViewById(R.id.rv_list_kp)

        var data =ArrayList<pengajuanKP>()
        data.add(pengajuanKP("Gojek", "Diterima", "Memenuhi syarat", R.drawable.ic_baseline_check_circle_24))
        data.add(pengajuanKP("Kominfo Padang", "Ditolak", "SKS Kurang", R.drawable.ic_baseline_cancel_24))
        data.add(pengajuanKP("Multipolar", "Ditolak", "Proposal Ditolak", R.drawable.ic_baseline_cancel_24))
        data.add(pengajuanKP("BNI Padang", "Ditolak", "Proposal Ditolak", R.drawable.ic_baseline_cancel_24))
        data.add(pengajuanKP("KONI Padang", "Ditolak", "Instansi tidak sesuai", R.drawable.ic_baseline_cancel_24))

        adapter = MyAdapter(data)
    }
}