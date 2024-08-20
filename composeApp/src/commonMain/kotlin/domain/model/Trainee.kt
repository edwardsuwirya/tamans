package domain.model

import io.realm.kotlin.types.EmbeddedRealmObject

open class Trainee : EmbeddedRealmObject {
    var traineeName: String = ""
    var idRef: String = ""
}