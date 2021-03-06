package com.kdp.wanandroidclient.ui.mvp.presenter;

import com.kdp.wanandroidclient.R;
import com.kdp.wanandroidclient.application.AppContext;
import com.kdp.wanandroidclient.net.callback.RxObserver;
import com.kdp.wanandroidclient.ui.mvp.model.impl.CommonModel;
import com.kdp.wanandroidclient.ui.mvp.view.IView;

/**
 * ICommonPresenter实现类，用于封装通用业务接口
 * author: 康栋普
 * date: 2018/4/10
 */

public class CommonPresenter<V extends IView> extends BasePresenter<V> implements ICommonPresenter {
    private CommonModel mCommonModel;

    public CommonPresenter() {
        this.mCommonModel = new CommonModel();
    }

    /**
     * 收藏文章
     * @param articleId
     * @param view
     */
    @Override
    public void collectArticle(int articleId, IView view) {
        RxObserver<String> mCollectRxObserver = new RxObserver<String>(this) {

            @Override
            protected void onStart() {
            }

            @Override
            protected void onSuccess(String data) {
                view.collect(true, AppContext.getContext().getString(R.string.collect_success));
            }

            @Override
            protected void onFail(int errorCode, String errorMsg) {
                view.showFail(errorMsg);
            }


        };
        mCommonModel.collectArticle(articleId, mCollectRxObserver);
        addDisposable(mCollectRxObserver);
    }

    /**
     * 收藏站内文章
     * @param articleId
     * @param view
     */
    @Override
    public void collectInsideArticle(int articleId, IView view) {
        RxObserver<String> mCollectInsideRxObserver = new RxObserver<String>(this) {

            @Override
            protected void onStart() {
            }

            @Override
            protected void onSuccess(String data) {
                view.collect(true, AppContext.getContext().getString(R.string.collect_success));
            }

            @Override
            protected void onFail(int errorCode, String errorMsg) {
                view.showFail(errorMsg);
            }
        };
        mCommonModel.collectInSideArticle(articleId, mCollectInsideRxObserver);
        addDisposable(mCollectInsideRxObserver);
    }

    /**
     * 取消收藏
     * @param articleId
     * @param view
     */
    @Override
    public void unCollectArticle(int articleId, IView view) {
        RxObserver<String> mUnCollectRxObserver = new RxObserver<String>(this) {
            @Override
            protected void onStart() {
            }

            @Override
            protected void onSuccess(String data) {
                view.collect(false, AppContext.getContext().getString(R.string.uncollect_success));
            }

            @Override
            protected void onFail(int errorCode, String errorMsg) {
                view.showFail(errorMsg);
            }
        };
        mCommonModel.unCollectArticle(articleId, mUnCollectRxObserver);
        addDisposable(mUnCollectRxObserver);
    }

}
