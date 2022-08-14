package com.example.lib.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.example.lib.R
import com.example.lib.`interface`.OnClickButtonDialog

class GoBackToHomeDialog(context: Context, onClickButtonDialog: OnClickButtonDialog) :
    Dialog(context), View.OnClickListener {

    private val onClickButtonDialog: OnClickButtonDialog

    init {
        this.onClickButtonDialog = onClickButtonDialog
    }

    private val iconTitle: ImageView by lazy { findViewById(R.id.iconTitle) }
    private val title: TextView by lazy { findViewById(R.id.textTitle) }
    private val description: TextView by lazy { findViewById(R.id.textDescription) }
    private val buttonCancal: AppCompatButton by lazy { findViewById(R.id.btnCancel) }
    private val buttonAgree: AppCompatButton by lazy { findViewById(R.id.btnAgree) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.layout_dialog)
        buttonCancal.setOnClickListener(this)
        buttonAgree.setOnClickListener(this)
        defaultSettingDialog()
    }

    override fun show() {
        super.show()
    }

    private fun defaultSettingDialog() {
        val window = this.window
        window!!.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        window.attributes.gravity = Gravity.CENTER

        buttonAgree.text = "Stay"
        buttonCancal.text = "Leave"
        iconTitle.visibility = View.GONE
        title.text = "Go back to home"
        description.text =
            "You can still access your unsaved project from the recent project folder."
    }

    fun setTitle(title: String) {
        this.title.text = title
    }

    fun setDescription(description: String) {
        this.description.text = description
    }

    fun setIconTitle(icon: Drawable) {
        iconTitle.setImageDrawable(icon)
    }

    fun setGravityDialog(gravity: Int) {
        val windowAttribute = window!!.attributes
        windowAttribute.gravity = gravity
    }

    override fun onClick(btnView: View?) {
        when (btnView!!.id) {
            R.id.btnCancel -> {
                onClickButtonDialog.onClickButtonCancel(this)
            }
            R.id.btnCancel -> {
                onClickButtonDialog.onClickButtonAgree(this)
            }
        }
    }
}