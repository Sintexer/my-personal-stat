package com.ilyabuhlakou.mps.app.controller

import com.ilyabuhlakou.mps.service.model.PersonalStat
import com.ilyabuhlakou.mps.service.stat.PersonalStatService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/stat")
class StatController
@Autowired constructor(private val personalStatService: PersonalStatService) {

    @RequestMapping(method=[RequestMethod.PUT, RequestMethod.POST])
    fun saveStat(@RequestBody personalStat: PersonalStat){
        personalStatService.save(personalStat)
    }

}