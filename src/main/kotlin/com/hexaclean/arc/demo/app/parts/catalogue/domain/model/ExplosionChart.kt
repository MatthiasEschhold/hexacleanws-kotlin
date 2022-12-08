package com.hexaclean.arc.demo.app.parts.catalogue.domain.model

class ExplosionChart(val vehicle: Vehicle, val partsCategory: PartsCategoryCode, val sparePartList: List<SparePart>) {

    fun doSomeIdependentBusinessLogic() {
        //do some indepenendet domain-relate logic
    }
}