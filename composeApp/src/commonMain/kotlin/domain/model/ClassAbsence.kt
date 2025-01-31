package domain.model

import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.BsonObjectId
import org.mongodb.kbson.ObjectId

open class ClassAbsence : RealmObject {
    companion object

    @PrimaryKey
    var _id: ObjectId = BsonObjectId()

    var trainingClass: TrainingClass? = null
    var trainingDate: String = ""
    var traineeList: RealmList<ClassAbsenceDetail> = realmListOf()
}