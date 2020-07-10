package com.android.belarusexchangerate.view.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.belarusexchangerate.data.api.ApiHelper
import com.android.belarusexchangerate.data.api.RetrofitBuilder
import com.android.belarusexchangerate.databinding.DetailFragmentBinding
import com.android.belarusexchangerate.utils.Status
import com.android.belarusexchangerate.view.adapter.BankAdapter
import com.android.belarusexchangerate.viewmodel.DetailViewModel
import com.android.belarusexchangerate.viewmodel.DetailViewModelFactory

class DetailFragment : Fragment() {

    private val viewModelFactory =
        DetailViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
    private val viewModel: DetailViewModel by activityViewModels { viewModelFactory }

    private var _binding: DetailFragmentBinding? = null
    private val binding get() = _binding!!
    private val bankAdapter = BankAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DetailFragmentBinding.inflate(inflater, container, false)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = bankAdapter
        }

        binding.btnGetRate.setOnClickListener {
            if (binding.textField.editText?.text.isNullOrEmpty())
                Toast.makeText(context, "Null", Toast.LENGTH_SHORT).show()
            else {
                bankAdapter.clearItems()
                viewModel.fetchData(binding.textField.editText?.text.toString())
            }
        }

        viewModel.loadingState.observe(viewLifecycleOwner, Observer { status ->
            when (status) {
                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                Status.SUCCESS -> {
                    binding.progressBar.visibility = View.INVISIBLE
                }
                else -> {
                    binding.progressBar.visibility = View.INVISIBLE
                    Toast.makeText(context, "hmm", Toast.LENGTH_SHORT).show()
                }
            }
        })

        viewModel.banks.observe(viewLifecycleOwner, Observer {
            it ?: return@Observer
            bankAdapter.addItems(it)
        })

        Log.i("my1", "1 time in viewcrea")
        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val city = binding.textField.editText?.text?.trim().toString()
        viewModel.saveCity(city)
        Log.i("my1", "save ${viewModel.getCity()}")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.textField.editText?.setText(viewModel.getCity())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}