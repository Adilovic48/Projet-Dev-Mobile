package com.example.epsi_app

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)  // Charger le layout XML

        // Gérer la transition vers la deuxième page après 2 secondes
        Handler().postDelayed({
            val intent = Intent(this, HomeActivity::class.java)  // Redirection vers la page d'accueil
            startActivity(intent)
            finish()  // Fermer l'activité Splash
        }, 2000)  // Délai de 2 secondes
    }
}
