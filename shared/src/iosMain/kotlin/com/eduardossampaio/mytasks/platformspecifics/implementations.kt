package com.eduardossampaio.mytasks.platformspecifics

import platform.Foundation.NSUUID

actual fun generateUUID(): String = NSUUID().UUIDString()