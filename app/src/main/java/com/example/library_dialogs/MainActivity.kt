package com.example.library_dialogs

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lib.`interface`.OnClickButtonDialog
import com.example.lib.dialog.GoBackToHomeDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dialog = GoBackToHomeDialog(this, object : OnClickButtonDialog {
            override fun onClickButtonAgree(dialog: Dialog) {}

            override fun onClickButtonCancel(dialog: Dialog) {}

        })
        dialog.show()
    }

}