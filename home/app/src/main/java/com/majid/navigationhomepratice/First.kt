package com.majid.navigationhomepratice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.majid.navigationhomepratice.databinding.FragmentFirstBinding


// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class First : Fragment() {
    lateinit var binding: FragmentFirstBinding

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(layoutInflater)
        binding.btnlogin.setOnClickListener {
            if (binding.etemail.text.isEmpty()) {
                binding.etemail.error = "Enter Your Email"
            } else if (binding.etpassword.text.isEmpty()) {
                binding.etpassword.error = "Enter Your Password"
            } else  {
                val bundle = Bundle()
                bundle.putString("name", binding.etemail.text.toString())
                bundle.putString("password", binding.etpassword.text.toString())

                findNavController().navigate(R.id.second, bundle)
            }
        }
        return binding.root
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            First().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}