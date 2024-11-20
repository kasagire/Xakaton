import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("events")
    fun getEvents(): Call<List<Event>>

    @POST("events")
    fun addEvent(@Body event: Event): Call<Event>
}