package com.ntpro.mobileandroiddevtestwork.repository

import androidx.paging.PagingData
import com.ntpro.mobileandroiddevtestwork.Column
import com.ntpro.mobileandroiddevtestwork.Deal
import com.ntpro.mobileandroiddevtestwork.Server
import kotlinx.coroutines.flow.Flow

interface DealRepository {
    fun getDeals(filter: Column, isAsc: Boolean, maxID: Long): Flow<PagingData<Deal>>

    suspend fun addNewDeals(deals: List<Server.Deal>)
}