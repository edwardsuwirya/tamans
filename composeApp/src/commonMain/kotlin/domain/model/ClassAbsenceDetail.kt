package domain.model

import io.realm.kotlin.types.EmbeddedRealmObject

open class ClassAbsenceDetail : EmbeddedRealmObject {
    var trainee: Trainee? = null
    var presentStatus: String = ""
}