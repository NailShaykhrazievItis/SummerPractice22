package com.test.summerpractice22

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import com.bumptech.glide.Glide
import kotlin.random.Random

class SplashActivity : Activity() {

    var name: String = "Test"
        set(value) {
            val random = Random.nextInt(0, 5)
            val newValue = "Value:$value Random: $random"
            textView?.text = newValue
            field = newValue
        }
    val age: Int = 18

    private var textView: TextView? = null
    private var image: ImageView? = null
    private var button: Button? = null
    private var buttonUpdate: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        onLoginClick("Summer")
        textView = findViewById(R.id.tv_splash)
        image = findViewById(R.id.iv_avatar)
        button = findViewById(R.id.btn_login)
        buttonUpdate = findViewById(R.id.btn_update_image)

        onLoginClick("TEST")

        button?.setOnClickListener {
            onLoginClick("BUTTON")
        }
        buttonUpdate?.setOnClickListener {
            loadNewImage()
        }
    }

    fun onLoginClick(newName: String) {
        val admin = Admin()
        admin.logMessage()

        admin.test()

        Log.e("SplashActivity", name)
        name = newName
    }

    private fun loadNewImage() {

        val imageView = image ?: return

        val url = "https://www.spletnik.ru/img/__post/df/df7196d3c2f2dc230eec0a5281010270_635.gif"
//        val url = "https://cs11.pikabu.ru/post_img/2019/02/04/12/1549312329147951618.jpg"

        Glide.with(this)
            .load(url)
            .into(imageView)


//        image?.setImageResource(R.drawable.test_cat)
    }
}
