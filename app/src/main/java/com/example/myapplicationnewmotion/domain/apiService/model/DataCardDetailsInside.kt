package com.example.myapplicationnewmotion.domain.apiService.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "cards")
data class DataCardDetailsInside(

    @ColumnInfo(name = "card_account")
    var cardAccount: String? = null,

    @ColumnInfo(name = "card_balance")
    var cardBalance: Int? = null,

    @PrimaryKey @ColumnInfo(name = "card_id")
    var cardId: Int? = null,

    @ColumnInfo(name = "card_name")
    var cardName: String? = null,

    @ColumnInfo(name = "card_number")
    var cardNumber: String? = null,

    @ColumnInfo(name = "card_state_changed_date")
    var cardStateChangedDate: String? = null,

    @ColumnInfo(name = "card_contract_type_group_id")
    var contractTypeGroupId: Int? = null,

    @ColumnInfo(name = "card_contract_type_group_name")
    var contractTypeGroupName: String? = null,

    @ColumnInfo(name = "data_expire")
    var dateExpiry: String? = null,

    @ColumnInfo(name = "embossed_name")
    var embossedName: String? = null,

    @ColumnInfo(name = "filial_code")
    var filialCode: String? = null,

    @ColumnInfo(name = "sms_service_state")
    var smsServiceState: Int? = null,

    @ColumnInfo(name = "sms_service_state_name")
    var smsServiceStateName: String? = null,

    @ColumnInfo(name = "state_code")
    var stateCode: String? = null,

    @ColumnInfo(name = "state_name")
    var stateName: String? = null,

    @ColumnInfo(name = "currency")
    var currency: String? = null,

    @ColumnInfo(name = "is_multi_currency")
    var isMultiCurrency: Boolean? = null,

    @Ignore
    var balanceList: List<BalanceList>? = null

    )
