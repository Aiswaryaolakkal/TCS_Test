package aiswarya.hopes.tcs_test.ui.search

import aiswarya.hopes.tcs_test.data.repository.BookRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val bookRepository: BookRepository

) : ViewModel() {
    val searchQuery = MutableStateFlow("")
    private val tasksFlow = searchQuery.flatMapLatest {
        bookRepository.getBooks(it)
    }

    val tasks = tasksFlow.asLiveData()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            bookRepository.addBooks()
        }
    }
}