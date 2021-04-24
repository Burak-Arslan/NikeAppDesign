package com.example.nikedesign

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var mBottomSheetBehavior: BottomSheetBehavior<*>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initilaze()
        events()
    }

    fun initilaze() {

        val list: MutableList<NikeResponse> = ArrayList()

        list.add(NikeResponse(R.drawable.first2, "700", "Zoom Pegasus - $299"))
        list.add(NikeResponse(R.drawable.first7, "450", "Mercurial - $199"))
        list.add(NikeResponse(R.drawable.top3, "600", "Soccer Ball - $299"))
        list.add(NikeResponse(R.drawable.first4, "450", "Nike Air - $499"))
        list.add(NikeResponse(R.drawable.uniform, "700", "Football Shirt - $399"))
        list.add(NikeResponse(R.drawable.first, "450", "Nike Air Max - $899"))
        list.add(NikeResponse(R.drawable.top5, "600", "Juventus Ball - $499"))
        list.add(NikeResponse(R.drawable.first3, "450", "Nike OutDoor - $699"))
        list.add(NikeResponse(R.drawable.uniform2, "700", "City FC Shirt - $99"))
        list.add(NikeResponse(R.drawable.first6, "450", "Nike Phantom - $999"))
        list.add(NikeResponse(R.drawable.uniform3, "700", "Football Shirt - $99"))
        list.add(NikeResponse(R.drawable.top4, "600", "Nike Soccer Ball - $99"))
        list.add(NikeResponse(R.drawable.uniform4, "700", "Football Shirt - $199"))
        list.add(NikeResponse(R.drawable.first5, "450", "SuperFly - $699"))
        list.add(NikeResponse(R.drawable.uniform5, "700", "National Team - $399"))
        list.add(NikeResponse(R.drawable.top, "600", "Soccer Ball - $99"))

        recyclerMain.adapter =
            NikeAdapter(list, this)
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        recyclerMain.layoutManager = layoutManager
        recyclerMain.setHasFixedSize(true)
    }

    fun events() {

        btnBag.setOnClickListener {

            imgSearch.visibility = View.GONE
            recyclerUpAnimated()
            animationBagAndBottomAppBar()

            val layoutParams: ViewGroup.LayoutParams = coordinatorLayout.layoutParams
            layoutParams.height = 750
            coordinatorLayout.layoutParams = layoutParams

            mBottomSheetBehavior!!.state = BottomSheetBehavior.STATE_EXPANDED

        }
        mBottomSheetBehavior = BottomSheetBehavior.from(bottom_sheet)

        (mBottomSheetBehavior as BottomSheetBehavior<View>).setBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_COLLAPSED -> {

                        imgSearch.visibility = View.VISIBLE
                        val params: ViewGroup.MarginLayoutParams = imgSearch!!.layoutParams as ViewGroup.MarginLayoutParams
                        params.topMargin = 185
                        imgSearch.layoutParams = params

                        expandedShowingMode()
                        animationSheet()
                    }
                    BottomSheetBehavior.STATE_DRAGGING -> {
                        Log.e("STATE_DRAGGING", "STATE_DRAGGING")
                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        Log.e("STATE_EXPANDED", "STATE_EXPANDED")
                    }
                    BottomSheetBehavior.STATE_HIDDEN -> {
                        expandedShowingMode()
                        animationSheet()
                    }
                    BottomSheetBehavior.STATE_SETTLING -> {
                        Log.e("STATE_SETTLING", "STATE_SETTLING")
                    }
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                Log.e("onSlide", "onSlide")
            }
        })
    }

    fun expandedShowingMode() {
        animationSheetAndAppBar()

        val layoutParams: ViewGroup.LayoutParams = coordinatorLayout.layoutParams
        layoutParams.height = 300
        coordinatorLayout.layoutParams = layoutParams
    }

    fun animationSheetAndAppBar(){
        val animate = TranslateAnimation(
            0F,
            0F,
            -150F,
            0F
        )
        animate.duration = 500
        animate.fillAfter = true
        btnBag.startAnimation(animate)
        bottomAppBar.startAnimation(animate)
        animate.setAnimationListener(object :
            Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                btnBag.visibility = View.VISIBLE
                bottomAppBar.visibility = View.VISIBLE
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }
        })
    }

    fun animationSheet(){
        val animate = TranslateAnimation(
            0F,
            0F,
            -150F,
            0F
        )
        animate.duration = 500
        animate.fillAfter = true
        bottom_sheet.startAnimation(animate)
        animate.setAnimationListener(object :
            Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                bottom_sheet.visibility = View.GONE
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }
        })

        bottom_sheet.visibility = View.GONE
        recyclerDownAnimated()
    }

    fun recyclerDownAnimated(){
        val animate = TranslateAnimation(
            0F,
            0F,
            -150F,
            0F
        )
        animate.duration = 500
        animate.fillAfter = true
        recyclerMain.startAnimation(animate)
        animate.setAnimationListener(object :
            Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                val layoutParams: ViewGroup.LayoutParams = coordinatorLayout.layoutParams
                layoutParams.height = 300
                coordinatorLayout.layoutParams = layoutParams
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }
        })
    }

    fun recyclerUpAnimated(){
        val animate = TranslateAnimation(
            0F,
            0F,
            150F,
            0F
        )
        animate.duration = 500
        animate.fillAfter = true
        recyclerMain.startAnimation(animate)
        animate.setAnimationListener(object :
            Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                val layoutParams: ViewGroup.LayoutParams = coordinatorLayout.layoutParams
                layoutParams.height = 700
                coordinatorLayout.layoutParams = layoutParams
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }
        })
    }

    fun animationBagAndBottomAppBar(){
        val animate = TranslateAnimation(
            0F,
            0F,
            0F,
            350F
        )
        animate.duration = 500
        animate.fillAfter = true
        btnBag.startAnimation(animate)
        bottomAppBar.startAnimation(animate)
        animate.setAnimationListener(object :
            Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                bottom_sheet.visibility = View.VISIBLE
                btnBag.visibility = View.GONE
                bottomAppBar.visibility = View.GONE
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }
        })
    }


    override fun onBackPressed() {

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return true
    }
}