package blue_bay.app.widgets.list

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import pl.tracker.app.data.api.base.BaseIDModel
import pl.tracker.app.data.api.base.BaseListRequest
import pl.tracker.app.data.api.base.BaseListResponse
import pl.tracker.app.widgets.BaseViewModelListener

class BaseListSourceFactory<T : BaseIDModel>(
    val baseListRequest: BaseListRequest,
    private val compositeDisposable: CompositeDisposable,
    private val token: String,
    private val baseViewModelListener: BaseViewModelListener,
    private val callback: (String, BaseListRequest) -> Single<BaseListResponse<T>>
) : DataSource.Factory<Int, T>() {

    private val reportUserLiveData = MutableLiveData<BaseListSource<T>>()
    private var reportUserListSource: BaseListSource<T>? = null

    override fun create(): DataSource<Int, T> {
        reportUserListSource = BaseListSource(baseListRequest, compositeDisposable, token, callback, baseViewModelListener)
        reportUserLiveData.postValue(reportUserListSource)
        return reportUserListSource!!
    }

    fun invalidate(){
        reportUserListSource?.invalidate()
    }
}