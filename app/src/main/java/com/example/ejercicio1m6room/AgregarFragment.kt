package com.example.ejercicio1m6room

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.ejercicio1m6room.databinding.FragmentAgregarBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class AgregarFragment : Fragment() {

    lateinit var binding: FragmentAgregarBinding
    private val tareaVM : ViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAgregarBinding.inflate(layoutInflater, container, false)
        initListener()
        loadTarea()
        return binding.root
    }



    private fun initListener() {
        binding.agregarB.setOnClickListener {
            val txt = binding.agregarEditTxt.text.toString()
            saveTarea(txt)
        }
    }

    private fun saveTarea(txt: String) {

        val tarea = TareaC(txt)
    tareaVM.insertarTareas(tarea)
    }

    private fun loadTarea() {


        tareaVM.obtenerTarea().observe(viewLifecycleOwner) {
            val tareaText = it.joinToString("\n") { it.nombreTarea }
            binding.titleTxt.text = tareaText
        }

    }

}
