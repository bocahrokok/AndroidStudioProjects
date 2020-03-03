package com.bocahrokok.quizapp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

class TodoViewModel: ViewModel() {
    val todos = MutableLiveData<List<TodoModel>>()
    val disposable = CompositeDisposable()
    val firestore = Firestore()

    init {
        todos.value = emptyList()
        getAllTodo()
    }

    private fun getAllTodo(){
        firestore.getAllQuiz()

            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                todos.value = it
            },{ Log.e("Todo", it.message)
            }).addTo(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }



}