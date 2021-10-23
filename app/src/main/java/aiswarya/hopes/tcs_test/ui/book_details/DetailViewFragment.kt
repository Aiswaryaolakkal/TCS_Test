package aiswarya.hopes.tcs_test.ui.book_details

import aiswarya.hopes.tcs_test.databinding.FragmentDetailViewBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class DetailViewFragment : Fragment() {
    private lateinit var binding: FragmentDetailViewBinding

    private val detailViewViewModel: DetailViewViewModel by viewModels()
    private val detailViewFragmentArgs: DetailViewFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailViewBinding.inflate(inflater, container, false)
        val view = binding.root

        detailViewViewModel.fetchBook(detailViewFragmentArgs.bookId)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            detailViewViewModel.book.collectLatest {
                it?.let {
                    binding.bookNameTv.text = it.bookName
                    binding.authorNameTv.text = it.authorName
                }
            }
        }
    }

}