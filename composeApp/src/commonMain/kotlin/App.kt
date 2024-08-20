import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import di.initializeMain
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.screen.TrainingAbsence.TrainingAbsenceScreen

@Composable
@Preview
fun App() {
    initializeMain()
//    val useCases: TrainingAbsenceUseCases = getKoin().get()
//    LaunchedEffect(Unit) {
//        val result = useCases.getTrainingAbsenceList()
//        result.collectLatest { absenceList ->
//            val list = absenceList.getSuccessData()
//            list.forEach { absence ->
//                println(absence.trainingClass?.className)
//            }
//        }
//    }
    MaterialTheme {
        Navigator(TrainingAbsenceScreen())
    }
}