package com.testapp.conditionloopapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class obtainedNumberlistAdapter(private val list: List<SubjectNumbers>) :
    RecyclerView.Adapter<obtainedNumberlistAdapter.obtainedViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): obtainedViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return obtainedViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: obtainedViewHolder, position: Int) {
        val subject_is :  SubjectNumbers = list[position]
        var subjName = subject_is.getSubject()
        var obtNums = subject_is.getObtNums()
        var totalNums = subject_is.getTotalNums()
        var display_text = "Obt marks in "+subjName+"= "+obtNums+"/"+totalNums
        holder.obtsubjectnumbers?.setText(display_text)
    }

    class obtainedViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.subject_items, parent, false)) {

        var obtsubjectnumbers : TextView? = null

        init {
            obtsubjectnumbers = itemView.findViewById(R.id.obtsubjectnumbers)
        }

    }
}
