package com.example.kuis

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_kuis.*


class kuis : AppCompatActivity(), View.OnClickListener {

    private var mposisi:Int =1
    private var msoallist : ArrayList<soal>? = null
    private var mposisipil : Int = 0
    private var mjawaban: Int = 0
    private var musername: String? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kuis)

        musername = intent.getStringExtra(constans.namauser)
        msoallist = constans.getsoal()

        setsoal()

        pil1.setOnClickListener(this)
        pil2.setOnClickListener(this)
        pil3.setOnClickListener(this)
        pil4.setOnClickListener(this)
        submit.setOnClickListener(this)

    }

    private fun setsoal (){

        val soal = msoallist!!.get(mposisi-1)

        defaultpil()

        if(mposisi== msoallist!!.size){
            submit.text = "Selesai"
        }else{
            submit.text = "Selanjutnya"
        }

        gambar.setImageResource(soal.gambar)
        bar.progress = mposisi
        progress.text = "$mposisi" + "/" + bar.max

        soals.text = soal.soal
        pil1.text = soal.pil1
        pil2.text = soal.pil2
        pil3.text = soal.pil3
        pil4.text = soal.pil4
    }

    private fun defaultpil(){
        val option = ArrayList<TextView>()
        option.add(0, pil1)
        option.add(1, pil2)
        option.add(2, pil3)
        option.add(3, pil4)

        for (options in option){
            options.setTextColor(Color.parseColor("gray"))
            options.typeface = Typeface.DEFAULT
            options.background = ContextCompat.getDrawable(this,R.drawable.border)
    }


}

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.pil1 ->{
                pildipilih(pil1, 1)
            }
            R.id.pil2 ->{
                pildipilih(pil2, 2)
            }
            R.id.pil3 ->{
                pildipilih(pil3, 3)
            }
            R.id.pil4 ->{
                pildipilih(pil4, 4)
            }
            R.id.submit ->{
                if(mposisipil == 0){
                    mposisi ++

                    when{mposisi <= msoallist!!.size ->{
                        setsoal()
                    }
                    else ->{
                        val intent = Intent(this, hasil::class.java)
                        intent.putExtra(constans.namauser,musername)
                        intent.putExtra(constans.jwbbnr,mjawaban)
                        intent.putExtra(constans.total,msoallist!!.size)
                        startActivity(intent)
                        finish()
                    }

                    }
                }
                else{
                    val pertanyaan=msoallist?.get(mposisi-1)
                    if(pertanyaan!!.jawaban != mposisipil){
                        jwb(mposisipil, R.drawable.salah)
                    }else{
                        mjawaban++
                    }
                    jwb(pertanyaan.jawaban,R.drawable.jawaban)

                    if(mposisi== msoallist!!.size){
                        submit.text = "Selesai"
                    }else{
                        submit.text = "Selanjutnya"
                    }
                    mposisipil=0
                }
            }


        }
    }
    private fun jwb (jawaban: Int, drawableView: Int){
        when(jawaban){
            1->{
                pil1.background = ContextCompat.getDrawable(this, drawableView)
            }
            2->{
                pil2.background = ContextCompat.getDrawable(this, drawableView)
            }
            3->{
                pil3.background = ContextCompat.getDrawable(this, drawableView)
            }
            4->{
                pil4.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }
    private fun pildipilih(tv: TextView, nopil:Int){
        defaultpil()
        mposisipil = nopil

        tv.setTextColor(Color.parseColor("black"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,R.drawable.borderdipilih)
    }
    }