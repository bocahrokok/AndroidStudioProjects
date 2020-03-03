package com.bocahrokok.quizapp

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import io.reactivex.Single

class Firestore {

    val db = FirebaseFirestore.getInstance()

    fun getAllQuiz() : Single<List<TodoModel>> {



        return Single.create {
            e -> db.collection("quiz")
            .get()
            .addOnSuccessListener {

                val list = mutableListOf<TodoModel>()
                it.forEach {document ->
                    val todo = TodoModel(
                        document.id,
                        document["title"]?.toString()?: "",
                       document["description"]?.toString() ?: ""

                    )
                    list.add(todo)
                }
                e.onSuccess(list)
            }
            .addOnFailureListener{
                e.onError(it)
            }
        }
    }
}