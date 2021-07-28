package com.ilyabuhlakou.mps.service.mapper

import com.ilyabuhlakou.mps.data.entity.StatEntryEntity
import com.ilyabuhlakou.mps.service.model.StatEntry
import org.springframework.stereotype.Component

@Component
class StatEntryMapperImpl : StatEntryMapper {

    override fun mapToEntryEntity(statEntry: StatEntry): StatEntryEntity {
        return statEntry.let {
            StatEntryEntity(
                "",
                it.dateCreated,
                it.content
            )
        }
    }

    override fun mapToEntry(statEntryEntity: StatEntryEntity): StatEntry {
        return statEntryEntity.let {
            StatEntry(
                it.dateCreated,
                it.content
            )
        }
    }
}