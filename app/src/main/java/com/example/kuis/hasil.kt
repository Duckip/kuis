package com.example.kuis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_hasil.*
import kotlinx.android.synthetic.main.activity_main.*

class hasil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil)

        val user = intent.getStringExtra(constans.namauser)
        namauser.text = "Selamat, $user"

        val totalsoal = intent.getIntExtra(constans.total, 0)
        val benar = intent.getIntExtra(constans.jwbbnr, 0 )

        skor.text = "Anda mendapatkan skor $benar dari $totalsoal"
        selesai.setOnClickListener{startActivity(Intent(this, Splash::class.java))
        }
    }
}