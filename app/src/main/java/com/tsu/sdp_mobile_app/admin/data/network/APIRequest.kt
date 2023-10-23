package com.tsu.sdp_mobile_app.admin.data.network


import com.tsu.sdp_mobile_app.admin.data.response.FacultyResponse
import retrofit2.http.*

interface APIRequest {

    @GET("Faculty/GetFaculties")
    suspend fun getFaculties(
    ) : FacultyResponse

    @GET("Discipline/GetDisciplines")
    suspend fun getDisciplines(
    ) : FacultyResponse

    @GET("Direction/GetDirections")
    suspend fun getDirections(
    ) : FacultyResponse

    @GET("Group/GetGroups")
    suspend fun getGroups(
    ) : FacultyResponse

//    @POST("account/login")
//    suspend fun login(
//        @Body user: LoginRequest
//    ) : LoginResponse
//
//    @POST("account/register")
//    suspend fun register(
//        @Body user: RegisterRequest
//    ) : LoginResponse
//
//    @POST("account/logout")
//    suspend fun logout(
//    ) : MessageTokenResponse
//
//    @GET("account/profile")
//    suspend fun getUser(
//        @Header ("Authorization") token : String
//    ) : UserResponse
//
//    @PUT("account/profile")
//    suspend fun updateUser(
//        @Header ("Authorization") token : String,
//        @Body user : UserUpdateRequest
//    ) : UserUpdateResponse
//
//    @GET("favorites")
//    suspend fun getFavorite(
//        @Header ("Authorization") token : String
//    ) : MovieResponse
//
//    @POST("favorites/{id}/add")
//    suspend fun addFavorite(
//        @Header ("Authorization") token : String,
//        @Path ("id") id : String
//    ) : MessageTokenResponse
//
//    @DELETE("favorites/{id}/delete")
//    suspend fun removeFavorite(
//        @Header ("Authorization") token : String,
//        @Path ("id") id : String
//    ) : MessageTokenResponse
//
//    @GET("movies/{page}")
//    suspend fun getGallery(
//        @Path ("page") page : Int
//    ) : MovieResponse
//
//    @GET("movies/details/{id}")
//    suspend fun getMovieDetails(
//        @Path ("id") id : String
//    ) : MovieDetailsResponse
//
//    @POST("movie/{movieId}/review/add")
//    suspend fun addReview(
//        @Header ("Authorization") token : String,
//        @Path("movieId") movieId: String,
//        @Body review: ReviewRequest
//    ) : MessageTokenResponse
//
//    @PUT("movie/{movieId}/review/{id}/edit")
//    suspend fun updateReview(
//        @Header ("Authorization") token : String,
//        @Path ("movieId") movieId : String,
//        @Path ("id") id : String,
//        @Body review: ReviewRequest
//    ) : MessageTokenResponse
//
//    @DELETE("movie/{movieId}/review/{id}/delete")
//    suspend fun deleteReview(
//        @Header ("Authorization") token : String,
//        @Path ("movieId") movieId : String,
//        @Path ("id") id : String
//    ) : MessageTokenResponse
}