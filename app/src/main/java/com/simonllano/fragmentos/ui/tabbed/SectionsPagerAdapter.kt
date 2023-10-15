package com.simonllano.fragmentos.ui.tabbed

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.simonllano.fragmentos.R
import com.simonllano.fragmentos.ui.batman.batmanFragment
import com.simonllano.fragmentos.ui.superman.supermanFragment
import com.simonllano.fragmentos.ui.wonderwoman.wonderwomanFragment
import com.simonllano.fragmentos.ui.flash.flashFragment


private val TAB_TITLES = arrayOf(
    R.string.batman_name,
    R.string.wonderwoman_name,
    R.string.superman_name,
    R.string.flash_name
)

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm){


    override fun getItem(position: Int): Fragment {
            return when(position) {
                0 -> batmanFragment()
                1 -> wonderwomanFragment()
                2 -> supermanFragment()
                else -> flashFragment()
            }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])

    }

    override fun getCount(): Int {
        return 4
    }


}