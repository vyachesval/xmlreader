package dev.xmlreader

import android.util.Log
import dev.xmlreader.api.ApiService
import dev.xmlreader.xml.BreakfastMenu
import dev.xmlreader.xml.Food
import okhttp3.OkHttpClient
import org.junit.Before
import org.junit.Test
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory


class ApiServiceClientTest {
    private var apiService: ApiService? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        val httpClientBuilder = OkHttpClient.Builder()
        val httpClient = httpClientBuilder.build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .client(httpClient)
            .build()
        apiService = retrofit.create(ApiService::class.java)
    }

    @Test
    @Throws(Exception::class)
    fun testApiCall() {
        val call: Call<BreakfastMenu> = apiService!!.getBreakfastMenu()
        val response: Response<BreakfastMenu> = call.execute()
        //assertThat(response.code().toString()).isEqualTo(200)
        val breakfastMenu: BreakfastMenu = response.body() ?: BreakfastMenu()
        //assertThat(breakfastMenu).isNotNull()
        //assertThat(breakfastMenu.foodList).isNotEmpty()
        breakfastMenu.foodList.let {
            for (i in breakfastMenu.foodList.indices) {
                println( "Food : " + breakfastMenu.foodList[i].name + " "
                            + breakfastMenu.foodList[i].description + " "
                            + breakfastMenu.foodList[i].price
                )
            }
        }
    }

    companion object {
        const val BASE_URL = "https://www.w3schools.com/"
    }
}
