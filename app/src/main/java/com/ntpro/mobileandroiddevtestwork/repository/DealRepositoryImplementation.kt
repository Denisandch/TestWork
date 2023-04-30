package com.ntpro.mobileandroiddevtestwork.repository

import android.content.Context
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ntpro.mobileandroiddevtestwork.*
import com.ntpro.mobileandroiddevtestwork.room.DealDao
import com.ntpro.mobileandroiddevtestwork.room.DealDataBase
import kotlinx.coroutines.flow.Flow

class DealRepositoryImplementation(context: Context) : DealRepository {

    init {
        context.deleteDatabase("deal_database")
    }

    private val dealDao: DealDao = DealDataBase.getDatabase(context).dealDao()
    private var maxID: Long = 0
    override fun getDeals(filter: Column, isAsc: Boolean): Flow<PagingData<Deal>> {

        return Pager<Int, Deal>(
            PagingConfig(pageSize = 50, initialLoadSize = 200),
        ) {
            DealPagingSource(dealDao, column = filter, direction = isAsc, maxID = maxID)
        }.flow
    }

    override suspend fun addNewDeals(deals: List<Deal>) {
        maxID += deals.size - 1
        dealDao.addListDeal(deals.map { it.toDealDB() })
    }
}