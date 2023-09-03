package com.argentina_programa.android.text_comparator


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.argentina_programa.android.text_comparator.model.Text
import com.argentina_programa.android.text_comparator.view.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ViewModelUnitTest {
    private lateinit var  viewModel: MainViewModel

    @get:Rule
    val instatTaskRule = InstantTaskExecutorRule();

    private val dispatcher =  StandardTestDispatcher()
    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
    @Test
    fun compareCorrect() = runTest {
        viewModel.compareTo(Text("correcto"),Text("correcto"))

        assertEquals("Las cadenas son iguales",viewModel.resultText.value)
    }
    @Test
    fun compareIncorrect() = runTest {
        viewModel.compareTo(Text("incorrecto"),Text("correcto"))

        assertEquals("Las cadenas son diferentes",viewModel.resultText.value)
    }
}