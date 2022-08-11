package com.example.tour

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tour.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), MainAdapter.ListListener {

    private lateinit var v: ActivityMainBinding
    private lateinit var mainAdapter: MainAdapter

    private val genresList = arrayListOf("最新促銷", "熱門城市", "test")
    private val contextList = arrayListOf("七里香", "風景", "衣服", "吉他", "湖面", "眼鏡")
    private val cityList = arrayListOf("台中", "台南", "高雄", "台北市", "桃園", "澎湖")

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

        val mainList = arrayListOf<Tour>()

        for(i in 0..genresList.lastIndex) {

            val nestArray: MutableList<Card> = ArrayList()
            val randomSlogan = contextList.shuffled()
            val randomCity = cityList.shuffled()

            when(i) {
                0 -> {
                    for (j in 0..5) {
                        nestArray.add(Card(contextList.indexOf(randomSlogan[j]), randomSlogan[j]))
                    }
                }
                1 -> {
                    for (j in 0..5) {
                        nestArray.add(Card(cityList.indexOf(randomCity[j]), randomCity[j]))
                    }
                }
                else -> {
                    for (j in 0..5) {
                        nestArray.add(Card(cityList.indexOf(randomCity[j]), randomCity[j]))
                    }
                }
            }

            mainList.add(Tour(genresList[i], nestArray))
            Log.d("tour", mainList.toString())
        }

        return mainList
    }
}