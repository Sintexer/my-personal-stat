package com.ilyabuhlakou.mps.service.mapper

import com.ilyabuhlakou.mps.data.entity.PersonalStatEntity
import com.ilyabuhlakou.mps.service.model.PersonalStat

interface PersonalStatMapper {

    fun mapToPersonalStatEntity(statEntry: PersonalStat): PersonalStatEntity
    fun mapToPersonalStat(statEntryEntity: PersonalStatEntity): PersonalStat

}