package com.android.belarusexchangerate.exchange

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.belarusexchangerate.databinding.ExchangeFragmentBinding

class ExchangeFragment : Fragment() {

    companion object {
        fun newInstance() =
            ExchangeFragment()
    }

    private lateinit var viewModel: ExchangeViewModel
    private var _binding: ExchangeFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ExchangeFragmentBinding.inflate(inflater, container, false)

        binding.btnGetRate.setOnClickListener {
            binding.textField.editText?.text
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ExchangeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}