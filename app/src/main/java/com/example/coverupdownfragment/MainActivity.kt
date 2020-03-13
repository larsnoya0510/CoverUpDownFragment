package com.example.coverupdownfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
lateinit var mfragmentContainer:Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mfragmentContainer=CoverFragment()
        var action = this.supportFragmentManager!!.beginTransaction()
        action.replace(R.id.fragmentContainer,
            mfragmentContainer
        )
        action.addToBackStack(null)
        action.commit()
    }
}
