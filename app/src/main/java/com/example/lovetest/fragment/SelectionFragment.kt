package com.example.lovetest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.lovetest.R
import com.example.lovetest.databinding.FragmentSelectionBinding


/**
 * A simple [Fragment] subclass.
 * Use the [SelectionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SelectionFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController
    private lateinit var binding: FragmentSelectionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSelectionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        binding.option1.setOnClickListener { navigateWithIndex(1) }
        binding.option2.setOnClickListener { navigateWithIndex(2) }
        binding.option3.setOnClickListener { navigateWithIndex(3) }
        binding.option4.setOnClickListener { navigateWithIndex(4) }
        binding.btnBack.setOnClickListener {
            navController.popBackStack()
        }

//        binding.option1.setOnClickListener { this }
//        binding.option2.setOnClickListener { this }
//        binding.option3.setOnClickListener { this }
//        binding.option4.setOnClickListener { this }
//        binding.btnBack.setOnClickListener { this }

    }

    override fun onClick(v: View?) {
        when(v){
            binding.option1 -> { navigateWithIndex(1) }
            binding.option2 -> { navigateWithIndex(2) }
            binding.option3 -> { navigateWithIndex(3) }
            binding.option4 -> { navigateWithIndex(4) }
            binding.btnBack -> {
                navController.popBackStack()
            }
        }
    }

    fun navigateWithIndex(index: Int) {
        val bundle = bundleOf("index" to index)
        navController.navigate(R.id.action_selectionFragment_to_resultFragment, bundle)
    }
}