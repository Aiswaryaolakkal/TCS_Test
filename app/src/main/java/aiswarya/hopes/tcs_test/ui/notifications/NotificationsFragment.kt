package aiswarya.hopes.tcs_test.ui.notifications


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import aiswarya.hopes.tcs_test.R
import aiswarya.hopes.tcs_test.databinding.FragmentHomeBinding
import aiswarya.hopes.tcs_test.databinding.FragmentNotificationsBinding
import aiswarya.hopes.tcs_test.databinding.FragmentSettingsBinding
import androidx.navigation.fragment.findNavController

class NotificationsFragment : Fragment() {
    private lateinit var binding: FragmentNotificationsBinding
    private lateinit var notificationsViewModel: NotificationsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val view = binding.root
        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textNotifications.text = it
        })
        binding.titleNotification.text = "Notification"
        binding.textNotifications.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_notifications_to_detailViewFragment)
        }
        return view
    }

}