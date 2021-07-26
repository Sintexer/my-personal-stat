package com.ilyabuhlakou.mps.service.mapper

import com.ilyabuhlakou.mps.data.entity.PersonalStatEntity
import com.ilyabuhlakou.mps.service.model.PersonalStat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class PersonalStatMapperImpl
@Autowired constructor(
    private val statEntryMapper: StatEntryMapper
) : PersonalStatMapper {

    override fun mapToPersonalStatEntity(statEntry: PersonalStat): PersonalStatEntity {
        return statEntry.let {
            val lists = it.lists.map { entry ->
                entry.key to entry.value.map(statEntryMapper::mapToEntryEntity)
            }.toMap()
            PersonalStatEntity(
                id = it.id,
                name = it.name,
                dateCreated = it.dateCreated,
                lists = lists
            )
        }
    }

    override fun mapToPersonalStat(statEntryEntity: PersonalStatEntity): PersonalStat {
        return statEntryEntity.let {
            val lists = it.lists.map { entry ->
                entry.key to entry.value.map(statEntryMapper::mapToEntry)
            }.toMap()
            PersonalStat(
                id = it.id,
                name = it.name,
                dateCreated = it.dateCreated,
                lists = lists
            )
        }
    }
}