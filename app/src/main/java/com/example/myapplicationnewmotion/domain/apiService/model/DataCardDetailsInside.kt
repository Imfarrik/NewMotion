package com.example.myapplicationnewmotion.domain.apiService.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cards")
data class DataCardDetailsInside(

    @ColumnInfo(name = "card_account")
    val cardAccount: String?,

    @ColumnInfo(name = "card_balance")
    val cardBalance: Int?,

    @PrimaryKey
    @ColumnInfo(name = "card_id")
    val cardId: Int?,

    @ColumnInfo(name = "card_name")
    val cardName: String?,

    @ColumnInfo(name = "card_number")
    val cardNumber: String?,

    @ColumnInfo(name = "card_state_changed_date")
    val cardStateChangedDate: String?,

    @ColumnInfo(name = "card_contract_type_group_id")
    val contractTypeGroupId: Int?,

    @ColumnInfo(name = "card_contract_type_group_name")
    val contractTypeGroupName: String?,

    @ColumnInfo(name = "data_expire")
    val dateExpiry: String?,

    @ColumnInfo(name = "embossed_name")
    val embossedName: String?,

    @ColumnInfo(name = "filial_code")
    val filialCode: String?,

    @ColumnInfo(name = "sms_service_state")
    val smsServiceState: Int?,

    @ColumnInfo(name = "sms_service_state_name")
    val smsServiceStateName: String?,

    @ColumnInfo(name = "state_code")
    val stateCode: String?,

    @ColumnInfo(name = "state_name")
    val stateName: String?,

    @ColumnInfo(name = "currency")
    val currency: String?,

    @ColumnInfo(name = "is_multi_currency")
    val isMultiCurrency: Boolean
)