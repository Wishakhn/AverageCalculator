package com.testapp.conditionloopapp

import android.icu.lang.UCharacter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    var obtNumbers: ArrayList<SubjectNumbers> = ArrayList()
    var adapterIs : obtainedNumberlistAdapter? =null
    var resadapterIs : displayNumberlistAdapter? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        obtNumbers.clear()
        adapterIs =  obtainedNumberlistAdapter(obtNumbers)
        resadapterIs =  displayNumberlistAdapter(obtNumbers)
        listnumbersCycler.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        listresultsheet.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
    }

    fun addsubjectnumber(view: View) {
        val subjname = textengnum.text.toString().trim()
        val obtnums = engnum.text.toString().trim().toInt()
        val tnums = totlnum.text.toString().trim().toInt()
        var gradeIs = findGradeforEach(obtnums,tnums)
        val model = SubjectNumbers(obtnums, tnums, subjname,gradeIs)
        obtNumbers.add(model)
        adapterIs?.notifyDataSetChanged()
        listnumbersCycler.adapter = adapterIs
        adapterIs?.notifyDataSetChanged()
        textengnum.setText("")
        engnum.setText("")
        totlnum.setText("")


    }

    private fun findGradeforEach(obtnums: Int, tnums: Int): String {
        val res : Int = ((obtnums/tnums))
        Log.i("OBTAINED Percentage",""+res)

        var g =""
        if (res> 90 || res== 100){
            g = "A+"
        }
        else  if (res> 80 || res== 90){
            g = "A"
        }
        else if (res> 70 || res== 80){
                g = "B+"
            }
        else  if (res> 60 || res== 70){
            g = "B"
        }
        else  if (res> 50 || res== 60){
            g = "C+"
        }
        else{
            g ="Shamefull"
        }
        return g
    }

    fun calculate_and_display(view: View) {
        resadapterIs?.notifyDataSetChanged()
        listresultsheet.adapter = resadapterIs
        calcualateResult()

    }

    private fun calcualateResult() {
       val totalnums = totlnumtext.text.toString().trim().toInt()
        var obtmarks = 0
        for (i in 0 until  obtNumbers.size){
            obtmarks = obtmarks+obtNumbers.get(i).getObtNums()
        }
        resobtnum.setText(""+obtmarks)
        restotlnum.setText(""+totalnums)
        Log.i("OBTAINED",""+obtmarks+" t:"+totalnums)

        val totalgrade = findGradeforEach(obtmarks,totalnums)
        grade.setText(totalgrade)
        var prcent = (obtmarks/totalnums) * 100
        percent.setText(""+prcent+"%")

    }
}
