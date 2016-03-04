package in.srain.cube.views.ptr.demo.ui.classic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import in.srain.cube.mints.base.TitleBaseFragment;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler2;
import in.srain.cube.views.ptr.demo.R;

public class WithScrollView extends TitleBaseFragment {

    private PtrClassicFrameLayout mPtrFrame;
    private ScrollView mScrollView;

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        setHeaderTitle(R.string.ptr_demo_block_scroll_view);

        final View contentView = inflater.inflate(R.layout.fragment_classic_header_with_scroll_view, null);
        mScrollView = (ScrollView) contentView.findViewById(R.id.rotate_header_scroll_view);
        mPtrFrame = (PtrClassicFrameLayout) contentView.findViewById(R.id.rotate_header_web_view_frame);
        mPtrFrame.setLastUpdateTimeRelateObject(this);
        /*mPtrFrame.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, mScrollView, header);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                mPtrFrame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPtrFrame.refreshComplete();
                    }
                }, 100);
            }
        });*/
         mPtrFrame.setPtrHandler(new PtrHandler2() {
             @Override
             public boolean checkCanDoLoadMore(PtrFrameLayout frame, View content, View footer) {
                 return PtrDefaultHandler2.checkContentCanBePulledUp(frame, mScrollView, footer);
             }

             @Override
             public void onLoadMoreBegin(PtrFrameLayout frame) {
                 mPtrFrame.postDelayed(new Runnable() {
                     @Override
                     public void run() {
                         mPtrFrame.refreshComplete();
                     }
                 }, 100);
             }

             @Override
             public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                 return PtrDefaultHandler2.checkContentCanBePulledDown(frame, mScrollView, header);
             }

             @Override
             public void onRefreshBegin(PtrFrameLayout frame) {
                 mPtrFrame.postDelayed(new Runnable() {
                     @Override
                     public void run() {
                         mPtrFrame.refreshComplete();
                     }
                 }, 100);
             }
         });

        //修改支持loadMore
        /*mPtrFrame.setPtrHandler(new PtrDefaultHandler2() {
            @Override
            public void onLoadMoreBegin(PtrFrameLayout frame) {
                mPtrFrame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPtrFrame.refreshComplete();
                    }
                }, 100);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                mPtrFrame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPtrFrame.refreshComplete();
                    }
                }, 100);
            }
        });*/

        // the following are default settings
        mPtrFrame.setResistance(1.7f);
        mPtrFrame.setRatioOfHeaderHeightToRefresh(1.2f);
        mPtrFrame.setDurationToClose(200);
        mPtrFrame.setDurationToCloseHeader(1000);
        // default is false
        mPtrFrame.setPullToRefresh(false);
        // default is true
        mPtrFrame.setKeepHeaderWhenRefresh(true);
        mPtrFrame.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPtrFrame.autoRefresh();
            }
        }, 100);
        return contentView;
    }
}