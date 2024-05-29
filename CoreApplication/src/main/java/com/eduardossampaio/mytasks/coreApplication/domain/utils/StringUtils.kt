package com.eduardossampaio.mytasks.coreApplication.domain.utils

import java.util.UUID


fun newId():String{
    return UUID.randomUUID().toString()
}