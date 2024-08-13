package payorder.orderservice.internal.user

interface UserApi {
    fun queryById(id: Long): User
}