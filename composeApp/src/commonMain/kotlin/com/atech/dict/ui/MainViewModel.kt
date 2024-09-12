package com.atech.dict.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atech.dict.network.ktor.DictionaryService
import com.atech.dict.network.model.DictionaryResponse
import com.atech.dict.utils.DataState
import kotlinx.coroutines.launch


class MainViewModel(
    private val service: DictionaryService
) : ViewModel() {
    private val _definitions =
        mutableStateOf<DataState<List<DictionaryResponse>>>(DataState.Empty)
    val definitions: State<DataState<List<DictionaryResponse>>> get() = _definitions

    fun getDefinition(word: String) = viewModelScope.launch {
        _definitions.value = DataState.Loading
        if (word.isNotEmpty()) {
            try {
                val response = service.getDefinition(word)
                if (response.isEmpty()) {
                    _definitions.value = DataState.Empty
                    return@launch
                }
                _definitions.value = DataState.Success(response)
            } catch (e: Exception) {
                _definitions.value = DataState.Error(e)
            }
        } else {
            _definitions.value = DataState.Empty
        }
    }
}