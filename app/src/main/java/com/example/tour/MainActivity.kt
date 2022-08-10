package com.example.tour

import android.R
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tour.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), MainAdapter.ListListener {

    private lateinit var v: ActivityMainBinding
    private lateinit var mainAdapter: MainAdapter

    private val genresList = arrayListOf("最新促銷", "熱門城市")
    private val contextList = arrayListOf("七里香", "風景", "衣服", "吉他", "湖面", "眼鏡", "台中", "台南", "高雄", "台北市", "桃園", "澎湖")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        v = ActivityMainBinding.inflate(layoutInflater)
        setContentView(v.root)

        mainAdapter = MainAdapter(this)
        mainAdapter.updateList(initData())
        mainAdapter.setListener(this)

        v.listRV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        v.listRV.adapter = mainAdapter
    }

    override fun onCardClick(url: String) {

//        val openBrowser = Intent.makeMainSelectorActivity(Intent.ACTION_MAIN, Intent.CATEGORY_APP_BROWSER)
//        openBrowser.data = Uri.parse(url)
//        startActivity(openBrowser)

        val intent = Intent(this, WebViewActivity::class.java)
        intent.putExtra("url", url)
        startActivity(intent)
    }

    private fun initData(): ArrayList<Tour>{

        var head = 0
        var tail = 5
        val mainList = arrayListOf<Tour>()

        for(i in 0..genresList.lastIndex) {

            val nestArray: MutableList<Card> = ArrayList()

            for (j in head..tail) {

                nestArray.add(Card(j, contextList[j]))
            }

            head = tail + 1
            tail = contextList.lastIndex

            mainList.add(Tour(genresList[i], nestArray))
        }

        return mainList
    }
}