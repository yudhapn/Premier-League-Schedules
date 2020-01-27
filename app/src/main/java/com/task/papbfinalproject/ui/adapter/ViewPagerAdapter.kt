package com.task.papbfinalproject.ui.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.task.papbfinalproject.ui.MatchesFragment
import com.task.papbfinalproject.R

@Suppress("DEPRECATION")
class ViewPagerAdapter(
    fm: FragmentManager,
    private val context: Context
) :
    FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> MatchesFragment("next")
            1 -> MatchesFragment("finished")
            else -> MatchesFragment("")
        }

    override fun getCount(): Int = 2

    override fun getPageTitle(position: Int): CharSequence? =
        when (position) {
            0 -> context.getString(R.string.upcoming)
            1 -> context.getString(R.string.finish)
            else -> context.getString(R.string.finish)
        }
}