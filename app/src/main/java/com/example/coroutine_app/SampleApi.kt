package com.example.coroutine_app

import android.util.Log
import kotlinx.coroutines.delay

class SampleApi {
    suspend fun uploadFile(fileName:String){
        Log.d("uploading","File $fileName is uploading......")
        delay(5000)
        Log.d("file uploaded","File $fileName is uploaded......")
    }
    suspend fun getUsers():List<String>{
        Log.d("User","getting user list started......")
        delay(5000)
        Log.d("User","getting user list completed......")
        return listOf("name1", "name2", "name3", "name4")
    }
}