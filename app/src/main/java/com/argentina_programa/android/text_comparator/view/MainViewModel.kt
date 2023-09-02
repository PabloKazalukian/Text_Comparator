package com.argentina_programa.android.text_comparator.view

import androidx.lifecycle.ViewModel
import com.argentina_programa.android.text_comparator.model.Text

class MainViewModel: ViewModel() {


    fun compareTo(string1 : Text, string2 : Text): String {
        val result: String= if (string1 == string2) "Las cadenas son iguales" else "Las cadenas son diferentes";
        return result;
    }
}