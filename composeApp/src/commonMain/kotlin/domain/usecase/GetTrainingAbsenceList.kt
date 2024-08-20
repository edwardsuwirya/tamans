package domain.usecase

import domain.repository.TrainingAbsenceRepository

class GetTrainingAbsenceList(private val repository: TrainingAbsenceRepository) {
    suspend operator fun invoke() = repository.readAbsence("001", "2024-08-01")
}