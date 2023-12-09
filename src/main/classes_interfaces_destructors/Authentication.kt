sealed class AuthenticationResult {
    data class Success(val username: String) : AuthenticationResult()
    object Failure : AuthenticationResult()
    object AccountLockout : AuthenticationResult()
}

class User(private val username: String, private val password: String) {
    private var failedLoginAttempts = 0
    private val maxFailedAttempts = 3  // Example: Lock account after 3 failed attempts

    fun authenticate(inputUsername: String, inputPassword: String): AuthenticationResult {
        if (failedLoginAttempts >= maxFailedAttempts) {
            return AuthenticationResult.AccountLockout  // Return account lockout outcome
        }

        return if (inputUsername == username && inputPassword == password) {
            failedLoginAttempts = 0  // Reset failed attempts on successful login
            AuthenticationResult.Success(username)
        } else {
            failedLoginAttempts++
            if (failedLoginAttempts >= maxFailedAttempts) {
                return AuthenticationResult.AccountLockout  // Return account lockout outcome
            }
            AuthenticationResult.Failure
        }
    }
}