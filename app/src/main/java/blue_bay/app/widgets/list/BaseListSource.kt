package blue_bay.app.widgets.list

import androidx.paging.PositionalDataSource
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import blue_bay.app.data.api.base.BaseIDModel
import blue_bay.app.data.api.base.BaseListRequest
import pl.tracker.app.data.api.base.BaseListResponse
import pl.tracker.app.widgets.BaseViewModelListener

class BaseListSource<T : BaseIDModel>(
    val baseListRequest: BaseListRequest,
    private val compositeDisposable: CompositeDisposable,
    private val token: String,
    private val callback: (String, BaseListRequest) -> Single<BaseListResponse<T>>,
    private val baseViewModelListener: BaseViewModelListener
) : PositionalDataSource<T>() {

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<T>) {
        baseListRequest.offset += baseListRequest.limit

        compositeDisposable.add(
            callback(token, baseListRequest)
                .subscribe({
                    callback.onResult(it.list)
                }, { baseViewModelListener.setError(it) })
        )
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<T>) {
        baseListRequest.offset = 0

        compositeDisposable.add(
            callback(token, baseListRequest)
                .subscribe({
                    callback.onResult(it.list, 0)
                }, {
                    baseViewModelListener.setError(it) })
        )
    }


}