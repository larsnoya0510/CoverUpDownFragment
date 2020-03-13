package com.example.coverupdownfragment


import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_cover.view.*

/**
 * A simple [Fragment] subclass.
 */
class CoverFragment : Fragment() {
lateinit var RootView:View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        RootView= inflater.inflate(R.layout.fragment_cover, container, false)
        RootView.TouchConstraintLayout.setOnClickListener {
            RootView.TopConstraintLayout.visibility=View.GONE

        }
        RootView.openFunctionConstraintLayout.setOnClickListener {
            RootView.TopConstraintLayout.visibility=View.VISIBLE
        }
        RootView.flipPrevConstraintLayout.setOnClickListener {
            Toast.makeText(this.context,"上一頁",Toast.LENGTH_SHORT).show()
        }
        RootView.flipNextConstraintLayout.setOnClickListener {
            Toast.makeText(this.context,"下一頁",Toast.LENGTH_SHORT).show()
        }
        RootView.orientationImageView.setOnClickListener {
            if (activity!!.requestedOrientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
                activity!!.requestedOrientation=ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
                RootView.showImageView.setImageResource(R.drawable.comic)

            }
            else if (activity!!.requestedOrientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
                activity!!.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
                RootView.showImageView.setImageResource(R.drawable.comic2)
            }
        }
        return RootView
    }

    override fun onResume() {
        super.onResume()
        if (activity!!.requestedOrientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            RootView.showImageView.setImageResource(R.drawable.comic2)

        }
        else if (activity!!.requestedOrientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            RootView.showImageView.setImageResource(R.drawable.comic)
        }
    }
}
