package di

import data.local.IDao
import data.local.TrainingAbsenceDao
import data.local.TrainingAbsenceDaoImpl
import data.repo.TrainingAbsenceRepoImpl
import domain.model.ClassAbsence
import domain.model.ClassAbsenceDetail
import domain.model.Trainee
import domain.model.TrainingClass
import domain.repository.TrainingAbsenceRepository
import domain.usecase.GetTrainingAbsenceList
import domain.usecase.TrainingAbsenceUseCases
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import org.koin.core.context.startKoin
import org.koin.dsl.module


val daoModule = module {
    single<Realm> {
        val config = RealmConfiguration
            .Builder(
                schema = setOf(
                    ClassAbsence::class,
                    Trainee::class,
                    TrainingClass::class,
                    ClassAbsenceDetail::class
                )
            ).name("TAMANS")
            .compactOnLaunch()
            .build()
        Realm.open(config)
    }
}
val useCaseModule = module {
    single<TrainingAbsenceDao> { TrainingAbsenceDaoImpl(get()) }
    single<TrainingAbsenceRepository> { TrainingAbsenceRepoImpl(get()) }
    single<TrainingAbsenceUseCases> {
        TrainingAbsenceUseCases(
            getTrainingAbsenceList = GetTrainingAbsenceList(get())
        )
    }
}


fun initializeMain() {
    startKoin {
        modules(daoModule + useCaseModule)
    }
}