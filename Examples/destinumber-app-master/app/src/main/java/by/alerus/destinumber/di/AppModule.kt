package by.alerus.destinumber.di

import by.alerus.destinumber.data.network.TokenStorage
import by.alerus.destinumber.presentation.features.guess_card_screen.GuessViewModel
import by.alerus.destinumber.presentation.features.login_screen.LoginViewModel
import by.alerus.destinumber.presentation.features.profile_screen.ProfileViewModel
import by.alerus.destinumber.presentation.features.registration_screen.RegistrationViewModel
import by.alerus.destinumber.data.repository.ApiRepository
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import by.alerus.destinumber.presentation.features.history_screen.HistoryViewModel
import by.alerus.destinumber.data.api.PredictionsApi

val appModule = module {
    viewModel { LoginViewModel(get(), get()) }
    viewModel { GuessViewModel(get()) }
    viewModel { HistoryViewModel(get<PredictionsApi>()) }
    viewModel { ProfileViewModel() }
    viewModel { RegistrationViewModel() }
    single { TokenStorage(androidContext()) }
    single { ApiRepository(get(), get(), get(), get(), get()) }
}