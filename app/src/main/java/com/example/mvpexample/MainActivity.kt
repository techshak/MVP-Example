package com.example.mvpexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity(),Contract.View {
    // creating object of TextView class
    private lateinit var imageView: ImageView

    // creating object of Button class
    private lateinit var button: Button

    // creating object of ProgressBar class
    private lateinit var progressBar: ProgressBar

    // creating object of Presenter interface in Contract
    var presenter: Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // assigning ID of the ImageView
        imageView = findViewById(R.id.imageView)

        // assigning ID of the Button
        button = findViewById(R.id.button)

        // assigning ID of the ProgressBar
        progressBar = findViewById(R.id.progressBar)

        // instantiating object of Presenter Interface
        presenter = Presenter(this, Model())

        // operations to be performed when user clicks the button
        this.button.setOnClickListener(View.OnClickListener { presenter!!.onButtonClick() })
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter!!.onDestroy()
    }

    // method to display the Pokemon ImageView
    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
        imageView.visibility = View.INVISIBLE
    }

    // method to hide the Pokemon ImageView
    override fun hideProgress() {
        progressBar.visibility = View.GONE
        imageView.visibility = View.VISIBLE
    }

    // method to set random url for the Pokemon ImageView
    override fun setString(string: String?) {
        Glide.with(this).load(string).into(imageView)
    }
}