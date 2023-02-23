package com.example.youtubeparser.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel>(
    @LayoutRes layoutId: Int
) : Fragment(layoutId) {
    abstract val binding: VB
    abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialize()
        setupRequests()
        setupListeners()
        setupSubscribes()
    }

    protected open fun initialize() {
    }

    protected open fun setupRequests() {
    }

    protected open fun setupListeners() {
    }

    protected open fun setupSubscribes() {
    }
}