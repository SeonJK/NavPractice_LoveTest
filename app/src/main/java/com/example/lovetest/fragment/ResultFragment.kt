package com.example.lovetest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.lovetest.R
import com.example.lovetest.databinding.FragmentResultBinding


/**
 * A simple [Fragment] subclass.
 * Use the [ResultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResultFragment : Fragment() {

    lateinit var navController: NavController
    private lateinit var binding: FragmentResultBinding
    var option = -1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentResultBinding.inflate(inflater, container, false)
        option = arguments?.getInt("index")?: -1

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        setResult(option)

        binding.btnHome.setOnClickListener {
            navController.navigate(R.id.action_resultFragment_to_mainFragment)
        }
    }

    fun setResult(option: Int) {
        when(option) {
            1 -> {
                binding.resMain.setText(R.string.result)
                binding.resSub.setText(R.string.quitter)
            }
            2 -> {
                binding.resMain.text = "You should focus on yourself"
                binding.resSub.text = "You become really clingy to your ex."
            }
            3 -> {
                binding.resMain.text = "You should take it easy"
                binding.resSub.text = "You can do crazy things no matterwhat it takes."
            }
            4 -> {
                binding.resMain.text = "You are pretty mature."
                binding.resSub.text = "You can easily accetp the break-up."
            }
        }
    }
}