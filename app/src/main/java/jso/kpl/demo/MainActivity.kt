package jso.kpl.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import jso.kpl.demo.adapter.RouteAdapter
import jso.kpl.demo.databinding.ActivityMainBinding
import jso.kpl.demo.myview.CustomNode
import jso.kpl.demo.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.baseline.view.*
import kotlinx.android.synthetic.main.custom_node.view.*

class MainActivity : AppCompatActivity()
{
    var mainBinding : ActivityMainBinding? = null
    var mainViewMdoel: MainViewModel? = null
    val adapter = RouteAdapter()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Oncreate")
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainViewMdoel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        mainBinding?.mainvm = mainViewMdoel

        var LinearParams1 : LinearLayout.LayoutParams = LinearLayout.LayoutParams(0, 300)
        LinearParams1.weight = 1f

        var Linear1 : (LinearLayout) = LayoutInflater.from(this).inflate(R.layout.skeleton,null, false) as LinearLayout
        var cnode : View = LayoutInflater.from(this).inflate(R.layout.custom_node, null, false) as View
        var cnode2 : View = LayoutInflater.from(this).inflate(R.layout.custom_node, null, false) as View
        var cnode3 : View = LayoutInflater.from(this).inflate(R.layout.custom_node, null, false) as View

        var Linear2 : (LinearLayout) = LayoutInflater.from(this).inflate(R.layout.skeleton,null, false) as LinearLayout
        var cnode4 : View = LayoutInflater.from(this).inflate(R.layout.custom_node, null, false) as View
        var cnode5 : View = LayoutInflater.from(this).inflate(R.layout.custom_node, null, false) as View
        var cnode6 : View = LayoutInflater.from(this).inflate(R.layout.custom_node, null, false) as View

        var Linear3 : (LinearLayout) = LayoutInflater.from(this).inflate(R.layout.skeleton,null, false) as LinearLayout
        var cnode7 : View = LayoutInflater.from(this).inflate(R.layout.custom_node, null, false) as View
        var cnode8 : View = LayoutInflater.from(this).inflate(R.layout.custom_node, null, false) as View
        var cnode9 : View = LayoutInflater.from(this).inflate(R.layout.custom_node, null, false) as View


//        var LinearParams2 : LinearLayout.LayoutParams = LinearLayout.LayoutParams(0, 300)
//        LinearParams2.weight = 1f
//        LinearParams2.layoutDirection = LinearLayout.LAYOUT_DIRECTION_RTL
        Linear2.layoutDirection =  LinearLayout.LAYOUT_DIRECTION_RTL
        Linear2.weightSum = 3f

        cnode.layoutParams = LinearParams1
        cnode.locationText.text = "Sweden"
        cnode.costtv.text="230만원"
//        cnode.headLine.visibility = View.INVISIBLE
//        cnode.tailLine.visibility = View.INVISIBLE


        cnode2.layoutParams = LinearParams1
        cnode2.locationText.text = "Korea"
        cnode2.costtv.text="300만원"
//        cnode2.tailLine.visibility = View.INVISIBLE

        cnode3.layoutParams = LinearParams1
        cnode3.locationText.text = "Turkey"
        cnode3.costtv.text="150만원"
        cnode3.tailLine.lineType = 0
//        cnode3.tailLine.visibility = View.INVISIBLE

        Linear1.addView(cnode)
//        Linear1.addView(cnode2)
//        Linear1.addView(cnode3)

        cnode4.layoutParams = LinearParams1
        cnode4.locationText.text = "France"
        cnode4.costtv.text="200만원"
        cnode4.tailLine.lineType = 1
//        cnode4.headLine.visibility = View.INVISIBLE

        cnode5.layoutParams = LinearParams1
        cnode5.locationText.text = "Brazil"
        cnode5.costtv.text="180만원"
//        cnode5.headLine.visibility = View.INVISIBLE

        cnode6.layoutParams = LinearParams1
        cnode6.locationText.text = "Swiss"
        cnode6.costtv.text="280만원"
        cnode6.headLine.lineType = 3
//        cnode6.headLine.visibility = View.INVISIBLE

        Linear2.addView(cnode4)
        Linear2.addView(cnode5)
        Linear2.addView(cnode6)


        cnode7.layoutParams = LinearParams1
        cnode7.locationText.text = "Germany"
        cnode7.costtv.text="340만원"
        cnode7.headLine.lineType = 2
//        cnode7.headLine.visibility = View.INVISIBLE
        cnode7.tailLine.visibility = View.INVISIBLE

        Linear3.weightSum = 3f
        Linear3.addView(cnode7)

        rootLinearLay.addView(Linear1)
//        rootLinearLay.addView(Linear2)
//        rootLinearLay.addView(Linear3)


        initObservables()
    }

    companion  object {
        val TAG = "Demo.MainActivity"
    }
    private fun initObservables() {
        Log.d(TAG, "initObservables")

//        mainViewMdoel?.Routelist?.observe(this, Observer {
//            Log.d(TAG, "observe on mainViewMdoel?.Routelist?")
//            if(it.size > 0)
//            {
//                adapter.addItems(it)
//            }
//            else
//            {
//                Log.d(TAG, "it.size == 0" + it.size)
//            }
//        })
    }
}
