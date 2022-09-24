package com.anshul.amphibians

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

enum class AmphibianApiStatus {LOADING, ERROR, DONE}

class AmphibianViewModel : ViewModel() {

    private val _status = MutableLiveData<AmphibianApiStatus>()
    val status: LiveData<AmphibianApiStatus> = _status

    private val _amphibians = MutableLiveData<List<Amphibian>>()
    val amphibians: LiveData<List<Amphibian>> = _amphibians

    private val _amphibian = MutableLiveData<Amphibian>()
    val amphibian: LiveData<Amphibian> = _amphibian

    fun getAmphibianList(){
        viewModelScope.launch{
            _status.value = AmphibianApiStatus.LOADING
            try{
                _amphibians.value = AmphibianApi.retrofitService.getAmphibians()
                _status.value = AmphibianApiStatus.DONE
            }
            catch (e: Exception){
                _status.value = AmphibianApiStatus.ERROR
                _amphibians.value = listOf()
            }
        }
    }

    fun onAmphibianClicked(amphibian: Amphibian) {
        _amphibian.value = amphibian
    }
}
