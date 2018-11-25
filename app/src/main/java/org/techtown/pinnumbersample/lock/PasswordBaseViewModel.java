package org.techtown.pinnumbersample.lock;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import org.techtown.pinnumbersample.BaseViewModel;

import java.util.Arrays;

public abstract class PasswordBaseViewModel extends BaseViewModel {

    public final static int JOB_CODE_PIN_AUTH = 001;
    public final static int JOB_CODE_INIT_FINGER_AUTH = 002;
    public final static int PASSWORD_SIZE = 6; //암호 크기 숫자 6개
    protected final char[] userPasswords = new char[PASSWORD_SIZE];
    protected int userPasswordsPointer = 0;


    private int checkPasswordFailCount;
    protected boolean blockInput;


    protected MutableLiveData<Void> initNumberKeypad = new MutableLiveData<>();



    /**
     * 초기화
     */
    public void init() {
        this.initNumberKeypad.postValue(null);
        this.checkPasswordFailCount = 0;
        this.blockInput = false;
        clearUserPassword();
        // 잠김상태라면 사용불가능하게 막는다.
//        handleBlockState();
    }



    protected void clearUserPassword() {
        Arrays.fill(this.userPasswords, '0');
        this.userPasswordsPointer = 0;
    }

    public LiveData<Void> getInitNumberKeypad() {
        return initNumberKeypad;
    }

}
