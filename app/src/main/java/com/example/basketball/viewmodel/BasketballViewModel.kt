package com.example.basketball.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class BasketballViewModel : ViewModel() {
    private var _scoreA = MutableLiveData(0)
    private var _scoreB = MutableLiveData(0)

    val updateScoreA: LiveData<Int> = _scoreA
    val updateScoreB: LiveData<Int> = _scoreB

    fun plusThreeA() {
        _scoreA.value = _scoreA.value?.plus(3)
    }

    fun plusThreeB() {
        _scoreB.value = _scoreB.value?.plus(3)
    }

    fun plusTwoA() {
        _scoreA.value = _scoreA.value?.plus(2)
    }

    fun plusTwoB() {
        _scoreB.value = _scoreB.value?.plus(2)
    }

    fun plusOneA() {
        _scoreA.value = _scoreA.value?.plus(1)
    }

    fun plusOneB() {
        _scoreB.value = _scoreB.value?.plus(1)
    }

    fun reset() {
        _scoreA.value = 0
        _scoreB.value = 0
    }
}