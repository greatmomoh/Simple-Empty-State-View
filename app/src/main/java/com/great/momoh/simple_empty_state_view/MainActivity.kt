package com.great.momoh.simple_empty_state_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.great.momoh.simpleemptystateview.SimpleEmptyStateView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        no_tasks_view.setActionBtnClickListener(object :
            SimpleEmptyStateView.ActionButtonClickListener {
                override fun invoke() {
                    Toast.makeText(this@MainActivity, getString(R.string.caption), Toast.LENGTH_LONG).show()
                }
            }
        )

    }
}