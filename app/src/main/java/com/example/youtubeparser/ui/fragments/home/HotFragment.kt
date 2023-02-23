package com.example.youtubeparser.ui.fragments.home

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.youtubeparser.base.BaseFragment
import com.example.youtubeparser.ui.adapters.HotAdapter
import com.excample.youtubeparser.R
import com.excample.youtubeparser.databinding.FragmentHotBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HotFragment :
    BaseFragment<FragmentHotBinding, HotFragmentViewModel>(R.layout.fragment_hot) {

    override val viewModel: HotFragmentViewModel by viewModels()
    override val binding by viewBinding(FragmentHotBinding::bind)
    private val videoAdapter = HotAdapter()

  override fun setupSubscribes() {
        subscribeToVideoHot()
    }

    override fun initialize() = with(binding.recView) {
        adapter = videoAdapter
    }

    private fun subscribeToVideoHot() {
        viewModel.fetchVideosPopular("ru", "mostPopular", "snippet").observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                videoAdapter.submitData(it)
            }
        }
    }
}