package payorder.payservice.presentation.dto

data class CreateShopRequest(
    val name: String,
    val ownerId: Long
)
