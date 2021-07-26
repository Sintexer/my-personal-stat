package com.ilyabuhlakou.mps.data.repository

import com.ilyabuhlakou.mps.data.entity.PersonalStatEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

interface PersonalStatRepository: MongoRepository<PersonalStatEntity, String> {
}