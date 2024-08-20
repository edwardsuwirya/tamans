package data.local

import domain.model.RequestState
import kotlinx.coroutines.flow.Flow

interface IDao<ENTITY> {
    suspend fun insertOne(data: ENTITY)
    fun findAll(): Flow<RequestState<List<ENTITY>>>
    suspend fun deleteAll()
}