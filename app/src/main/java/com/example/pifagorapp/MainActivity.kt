package com.example.pifagorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.pifagorapp.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    fun click (view : View){
        if (!isFeldEmpty()){
            val result = getString(R.string.result_info) + getResult()
            binding.tVInfo.text = result
        }
    }

    private fun isFeldEmpty() : Boolean{
        binding.apply {
            if (edA.text.isNullOrEmpty()) edA.error = getString(R.string.error)
            if (edB.text.isNullOrEmpty()) edB.error = getString(R.string.error)
            return edA.text.isNullOrEmpty() || edB.text.isNullOrEmpty()
        }
    }

    private fun getResult() : String{
        val a : Double
        val b : Double
        binding.apply {
            a = edA.text.toString().toDouble()
            b = edB.text.toString().toDouble()
        }
        return sqrt ((a.pow(2) + b.pow(2)) ).toString()
    }
}