package aiswarya.hopes.tcs_test.ui.home

import aiswarya.hopes.tcs_test.data.repository.BookRepository
import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val bookRepository: BookRepository

) : ViewModel() {
    val recenBook = MutableStateFlow("")
    private val booksFlow = recenBook.flatMapLatest {
        bookRepository.getRecentBook()
    }

    val books = booksFlow.asLiveData()

}

