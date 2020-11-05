package com.personal.techugoassignment.view.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.personal.techugoassignment.view.fragment.OfferDetailsFragment
import com.personal.techugoassignment.view.fragment.OfferFragment

class TabPagerAdapter(fm: FragmentManager?) :
    FragmentStatePagerAdapter(fm!!) {
    private val mList =
        arrayOf("Offers", "Offer Details")
    var context: Context? = null
    override fun getPageTitle(position: Int): CharSequence? {
        return mList[position]
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                OfferFragment()
            }
            1 -> {
                OfferDetailsFragment()
            }
            else-> null!!
        }
    }

    override fun getCount(): Int {
        return mList.size
    }
}
