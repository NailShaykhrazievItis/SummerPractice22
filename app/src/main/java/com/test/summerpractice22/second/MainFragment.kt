package com.test.summerpractice22.second

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.test.summerpractice22.R
import com.test.summerpractice22.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)

        with(binding) {
            btnMusic.setOnClickListener {
                val text = (etText.text ?: "Error").toString()
                if (text.isNotEmpty()) {
                    val pref = activity?.getSharedPreferences("TEST", Context.MODE_PRIVATE)
                    pref?.edit {
                        putString("PREF_TEXT", text)
                        commit()
                    }
                }
                findNavController().navigate(
                    R.id.action_mainFragment_to_musicFragment,
                    MusicFragment.createBundle(text),
                )
            }
            btnProfile.setOnClickListener {

            }

        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
