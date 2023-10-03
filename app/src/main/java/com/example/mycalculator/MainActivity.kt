package com.example.mycalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private var selectedDate1: TextView?=null
    private var selectedminutes: TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1:Button=findViewById(R.id.button3)

        button1.setOnClickListener {
               buttonclicked()

        }
    }

    fun buttonclicked(){
        val mycalender= Calendar.getInstance()
        val year=mycalender.get(Calendar.YEAR)
        val month=mycalender.get(Calendar.MONTH)
        val day=mycalender.get(Calendar.DAY_OF_MONTH)
        var selectedDate1: TextView?=findViewById(R.id.selectedDate)
        var selectedminutes: TextView?=findViewById(R.id.minutes)
        var dpd=DatePickerDialog(this,
            { _, year, month, dayOfMonth ->
                Toast.makeText(this,"Date Picker",Toast.LENGTH_LONG).show()

             val selectedDateNew="$dayOfMonth/${month+1}/$year"
                selectedDate1?.text=selectedDateNew
             val sdf=SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val theDate=sdf.parse(selectedDateNew)
                val selectedateinminutes=theDate.time/60000
                val currentDate=sdf.parse(sdf.format(System.currentTimeMillis()))
                val differnce=(currentDate.time/60000)-selectedateinminutes
                selectedminutes?.text=differnce.toString()
            },year,month,day)
        dpd.datePicker.maxDate=System.currentTimeMillis()-86400000
        dpd.show()


    }
}