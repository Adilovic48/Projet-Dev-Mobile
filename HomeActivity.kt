package com.example.epsiapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Définir les éléments de la page, ici le bouton pour accéder aux informations des étudiants
        val btnStudentInfo: Button = findViewById(R.id.btn_student_info)
        btnStudentInfo.setOnClickListener {
            // Rediriger vers la page des informations des étudiants
            val intent = Intent(this, StudentInfoActivity::class.java)
            startActivity(intent)
        }
    }

    // Cette méthode est appelée quand le bouton Informations des étudiants est cliqué
    fun onStudentInfoClick(view: View) {
        // Rediriger vers la page suivante (Information du groupe par exemple)
        val intent = Intent(this, StudentInfoActivity::class.java)
        startActivity(intent)
    }
}
