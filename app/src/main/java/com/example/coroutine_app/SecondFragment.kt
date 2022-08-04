package com.example.coroutine_app

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels



class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(
            R.layout.fragment_second, container, false)

        rootView.findViewById<Button>(R.id.button2).setOnClickListener {
            val intent = Intent(activity, SecondActivity::class.java)
            startActivity(intent)
        }
        // Inflate the layout for this fragment
        return rootView

    }

    // below code is to test for view model scope
    //private val vm: MainViewModel by navGraphViewModels(R.id.nav_graph)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //   2. LifeCycle Scope
        //LifeCycle scope= component lifecycle (activity , fragment)
        // once second fragment gets destroyed this scope ends
        /*lifecycleScope.launch {
            while (true) {
                SampleApi().uploadFile("FileName")
            }
        }*/


        // below code is to test for view model scope
        //vm.uploadFile()


    }
}