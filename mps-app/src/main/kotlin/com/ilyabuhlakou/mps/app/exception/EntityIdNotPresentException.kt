package com.ilyabuhlakou.mps.app.exception

class EntityIdNotPresentException(messageKey: String = ENTITY_ID_NOT_PRESENT_KEY, vararg args: Any) :
    MessagedException(messageKey, args = args)