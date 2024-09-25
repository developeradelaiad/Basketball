package com.example.basketball

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.basketball.databinding.ActivityMainBinding
import com.example.basketball.dialog.ExitDialog
import com.example.basketball.viewmodel.BasketballViewModel
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val basketballViewModel = ViewModelProvider(this)[BasketballViewModel()::class.java]
        basketballViewModel.updateScoreA.observe(this) {
            binding.scoreATx.text = it.toString()
        }
        basketballViewModel.updateScoreB.observe(this) {
            binding.scoreBTx.text = it.toString()
        }

        binding.plusThreeABtn.setOnClickListener { basketballViewModel.plusThreeA() }
        binding.plusThreeBBtn.setOnClickListener { basketballViewModel.plusThreeB() }
        binding.plusTwoABtn.setOnClickListener { basketballViewModel.plusTwoA() }
        binding.plusTwoBBtn.setOnClickListener { basketballViewModel.plusTwoB() }
        binding.plusOneABtn.setOnClickListener { basketballViewModel.plusOneA() }
        binding.plusOneBBtn.setOnClickListener { basketballViewModel.plusOneB() }
        binding.exitBtn.setOnClickListener {
            if (binding.scoreATx.text.toString().toInt() > binding.scoreBTx.text.toString().toInt())
                Toast.makeText(this, "Team A is Winner", Toast.LENGTH_SHORT).show()
            else Toast.makeText(this, "Team B is Winner", Toast.LENGTH_SHORT).show()
        }
        binding.restBtn.setOnClickListener {
            Snackbar.make(binding.root, "Do you want to reser", Snackbar.LENGTH_INDEFINITE)
                .setAction("Yes") {
                        basketballViewModel.reset()

                }
                .setActionTextColor(getColor(R.color.red))
                .setTextColor(getColor(R.color.white))
                .setBackgroundTint(getColor(R.color.black))
                .show()
        }
    }

    override fun onBackPressed() {
        val alert = ExitDialog()
        alert.isCancelable = false
        alert.show(supportFragmentManager, "ExitDialog")

    }
}