package aiswarya.hopes.tcs_test.ui.search

import aiswarya.hopes.tcs_test.model.BookEntity
import aiswarya.hopes.tcs_test.databinding.BookItemLayoutBinding
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup

import android.view.LayoutInflater
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

/**
 *Book Adapter
 */
class BookAdapter : ListAdapter<BookEntity, BookAdapter.SearchViewHolder>(DiffCallback()) {

    private lateinit var callback: (BookEntity) -> Unit

    fun onChoose(callback: (BookEntity) -> Unit) {
        this.callback = callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding =
            BookItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem, callback)
    }

    class SearchViewHolder(private val binding: BookItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(bookEntity: BookEntity, callback: (BookEntity) -> Unit) = with(itemView) {

            setOnClickListener {
                callback.invoke(bookEntity)
            }

            binding.apply {
                nameTv.text = bookEntity.bookName
                authorNameTV.text = bookEntity.authorName
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<BookEntity>() {
        override fun areItemsTheSame(oldItem: BookEntity, newItem: BookEntity) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: BookEntity, newItem: BookEntity) =
            oldItem == newItem
    }
}