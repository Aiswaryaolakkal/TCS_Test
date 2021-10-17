package aiswarya.hopes.tcs_test.ui.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import aiswarya.hopes.tcs_test.R
import aiswarya.hopes.tcs_test.databinding.FragmentSearchBinding
import aiswarya.hopes.tcs_test.util.onQueryTextChanged
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.fragment_search) {

    private val viewModel: SearchViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentSearchBinding.bind(view)
        val searchAdapter = SearchAdapter()

        binding.apply {
            list.apply {
                adapter = searchAdapter
                layoutManager = LinearLayoutManager(requireContext())
                setHasFixedSize(true)
            }


        }
        viewModel.tasks.observe(viewLifecycleOwner) {
            searchAdapter.submitList(it)
        }

        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_fragment, menu)

        val searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem.actionView as SearchView

        searchView.onQueryTextChanged {
            viewModel.searchQuery.value = it
        }
    }

}