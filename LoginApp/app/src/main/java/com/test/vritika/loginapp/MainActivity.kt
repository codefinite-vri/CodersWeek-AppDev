package com.test.vritika.loginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()
        register.setOnClickListener{
            startActivity(Intent(this, SignUp::class.java))
            finish()
        }
        Login.setOnClickListener{
            doLogin()
        }
    }
    private fun doLogin(){
        if(email.text.toString().isEmpty()){
            email.error="Please enter email"
            email.requestFocus()
            return
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()){
            email.error="Please enter a valid email"
            email.requestFocus()
            return
        }

        if(password.text.toString().isEmpty()){
            password.error = "Please enter password"
            password.requestFocus()
            return
        }    
        auth.signInWithEmailAndPassword(email.text.toString(), password.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user:FirebaseUser? = auth.currentUser
                    updateUI(user)
                } else {
                    Toast.makeText(baseContext, "Login failed.",
                        Toast.LENGTH_SHORT).show()
                    updateUI(null)
                }
            }
    }
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
    }

    private fun updateUI(currentUser:  FirebaseUser?){
        if (currentUser != null){
            if(currentUser.isEmailVerified){
                startActivity(Intent(this, Switch::class.java))
                finish()
            }
            else{
                Toast.makeText(baseContext, "Please verify your email", Toast.LENGTH_SHORT).show()
            }
        }
        else{
            Toast.makeText(baseContext, "Login failed", Toast.LENGTH_SHORT).show()
        }
    }
}
