package com.task.papbfinalproject.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pertamina.spbucare.notification.NotificationHelper
import com.task.papbfinalproject.databinding.FragmentMatchesBinding
import com.task.papbfinalproject.util.getImage
import com.task.papbfinalproject.ui.adapter.EventAdapter
import com.task.papbfinalproject.ui.adapter.EventListener
import com.task.papbfinalproject.viewmodel.NewsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MatchesFragment(eventType: String) : Fragment() {
    private lateinit var binding: FragmentMatchesBinding
    private val newsViewModel: NewsViewModel by viewModel { parametersOf(eventType) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMatchesBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.newsVM = newsViewModel


        binding.rvNews.adapter = EventAdapter(EventListener {
            var title = "Upcoming!!"
            var body = "Upcoming!!"
            var idWinner = ""
            if (it.intHomeScore != null) {
                if (it.intHomeScore.toInt() > it.intAwayScore.toInt()) {
                    title = "${it.strHomeTeam} Win!!"
                    idWinner = it.idHomeTeam
                } else if(it.intHomeScore.toInt() < it.intAwayScore.toInt()) {
                    title = "${it.strAwayTeam} Win!!"
                    idWinner = it.idAwayTeam
                } else {
                    title = "Draw!!"
                }
                body = "${it.strHomeTeam} ${it.intHomeScore} : ${it.intAwayScore} ${it.strAwayTeam}"
            }
            val image = getImage(idWinner)



            NotificationHelper.run {
                displayNotification(
                    requireContext(),
                    title,
                    body,
                    image
                )
            }
//            val action = HomeFragmentDirections.actionToDetailNews(it)
//            findNavController().navigate(action)
        })
        return binding.root
    }
}
