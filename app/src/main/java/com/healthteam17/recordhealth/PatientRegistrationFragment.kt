package com.healthteam17.recordhealth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.healthteam17.recordhealth.databinding.FragmentPatientRegistrationBinding

/**
 * A simple [Fragment] subclass.
 */
class PatientRegistrationFragment : Fragment() {

    private var _binding: FragmentPatientRegistrationBinding? = null
    private val mBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPatientRegistrationBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.buttonRegPatient.setOnClickListener {
            this.findNavController()
                .navigate(R.id.action_patientRegistrationFragment_to_loginRegistrationFragment)
        }
    }

    companion object {}
}