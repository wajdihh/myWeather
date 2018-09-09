package com.wajdihh.weatherapp.data.remote

import android.content.Context
import com.wajdihh.weatherapp.R
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory



/**
 * Created by wajdihh on 09/09/2018.
 */
class Retrofit2Client {

    companion object {
        private var retrofit: Retrofit? = null

        /**
         * Retrounrer le client retrofit (HTTP)
         * @param context
         * @return
         */
        fun getClient(context: Context): Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .baseUrl(context.getString(R.string.url_base))
                        .build()
            }
            return retrofit
        }
    }
}