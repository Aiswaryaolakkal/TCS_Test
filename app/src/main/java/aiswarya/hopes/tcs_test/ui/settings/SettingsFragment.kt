package aiswarya.hopes.tcs_test.ui.settings

import aiswarya.hopes.tcs_test.R
import aiswarya.hopes.tcs_test.databinding.FragmentHomeBinding
import aiswarya.hopes.tcs_test.databinding.FragmentSettingsBinding
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider


class SettingsFragment : Fragment() {

    private lateinit var binding: FragmentSettingsBinding
    private lateinit var settinsViewModel: SettingsViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        settinsViewModel = ViewModelProvider(this).get(SettingsViewModel::class.java)
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val view = binding.root

        settinsViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textSetting.text = it
        })
        return view

    }


}