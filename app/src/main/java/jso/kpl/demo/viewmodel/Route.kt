package jso.kpl.demo.viewmodel

import android.util.Log

class Route
{
    var location:String
    var cost:String

    constructor(_location : String, _cost:String)
    {
        Log.d(TAG, "create, location -> " + _location + " cost -> " + _cost)
        this.location = _location
        this.cost = _cost
    }

    companion object
    {
        val TAG:String = "Demo.Route"
    }
}