package com.test.summerpractice22.second

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.test.summerpractice22.R
import com.test.summerpractice22.databinding.FragmentMusicBinding
import com.test.summerpractice22.second.third.SongAdapter
import com.test.summerpractice22.second.third.SongRepository
import com.test.summerpractice22.second.third.showSnackbar

class MusicFragment : Fragment(R.layout.fragment_music) {

    private var _binding: FragmentMusicBinding? = null
    private val binding get() = _binding!!

    private var adapter: SongAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMusicBinding.bind(view)

//        val text = arguments?.getString(ARG_TEXT).orEmpty()
        initAdapter()
        initPref()
    }

    private fun initAdapter() {
        adapter = SongAdapter(
            SongRepository.songs,
            Glide.with(this)
        ) {
            binding.root.showSnackbar("Song id: ${it.id}")
        }
        binding.tvTitle.setOnClickListener {
            SongRepository.songs.removeAt(0)
            adapter?.updateData(SongRepository.songs)
        }
        binding.rvMusic.adapter = adapter
        binding.rvMusic.layoutManager = GridLayoutManager(requireContext(), 2)

    }

    private fun initPref() {
        val pref = activity?.getSharedPreferences("TEST", Context.MODE_PRIVATE) ?: return
        val value = pref.getString("PREF_TEXT", "error").orEmpty()
        binding.root.showSnackbar(value)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        private const val ARG_TEXT = "amazing"

        fun createBundle(text: String): Bundle {
            val bundle = Bundle()
            bundle.putString(
                ARG_TEXT,
                text
            )
            return bundle
        }
    }
}
