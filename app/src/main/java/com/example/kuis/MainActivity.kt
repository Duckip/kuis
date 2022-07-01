package com.example.kuis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mulai: Button = findViewById(R.id.mulai)
        val nama: androidx.appcompat.widget.AppCompatEditText = findViewById(R.id.nama)

        mulai.setOnClickListener{
            if(nama.text.toString().isEmpty()){
                Toast.makeText( this,
                    "Masukkan nama terlebih dahulu", Toast.LENGTH_SHORT).show()
            }

            else{
                val intent = Intent (Intent(this,kuis::class.java))
                intent.putExtra(constans.namauser,nama.text.toString())
                startActivity(intent)
                finish()
            }
        }

    }
}