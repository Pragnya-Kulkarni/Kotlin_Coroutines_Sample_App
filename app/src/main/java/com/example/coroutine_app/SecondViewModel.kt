package com.example.coroutine_app

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class SecondViewModel : ViewModel() {
    // below code is to test dispatcher.IO and Main
    /*fun testDispatcherIO() {

        Log.d("MainThread", "MainThread>>>>>" + Thread.currentThread().toString())
        viewModelScope.launch(Dispatchers.IO) {
            SampleApi().uploadFile("DispatcherIOFile")

            Log.d("CurrentThread", "CurrentThread>>>>>" + Thread.currentThread().toString())
            updateUI()

        }
    }*/


    // below code is to test async await
    /* fun testAsyncAwait(){
         // below code is to test async await
         viewModelScope.launch {
             val defferedResult = deffered.await() // "any result"
             Log.d("Users",defferedResult.toString())
         }
     }*/


    /* val deffered = viewModelScope.async(Dispatchers.IO) {
         val lstUsers = SampleApi().getUsers()

         updateUI()
         return@async lstUsers
     }*/

    /*var liveData: MutableLiveData<String>? = null
    private suspend fun updateUI() {
        withContext(Dispatchers.Main)
        {
            Log.d("CurrentThread", "Switched Thread To>>>>>>> " + Thread.currentThread().toString())
            liveData?.let {
                it.value = "Image decoded successfully!"

            }
        }

    }*/


    private lateinit var scope: CoroutineScope
    private lateinit var job: Job
    fun printAllThreadsWithCustomScope() {

        viewModelScope.launch {
            Log.d(
                "ViewModelScope",
                "ViewModelScope launched >>>>>>>>>>>>>>>>>>>"
            )
            job = Job()
            scope = CoroutineScope(job + Dispatchers.Main + CoroutineName("MyCoroutine"))

            val jobs = listOf<Job>(
                scope.launch {
                    Log.d(
                        "CustomScope",
                        "Thread from parent : My Thread is ${Thread.currentThread().name}"
                    )
                },

                scope.launch(Dispatchers.Main) {
                    Log.d(
                        "CustomScope",
                        "Main : My Thread is ${Thread.currentThread().name}"
                    )
                },
                scope.launch(Dispatchers.Unconfined) {
                    Log.d(
                        "CustomScope",
                        "Unconfined  : My Thread is ${Thread.currentThread().name}"
                    )
                },
                scope.launch(Dispatchers.Default) {
                    Log.d(
                        "CustomScope",
                        "Default : My Thread is ${Thread.currentThread().name}"
                    )
                },
                scope.launch(newSingleThreadContext("MyOwnCustomThread")) {
                    Log.d(
                        "CustomScope",
                        "newSingleThreadContext : My Thread is ${Thread.currentThread().name}"
                    )
                }
            )

            // waiting for the coroutine to finish it's work
            jobs.joinAll()

            Log.d(
                "ViewModelScope",
                "Join back to ViewModelScope >>>>>>>>>>>>>>>>>>>"
            )
        }
    }

    override fun onCleared() {
        Log.d("VMCleared", "Second View Model is cleared")
        //cancel job
        job.cancel()
        super.onCleared()
    }
}