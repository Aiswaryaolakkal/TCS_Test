package aiswarya.hopes.tcs_test.ui.book_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailViewViewHolder : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Welcome to BookHouse"
    }
    val text: LiveData<String> = _text
}