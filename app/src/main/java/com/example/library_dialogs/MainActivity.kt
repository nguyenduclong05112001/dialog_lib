package com.example.library_dialogs

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.lib.dialog.PixlrDialog
import com.example.lib.interfacess.OnClickButtonNegative
import com.example.lib.interfacess.OnClickButtonPositive

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn1: AppCompatButton by lazy { findViewById(R.id.btnshow1) }
        val btn2: AppCompatButton by lazy { findViewById(R.id.btnshow2) }

        btn1.setOnClickListener {
            showDemo1()
        }

        btn2.setOnClickListener {
            showDemo2()
        }
    }

    private fun showDemo1() {
        PixlrDialog(this)
            .createDialog()
            .setIconTitle(R.drawable.icon_camera)
            .setTitle("Connect Photos Album")
            .setDescription("We need your permission to access your photos so you can remove background from your photos and save it your photos.")
            .setButtonPositive("Allow Access", object : OnClickButtonPositive {
                override fun onClickButton(dialog: Dialog) {
                    dialog.dismiss()
                }
            })
            .build()
    }

    private fun showDemo2() {
        PixlrDialog(this)
            .createDialog()
            .setTitle("Go back to home")
            .setDescription("You can still access your unsaved project from the recent project folder.")
            .setButtonPositive("Stay", object : OnClickButtonPositive {
                override fun onClickButton(dialog: Dialog) {
                    dialog.dismiss()
                }
            })
            .setButtonNegative("Leave", object : OnClickButtonNegative {
                override fun onClickButton(dialog: Dialog) {
                    dialog.dismiss()
                }
            })
            .build()
    }

}