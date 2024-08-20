package domain.model

import io.realm.kotlin.types.EmbeddedRealmObject

open class TrainingClass : EmbeddedRealmObject {
    var classCode: String = ""
    var className: String = ""
}