package com.example.myapplicationnewmotion.domain.room

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE cards ADD COLUMN currency TEXT")
    }
}

val MIGRATION_2_3 = object : Migration(2, 3) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE cards ADD COLUMN is_multi_currency INTEGER DEFAULT(0)")
    }
}

val MIGRATION_3_4 = object : Migration(3, 4) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "CREATE TABLE balance_list (card_id INTEGER, balance INTEGER, currency TEXT, PRIMARY KEY(card_id))"
        )
    }
}

val MIGRATION_4_5 = object : Migration(4, 5) {
    override fun migrate(database: SupportSQLiteDatabase) {

        database.execSQL("CREATE TABLE balance_list_tem (card_id INTEGER, balance INTEGER, currency TEXT, PRIMARY KEY(card_id))")
        database.execSQL("DROP TABLE balance_list")
        database.execSQL("ALTER TABLE balance_list_tem RENAME TO balance_list")

    }
}


