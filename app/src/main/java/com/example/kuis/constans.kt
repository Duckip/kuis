package com.example.kuis

object constans {

    const val namauser: String = "user"
    const val  total: String = "total"
    const val jwbbnr: String = "jwbbnr"

    fun getsoal (): ArrayList<soal>{
        val soalList = ArrayList<soal>()

       val soal1 = soal (1, "Bendera di bawah adalah gambar bendera negara?",
            R.drawable.no1,"Indonesia", "Malaysia", "Polandia", "Singapura",
            1
       )
        soalList.add(soal1)

        val soal2 = soal (2, "Jika nilai a=3 dan nilai b=4, nilai c=?",
            R.drawable.no2,"3", "4", "5", "6",
            3
        )
        soalList.add(soal2)

        val soal3 = soal (3, "Dimanakah letak candi borobudur??",
            R.drawable.no3, "Jakarta", "Jogya", "Malang", "Magelang",
            4
        )
        soalList.add(soal3)

        val soal4 = soal (4, "Negara Indonesia terletak di benua?",
            R.drawable.no4, "Australia", "Indonesia", "Asia", "Afrika",
            3
        )
        soalList.add(soal4)

        val soal5 = soal (5, "Siapakah tokoh pada gambar dibawah ini?",
            R.drawable.no5, "Soeharto", "B. J. Habibie", "K.H. Abdurrahman Wahid", "Ir Soekarno",
            2
        )
        soalList.add(soal5)

        return soalList
    }
}