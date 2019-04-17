package com.vmarienkov.beers.data.network

data class Response(
    val abv: Double?,
    val attenuation_level: Double?,
    val boil_volume: BoilVolume?,
    val brewers_tips: String?,
    val contributed_by: String?,
    val description: String,
    val ebc: Int?,
    val first_brewed: String?,
    val food_pairing: List<String?>?,
    val ibu: Int?,
    val id: Int,
    val image_url: String?,
    val ingredients: Ingredients?,
    val method: Method?,
    val name: String?,
    val ph: Double?,
    val srm: Double?,
    val tagline: String?,
    val target_fg: Int?,
    val target_og: Int?,
    val volume: Volume?
)

data class Method(
    val fermentation: Fermentation?,
    val mash_temp: List<MashTemp?>?,
    val twist: Any?
)

data class Fermentation(
    val temp: Temp?
)

data class Temp(
    val unit: String?,
    val value: Int?
)

data class MashTemp(
    val duration: Int?,
    val temp: Temp?
)

data class Volume(
    val unit: String?,
    val value: Int?
)

data class BoilVolume(
    val unit: String?,
    val value: Int?
)

data class Ingredients(
    val hops: List<Hop?>?,
    val malt: List<Malt?>?,
    val yeast: String?
)

data class Malt(
    val amount: Amount?,
    val name: String?
)

data class Amount(
    val unit: String?,
    val value: Double?
)

data class Hop(
    val add: String?,
    val amount: AmountX?,
    val attribute: String?,
    val name: String?
)

data class AmountX(
    val unit: String?,
    val value: Int?
)