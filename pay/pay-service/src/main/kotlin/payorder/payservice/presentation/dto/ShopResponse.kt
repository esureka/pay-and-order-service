package payorder.payservice.presentation.dto

data class ShopResponse(
    val id: String,
    val name: String,
    val owner: OwnerInfo,
    val starRate: Double
)

data class OwnerInfo(
    val id: Long,
    val name: String
)