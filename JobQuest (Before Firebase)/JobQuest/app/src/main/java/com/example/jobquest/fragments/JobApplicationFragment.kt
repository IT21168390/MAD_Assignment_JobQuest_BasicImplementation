package com.example.jobquest.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.jobquest.R

class JobApplicationFragment : Fragment(R.layout.fragment_job_application) {
    private lateinit var paymentTypeSpinner: Spinner
    private lateinit var salaryLayout: LinearLayout
    private lateinit var workBasedWageLayout: LinearLayout
    private lateinit var salaryEditText: EditText
    private lateinit var chargingRateEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_job_application, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        paymentTypeSpinner = view.findViewById(R.id.payment_type_spinner)
        salaryLayout = view.findViewById(R.id.salary_layout)
        workBasedWageLayout = view.findViewById(R.id.work_based_wage_layout)
        salaryEditText = view.findViewById(R.id.edit_text_salary)
        chargingRateEditText = view.findViewById(R.id.edit_text_charging_rate)

        // Populate the payment type spinner with the payment types defined in strings.xml
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.payment_types,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            paymentTypeSpinner.adapter = adapter
        }

        // Set an on item selected listener for the payment type spinner
        paymentTypeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                // Show or hide the salary layout and the work based wage layout based on the selected payment type
                val selectedPaymentType = parent?.getItemAtPosition(position).toString()
                if (selectedPaymentType == getString(R.string.salary)) {
                    salaryLayout.visibility = View.VISIBLE
                    workBasedWageLayout.visibility = View.GONE
                } else if (selectedPaymentType == getString(R.string.work_based_wage)) {
                    salaryLayout.visibility = View.GONE
                    workBasedWageLayout.visibility = View.VISIBLE
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        // Set a click listener for the submit button
        view.findViewById<View>(R.id.submit_button).setOnClickListener {
            // Get the values entered by the user
            val name = view.findViewById<EditText>(R.id.edit_text_name).text.toString()
            val age = view.findViewById<EditText>(R.id.edit_text_age).text.toString()
            val city = view.findViewById<EditText>(R.id.edit_text_city).text.toString()

            val paymentType = paymentTypeSpinner.selectedItem.toString()
            val expectedSalary = salaryEditText.text.toString()
            val chargingRate = chargingRateEditText.text.toString()

            // Only works for Activities...
           /* val intent = Intent(requireContext(), SentApplicationsFragment::class.java)
            startActivity(intent)*/

            val nextFragment = SentApplicationsFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.mainContainer, nextFragment)
            transaction.addToBackStack(null)
            transaction.commit()


            // TODO: Validate the input values

            // TODO: Submit the job application
        }
    }

}