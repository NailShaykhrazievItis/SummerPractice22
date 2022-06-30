package com.test.summerpractice22.first

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.test.summerpractice22.databinding.ActivitySplashBinding
import kotlin.random.Random

class SplashActivity : Activity() {

    var name: String = "Test"
        set(value) {
            val random = Random.nextInt(0, 5)
            val newValue = "Value:$value Random: $random"
            binding.tvSplash.text = newValue
            field = newValue
        }
    val age: Int = 18

    private var _binding: ActivitySplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)


        test("MESSAGE")

        with(binding) {
            btnLogin.setOnClickListener {
                onLoginClick("BUTTON")
            }
            btnUpdateImage.setOnClickListener {
                loadNewImage()
            }
        }
    }

    fun onLoginClick(newName: String) {
        val admin = Admin(0)
        admin.logMessage()

        admin.test()

        Log.e("SplashActivity", name)
        name = newName
    }

    private fun loadNewImage() {

        val url = "https://www.spletnik.ru/img/__post/df/df7196d3c2f2dc230eec0a5281010270_635.gif"
//        val url = "https://cs11.pikabu.ru/post_img/2019/02/04/12/1549312329147951618.jpg"

        Glide.with(this)
            .load(url)
            .into(binding.ivAvatar)


//        image?.setImageResource(R.drawable.test_cat)
    }

    private fun test(text: String) {
        val list2 = arrayListOf("1", "2", "3")
        val map = mapOf<Int, String>(
            0 to "0",
            1 to "1",
            2 to "2",
            3 to "3",
        )
        map.toList()

        val admins = listOf(
            Admin(0, "first@mail.ru"),
            Admin(1, "second@mail.ru"),
            Admin(2, "third@mail.ru"),
            Admin(3, "fourth@mail.ru"),
        )
        val resultMap = admins.associateBy {
            it.id
        }
        resultMap.forEach { (key, value) ->
            logMessage("Key: $key, Value: $value")
        }
        val set = setOf<String>("22", "22", "33")

        val list = ArrayList<String>(5)
        list.add("zero")
        list.add("first")
        list.add("second")
        list.add("last")
        list.forEach { item ->
//            logMessage(item)
        }
        for (i in 0 until list.size) {
            val item = list[i]
//            logMessage(item)
        }

        val result: String = when {
            text.isEmpty() -> "empty"
            text.length < 5 -> "55"
            text.length < 3 -> "33"
            text.length < 7 -> {
                println()
                val admin = Admin(0)
                "77"
            }
            else -> "error"
        }
        println("Result: $result")
    }

    fun testColors(colors: Colors): Int = when (colors) {
        Colors.RED -> 0
        Colors.BLUE -> 1
        Colors.YELLOW -> 2
        Colors.GREEN -> 55
    }

    private fun logMessage(message: String) {
        Log.e("SplashActivity", message)
    }
}
