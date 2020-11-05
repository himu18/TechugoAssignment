package com.personal.techugoassignment.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.personal.techugoassignment.BR
import com.personal.techugoassignment.R
import com.personal.techugoassignment.base.BaseActivity
import com.personal.techugoassignment.view.adapter.TabPagerAdapter
import com.personal.techugoassignment.viewmodel.FitnessViewModel


class FitnessActivity : BaseActivity<FitnessViewModel>() {

    private lateinit var mFitnessViewModel: FitnessViewModel
    var mainTabLayout: TabLayout? = null
    var pager: ViewPager? = null
    private val mLiatItems =
        arrayOf("Offers", "Offer Details")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fitness)
        mainTabLayout = findViewById(R.id.mainTablayout)
        pager = findViewById(R.id.mainViewPager)
        for (i in mLiatItems.indices) {
            with(mainTabLayout) { this!!.addTab(newTab().setText("" + mLiatItems[i]), i) }
        }
        val tabPagerAdapter = TabPagerAdapter(supportFragmentManager)
        with(pager) {
            this!!.setAdapter(tabPagerAdapter)
        }
        with(mainTabLayout) {
            with(pager) {
                this!!.setAdapter(tabPagerAdapter)
            }
            this!!.setupWithViewPager(pager)
        }
    }

    override fun getBindingVariable(): Int {
        return BR.viewmodel1
    }

    override fun getLayoutId(): Int {
       return R.layout.activity_fitness
    }

    override fun getViewModel(): FitnessViewModel {
        mFitnessViewModel = ViewModelProviders.of(this).get(FitnessViewModel::class.java)
        return mFitnessViewModel
    }


}
