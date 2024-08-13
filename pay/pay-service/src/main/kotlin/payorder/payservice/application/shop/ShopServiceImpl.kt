package payorder.payservice.application.shop

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import payorder.payservice.application.ShopPort
import payorder.payservice.common.error.PayBasicException
import payorder.payservice.internal.user.UserApi
import payorder.payservice.presentation.dto.CreateShopRequest
import payorder.payservice.presentation.dto.OwnerInfo
import payorder.payservice.presentation.dto.ShopResponse

@Service
class ShopServiceImpl(
    private val shopPort: ShopPort,
    private val userApi: UserApi
) : ShopService {

    @Transactional
    override suspend fun createShop(request: CreateShopRequest) {

        if(shopPort.existsByName(request.name)) {
            throw PayBasicException("Already Exists Shop Name..", HttpStatus.ALREADY_REPORTED)
        }

        val user = userApi.queryById(request.ownerId) // current user 임시

        shopPort.save(
            ShopCommand.CreateShop(request).toEntity(user.id)
        )
    }

    @Transactional(readOnly = true)
    override suspend fun queryAllShop(): List<ShopResponse> =
       shopPort.findAll().map {
           val owner = userApi.queryById(it.ownerId)
           ShopResponse(
               id = it.id!!,
               name = it.name,
               owner = OwnerInfo(
                   id = owner.id,
                   name = owner.name
               ),
               starRate = it.starRate
           )
       }

    @Transactional(readOnly = true)
    override suspend fun queryById(id: String): ShopResponse {

        val shop = shopPort.findById(id)
            ?: throw PayBasicException("Not Found Shop..", HttpStatus.NOT_FOUND)

        val owner = userApi.queryById(shop.ownerId)

        return ShopResponse(
            id = shop.id!!,
            name = shop.name,
            owner = OwnerInfo(
                id = owner.id,
                name = owner.name
            ),
            starRate = shop.starRate
        )
    }

}
