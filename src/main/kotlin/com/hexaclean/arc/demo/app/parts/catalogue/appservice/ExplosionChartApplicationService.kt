package com.hexaclean.arc.demo.app.parts.catalogue.appservice

import com.hexaclean.arc.demo.app.parts.catalogue.domain.model.ExplosionChart
import com.hexaclean.arc.demo.app.parts.catalogue.domain.model.PartsCategoryCode
import com.hexaclean.arc.demo.app.parts.catalogue.domain.service.ExplosionChartDomainService
import com.hexaclean.arc.demo.app.parts.catalogue.usecase.`in`.ExplosionChartQuery
import com.hexaclean.arc.demo.app.parts.catalogue.usecase.out.FetchExplosionChart
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin
import com.hexaclean.arc.demo.app.vehicle.usecase.`in`.VehicleQuery
import org.springframework.stereotype.Component

@Component
class ExplosionChartApplicationService(
    val fetchExplosionChart: FetchExplosionChart,
    val vehicleQuery: VehicleQuery,
    val vehicleToOriginVehicleMapper: VehicleToOriginVehicleMapper,
    val explosionChartDomainService: ExplosionChartDomainService
) : ExplosionChartQuery {

    override fun read(partsCategoryCode: PartsCategoryCode, vin: String): ExplosionChart {

        //Add ypur code to implement the application service pattern here
        val vehicle = vehicleToOriginVehicleMapper.mapOriginVehicleToVehicle(vehicleQuery.findByVin(Vin(vin)))

        val explosionChart =
            vehicle.let { fetchExplosionChart.fetch(partsCategoryCode, it.vehicleModel, it.has2GSupport) };

        //some domain logic located in the domain service respectively in the root entity
        explosionChartDomainService.doSomeIdependentBusinessLogic(explosionChart)
        explosionChart!!.doSomeIdependentBusinessLogic()
        return explosionChart
    }
}