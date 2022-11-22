package com.healthteam17.recordhealth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.healthteam17.recordhealth.databinding.FragmentLoginBinding

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val mBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.buttonNLogIn.setOnClickListener {
            this.findNavController()
                .navigate(R.id.action_loginFragment_to_dashboardFragment)
        }
        mBinding.buttonGLogIn.setOnClickListener {
            this.findNavController()
                .navigate(R.id.action_loginFragment_to_dashboardFragment)
        }
    }

    companion object {}
}