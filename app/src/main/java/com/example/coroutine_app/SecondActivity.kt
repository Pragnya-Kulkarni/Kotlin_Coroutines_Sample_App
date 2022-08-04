package com.example.coroutine_app

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.navGraphViewModels
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.coroutine_app.databinding.ActivitySecondBinding


class SecondActivity : AppCompatActivity() {
    lateinit var secondViewModel: SecondViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //uncomment this to check viewModelScope... view model scope gets destroyed when this activity is destroyed and view model is closed
        /*Log.d("SecondActivity", "Second Activity started")
        secondViewModel = ViewModelProvider(this)[SecondViewModel::class.java];
        Log.d("SecondActivity", "Second view model - Get Users function is called")
        secondViewModel.getUsers()*/


        // below code is to test dispatcher IO and MAIN
       // secondViewModel = ViewModelProvider(this)[SecondViewModel::class.java];
       // secondViewModel.testDispatcherIO()


        // below code is to test async await
        //secondViewModel = ViewModelProvider(this)[SecondViewModel::class.java];
        //secondViewModel.testAsyncAwait()


        // below code is to demo custom scope, about job, job joining ,job cancel,
        secondViewModel = ViewModelProvider(this)[SecondViewModel::class.java];
        secondViewModel.printAllThreadsWithCustomScope()

    }
}