package com.hexaclean.arc.demo.app.parts.catalogue.usecase.out

import com.hexaclean.arc.demo.app.parts.catalogue.domain.model.ExplosionChart
import com.hexaclean.arc.demo.app.parts.catalogue.domain.model.PartsCategoryCode
import com.hexaclean.arc.demo.app.parts.catalogue.domain.model.VehicleModel

interface FetchExplosionChart {
    fun fetch(partsCategoryId: PartsCategoryCode, vehicleModel: VehicleModel, has2GSupport: Boolean): ExplosionChart
}