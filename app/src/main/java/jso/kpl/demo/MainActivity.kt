package jso.kpl.demo

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import jso.kpl.demo.adapter.NodeAdapter
import jso.kpl.demo.adapter.RouteAdapter
import jso.kpl.demo.databinding.ActivityMainBinding
import jso.kpl.demo.myview.CustomNode
import jso.kpl.demo.viewmodel.MainViewModel
import jso.kpl.demo.viewmodel.Route
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


        var abc : NodeAdapter = NodeAdapter(this, rootLinearLay)
        dataList.add(Route("Korea","200만원"))
        dataList.add(Route("Sweden","230만원"))
        dataList.add(Route("Turkey","150만원"))
        dataList.add(Route("Brazil","180만원"))
        dataList.add(Route("France","200만원"))
        dataList.add(Route("Swiss","220만원"))
        dataList.add(Route("Swiass","240만원"))
        dataList.add(Route("France","200만원"))
        dataList.add(Route("Swiss","220만원"))
        dataList.add(Route("Swiass","240만원"))
        dataList.add(Route("France","200만원"))
        dataList.add(Route("Swiss","220만원"))
        dataList.add(Route("Swiass","240만원"))
        dataList.add(Route("France","200만원"))
        dataList.add(Route("Swiss","220만원"))
        dataList.add(Route("Swiass","240만원"))


        initObservables()
    }


    companion  object {
        val TAG = "Demo.MainActivity"
        var dataList : ArrayList<Route> = ArrayList<Route>()
        var dlistidx : Int = 0
//        연결리스트를 이용해서 미로를 구현
//        너비우선 깊이우선을 했는데
    }
    private fun initObservables() {
        Log.d(TAG, "initObservables")
    }
}
