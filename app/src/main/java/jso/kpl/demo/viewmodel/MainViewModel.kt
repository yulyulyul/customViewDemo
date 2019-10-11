package jso.kpl.demo.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel(application: Application): AndroidViewModel(application)
{
    var Routelist : MutableLiveData<MutableList<Route>>? = null

    init {
        Log.d(TAG, "MainViewModel -> init")
        Routelist = MutableLiveData<MutableList<Route>>()
        Routelist?.value = mutableListOf()
        DataInsert()
    }

    private fun DataInsert()
    {

        Log.d(TAG, "DataInsert")
        var tempList : MutableLiveData<MutableList<Route>> = MutableLiveData<MutableList<Route>>()

        var routeData1: Route = Route("Korea","100만원")
        var routeData2: Route = Route("Spain","150만원")
        var routeData3: Route = Route("Sweden","180만원")
        var routeData4: Route = Route("Paris","85만원")
        var routeData5: Route = Route("Barcelona","10만원")
        var routeData6: Route = Route("Roma","230만원")
        var routeData7: Route = Route("China","300만원")

        Routelist?.value?.add(routeData1)
        Routelist?.value?.add(routeData2)
        Routelist?.value?.add(routeData3)
        Routelist?.value?.add(routeData4)
        Routelist?.value?.add(routeData5)
        Routelist?.value?.add(routeData6)
        Routelist?.value?.add(routeData7)
//        Routelist = tempList
    }

    companion object
    {
        val TAG:String = "Demo.MainViewModel"
    }
}