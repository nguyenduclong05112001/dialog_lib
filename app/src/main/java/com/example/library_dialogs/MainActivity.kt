package com.example.library_dialogs

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lib.dialog.PixlrDialog
import com.example.lib.interfacess.OnClickButtonPositive

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dialog = PixlrDialog(this)
        dialog.createDialog()
        dialog.setTitle("This is title")
        dialog.setDescription("asdasdasdasdasdasdasdasdasdasdasdasdasdasd")
        dialog.setButtonPositive("Next",object : OnClickButtonPositive{
            override fun onClickButton(dialog: Dialog) {
                dialog.dismiss()
            }
        })
        dialog.build()
    }

}