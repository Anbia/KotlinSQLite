package com.kodeanbia.kotlinsqlite

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {

            val myDataBase = this.openOrCreateDatabase("Musisi", Context.MODE_PRIVATE, null)
            myDataBase.execSQL("CREATE TABLE IF NOT EXISTS musisi (nama VARCHAR, umur INT(2))")
//            myDataBase.execSQL("INSERT INTO musisi (nama, umur) VALUES('Aril', 50)")
//            myDataBase.execSQL("INSERT INTO musisi (nama, umur) VALUES('noah', 40)")
//            myDataBase.execSQL("INSERT INTO musisi (nama, umur) VALUES('Erik', 56)")
//            myDataBase.execSQL("DELETE FROM musisi WHERE nama = 'Aril'")
//            myDataBase.execSQL("UPDATE musisi set umur = 51 WHERE nama = 'Erik'")

            val cursor = myDataBase.rawQuery("SELECT * FROM musisi WHERE nama = 'Erik'", null)
            val namaIndex = cursor.getColumnIndex("nama")
            val umurIndex = cursor.getColumnIndex("umur")

            cursor.moveToFirst()

            while (cursor != null){
                println("nama : " + cursor.getString(namaIndex))
                println("umur : " + cursor.getInt(umurIndex))

                cursor.moveToNext()
            }

            if (cursor != null){
                cursor!!.close()
            }

        }catch (e:Exception){
            e.printStackTrace()
        }

    }
}
