package com.task.papbfinalproject.ui


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.task.papbfinalproject.R
import com.task.papbfinalproject.databinding.FragmentHomeBinding
import com.task.papbfinalproject.ui.adapter.ViewPagerAdapter
import com.task.papbfinalproject.viewmodel.NewsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment() : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val newsViewModel: NewsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)


        val shared = requireContext().getSharedPreferences("shared", AppCompatActivity.MODE_PRIVATE)
        val avatarImage = shared.getInt("avatar", R.drawable.ic_avatar)
        Log.d("testing", "default avatar: ${R.drawable.ic_avatar}")
        Log.d("testing", "shared avatar: $avatarImage")
        binding.ivAvatar.setImageResource(avatarImage)


        val adapter = ViewPagerAdapter(childFragmentManager, requireContext())
        binding.viewPager.adapter = adapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
        binding.ivAvatar.setOnClickListener {
            val action = HomeFragmentDirections.actionToEditProfile(avatarImage)
            findNavController().navigate(action)
        }
        return binding.root
    }
}
