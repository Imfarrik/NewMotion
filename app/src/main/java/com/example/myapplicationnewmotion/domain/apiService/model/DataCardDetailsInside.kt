package com.example.myapplicationnewmotion.domain.apiService.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "cards")
data class DataCardDetailsInside(

    @ColumnInfo(name = "card_account") val cardAccount: String? = null,

    @ColumnInfo(name = "card_balance") val cardBalance: Int? = null,

    @PrimaryKey @ColumnInfo(name = "card_id") val cardId: Int? = null,

    @ColumnInfo(name = "card_name") val cardName: String? = null,

    @ColumnInfo(name = "card_number") val cardNumber: String? = null,

    @ColumnInfo(name = "card_state_changed_date") val cardStateChangedDate: String? = null,

    @ColumnInfo(name = "card_contract_type_group_id") val contractTypeGroupId: Int? = null,

    @ColumnInfo(name = "card_contract_type_group_name") val contractTypeGroupName: String? = null,

    @ColumnInfo(name = "data_expire") val dateExpiry: String? = null,

    @ColumnInfo(name = "embossed_name") val embossedName: String? = null,

    @ColumnInfo(name = "filial_code") val filialCode: String? = null,

    @ColumnInfo(name = "sms_service_state") val smsServiceState: Int? = null,

    @ColumnInfo(name = "sms_service_state_name") val smsServiceStateName: String? = null,

    @ColumnInfo(name = "state_code") val stateCode: String? = null,

    @ColumnInfo(name = "state_name") val stateName: String? = null,

    @ColumnInfo(name = "currency") val currency: String? = null,

    @ColumnInfo(name = "is_multi_currency") val isMultiCurrency: Boolean? = null,

    )
{
//    @Ignore
//    lateinit var balanceList: List<BalanceList>
}
