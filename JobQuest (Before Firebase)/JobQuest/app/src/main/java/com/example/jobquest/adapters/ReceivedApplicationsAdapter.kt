package com.example.jobquest.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jobquest.R
import com.example.jobquest.activities.Application

class ReceivedApplicationsAdapter(private val applications: List<Application>) :
    RecyclerView.Adapter<ReceivedApplicationsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.received_application_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val application = applications[position]
        holder.bind(application)
    }

    override fun getItemCount() = applications.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.name_textview)
        private val paymentTypeTextView: TextView = itemView.findViewById(R.id.payment_type_textview)

        private val estimatedCostForJob:TextView = itemView.findViewById(R.id.expectedRate_textview)
        /*private val statusSpinner: Spinner = itemView.findViewById(R.id.status_spinner)
        private val cancelButton: Button = itemView.findViewById(R.id.cancel_button)
        private val proceedButton: Button = itemView.findViewById(R.id.proceed_button)*/

        private val appliedJobTitle: TextView = itemView.findViewById(R.id.job_tv)
        private val ageTextView: TextView = itemView.findViewById(R.id.age_textview)
        private val cityTextView: TextView = itemView.findViewById(R.id.city_textview)

        fun bind(application: Application) {
            nameTextView.text = application.name
            paymentTypeTextView.text = application.paymentType
            estimatedCostForJob.text = application.estCost.toString()

            appliedJobTitle.text = "Job: "+application.jobName
            ageTextView.text = "Age: "+application.ag.toString()+" Years Old"
            cityTextView.text = application.ct
        }
    }
}
