package domain.repository

import domain.model.RequestState
import domain.model.ClassAbsence
import kotlinx.coroutines.flow.Flow

interface TrainingAbsenceRepository {
    suspend fun readAbsence(
        classCode: String,
        trainingDate: String
    ): Flow<RequestState<List<ClassAbsence>>>

}