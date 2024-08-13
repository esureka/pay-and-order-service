package payorder.orderservice.internal.user

interface UserApi {
    suspend fun queryById(id: Long): User
}