package com.ilyabuhlakou.mps.service.mapper

import com.ilyabuhlakou.mps.data.entity.StatEntryEntity
import com.ilyabuhlakou.mps.service.model.StatEntry

interface StatEntryMapper {

    fun mapToEntryEntity(statEntry: StatEntry): StatEntryEntity
    fun mapToEntry(statEntryEntity: StatEntryEntity): StatEntry

}