package com.example.andy.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.andy.aboutme.databinding.ActivityMainBinding
import com.example.andy.aboutme.viewmodel.MyName

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val myName : MyName = MyName("Andy Huang", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName

        // 初始化
        init()
    }

    /** 初始化 */
    private fun init() {
        // 初始化 Event
        initEvent()
    }

    /** 初始化 Event */
    private fun initEvent() {
        binding.doneButton.setOnClickListener {
            // add nickname
            addNickname(it)
        }
    }

    /** add nickname */
    private fun addNickname(view : View) {

        binding.apply {

            myName?.nickname = binding.nicknameEdit.text.toString()
            invalidateAll()

            view.visibility = View.GONE
            nicknameEdit.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}