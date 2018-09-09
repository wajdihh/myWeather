package com.wajdihh.weatherapp.ui.list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.wajdihh.weatherapp.R
import com.wajdihh.weatherapp.data.entities.Forecast
import com.wajdihh.weatherapp.mvp.list.ListPresenter
import com.wajdihh.weatherapp.mvp.list.ListPresenterImpl
import com.wajdihh.weatherapp.mvp.list.ListView

class ListActivity : AppCompatActivity(), ListView {


    private var presenter : ListPresenter ?=null

    private var progressBar : ProgressBar?=null
    private var tvCount : TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        progressBar = findViewById(R.id.myProgress)
        tvCount = findViewById(R.id.myCount)

        presenter = ListPresenterImpl(this)
        // cette methode va implementer les methodes de notre vu MVP
        presenter!!.attachView(this)



        presenter!!.loadForecasts("paris","metric",5,"8194ea842a9aef80a798c8ac0c320ec4")
    }



    override fun showProgress() {
        progressBar?.visibility= View.VISIBLE
    }

    override fun hideProgress() {
        progressBar?.visibility= View.GONE
    }

    override fun onSuccessLoadForecast(list: List<Forecast>) {
        tvCount?.setText("La taille est :"+list.size)

        for (f in list){
            println("Result :"+f.speed)
        }

    }

    override fun onErrorLoadForecast(throwable: Throwable) {
        Toast.makeText(this,"Errorrrr ",Toast.LENGTH_SHORT).show()
    }
}
