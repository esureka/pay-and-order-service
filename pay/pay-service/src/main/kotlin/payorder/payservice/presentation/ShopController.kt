package payorder.payservice.presentation

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import payorder.payservice.application.shop.ShopService
import payorder.payservice.presentation.dto.CreateShopRequest
import payorder.payservice.presentation.dto.ShopResponse

@RestController
@RequestMapping("/shop")
class ShopController(
    private val shopService: ShopService
) {

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    suspend fun createShop(@RequestBody request: CreateShopRequest) {
        shopService.createShop(request)
    }

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    suspend fun queryById(@PathVariable id: String): ShopResponse {
        return shopService.queryById(id)
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    suspend fun queryAll(): List<ShopResponse> {
        return shopService.queryAllShop()
    }

}