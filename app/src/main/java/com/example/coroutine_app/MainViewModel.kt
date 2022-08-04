package com.example.coroutine_app

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
     fun uploadFile(){
         viewModelScope.launch {
             while (true) {
                 SampleApi().uploadFile("Main ViewModel File")
             }
         }
     }

    override fun onCleared() {
        Log.d("VMCleared","Main View model is cleared")
        super.onCleared()
    }
}