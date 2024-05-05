package com.learning.common.extensions

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * @param block will return the availability of internet, when the internet is available it will
 * automatically call it self.
 */
fun LifecycleOwner.observeUiState(block: suspend CoroutineScope.() -> Unit) {
    lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            block.invoke(this)
        }
    }
}

fun ViewModel.launchViewModelScope(block: suspend CoroutineScope.() -> Unit) {
    viewModelScope.launch { block() }
}
