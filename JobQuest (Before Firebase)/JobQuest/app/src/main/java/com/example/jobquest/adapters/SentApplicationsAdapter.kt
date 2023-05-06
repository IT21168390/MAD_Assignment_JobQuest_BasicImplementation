package com.example.jobquest.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jobquest.R
import com.example.jobquest.fragments.SentApplicationsFragment

class SentApplicationsAdapter(private val applications: List<SentApplicationsFragment.ApplicationSent>) :
//class SentApplicationsAdapter(private val applications: List<SentApplicationsActivity.ApplicationSent>) :
    RecyclerView.Adapter<SentApplicationsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.sent_application_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val application = applications[position]
        holder.bind(application)
    }

    override fun getItemCount() = applications.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.sentApplicationItemJobTitle)
        private val budgetTextView: TextView = itemView.findViewById(R.id.sentApplicationItemJobBudget)
        private val posterTextView: TextView = itemView.findViewById(R.id.sentApplicationItemJobPoster)
        private val statusTextView: TextView = itemView.findViewById(R.id.sentApplicationItemStatus)
        private val cancelButton: Button = itemView.findViewById(R.id.sentApplicationItemCancelButton)
fun bind(application: SentApplicationsFragment.ApplicationSent) {
        //fun bind(application: SentApplicationsActivity.ApplicationSent) {
            titleTextView.text = application.title
            budgetTextView.text = application.budget
            posterTextView.text = application.posterName
            statusTextView.text = application.status

            cancelButton.setOnClickListener {
                // TODO: Handle cancel button click
            }
        }
    }

}