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
import com.example.jobquest.activities.Application
import com.example.jobquest.adapters.ReceivedApplicationsAdapter

class ReceivedJobApplicationsFragment : Fragment(R.layout.fragment_received_job_applications_rv) {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ReceivedApplicationsAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_received_job_applications_rv, container, false)
        recyclerView = view.findViewById(R.id.applications_recyclerview)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val applications = listOf(
            Application("John", "Gardener Vacancy", "Salary", 15000, 20, "City: "+"Colombo", Application.STATUS_IN_REVIEW),
            Application("Alice", "Painting Job", "Work Based Wage", 12000, 22, "City: "+"Malambe", Application.STATUS_ACCEPTED),
            Application("Bob", "Cleaning Vacancy", "Salary", 15000, 25, "City: "+"Kandy", Application.STATUS_IN_REVIEW),
            Application("Shan", "Driver Job", "Salary", 25000, 19, "City: "+"Galle", Application.STATUS_IN_REVIEW)
        )
        adapter = ReceivedApplicationsAdapter(applications)
        layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                requireActivity().onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}