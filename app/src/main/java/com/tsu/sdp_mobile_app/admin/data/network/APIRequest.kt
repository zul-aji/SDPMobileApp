package com.tsu.sdp_mobile_app.admin.data.network

import com.tsu.sdp_mobile_app.admin.data.response.Direction
import com.tsu.sdp_mobile_app.admin.data.response.DirectionRequest
import com.tsu.sdp_mobile_app.admin.data.response.DirectionResponse
import com.tsu.sdp_mobile_app.admin.data.response.DirectionsResponse
import com.tsu.sdp_mobile_app.admin.data.response.Discipline
import com.tsu.sdp_mobile_app.admin.data.response.DisciplineResponse
import com.tsu.sdp_mobile_app.admin.data.response.DisciplinesResponse
import com.tsu.sdp_mobile_app.admin.data.response.FacultiesResponse
import com.tsu.sdp_mobile_app.admin.data.response.FacultyResponse
import com.tsu.sdp_mobile_app.admin.data.response.Group
import com.tsu.sdp_mobile_app.admin.data.response.GroupRequest
import com.tsu.sdp_mobile_app.admin.data.response.GroupResponse
import com.tsu.sdp_mobile_app.admin.data.response.GroupsResponse
import retrofit2.http.*

interface APIRequest {

    @GET("Faculty/GetFaculties")
    suspend fun getFaculties(
    ) : FacultiesResponse

    @GET("Discipline/GetDisciplines")
    suspend fun getDisciplines(
    ) : DisciplinesResponse

    @GET("Direction/GetDirections")
    suspend fun getDirections(
    ) : DirectionsResponse

    @GET("Group/GetGroups")
    suspend fun getGroups(
    ) : GroupsResponse

    @GET("Faculty/GetFaculty/{id}")
    suspend fun getFaculty(
        @Path ("id") id : String
    ) : FacultyResponse

    @GET("Discipline/GetDiscipline/{id}")
    suspend fun getDiscipline(
        @Path ("id") id : String
    ) : DisciplineResponse

    @GET("Direction/GetDirection/{id}")
    suspend fun getDirection(
        @Path ("id") id : String
    ) : DirectionResponse

    @GET("Group/GetGroup/{id}")
    suspend fun getGroup(
        @Path ("id") id : String
    ) : GroupResponse

    @GET("Group/GetGroupByName/{name}")
    suspend fun getGroupByName(
        @Path ("name") name : String
    ) : GroupResponse

    @POST("Faculty/CreateFaculty/{name}")
    suspend fun createFaculty(
        @Path ("name") name : String
    ) : FacultyResponse

    @POST("Discipline/CreateDiscipline")
    suspend fun createDiscipline(
        @Body discipline : Discipline
    ) : DisciplineResponse

    @POST("Direction/CreateDirection")
    suspend fun createDirection(
        @Body newDirection : DirectionRequest
    ) : DirectionResponse

    @POST("Group/CreateGroup")
    suspend fun createGroup(
        @Body newGroup: GroupRequest
    ) : GroupResponse

    @PUT("Faculty/UpdateFaculty?id={id}&name={name}")
    suspend fun updateFaculty(
        @Path ("id") id : String,
        @Path ("name") name : String
    ) : FacultyResponse

    @PUT("Discipline/UpdateDiscipline/{id}")
    suspend fun updateDiscipline(
        @Path ("id") id : String,
        @Body discipline: Discipline
    ) : DisciplineResponse

    @PUT("Direction/UpdateDirection/{id}")
    suspend fun updateDirection(
        @Path ("id") id : String,
        @Body direction: Direction
    ) : DirectionResponse

    @PUT("Group/UpdateGroup/{id}")
    suspend fun updateGroup(
        @Path ("id") id : String,
        @Body group: Group
    ) : GroupResponse

    @DELETE("Faculty/DeleteFaculty/{id}")
    suspend fun deleteFaculty(
        @Path ("id") id : String
    ) : FacultyResponse

    @DELETE("Discipline/DeleteDiscipline/{id}")
    suspend fun deleteDiscipline(
        @Path ("id") id : String
    ) : DisciplineResponse

    @DELETE("Direction/DeleteDirection/{id}")
    suspend fun deleteDirection(
        @Path ("id") id : String
    ) : DirectionResponse

    @DELETE("Group/DeleteGroup/{id}")
    suspend fun deleteGroup(
        @Path ("id") id : String
    ) : GroupResponse
}