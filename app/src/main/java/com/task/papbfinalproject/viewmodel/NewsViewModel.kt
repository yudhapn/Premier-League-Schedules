package com.task.papbfinalproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.task.papbfinalproject.model.Event
import com.task.papbfinalproject.model.Team
import com.task.papbfinalproject.repository.FootballRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class NewsViewModel(
    private val repo: FootballRepository,
    private val eventType: String
) : BaseViewModel() {
    private var supervisorJob = SupervisorJob()

    private val _eventList = MutableLiveData<List<Event>>()
    val eventList: LiveData<List<Event>>
        get() = _eventList

    private val _teamList = MutableLiveData<List<Team>>()
    val teamList: LiveData<List<Team>>
        get() = _teamList

    init {
        getEvent()
        getAllTeam()
    }

    private fun getEvent(id: String = "4328") {
        ioScope.launch(getJobErrorHandler() + supervisorJob) {
            val events = repo.getEvent(id, eventType)
            _eventList.postValue(events)
        }
    }

    private fun getAllTeam(id: String = "4328") {
        ioScope.launch(getJobErrorHandler() + supervisorJob) {
            _teamList.postValue(repo.getAllTeam(id))
        }
    }

    private fun getJobErrorHandler() = CoroutineExceptionHandler { _, _ ->
        //        _networkState.postValue(NetworkState.FAILED)
    }
}