package com.argentina_programa.android.text_comparator.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.argentina_programa.android.text_comparator.model.Text

class MainViewModel: ViewModel() {

    private val _resultText = MutableLiveData<String>()
    val resultText: LiveData<String> = _resultText

    fun compareTo(string1 : Text, string2 : Text) {
        _resultText.value = if (string1 == string2) "Las cadenas son iguales" else "Las cadenas son diferentes";
    }
}