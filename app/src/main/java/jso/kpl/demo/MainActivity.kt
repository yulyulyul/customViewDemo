package jso.kpl.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import jso.kpl.demo.adapter.RouteAdapter
import jso.kpl.demo.databinding.ActivityMainBinding
import jso.kpl.demo.viewmodel.MainViewModel

class MainActivity : AppCompatActivity()
{
    var mainBinding : ActivityMainBinding? = null
    var mainViewMdoel: MainViewModel? = null
    val adapter = RouteAdapter()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        /*
         setContentView(R.layout.activity_main)
        var viewList : ArrayList<View> = ArrayList<View>()
        val view1 = LayoutInflater.from(this).inflate(R.layout.baseline,   null, false)
        val view3 = LayoutInflater.from(this).inflate(R.layout.baseline,   null, false)
        val view5 = LayoutInflater.from(this).inflate(R.layout.baseline,   null, false)

        viewList.add(view1)
        viewList.add(view3)
        viewList.add(view5)

        viewList.get(0).leftb.setHeadlineVisiblity(1)
        viewList.get(0).leftb.cost = "100만원"
        viewList.get(0).centerb.cost = "150만원"
        viewList.get(0).rightb.cost = "175만원"

        viewList.get(1).leftb.cost = "50만원"
        viewList.get(1).centerb.cost = "10만원"
        viewList.get(1).rightb.cost = "230만원"

        viewList.get(1).leftb.cost = "85만원"

        viewList.get(2).centerb.visibility = View.INVISIBLE
        viewList.get(2).rightb.visibility = View.INVISIBLE

        viewList.get(1).leftb.headLineType = 3
        viewList.get(1).leftb.locationName = "Paris"
        viewList.get(1).centerb.locationName = "Barcelona"
        viewList.get(1).rightb.locationName = "Roma"
        viewList.get(1).rightb.tailLineType = 1

        viewList.get(2).leftb.headLineType = 2
        viewList.get(2).leftb.locationName = "China"
        viewList.get(2).leftb.setTailLineVisiblity(1)

         */

        Log.d(TAG, "Oncreate")
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainViewMdoel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        mainBinding?.mainvm = mainViewMdoel

        initObservables()

        val gridLmanager : GridLayoutManager = GridLayoutManager(this, 3)
        rootRecycle.layoutManager = gridLmanager
        rootRecycle.adapter = adapter
    }

    companion  object {
        val TAG = "Demo.MainActivity"
    }
    private fun initObservables() {
        Log.d(TAG, "initObservables")

        mainViewMdoel?.Routelist?.observe(this, Observer {
            Log.d(TAG, "observe on mainViewMdoel?.Routelist?")
            if(it.size > 0)
            {
                adapter.addItems(it)
            }
            else
            {
                Log.d(TAG, "it.size == 0" + it.size)
            }
        })
    }
}
