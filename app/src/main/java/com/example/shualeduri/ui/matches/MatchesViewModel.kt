package com.example.shualeduri.ui.matches

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shualeduri.models.Result
import com.example.shualeduri.network.RetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MatchesViewModel : ViewModel() {

    private val _resultLiveData = MutableLiveData<Result>().apply {
        Result
    }
    val resultLiveData: MutableLiveData<Result> = _resultLiveData

    fun getData() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                getFields()
            }
        }
    }

    private suspend fun getFields() {
        val response = RetrofitService.retrofitService.getResult()
        if (response.isSuccessful) {
            val fields = response.body()
            resultLiveData.postValue(fields)
        } else {
            response.code()
        }
    }
}