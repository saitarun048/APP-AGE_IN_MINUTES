package com.example.agetominutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        button.setOnClickListener {view->
            clickDatePicker(view)
            Toast.makeText(this,"Please, Select Year and Date",Toast.LENGTH_LONG).show()

        }

    }
    fun clickDatePicker(view: View){

        val myCal = Calendar.getInstance()
        val year = myCal.get(Calendar.YEAR)
        val month= myCal.get(Calendar.MONTH)
        val day = myCal.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this,DatePickerDialog.OnDateSetListener
        { view, selectedyear, selectedmonth, selecteddayOfMonth ->
            Toast.makeText(this,"Year selected is: $selectedyear, " +
                    "month selected is: $selectedmonth, " +
                    "and Day selected is: $selecteddayOfMonth",
                Toast.LENGTH_LONG).show()
            val selectedDate = "$selecteddayOfMonth/${selectedmonth+1}/$selectedyear"
            tvSelectedDate.setText(selectedDate)
            val sdf = SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
            val theDate = sdf.parse(selectedDate)
            val selectedDateInMinutes  = theDate!!.time / 60000
            val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
            val currentDateToMinutes = currentDate!!.time / 60000
            val differenceInMinutes = currentDateToMinutes - selectedDateInMinutes
            tvSelectedDateInMinutes.setText(differenceInMinutes.toString())

        }
            ,year,month,day).show()
    }
}
