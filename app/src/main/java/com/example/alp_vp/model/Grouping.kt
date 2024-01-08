package com.example.alp_vp.model

data class Grouping(val enum_isAccepted: is_accepted)

enum class is_accepted {
    pending,
    accepted,
    rejected
}
