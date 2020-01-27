package com.task.papbfinalproject.ui


import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.task.papbfinalproject.databinding.FragmentCategoryBinding
import com.task.papbfinalproject.ui.adapter.TeamAdapter
import com.task.papbfinalproject.ui.adapter.TeamListener
import com.task.papbfinalproject.viewmodel.NewsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class CategoryFragment : Fragment() {
    private lateinit var binding: FragmentCategoryBinding
    private val newsViewModel: NewsViewModel by viewModel{ parametersOf("")}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.newsVM = newsViewModel
        binding.rvTeam.adapter = TeamAdapter(TeamListener {
            searchWeb(it.strTeam)
        })
        return binding.root
    }

    fun searchWeb(query: String) {
        val intent = Intent(Intent.ACTION_WEB_SEARCH).apply {
            putExtra(SearchManager.QUERY, query)
        }
        if (intent.resolveActivity(requireContext().packageManager) != null) {
            startActivity(intent)
        }
    }

}
