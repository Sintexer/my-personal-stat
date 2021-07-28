package com.ilyabuhlakou.mps.service.stat

import com.ilyabuhlakou.mps.data.entity.PersonalStatEntity
import com.ilyabuhlakou.mps.data.entity.StatEntryEntity
import com.ilyabuhlakou.mps.data.repository.PersonalStatRepository
import com.ilyabuhlakou.mps.service.exception.StatNotFoundException
import com.ilyabuhlakou.mps.service.mapper.PersonalStatMapper
import com.ilyabuhlakou.mps.service.model.PersonalStat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class PersonalStatServiceImpl
@Autowired constructor(
    private val repository: PersonalStatRepository,
    private val personalStatMapper: PersonalStatMapper
) : PersonalStatService {

    override fun save(personalStat: PersonalStat): PersonalStat {
        val entity = PersonalStatEntity(
            "",
            personalStat.name,
            LocalDateTime.now(),
            personalStat.lists.map { entry ->
                entry.key to entry.value.map {
                    StatEntryEntity("", LocalDateTime.now(), it.content)
                }.toList()
            }.toMap()
        )
        val savedEntity = repository.save(entity)
        return personalStatMapper.mapToPersonalStat(savedEntity)
    }

    override fun update(personalStat: PersonalStat): PersonalStat {
        TODO("Not yet implemented")
    }

    override fun getById(personalStatId: String): PersonalStat {
        TODO("Not yet implemented")
    }

    override fun delete(personalStatId: String) {
        TODO("Not yet implemented")
    }

    override fun getAllByPerson(personName: String): List<PersonalStat> {
        TODO("Not yet implemented")
    }
}