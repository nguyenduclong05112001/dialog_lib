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

    fun createDialog():PixlrDialog {
        this.create()
        return this
    }

    fun setTitle(title: String): PixlrDialog {
        this.textTitle.text = title
        return this
    }

    fun setDescription(description: String) : PixlrDialog{
        this.description.text = description
        return this
    }

    fun setIconTitle(icon: Int): PixlrDialog {
        iconTitle.setImageResource(icon)
        isAddIconTitle = true
        return this
    }

    fun setGravityDialog(gravity: Int) : PixlrDialog{
        val windowAttribute = window?.attributes
        windowAttribute?.gravity = gravity
        window?.attributes = windowAttribute
        return this
    }

    fun setButtonNegative (
        contentText: String,
        onClickButtonNegative: OnClickButtonNegative
    ) : PixlrDialog{
        isAddButtonNegative = true
        this.onClickButtonNegative = onClickButtonNegative
        this.buttonNegative.text = contentText
        return this
    }

    fun setButtonPositive(
        contentText: String,
        onClickButtonPositive: OnClickButtonPositive
    ) : PixlrDialog{
        isAddButtonPositive = true
        this.onClickButtonPositive = onClickButtonPositive
        this.buttonPossible.text = contentText
        return this
    }

    fun build() : PixlrDialog{
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
        return this
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