package data.local

import domain.model.RequestState
import domain.model.ClassAbsence
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class TrainingAbsenceDaoImpl(private val realm: Realm) : TrainingAbsenceDao {

    override suspend fun insertOne(data: ClassAbsence) {
        realm.write { copyToRealm(data) }
    }

    override fun findAll(): Flow<RequestState<List<ClassAbsence>>> {
        return realm.query<ClassAbsence>().asFlow()
            .map { result -> RequestState.Success(data = result.list) }
            ?: flow { RequestState.Error(message = "Realm not configure") }
    }

    override suspend fun deleteAll() {
        realm.write {
            val currencyCollection = this.query<ClassAbsence>()
            delete(currencyCollection)
        }
    }
}