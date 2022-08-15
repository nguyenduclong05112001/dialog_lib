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
import com.example.lib.interfacess.OnClickButtonNegative
import com.example.lib.interfacess.OnClickButtonPositive

class PixlrDialog(
    context: Context
) : Dialog(context), View.OnClickListener {

    private var onClickButtonNegative: OnClickButtonNegative? = null
    private var onClickButtonPositive: OnClickButtonPositive? = null

    private val iconTitle: ImageView by lazy { findViewById(R.id.iconTitle) }
    private val textTitle: TextView by lazy { findViewById(R.id.textTitle) }
    private val description: TextView by lazy { findViewById(R.id.textDescription) }
    private val buttonNegative: AppCompatButton by lazy { findViewById(R.id.btnNegative) }
    private val buttonPossible: AppCompatButton by lazy { findViewById(R.id.btnPositive) }

    private var isAddIconTitle = false
    private var isAddButtonNegative = false
    private var isAddButtonPositive = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.layout_dialog)
        buttonNegative.setOnClickListener(this)
        buttonPossible.setOnClickListener(this)
        defaultSettingDialog()
    }

    private fun defaultSettingDialog() {
        this.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        this.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val windowAttribute = this.window?.attributes
        windowAttribute?.gravity = Gravity.CENTER
        this.window?.attributes = windowAttribute
    }

    fun createDialog() {
        this.create()
    }

    fun setTitle(title: String) {
        this.textTitle.text = title
    }

    fun setDescription(description: String) {
        this.description.text = description
    }

    fun setIconTitle(icon: Drawable) {
        iconTitle.setImageDrawable(icon)
        isAddIconTitle = true
    }

    fun setGravityDialog(gravity: Int) {
        val windowAttribute = window?.attributes
        windowAttribute?.gravity = gravity
        window?.attributes = windowAttribute
    }

    fun setButtonNegative(
        contentText: String,
        onClickButtonNegative: OnClickButtonNegative
    ) {
        isAddButtonNegative = true
        this.onClickButtonNegative = onClickButtonNegative
        this.buttonNegative.text = contentText
    }

    fun setButtonPositive(
        contentText: String,
        onClickButtonPositive: OnClickButtonPositive
    ) {
        isAddButtonPositive = true
        this.onClickButtonPositive = onClickButtonPositive
        this.buttonPossible.text = contentText
    }

    fun build() {
        when (isAddIconTitle) {
            true -> {
                this.iconTitle.visibility = View.VISIBLE
            }
            false -> {
                this.iconTitle.visibility = View.GONE
            }
        }

        if (!this.description.text.isEmpty()) {
            this.description.visibility = View.VISIBLE
        } else {
            this.description.visibility = View.GONE
        }

        when (isAddButtonNegative) {
            true -> {
                this.buttonNegative.visibility = View.VISIBLE
            }
            false -> {
                this.buttonNegative.visibility = View.GONE
            }
        }

        when (isAddButtonPositive) {
            true -> {
                this.buttonPossible.visibility = View.VISIBLE
            }
            false -> {
                this.buttonPossible.visibility = View.GONE
            }
        }
        this.show()
    }

    override fun onClick(btnView: View) {
        when (btnView.id) {
            R.id.btnNegative -> {
                this.onClickButtonNegative?.onClickButton(this)
            }
            R.id.btnPositive -> {
                this.onClickButtonPositive?.onClickButton(this)
            }
        }
    }
}