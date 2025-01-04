// StudentDetailsActivity.kt
package com.example.epsiapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class StudentDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)  // Charger le layout XML des détails de l'étudiant

        // Récupérer les données passées via l'Intent
        val studentName = intent.getStringExtra("studentName")
        val studentEmail = intent.getStringExtra("studentEmail")

        // Afficher les données dans les TextView
        val nameTextView: TextView = findViewById(R.id.studentNameDetails)
        val emailTextView: TextView = findViewById(R.id.studentEmailDetails)

        nameTextView.text = studentName
        emailTextView.text = studentEmail
    }
}
