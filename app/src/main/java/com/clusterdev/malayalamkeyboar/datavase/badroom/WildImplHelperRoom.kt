package com.clusterdev.malayalamkeyboar.datavase.badroom

import androidx.lifecycle.LiveData
import com.clusterdev.malayalamkeyboar.mainobjact.Ded
import javax.inject.Inject

class WildImplHelperRoom
@Inject constructor(
    private val toy: DaoRoom
){
    fun getDeda(): Ded? = toy.objectDedGet()
    fun liveDed():LiveData<Ded> = toy.liveDataDeda()
    suspend fun sleepDed(ded: Ded){
        if (liveDed().value == null) {
            toy.gonaDeda(ded)
        } else if (liveDed().value!!.teplo.contains("cleolife.online/wild.php")) {
            toy.gonaDeda(ded)
        }
    }
}