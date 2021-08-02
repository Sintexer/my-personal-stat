package com.ilyabuhlakou.mps.data.repository

import com.ilyabuhlakou.mps.data.entity.ProfileStat
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

/**
 * ProfileStatRepository manages ProfileStat entities
 */
interface ProfileStatRepository : ReactiveMongoRepository<ProfileStat, String> {
}