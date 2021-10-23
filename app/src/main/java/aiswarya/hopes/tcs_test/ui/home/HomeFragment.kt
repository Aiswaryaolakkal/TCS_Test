package aiswarya.hopes.tcs_test.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import aiswarya.hopes.tcs_test.R
import aiswarya.hopes.tcs_test.databinding.FragmentHomeBinding
import aiswarya.hopes.tcs_test.ui.search.BookAdapter
import android.view.*
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentHomeBinding.bind(view)
        val recentBookAdapter = BookAdapter()
        recentBookAdapter.onChoose {
            val data = bundleOf(
                "bookId" to it.id,
            )
            findNavController().navigate(R.id.action_navigation_home_to_detailViewFragment,data)
        }
        binding.apply {

            recentBookRv.apply {
                adapter = recentBookAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
            titleHome.text = "Home"
        }
        homeViewModel.books.observe(viewLifecycleOwner) {
            recentBookAdapter.submitList(it)
        }

    }


}