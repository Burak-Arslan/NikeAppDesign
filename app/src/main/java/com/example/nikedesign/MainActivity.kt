package com.example.nikedesign

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list: MutableList<NikeResponse> = ArrayList()

        list.add(NikeResponse(R.drawable.first2, "700"))
        list.add(NikeResponse(R.drawable.first7, "350"))
        list.add(NikeResponse(R.drawable.top3, "500"))
        list.add(NikeResponse(R.drawable.first4, "350"))
        list.add(NikeResponse(R.drawable.uniform, "700"))
        list.add(NikeResponse(R.drawable.first, "450"))
        list.add(NikeResponse(R.drawable.top5, "500"))
        list.add(NikeResponse(R.drawable.first3, "350"))
        list.add(NikeResponse(R.drawable.uniform2, "700"))
        list.add(NikeResponse(R.drawable.first6, "450"))
        list.add(NikeResponse(R.drawable.uniform3, "700"))
        list.add(NikeResponse(R.drawable.top4, "500"))
        list.add(NikeResponse(R.drawable.uniform4, "700"))
        list.add(NikeResponse(R.drawable.first5, "350"))
        list.add(NikeResponse(R.drawable.uniform5, "700"))
        list.add(NikeResponse(R.drawable.top, "500"))

        recyclerMain.adapter =
            NikeAdapter(list, this)
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        recyclerMain.layoutManager = layoutManager
        recyclerMain.setHasFixedSize(true)
    }

    override fun onBackPressed() {

    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return true
    }
}