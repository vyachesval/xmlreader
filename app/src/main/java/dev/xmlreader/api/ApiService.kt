package dev.xmlreader.api

import dev.xmlreader.xml.BreakfastMenu
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {
    @GET("xml/simple.xml")
    @Headers("Accept: application/xml", "User-Agent: Retrofit-Sample-App")
    fun getBreakfastMenu(): Call<BreakfastMenu>
}