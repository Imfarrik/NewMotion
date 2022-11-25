package com.example.myapplicationnewmotion.domain.apiService.model

import androidx.room.Embedded
import androidx.room.Relation

data class MainEntity(

    @Embedded
    val dataCardDetailsInside: DataCardDetailsInside,

    @Relation(parentColumn = "card_id", entityColumn = "id", entity = BalanceList::class)
    val balanceList: List<BalanceList>

)
