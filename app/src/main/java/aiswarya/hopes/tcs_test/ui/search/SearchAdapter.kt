package aiswarya.hopes.tcs_test.ui.search

import aiswarya.hopes.tcs_test.R
import aiswarya.hopes.tcs_test.model.BookEntity
import aiswarya.hopes.tcs_test.databinding.BookItemLayoutBinding
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup

import android.util.Log
import android.view.LayoutInflater
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

/**
 *Book Adapter
 */
class SearchAdapter : ListAdapter<BookEntity, SearchAdapter.SearchViewHolder>(DiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding = BookItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    class SearchViewHolder(private val binding: BookItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(bookEntity: BookEntity) = with(itemView) {
            // TODO: Bind the data with View

            setOnClickListener {
//                val bundle = bundleOf("amount" to amount)
//                findNavController().navigate(R.id.action_navigation_search_to_detailViewFragment, bundle)
                val data = bundleOf(
                    "book_id" to bookEntity.id,
                    "book_name" to bookEntity.bookName,
                    "author_name" to bookEntity.authorName
                )
                findNavController().navigate(R.id.action_navigation_search_to_detailViewFragment,data)

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