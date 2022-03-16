package com.example.lovetest.fragment

import android.os.Bundle
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.lovetest.R
import com.example.lovetest.databinding.FragmentSelectionBinding


/**
 * A simple [Fragment] subclass.
 * Use the [SelectionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SelectionFragment : Fragment() {

    lateinit var navController: NavController
    lateinit var binding: FragmentSelectionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSelectionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        binding.option1.setOnClickListener { onButtonClicked() }
        binding.option2.setOnClickListener { onButtonClicked() }
        binding.option3.setOnClickListener { onButtonClicked() }
        binding.option4.setOnClickListener { onButtonClicked() }
        binding.btnBack.setOnClickListener { navController.navigate(R.id.action_selectionFragment_pop) }
    }

//    override fun onClick(v: View?) {
//        when(v?.id){
//            R.id.option_1 -> {
//                navController.navigate(R.id.action_selectionFragment_to_resultFragment)
//            }
//            R.id.option_2 -> {
//                navController.navigate(R.id.action_selectionFragment_to_resultFragment)
//            }
//            R.id.option_3 -> {
//                navController.navigate(R.id.action_selectionFragment_to_resultFragment)
//            }
//            R.id.option_4 -> {
//                navController.navigate(R.id.action_selectionFragment_to_resultFragment)
//            }
//        }
//    }

    private fun onButtonClicked() {
        navController.navigate(R.id.action_selectionFragment_to_resultFragment)
    }
}

