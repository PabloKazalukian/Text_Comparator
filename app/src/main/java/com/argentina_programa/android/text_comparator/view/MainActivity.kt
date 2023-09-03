package com.argentina_programa.android.text_comparator.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.argentina_programa.android.text_comparator.databinding.ActivityMainBinding
import com.argentina_programa.android.text_comparator.model.Text

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root);

        binding.buttonCompare?.setOnClickListener{
            val text1: Text = Text( binding.textInput1?.text.toString() );
            val text2: Text = Text( binding.textInput2?.text.toString() );
            mainViewModel.compareTo( text1, text2);
        }

        mainViewModel.resultText.observe(this, Observer {result ->
            binding.result?.text = result;
        })

    }
}