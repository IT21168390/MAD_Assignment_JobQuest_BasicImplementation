package com.example.jobquest.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jobquest.R
import com.example.jobquest.adapters.SentApplicationsAdapter

class SentApplicationsFragment : Fragment(R.layout.fragment_sent_job_applications_rv) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SentApplicationsAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_sent_job_applications_rv, container, false)
        recyclerView = view.findViewById(R.id.sentApplicationsRecyclerView)
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val applications = listOf(
            ApplicationSent("Gardener Vacancy", "Salary", "Employer Name", "IN REVIEW"),
            ApplicationSent("Painting Job", "Work Based Wage", "Employer Name","ACCEPTED"),
            ApplicationSent("Cleaning Vacancy", "Salary", "Employer Name","IN REVIEW"),
            ApplicationSent("Driver Job", "Salary", "Employer Name", "IN REVIEW"),
            ApplicationSent("Carpentry", "Work Based Wage", "Employer Name","ACCEPTED")
        )
        adapter = SentApplicationsAdapter(applications)
        layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.sentApplicationsRecyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    class ApplicationSent(val title: String, val budget: String, val posterName:String, val status: String) {
        companion object {
            const val STATUS_IN_REVIEW = 0
            const val STATUS_ACCEPTED = 1
        }
    }

}