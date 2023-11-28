package com.example.bromagindia

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class PlayContestActivity : AppCompatActivity() {

    var btn:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_contest)

        btn=findViewById(R.id.btnSubmit)


        btn!!.setOnClickListener {
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.scratch_won_dialog, null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("")

            mBuilder.show()

            mDialogView.findViewById<TextView>(R.id.txt3).setOnClickListener {
                val mDialogView1 = LayoutInflater.from(this).inflate(R.layout.scratch_lose_dialog, null)
                val mBuilder1 = AlertDialog.Builder(this)
                    .setView(mDialogView1)
                    .setTitle("")

                mBuilder1.show()
            }

        }

        }
    }
