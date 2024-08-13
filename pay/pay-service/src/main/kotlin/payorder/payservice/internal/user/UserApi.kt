package payorder.payservice.internal.user

interface UserApi {
    suspend fun queryById(id: Long): User
}