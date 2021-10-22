package aiswarya.hopes.tcs_test.ui.book_details

import aiswarya.hopes.tcs_test.databinding.FragmentDetailViewBinding
import aiswarya.hopes.tcs_test.ui.home.HomeViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class DetailViewFragment : Fragment() {
    private lateinit var binding: FragmentDetailViewBinding
    private lateinit var detailViewViewHolder: DetailViewViewHolder


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        detailViewViewHolder =
            ViewModelProvider(this).get(DetailViewViewHolder::class.java)
        binding = FragmentDetailViewBinding.inflate(inflater, container, false)
        val view = binding.root

//        detailViewViewHolder.text.observe(viewLifecycleOwner, Observer {
//            binding.textDetail.text = it
//        })

        val id = arguments?.getString("book_id")
        binding.bookNameTv.text = arguments?.getString("book_name")
        binding.authorNameTv.text = arguments?.getString("author_name")
        return view
    }


}