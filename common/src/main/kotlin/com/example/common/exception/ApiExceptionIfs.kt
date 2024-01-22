package com.example.common.exception

import com.example.common.error.ErrorCodeIfs

interface ApiExceptionIfs {
    val errorCodeIfs: ErrorCodeIfs?
    val errorDescription: String?
}