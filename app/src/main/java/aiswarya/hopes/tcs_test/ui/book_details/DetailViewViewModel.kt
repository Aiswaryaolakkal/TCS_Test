package aiswarya.hopes.tcs_test.ui.book_details

import aiswarya.hopes.tcs_test.data.repository.BookRepository
import aiswarya.hopes.tcs_test.model.BookEntity
import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewViewModel @Inject constructor(
    private val bookRepository: BookRepository

) : ViewModel() {
    val book: MutableStateFlow<BookEntity?> = MutableStateFlow(null)
    fun fetchBook(bookId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            book.emit(bookRepository.getBookById(bookId))
            bookRepository.setOpen(bookId, System.currentTimeMillis())
        }
    }
}


