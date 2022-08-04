package com.example.coroutine_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // 1. Global Scope
        // it wil run till the app is running or in background, once app is closed then scope wil be destroyed
        //global scope= apps lifecycle
       /* GlobalScope.launch {
            while(true) {
                SampleApi().uploadFile("FileName")
            }
        }*/

        //   2. LifeCycle Scope
        //LifeCycle scope= component lifecycle (activity , fragment)
        //check inside second fragment // uncomment code in second fragment
        /*lifecycleScope.launch{
            while(true) {
                SampleApi().uploadFile("FileName")
            }
        }*/


        // 3. ViewModel Scope
        //Uncomment the second fragment code and second viewmodel code

    }
}