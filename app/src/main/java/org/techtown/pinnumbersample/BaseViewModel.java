package org.techtown.pinnumbersample;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.io.PrintWriter;
import java.io.StringWriter;

public class BaseViewModel extends ViewModel {

    public static final int RESULT_CODE_SUCCESS = 200;
    public static final int RESULT_CODE_CANCELED = 300;
    public static final int RESULT_CODE_FAIL = 400;
    public static final int RESULT_CODE_ERROR = 500;
    private final static String TAG = BaseViewModel.class.getName();
    protected MutableLiveData<Boolean> loadingPopup = new MutableLiveData<>();
    protected MutableLiveData<JobResult> result = new MutableLiveData<>();
    protected MutableLiveData<Throwable> error = new MutableLiveData<>();

    protected void logError(Throwable throwable) {
        StringWriter sw = new StringWriter();
        throwable.printStackTrace(new PrintWriter(sw));
        /*if (!BuildUtil.isRelease()) {
            Crashlytics.log(Log.ERROR, "BASE_ERROR_LOG", sw.toString());
        }
        Crashlytics.logException(throwable);
        this.error.postValue(throwable);*/
    }

    public LiveData<Boolean> getLoadingPopup() {
        return loadingPopup;
    }

    public LiveData<JobResult> getResult() {
        return result;
    }

    public LiveData<Throwable> getError() {
        return error;
    }
}
