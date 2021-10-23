package aiswarya.hopes.tcs_test.ui.home

import aiswarya.hopes.tcs_test.R
import aiswarya.hopes.tcs_test.databinding.BookItemLayoutBinding
import aiswarya.hopes.tcs_test.model.BookEntity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class RecentBookAdapter :
    ListAdapter<BookEntity, RecentBookAdapter.RecentBookViewHolder>(DiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentBookViewHolder {
        val binding =
            BookItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecentBookViewHolder(binding)

    }

    override fun onBindViewHolder(holder: RecentBookViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)

    }

    class RecentBookViewHolder(private val binding: BookItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(bookEntity: BookEntity) = with(itemView) {


            setOnClickListener {
                val data = bundleOf(
                    "book_id" to bookEntity.id,
                    "book_name" to bookEntity.bookName,
                    "author_name" to bookEntity.authorName
                )
                findNavController().navigate(
                    R.id.action_navigation_home_to_detailViewFragment,
                    data
                )

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