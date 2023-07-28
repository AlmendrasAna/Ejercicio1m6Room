package com.example.ejercicio1m6room

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ejercicio1m6room.databinding.FragmentListarBinding


class ListarFragment : Fragment() {

    lateinit var binding: FragmentListarBinding
    lateinit var repositorioTarea: RepositorioTarea
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
        initRepositorio()
       initAdapter()

        return binding.root
    }
    private fun initRepositorio() {
        repositorioTarea = RepositorioTarea(BaseDatosTarea.getDatabase(requireContext()).getDaoTarea())
    }
    fun initAdapter() {
        val adapter = Adapter()
        var listadoTareaC = repositorioTarea.listarTarea()
           var f=  listadoTareaC.value?.toMutableList()


        if (f != null) {
            Log.e("lol", "initAdapter: ~${listadoTareaC.toString()}", )
            adapter.setData(f)
        }


        binding.recyclerView.adapter = adapter

    }
    }


