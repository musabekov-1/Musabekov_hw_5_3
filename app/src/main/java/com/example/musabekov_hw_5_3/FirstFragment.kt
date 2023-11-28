package com.example.musabekov_hw_5_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class FirstFragment : Fragment() {
    private var counter = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btn_plus: Button = requireActivity().findViewById(R.id.button_plus)
        val btn_minus: Button = requireActivity().findViewById(R.id.button_minus)
        val btn_second_fragment:Button = requireActivity().findViewById(R.id.btn_second_fragment)
        val text: TextView = requireActivity().findViewById(R.id.tv_result)

        btn_minus.setOnClickListener {
            if (text.text.toString() > 0.toString()) {
                counter--
                text.text = counter.toString()
            }
        }

        btn_plus.setOnClickListener {
            counter++
            text.text = counter.toString()

            if (text.text.equals("10")) {
                btn_minus.visibility = View.VISIBLE
                btn_plus.visibility = View.GONE
            }
        }

        btn_second_fragment.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("result", text.text.toString())
            val secondFragment = SecondFragment()
            secondFragment.arguments = bundle
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.container, SecondFragment()).addToBackStack(null).commit()

        }
    }
}