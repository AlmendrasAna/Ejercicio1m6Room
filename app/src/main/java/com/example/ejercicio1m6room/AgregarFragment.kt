package com.example.ejercicio1m6room

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ejercicio1m6room.databinding.FragmentAgregarBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class AgregarFragment : Fragment() {

    lateinit var binding: FragmentAgregarBinding
    lateinit var repositorioTarea: RepositorioTarea
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAgregarBinding.inflate(layoutInflater, container, false)
        initRepositorio()
        initListener()
        LoadTarea()
        return binding.root
    }

    private fun initRepositorio() {
        repositorioTarea = RepositorioTarea(BaseDatosTarea.getDatabase(requireContext()).getDaoTarea())
    }

    private fun initListener() {
        binding.agregarB.setOnClickListener {
            val txt = binding.agregarEditTxt.text.toString()
            saveTarea(txt)
        }
    }

    private fun saveTarea(txt: String) {

        val tarea = TareaC(txt)
        GlobalScope.launch { repositorioTarea.insertarTarea(tarea) }
    }

    private fun LoadTarea() {


        val tareas = repositorioTarea.listarTarea().observe(requireActivity()) {
            val tareaText = it.joinToString("\n") { it.nombreTarea }
            binding.titleTxt.text = tareaText
        }

    }

}
