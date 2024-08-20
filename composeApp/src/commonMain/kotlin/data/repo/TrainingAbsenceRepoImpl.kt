package data.repo

import data.local.TrainingAbsenceDao
import domain.model.RequestState
import domain.model.ClassAbsence
import domain.model.ClassAbsenceDetail
import domain.model.Trainee
import domain.model.TrainingClass
import domain.repository.TrainingAbsenceRepository
import io.realm.kotlin.ext.realmListOf
import kotlinx.coroutines.flow.Flow

class TrainingAbsenceRepoImpl(private val dao: TrainingAbsenceDao) :
    TrainingAbsenceRepository {

    override suspend fun readAbsence(
        classCode: String,
        trainingDate: String
    ): Flow<RequestState<List<ClassAbsence>>> {
        dao.deleteAll()

        val trainingClass01 = TrainingClass()
        trainingClass01.classCode = "001"
        trainingClass01.className = "Instructor LED Java Batch 18"

        val trainee01 = Trainee()
        trainee01.traineeName = "Joko"
        trainee01.idRef = "KTP001"

        val trainee02 = Trainee()
        trainee01.traineeName = "Budi"
        trainee01.idRef = "KTP002"

        val classAbsence01 = ClassAbsence()
        classAbsence01.trainingClass = trainingClass01
        classAbsence01.trainingDate = "2024-08-06"

        val classAbsenceDetail01 = ClassAbsenceDetail()
        classAbsenceDetail01.trainee = trainee01
        classAbsenceDetail01.presentStatus = "A"

        val classAbsenceDetail02 = ClassAbsenceDetail()
        classAbsenceDetail02.trainee = trainee02
        classAbsenceDetail02.presentStatus = "A"

        classAbsence01.traineeList = realmListOf(classAbsenceDetail01, classAbsenceDetail02)
        dao.insertOne(classAbsence01)
        return dao.findAll()
    }
}