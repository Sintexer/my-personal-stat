package com.ilyabuhlakou.mps.service.stat

import com.ilyabuhlakou.mps.service.model.PersonalStat

interface PersonalStatService {

    fun save(personalStat: PersonalStat): PersonalStat
    fun update(personalStat: PersonalStat): PersonalStat
    fun delete(personalStatId: String)
    fun getById(personalStatId: String): PersonalStat
    fun getAllByPerson(personName: String): List<PersonalStat>

}