package com.neobuchaemyj.sbertest.api.model

class SberUnit (

    private var usNumber: String = "",
    private var placeType: String = "",
    private var placeName: String = "",
    private var streetType: String = "",
    private var streetName: String = "",
    private var houseType: String = "",
    private var houseName: String = "",
    private var buildingType: String = "",
    private var buildingNumber: String = "",
    private var lat: Double = 0.0,
    private var long: Double = 0.0,
    private var installPlace: String = "",
    private var workType: String = "",
    private var usType: String = "",
    private var isCashIn: String = "",
    private var payToCard: String = "",
    private var payToService: String = "",
    private var availability: String = "",
    private var changeModule: String = "",
    private var postIndex: String = "",
    private var subjectType: String = "",
    private var subjectName: String = "",
    private var regionType: String = "",
    private var regionName: String = "",
    private var selfInc: String = "",
    private var lov: String = ""

) {
    fun getUsNumber(): String {
        return usNumber
    }

    fun getPlaceType(): String {
        return placeType
    }

    fun getPlaceName(): String {
        return placeName
    }

    fun getStreetType(): String {
        return streetType
    }

    fun getStreetName(): String {
        return streetName
    }

    fun getHouseType(): String {
        return houseType
    }

    fun getHouseName(): String {
        return houseName
    }

    fun getBuildingType(): String {
        return buildingType
    }

    fun getBuildingNumber(): String {
        return buildingNumber
    }

    fun getLat(): Double {
        return lat
    }

    fun getLong(): Double {
        return long
    }

    fun getInstallPlace(): String {
        return installPlace
    }

    fun getWorkType(): String {
        return workType
    }

    fun getUsType(): String {
        return usType
    }

    fun getIsCashIn(): String {
        return isCashIn
    }

    fun getPayToCard(): String {
        return payToCard
    }

    fun getPayToService(): String {
        return payToService
    }

    fun getAvailability(): String {
        return availability
    }

    fun getChangeModule(): String {
        return changeModule
    }

    fun getPostIndex(): String {
        return postIndex
    }

    fun getSubjectType(): String {
        return subjectType
    }

    fun getSubjectName(): String {
        return subjectName
    }

    fun getRegionType(): String {
        return regionType
    }

    fun getRegionName(): String {
        return regionName
    }

    fun getSelfInc(): String {
        return selfInc
    }

    fun getLov(): String {
        return lov
    }


}