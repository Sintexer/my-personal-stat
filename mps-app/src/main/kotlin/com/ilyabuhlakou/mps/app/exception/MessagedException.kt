package com.ilyabuhlakou.mps.app.exception

import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotEmpty

open class MessagedException(

    @NotEmpty
    val descriptionKey: String,

    @Min(1) @Max(999)
    val httpStatus: Int = 500,

    val args: Array<out Any> = emptyArray()
) : Exception(){

}