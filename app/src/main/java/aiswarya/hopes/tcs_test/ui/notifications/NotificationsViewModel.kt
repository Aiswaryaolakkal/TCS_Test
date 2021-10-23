package aiswarya.hopes.tcs_test.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotificationsViewModel : ViewModel() {

    private val notification_txt = MutableLiveData<String>().apply {
        value = "Notifications"
    }
    val text: LiveData<String> = notification_txt
}