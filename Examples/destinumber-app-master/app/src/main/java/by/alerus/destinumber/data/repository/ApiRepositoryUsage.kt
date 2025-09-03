package by.alerus.destinumber.data.repository

import by.alerus.destinumber.data.model.PatchedUserProfile
import by.alerus.destinumber.data.model.Prediction
import by.alerus.destinumber.data.model.PredictionTypeEnum
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Example usage of ApiRepository with suspend functions
 */
object ApiRepositoryUsage {

    fun demonstrateAllApiCalls(api: ApiRepository) {
        CoroutineScope(Dispatchers.IO).launch {
            // Login
            api.login("testuser", "password123").onSuccess { token ->
                println("Login successful: ${token.access}")
            }.onFailure { e ->
                println("Login failed: ${e.message}")
            }

            // Register
            api.register("testuser", "test@example.com", "password123").onSuccess { user ->
                println("Registered: ${user.username}")
            }.onFailure { e ->
                println("Registration failed: ${e.message}")
            }

            // Profile
            api.getUserProfile().onSuccess { profile ->
                println("Profile: ${profile.username}")

                // Update (PUT)
                api.updateUserProfile(profile.copy(username = "updated")).onSuccess {
                    println("Profile updated")
                }

                // Partial update (PATCH)
                api.partialUpdateUserProfile(PatchedUserProfile(username = "patched")).onSuccess {
                    println("Profile patched")
                }
            }

            // Refresh token
            api.refreshToken("your-refresh-token").onSuccess { t ->
                println("Refreshed: ${t.access}")
            }

            // Predictions
            api.createPrediction(
                Prediction(text = "I will have a great day today!", predictionType = PredictionTypeEnum.GOOD)
            ).onSuccess { act ->
                println("Prediction: ${act.prediction.text}")
            }

            api.getUserPredictions().onSuccess { list ->
                println("Predictions count: ${list.size}")
            }

            // Health
            api.healthCheck().onSuccess { h ->
                println("Health: $h")
            }

            // Token utilities
            api.setBearerToken("manual-token")
            api.clearBearerToken()
        }
    }
} 