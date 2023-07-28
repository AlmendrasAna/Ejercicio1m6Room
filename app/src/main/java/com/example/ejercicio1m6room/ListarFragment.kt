package com.example.ejercicio1m6room

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.ejercicio1m6room.databinding.FragmentListarBinding


class ListarFragment : Fragment() {

    lateinit var binding: FragmentListarBinding
    private val tareaVM : ViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListarBinding.inflate(layoutInflater, container, false)


       initAdapter()

        return binding.root
    }

    fun initAdapter() {

        val adapter = Adapter()
        var listadoTareaC = tareaVM.obtenerTarea().observe(viewLifecycleOwner) {
            adapter.setData(it.toMutableList())
        }
        binding.recyclerView.adapter = adapter

    }
    }


